# Employee Attendance System - Development Guide

## Project Overview
Building a secure, semi-automated Employee Attendance System with device binding and Wi-Fi presence detection. The system prevents time-theft through device binding and Wi-Fi validation, provides accurate server-stamped work hours for payroll, and keeps the mobile app lightweight with offline tolerance.

## Architecture
```
Android App ⇆ Office Server ⇆ Supabase (Postgres + Auth)
```

- **Transport:** Plain HTTP on LAN
- **Auth:** Supabase JWT + HMAC verification  
- **Time Source:** All timestamps server-generated (IST timezone)
- **Offline:** App queues requests locally, retries when connection restored

## Technology Stack

### Android App
- **Language:** Kotlin
- **UI:** Jetpack Compose  
- **Architecture:** MVVM with ViewModels
- **Networking:** Retrofit/OkHttp for HTTP calls
- **Background:** WorkManager for 30-min heartbeats
- **Auth:** Supabase Auth SDK
- **Permissions:** Fine location, Wi-Fi state, battery optimization exemption

### Office Server  
- **Runtime:** Node.js 18 + TypeScript
- **Framework:** Express.js
- **Database:** Supabase client with service-role key
- **Cron:** node-cron for automated jobs
- **Excel:** exceljs for payroll reports
- **Deployment:** Docker container on on-premise server

## Supabase Database Schema

### Connection Details
- **Project ID:** vxcdvuekhfdkccjhbrhz
- **URL:** https://vxcdvuekhfdkccjhbrhz.supabase.co
- **Region:** ap-south-1

### Core Tables

#### `public.profile` (Extended User Profiles)
```sql
id                uuid PK (FK to auth.users)
email             text
first_name        text  
last_name         text
role              user_role enum
is_active         boolean default true
emp_code          text NOT NULL UNIQUE  -- Company employee ID
salary_current    numeric(12,2)         -- Hidden from mobile clients
device_id         text UNIQUE           -- Android device UUID  
android_login     boolean default false -- Device binding flag
bank_account_no   text                  -- Self-service bank details
bank_ifsc         text
bank_name         text
extra_updated_at  timestamptz default now()
created_at        timestamptz default now()
updated_at        timestamptz default now()
```

#### `attendance_sessions` (Live IN/OUT Windows)
```sql
id              uuid PK
employee_id     uuid FK(profile.id)
session_date    date NOT NULL
in_time         timestamptz NOT NULL
last_heartbeat  timestamptz NOT NULL  
out_time        timestamptz           -- NULL while active
missed_count    smallint default 0    -- Heartbeat failures
created_at      timestamptz default now()
```

#### `heartbeats` (Raw Presence Logs)
```sql
id           bigserial PK
session_id   uuid FK(attendance_sessions.id)
received_at  timestamptz default now()
```

#### `attendance` (Final Daily Summary)
```sql
id               uuid PK
employee_id      uuid FK(profile.id)
attendance_date  date NOT NULL
in_time          timestamptz
out_time         timestamptz  
total_minutes    integer NOT NULL
status           att_status NOT NULL  -- Present/Late/Half Day/Absent/Holiday
created_at       timestamptz default now()

UNIQUE(employee_id, attendance_date)
```

#### `wifi_allowed` (BSSID Whitelist)
```sql
id           serial PK
bssid        text NOT NULL UNIQUE  -- Router MAC address
label        text                  -- Human-readable name
inserted_at  timestamptz default now()
```

#### `holidays` (Public Holidays)
```sql
holiday_date  date PK
description   text
```

#### `processed_events` (Idempotency Ledger)
```sql
event_id     text PK              -- HMAC hash for duplicate detection
received_at  timestamptz default now()
```

#### `config` (App Settings)
```sql
key    text PK                    -- e.g., 'min_app_version'
value  jsonb NOT NULL             -- Configuration value
```

### Enums
```sql
CREATE TYPE att_status AS ENUM ('Present', 'Late', 'Half Day', 'Absent', 'Holiday');
```

### RLS Policies
- `attendance` table: Employees can SELECT own records, no client writes allowed
- All writes go through Office Server with service-role key

