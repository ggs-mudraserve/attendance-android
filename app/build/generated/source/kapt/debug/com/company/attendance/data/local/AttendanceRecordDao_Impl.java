package com.company.attendance.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.company.attendance.data.model.AttendanceStatus;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AttendanceRecordDao_Impl implements AttendanceRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AttendanceRecordEntity> __insertionAdapterOfAttendanceRecordEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<AttendanceRecordEntity> __deletionAdapterOfAttendanceRecordEntity;

  private final EntityDeletionOrUpdateAdapter<AttendanceRecordEntity> __updateAdapterOfAttendanceRecordEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteExpiredRecords;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllRecordsForEmployee;

  public AttendanceRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAttendanceRecordEntity = new EntityInsertionAdapter<AttendanceRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `attendance_records` (`id`,`employee_id`,`attendance_date`,`in_time`,`out_time`,`total_minutes`,`status`,`cached_at`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AttendanceRecordEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getEmployeeId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEmployeeId());
        }
        final Long _tmp = __converters.localDateToTimestamp(entity.getAttendanceDate());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, _tmp);
        }
        final Long _tmp_1 = __converters.dateToTimestamp(entity.getInTime());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, _tmp_1);
        }
        final Long _tmp_2 = __converters.dateToTimestamp(entity.getOutTime());
        if (_tmp_2 == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp_2);
        }
        statement.bindLong(6, entity.getTotalMinutes());
        statement.bindString(7, __AttendanceStatus_enumToString(entity.getStatus()));
        statement.bindLong(8, entity.getCachedAt());
      }
    };
    this.__deletionAdapterOfAttendanceRecordEntity = new EntityDeletionOrUpdateAdapter<AttendanceRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `attendance_records` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AttendanceRecordEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfAttendanceRecordEntity = new EntityDeletionOrUpdateAdapter<AttendanceRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `attendance_records` SET `id` = ?,`employee_id` = ?,`attendance_date` = ?,`in_time` = ?,`out_time` = ?,`total_minutes` = ?,`status` = ?,`cached_at` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AttendanceRecordEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getEmployeeId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEmployeeId());
        }
        final Long _tmp = __converters.localDateToTimestamp(entity.getAttendanceDate());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, _tmp);
        }
        final Long _tmp_1 = __converters.dateToTimestamp(entity.getInTime());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, _tmp_1);
        }
        final Long _tmp_2 = __converters.dateToTimestamp(entity.getOutTime());
        if (_tmp_2 == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp_2);
        }
        statement.bindLong(6, entity.getTotalMinutes());
        statement.bindString(7, __AttendanceStatus_enumToString(entity.getStatus()));
        statement.bindLong(8, entity.getCachedAt());
        if (entity.getId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteExpiredRecords = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM attendance_records WHERE employee_id = ? AND cached_at < ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllRecordsForEmployee = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM attendance_records WHERE employee_id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAttendanceRecords(final List<AttendanceRecordEntity> records,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAttendanceRecordEntity.insert(records);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAttendanceRecord(final AttendanceRecordEntity record,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAttendanceRecordEntity.insert(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAttendanceRecord(final AttendanceRecordEntity record,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAttendanceRecordEntity.handle(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAttendanceRecord(final AttendanceRecordEntity record,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAttendanceRecordEntity.handle(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteExpiredRecords(final String employeeId, final long expiry,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteExpiredRecords.acquire();
        int _argIndex = 1;
        if (employeeId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, employeeId);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, expiry);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteExpiredRecords.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllRecordsForEmployee(final String employeeId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllRecordsForEmployee.acquire();
        int _argIndex = 1;
        if (employeeId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, employeeId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllRecordsForEmployee.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<AttendanceRecordEntity>> getAttendanceRecordsForPeriod(final String employeeId,
      final LocalDate startDate, final LocalDate endDate) {
    final String _sql = "SELECT * FROM attendance_records WHERE employee_id = ? AND attendance_date BETWEEN ? AND ? ORDER BY attendance_date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (employeeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, employeeId);
    }
    _argIndex = 2;
    final Long _tmp = __converters.localDateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 3;
    final Long _tmp_1 = __converters.localDateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"attendance_records"}, new Callable<List<AttendanceRecordEntity>>() {
      @Override
      @NonNull
      public List<AttendanceRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "employee_id");
          final int _cursorIndexOfAttendanceDate = CursorUtil.getColumnIndexOrThrow(_cursor, "attendance_date");
          final int _cursorIndexOfInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "in_time");
          final int _cursorIndexOfOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "out_time");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "total_minutes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cached_at");
          final List<AttendanceRecordEntity> _result = new ArrayList<AttendanceRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AttendanceRecordEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmployeeId;
            if (_cursor.isNull(_cursorIndexOfEmployeeId)) {
              _tmpEmployeeId = null;
            } else {
              _tmpEmployeeId = _cursor.getString(_cursorIndexOfEmployeeId);
            }
            final LocalDate _tmpAttendanceDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAttendanceDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfAttendanceDate);
            }
            _tmpAttendanceDate = __converters.fromDateTimestamp(_tmp_2);
            final LocalDateTime _tmpInTime;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfInTime)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfInTime);
            }
            _tmpInTime = __converters.fromTimestamp(_tmp_3);
            final LocalDateTime _tmpOutTime;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfOutTime)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfOutTime);
            }
            _tmpOutTime = __converters.fromTimestamp(_tmp_4);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final AttendanceStatus _tmpStatus;
            _tmpStatus = __AttendanceStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new AttendanceRecordEntity(_tmpId,_tmpEmployeeId,_tmpAttendanceDate,_tmpInTime,_tmpOutTime,_tmpTotalMinutes,_tmpStatus,_tmpCachedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getAttendanceRecordsForPeriodSync(final String employeeId,
      final LocalDate startDate, final LocalDate endDate,
      final Continuation<? super List<AttendanceRecordEntity>> $completion) {
    final String _sql = "SELECT * FROM attendance_records WHERE employee_id = ? AND attendance_date BETWEEN ? AND ? ORDER BY attendance_date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (employeeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, employeeId);
    }
    _argIndex = 2;
    final Long _tmp = __converters.localDateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 3;
    final Long _tmp_1 = __converters.localDateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<AttendanceRecordEntity>>() {
      @Override
      @NonNull
      public List<AttendanceRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "employee_id");
          final int _cursorIndexOfAttendanceDate = CursorUtil.getColumnIndexOrThrow(_cursor, "attendance_date");
          final int _cursorIndexOfInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "in_time");
          final int _cursorIndexOfOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "out_time");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "total_minutes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cached_at");
          final List<AttendanceRecordEntity> _result = new ArrayList<AttendanceRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AttendanceRecordEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmployeeId;
            if (_cursor.isNull(_cursorIndexOfEmployeeId)) {
              _tmpEmployeeId = null;
            } else {
              _tmpEmployeeId = _cursor.getString(_cursorIndexOfEmployeeId);
            }
            final LocalDate _tmpAttendanceDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAttendanceDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfAttendanceDate);
            }
            _tmpAttendanceDate = __converters.fromDateTimestamp(_tmp_2);
            final LocalDateTime _tmpInTime;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfInTime)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfInTime);
            }
            _tmpInTime = __converters.fromTimestamp(_tmp_3);
            final LocalDateTime _tmpOutTime;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfOutTime)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfOutTime);
            }
            _tmpOutTime = __converters.fromTimestamp(_tmp_4);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final AttendanceStatus _tmpStatus;
            _tmpStatus = __AttendanceStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new AttendanceRecordEntity(_tmpId,_tmpEmployeeId,_tmpAttendanceDate,_tmpInTime,_tmpOutTime,_tmpTotalMinutes,_tmpStatus,_tmpCachedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAttendanceRecordForDate(final String employeeId, final LocalDate date,
      final Continuation<? super AttendanceRecordEntity> $completion) {
    final String _sql = "SELECT * FROM attendance_records WHERE employee_id = ? AND attendance_date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (employeeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, employeeId);
    }
    _argIndex = 2;
    final Long _tmp = __converters.localDateToTimestamp(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<AttendanceRecordEntity>() {
      @Override
      @Nullable
      public AttendanceRecordEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "employee_id");
          final int _cursorIndexOfAttendanceDate = CursorUtil.getColumnIndexOrThrow(_cursor, "attendance_date");
          final int _cursorIndexOfInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "in_time");
          final int _cursorIndexOfOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "out_time");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "total_minutes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cached_at");
          final AttendanceRecordEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmployeeId;
            if (_cursor.isNull(_cursorIndexOfEmployeeId)) {
              _tmpEmployeeId = null;
            } else {
              _tmpEmployeeId = _cursor.getString(_cursorIndexOfEmployeeId);
            }
            final LocalDate _tmpAttendanceDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfAttendanceDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfAttendanceDate);
            }
            _tmpAttendanceDate = __converters.fromDateTimestamp(_tmp_1);
            final LocalDateTime _tmpInTime;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfInTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfInTime);
            }
            _tmpInTime = __converters.fromTimestamp(_tmp_2);
            final LocalDateTime _tmpOutTime;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfOutTime)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfOutTime);
            }
            _tmpOutTime = __converters.fromTimestamp(_tmp_3);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final AttendanceStatus _tmpStatus;
            _tmpStatus = __AttendanceStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _result = new AttendanceRecordEntity(_tmpId,_tmpEmployeeId,_tmpAttendanceDate,_tmpInTime,_tmpOutTime,_tmpTotalMinutes,_tmpStatus,_tmpCachedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAttendanceRecordsPaginated(final String employeeId, final int limit,
      final int offset, final Continuation<? super List<AttendanceRecordEntity>> $completion) {
    final String _sql = "SELECT * FROM attendance_records WHERE employee_id = ? ORDER BY attendance_date DESC LIMIT ? OFFSET ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (employeeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, employeeId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    _argIndex = 3;
    _statement.bindLong(_argIndex, offset);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<AttendanceRecordEntity>>() {
      @Override
      @NonNull
      public List<AttendanceRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "employee_id");
          final int _cursorIndexOfAttendanceDate = CursorUtil.getColumnIndexOrThrow(_cursor, "attendance_date");
          final int _cursorIndexOfInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "in_time");
          final int _cursorIndexOfOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "out_time");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "total_minutes");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCachedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "cached_at");
          final List<AttendanceRecordEntity> _result = new ArrayList<AttendanceRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AttendanceRecordEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpEmployeeId;
            if (_cursor.isNull(_cursorIndexOfEmployeeId)) {
              _tmpEmployeeId = null;
            } else {
              _tmpEmployeeId = _cursor.getString(_cursorIndexOfEmployeeId);
            }
            final LocalDate _tmpAttendanceDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfAttendanceDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfAttendanceDate);
            }
            _tmpAttendanceDate = __converters.fromDateTimestamp(_tmp);
            final LocalDateTime _tmpInTime;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfInTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfInTime);
            }
            _tmpInTime = __converters.fromTimestamp(_tmp_1);
            final LocalDateTime _tmpOutTime;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOutTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfOutTime);
            }
            _tmpOutTime = __converters.fromTimestamp(_tmp_2);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final AttendanceStatus _tmpStatus;
            _tmpStatus = __AttendanceStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpCachedAt;
            _tmpCachedAt = _cursor.getLong(_cursorIndexOfCachedAt);
            _item = new AttendanceRecordEntity(_tmpId,_tmpEmployeeId,_tmpAttendanceDate,_tmpInTime,_tmpOutTime,_tmpTotalMinutes,_tmpStatus,_tmpCachedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getPresentDaysCount(final String employeeId, final LocalDate startDate,
      final LocalDate endDate, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = ? AND attendance_date BETWEEN ? AND ? AND status = 'PRESENT'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (employeeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, employeeId);
    }
    _argIndex = 2;
    final Long _tmp = __converters.localDateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 3;
    final Long _tmp_1 = __converters.localDateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp_2;
            if (_cursor.isNull(0)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(0);
            }
            _result = _tmp_2;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getLateDaysCount(final String employeeId, final LocalDate startDate,
      final LocalDate endDate, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = ? AND attendance_date BETWEEN ? AND ? AND status = 'LATE'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (employeeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, employeeId);
    }
    _argIndex = 2;
    final Long _tmp = __converters.localDateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 3;
    final Long _tmp_1 = __converters.localDateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp_2;
            if (_cursor.isNull(0)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(0);
            }
            _result = _tmp_2;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getHalfDaysCount(final String employeeId, final LocalDate startDate,
      final LocalDate endDate, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = ? AND attendance_date BETWEEN ? AND ? AND status = 'HALF_DAY'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (employeeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, employeeId);
    }
    _argIndex = 2;
    final Long _tmp = __converters.localDateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 3;
    final Long _tmp_1 = __converters.localDateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp_2;
            if (_cursor.isNull(0)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(0);
            }
            _result = _tmp_2;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAbsentDaysCount(final String employeeId, final LocalDate startDate,
      final LocalDate endDate, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = ? AND attendance_date BETWEEN ? AND ? AND status = 'ABSENT'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (employeeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, employeeId);
    }
    _argIndex = 2;
    final Long _tmp = __converters.localDateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 3;
    final Long _tmp_1 = __converters.localDateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp_2;
            if (_cursor.isNull(0)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(0);
            }
            _result = _tmp_2;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getHolidayDaysCount(final String employeeId, final LocalDate startDate,
      final LocalDate endDate, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = ? AND attendance_date BETWEEN ? AND ? AND status = 'HOLIDAY'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (employeeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, employeeId);
    }
    _argIndex = 2;
    final Long _tmp = __converters.localDateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 3;
    final Long _tmp_1 = __converters.localDateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp_2;
            if (_cursor.isNull(0)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(0);
            }
            _result = _tmp_2;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __AttendanceStatus_enumToString(@NonNull final AttendanceStatus _value) {
    switch (_value) {
      case PRESENT: return "PRESENT";
      case LATE: return "LATE";
      case HALF_DAY: return "HALF_DAY";
      case ABSENT: return "ABSENT";
      case HOLIDAY: return "HOLIDAY";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private AttendanceStatus __AttendanceStatus_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "PRESENT": return AttendanceStatus.PRESENT;
      case "LATE": return AttendanceStatus.LATE;
      case "HALF_DAY": return AttendanceStatus.HALF_DAY;
      case "ABSENT": return AttendanceStatus.ABSENT;
      case "HOLIDAY": return AttendanceStatus.HOLIDAY;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
