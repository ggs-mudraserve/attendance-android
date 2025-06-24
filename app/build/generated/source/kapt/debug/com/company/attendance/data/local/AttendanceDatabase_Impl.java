package com.company.attendance.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AttendanceDatabase_Impl extends AttendanceDatabase {
  private volatile QueuedRequestDao _queuedRequestDao;

  private volatile ApprovedWiFiDao _approvedWiFiDao;

  private volatile AttendanceRecordDao _attendanceRecordDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `queued_requests` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `endpoint` TEXT NOT NULL, `method` TEXT NOT NULL, `body` TEXT, `timestamp` INTEGER NOT NULL, `retry_count` INTEGER NOT NULL, `event_id` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `approved_wifi_networks` (`bssid` TEXT NOT NULL, `label` TEXT, `ssid` TEXT, `last_validated` INTEGER NOT NULL, `is_active` INTEGER NOT NULL, PRIMARY KEY(`bssid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `attendance_records` (`id` TEXT NOT NULL, `employee_id` TEXT NOT NULL, `attendance_date` INTEGER NOT NULL, `in_time` INTEGER, `out_time` INTEGER, `total_minutes` INTEGER NOT NULL, `status` TEXT NOT NULL, `cached_at` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c13f937ac3b82783e2971659badff1e5')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `queued_requests`");
        db.execSQL("DROP TABLE IF EXISTS `approved_wifi_networks`");
        db.execSQL("DROP TABLE IF EXISTS `attendance_records`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsQueuedRequests = new HashMap<String, TableInfo.Column>(7);
        _columnsQueuedRequests.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQueuedRequests.put("endpoint", new TableInfo.Column("endpoint", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQueuedRequests.put("method", new TableInfo.Column("method", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQueuedRequests.put("body", new TableInfo.Column("body", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQueuedRequests.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQueuedRequests.put("retry_count", new TableInfo.Column("retry_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQueuedRequests.put("event_id", new TableInfo.Column("event_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQueuedRequests = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQueuedRequests = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQueuedRequests = new TableInfo("queued_requests", _columnsQueuedRequests, _foreignKeysQueuedRequests, _indicesQueuedRequests);
        final TableInfo _existingQueuedRequests = TableInfo.read(db, "queued_requests");
        if (!_infoQueuedRequests.equals(_existingQueuedRequests)) {
          return new RoomOpenHelper.ValidationResult(false, "queued_requests(com.company.attendance.data.model.QueuedRequest).\n"
                  + " Expected:\n" + _infoQueuedRequests + "\n"
                  + " Found:\n" + _existingQueuedRequests);
        }
        final HashMap<String, TableInfo.Column> _columnsApprovedWifiNetworks = new HashMap<String, TableInfo.Column>(5);
        _columnsApprovedWifiNetworks.put("bssid", new TableInfo.Column("bssid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApprovedWifiNetworks.put("label", new TableInfo.Column("label", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApprovedWifiNetworks.put("ssid", new TableInfo.Column("ssid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApprovedWifiNetworks.put("last_validated", new TableInfo.Column("last_validated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApprovedWifiNetworks.put("is_active", new TableInfo.Column("is_active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysApprovedWifiNetworks = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesApprovedWifiNetworks = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoApprovedWifiNetworks = new TableInfo("approved_wifi_networks", _columnsApprovedWifiNetworks, _foreignKeysApprovedWifiNetworks, _indicesApprovedWifiNetworks);
        final TableInfo _existingApprovedWifiNetworks = TableInfo.read(db, "approved_wifi_networks");
        if (!_infoApprovedWifiNetworks.equals(_existingApprovedWifiNetworks)) {
          return new RoomOpenHelper.ValidationResult(false, "approved_wifi_networks(com.company.attendance.data.model.ApprovedWiFiNetwork).\n"
                  + " Expected:\n" + _infoApprovedWifiNetworks + "\n"
                  + " Found:\n" + _existingApprovedWifiNetworks);
        }
        final HashMap<String, TableInfo.Column> _columnsAttendanceRecords = new HashMap<String, TableInfo.Column>(8);
        _columnsAttendanceRecords.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("employee_id", new TableInfo.Column("employee_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("attendance_date", new TableInfo.Column("attendance_date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("in_time", new TableInfo.Column("in_time", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("out_time", new TableInfo.Column("out_time", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("total_minutes", new TableInfo.Column("total_minutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendanceRecords.put("cached_at", new TableInfo.Column("cached_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttendanceRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAttendanceRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAttendanceRecords = new TableInfo("attendance_records", _columnsAttendanceRecords, _foreignKeysAttendanceRecords, _indicesAttendanceRecords);
        final TableInfo _existingAttendanceRecords = TableInfo.read(db, "attendance_records");
        if (!_infoAttendanceRecords.equals(_existingAttendanceRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "attendance_records(com.company.attendance.data.local.AttendanceRecordEntity).\n"
                  + " Expected:\n" + _infoAttendanceRecords + "\n"
                  + " Found:\n" + _existingAttendanceRecords);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c13f937ac3b82783e2971659badff1e5", "8c5c43b96af50a84c9977a40557e6e3a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "queued_requests","approved_wifi_networks","attendance_records");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `queued_requests`");
      _db.execSQL("DELETE FROM `approved_wifi_networks`");
      _db.execSQL("DELETE FROM `attendance_records`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(QueuedRequestDao.class, QueuedRequestDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ApprovedWiFiDao.class, ApprovedWiFiDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AttendanceRecordDao.class, AttendanceRecordDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public QueuedRequestDao queuedRequestDao() {
    if (_queuedRequestDao != null) {
      return _queuedRequestDao;
    } else {
      synchronized(this) {
        if(_queuedRequestDao == null) {
          _queuedRequestDao = new QueuedRequestDao_Impl(this);
        }
        return _queuedRequestDao;
      }
    }
  }

  @Override
  public ApprovedWiFiDao approvedWiFiDao() {
    if (_approvedWiFiDao != null) {
      return _approvedWiFiDao;
    } else {
      synchronized(this) {
        if(_approvedWiFiDao == null) {
          _approvedWiFiDao = new ApprovedWiFiDao_Impl(this);
        }
        return _approvedWiFiDao;
      }
    }
  }

  @Override
  public AttendanceRecordDao attendanceRecordDao() {
    if (_attendanceRecordDao != null) {
      return _attendanceRecordDao;
    } else {
      synchronized(this) {
        if(_attendanceRecordDao == null) {
          _attendanceRecordDao = new AttendanceRecordDao_Impl(this);
        }
        return _attendanceRecordDao;
      }
    }
  }
}