### Extensions Enabled
- `pg_cron` - For automated jobs
- `pgcrypto` - For cryptographic functions

## Business Logic

### Attendance Status Calculation
```typescript
function calculateStatus(totalMinutes: number): att_status {
  if (totalMinutes >= 500) return 'Present';     // 8h 20m+
  if (totalMinutes >= 380) return 'Late';        // 6h 20m - 8h 19m  
  if (totalMinutes >= 200) return 'Half Day';    // 3h 20m - 6h 19m
  return 'Absent';                               // < 3h 20m
}
```

### Working Days
- **Sunday:** Non-working day (automatic)
- **Holidays:** From `holidays` table
- **Saturday:** Working day

### Time Rules
- **IN before 10:00 AM:** Clamped to 10:00 AM
- **OUT after 19:30:** Auto-closed at 19:30
- **Missing OUT:** Auto-closed at 19:30
- **Grace Period:** 1 missed heartbeat allowed (≤59 minutes)

### Automated Jobs (IST)
- **19:30 daily:** Auto-close open sessions
- **20:00 daily:** Finalize attendance status

## Security Model

### Authentication Flow
1. Employee logs in via Supabase Auth
2. App sends JWT + HMAC `X-Event-Id` to server
3. Server verifies JWT and HMAC for idempotency
4. Server generates all timestamps in IST

### HMAC Generation
```typescript
const eventId = crypto
  .createHmac('sha256', SHARED_SECRET)
  .update(deviceUuid + timestamp)
  .digest('hex');
```

### Device Binding
- One device per employee (enforced by unique `device_id`)
- `android_login` flag prevents second device binding

## API Endpoints (Office Server)

### Authentication Endpoints
- `POST /onboard` - Bind device, optional bank details
  ```json
  {
    "device_uuid": "550e8400-e29b-41d4-a716-446655440000",
    "bank_account_no": "1234567890",
    "bank_ifsc": "HDFC0001234", 
    "bank_name": "HDFC Bank"
  }
  ```

### Attendance Endpoints  
- `POST /in` - Start attendance session
- `POST /out` - End attendance session  
- `POST /heartbeat` - 30-min presence ping

### Data Endpoints
- `GET /attendance/:year/:month` - Monthly attendance data
- `GET /report/:yyyy_mm.xlsx` - Payroll Excel report

### Admin Endpoints
- `GET/POST/DELETE /wifi` - Manage BSSID whitelist
- `GET/POST/DELETE /holidays` - Manage public holidays
- `POST /deactivate/:emp_id` - Deactivate employee
- `GET /healthz` - Health check

### Request Headers
```
Authorization: Bearer <supabase_jwt>
X-Event-Id: <hmac_hash>
Content-Type: application/json
```

## Android App Requirements

### Core Features
1. **One-time Setup:**
   - Supabase Auth login
   - Device UUID generation  
   - Wi-Fi permission requests
   - Battery optimization exemption

2. **Daily Usage:**
   - IN/OUT buttons (Wi-Fi validated)
   - Current status display
   - Monthly attendance history

3. **Background Service:**
   - 30-min WorkManager heartbeats
   - Offline request queueing
   - Automatic retry logic

4. **Settings:**
   - Server IP/port configuration
   - App version display
   - Bank details (one-time entry)

### UI Screens
1. **Login Screen** - Supabase auth
2. **Onboarding Screen** - Device binding + bank details
3. **Dashboard** - IN/OUT buttons, current status
4. **History Screen** - Monthly attendance list  
5. **Settings Screen** - Server config, app info

### Offline Handling
```kotlin
// Queue failed requests locally
data class QueuedRequest(
    val endpoint: String,
    val method: String, 
    val body: String?,
    val timestamp: Long,
    val retryCount: Int = 0
)
```

### Wi-Fi Validation
```kotlin
fun isOnApprovedWiFi(): Boolean {
    val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
    val connectionInfo = wifiManager.connectionInfo
    val bssid = connectionInfo.bssid
    
    // Check against server's wifi_allowed table
    return approvedBSSIDs.contains(bssid)
}
```

## Office Server Requirements

### Project Structure
```
src/
├── config/
│   ├── database.ts          # Supabase client setup
│   └── constants.ts         # App constants
├── middleware/
│   ├── auth.ts              # JWT + HMAC verification  
│   └── validation.ts        # Request validation
├── services/
│   ├── statusEngine.ts      # Attendance calculation
│   ├── excelService.ts      # Report generation
│   └── supabaseService.ts   # Database operations
├── cron/
│   └── attendanceJobs.ts    # Automated tasks
├── routes/
│   ├── attendance.ts        # IN/OUT/heartbeat endpoints
│   ├── admin.ts             # Wi-Fi/holiday management
│   └── reports.ts           # Excel exports
├── utils/
│   ├── dateUtils.ts         # IST date handling
│   └── crypto.ts            # HMAC utilities
└── app.ts                   # Express app setup
```

### Environment Variables
```env
# Supabase
SUPABASE_URL=https://vxcdvuekhfdkccjhbrhz.supabase.co
SUPABASE_SERVICE_ROLE_KEY=<service_role_key>

# Database  
DATABASE_URL=postgresql://postgres:[password]@db.vxcdvuekhfdkccjhbrhz.supabase.co:5432/postgres

# Security
HMAC_SECRET=<generated_random_key>

# Server
PORT=3000
NODE_ENV=production
```

### Excel Report Format
**Sheet 1 "Summary":**
- Emp Code, Name, Present Days, Late Days, Half Days, Absent Days, Holiday Days

**Sheet 2 "Daily":**  
- Date, Emp Code, Status, Total Minutes, In Time, Out Time

### Deployment
- Docker container on on-premise server
- Plain HTTP on LAN (configurable IP/port)
- PM2 or Docker Compose for process management
- Log rotation and health monitoring

## Development Workflow

### Phase 1: Office Server Core
1. Set up Express.js project with TypeScript
2. Configure Supabase client with service-role key
3. Implement JWT + HMAC authentication middleware
4. Create core endpoints (/onboard, /in, /out, /heartbeat)
5. Implement cron jobs for auto-close and status calculation

### Phase 2: Android App Foundation  
1. Create Kotlin + Jetpack Compose project
2. Set up Supabase Auth SDK
3. Implement device UUID generation and Wi-Fi detection
4. Create main UI screens (Login, Dashboard, History, Settings)
5. Add offline request queueing with WorkManager

### Phase 3: Integration & Testing
1. Test full authentication flow
2. Verify Wi-Fi validation and device binding
3. Test offline scenarios and request retry
4. Validate attendance calculation and Excel reports
5. End-to-end testing with multiple devices

### Phase 4: Production Deployment
1. Docker containerization for Office Server
2. Android APK build for private distribution
3. Set up monitoring and alerting
4. Database backup and recovery procedures

## Security Considerations

### Data Protection
- Salary information hidden from mobile clients
- All attendance writes server-authoritative  
- Device binding prevents multiple logins
- HMAC prevents replay attacks

### Network Security
- Plain HTTP acceptable on trusted LAN
- JWT tokens for authentication
- Service-role key restricted to server only

### Operational Security  
- Regular database backups
- Log monitoring for suspicious activity
- Device deactivation capabilities
- Audit trail for all attendance changes

## Testing Strategy

### Unit Tests
- Attendance status calculation logic
- Date/time utilities (IST handling)
- HMAC generation and validation
- Wi-Fi BSSID validation

### Integration Tests  
- Full authentication flow
- Database operations with transactions
- Cron job execution
- Excel report generation

### End-to-End Tests
- Complete IN/OUT cycle
- Offline request queueing
- Multi-device scenarios
- Admin operations

## Monitoring & Alerts

### Health Checks
- Server `/healthz` endpoint
- Database connectivity
- Supabase service status
- Cron job execution logs

### Key Metrics
- Daily attendance completion rate
- Failed heartbeat counts
- API response times
- Offline request queue size

### Alert Conditions
- Server downtime > 5 minutes
- Failed cron job execution
- Database connection errors
- Unusual attendance patterns

This guide provides complete context for building both the Android app and Office Server. Use this as reference for implementation details, security requirements, and business logic.