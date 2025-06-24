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
import com.company.attendance.data.model.QueuedRequest;
import java.lang.Class;
import java.lang.Exception;
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

@SuppressWarnings({"unchecked", "deprecation"})
public final class QueuedRequestDao_Impl implements QueuedRequestDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QueuedRequest> __insertionAdapterOfQueuedRequest;

  private final EntityDeletionOrUpdateAdapter<QueuedRequest> __deletionAdapterOfQueuedRequest;

  private final EntityDeletionOrUpdateAdapter<QueuedRequest> __updateAdapterOfQueuedRequest;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRequestById;

  private final SharedSQLiteStatement __preparedStmtOfClearAllRequests;

  private final SharedSQLiteStatement __preparedStmtOfClearFailedRequests;

  public QueuedRequestDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQueuedRequest = new EntityInsertionAdapter<QueuedRequest>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `queued_requests` (`id`,`endpoint`,`method`,`body`,`timestamp`,`retry_count`,`event_id`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final QueuedRequest entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getEndpoint() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEndpoint());
        }
        if (entity.getMethod() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getMethod());
        }
        if (entity.getBody() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBody());
        }
        statement.bindLong(5, entity.getTimestamp());
        statement.bindLong(6, entity.getRetryCount());
        if (entity.getEventId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getEventId());
        }
      }
    };
    this.__deletionAdapterOfQueuedRequest = new EntityDeletionOrUpdateAdapter<QueuedRequest>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `queued_requests` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final QueuedRequest entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfQueuedRequest = new EntityDeletionOrUpdateAdapter<QueuedRequest>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `queued_requests` SET `id` = ?,`endpoint` = ?,`method` = ?,`body` = ?,`timestamp` = ?,`retry_count` = ?,`event_id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final QueuedRequest entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getEndpoint() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEndpoint());
        }
        if (entity.getMethod() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getMethod());
        }
        if (entity.getBody() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBody());
        }
        statement.bindLong(5, entity.getTimestamp());
        statement.bindLong(6, entity.getRetryCount());
        if (entity.getEventId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getEventId());
        }
        statement.bindLong(8, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteRequestById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM queued_requests WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearAllRequests = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM queued_requests";
        return _query;
      }
    };
    this.__preparedStmtOfClearFailedRequests = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM queued_requests WHERE retry_count >= ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertRequest(final QueuedRequest request,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfQueuedRequest.insertAndReturnId(request);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRequest(final QueuedRequest request,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfQueuedRequest.handle(request);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateRequest(final QueuedRequest request,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfQueuedRequest.handle(request);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRequestById(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRequestById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfDeleteRequestById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object clearAllRequests(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllRequests.acquire();
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
          __preparedStmtOfClearAllRequests.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object clearFailedRequests(final int maxRetries,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearFailedRequests.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, maxRetries);
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
          __preparedStmtOfClearFailedRequests.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<QueuedRequest>> getAllQueuedRequests() {
    final String _sql = "SELECT * FROM queued_requests ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"queued_requests"}, new Callable<List<QueuedRequest>>() {
      @Override
      @NonNull
      public List<QueuedRequest> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEndpoint = CursorUtil.getColumnIndexOrThrow(_cursor, "endpoint");
          final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfRetryCount = CursorUtil.getColumnIndexOrThrow(_cursor, "retry_count");
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "event_id");
          final List<QueuedRequest> _result = new ArrayList<QueuedRequest>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final QueuedRequest _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpEndpoint;
            if (_cursor.isNull(_cursorIndexOfEndpoint)) {
              _tmpEndpoint = null;
            } else {
              _tmpEndpoint = _cursor.getString(_cursorIndexOfEndpoint);
            }
            final String _tmpMethod;
            if (_cursor.isNull(_cursorIndexOfMethod)) {
              _tmpMethod = null;
            } else {
              _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
            }
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final int _tmpRetryCount;
            _tmpRetryCount = _cursor.getInt(_cursorIndexOfRetryCount);
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            _item = new QueuedRequest(_tmpId,_tmpEndpoint,_tmpMethod,_tmpBody,_tmpTimestamp,_tmpRetryCount,_tmpEventId);
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
  public Object getPendingRequests(final int maxRetries,
      final Continuation<? super List<QueuedRequest>> $completion) {
    final String _sql = "SELECT * FROM queued_requests WHERE retry_count < ? ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, maxRetries);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<QueuedRequest>>() {
      @Override
      @NonNull
      public List<QueuedRequest> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEndpoint = CursorUtil.getColumnIndexOrThrow(_cursor, "endpoint");
          final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfRetryCount = CursorUtil.getColumnIndexOrThrow(_cursor, "retry_count");
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "event_id");
          final List<QueuedRequest> _result = new ArrayList<QueuedRequest>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final QueuedRequest _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpEndpoint;
            if (_cursor.isNull(_cursorIndexOfEndpoint)) {
              _tmpEndpoint = null;
            } else {
              _tmpEndpoint = _cursor.getString(_cursorIndexOfEndpoint);
            }
            final String _tmpMethod;
            if (_cursor.isNull(_cursorIndexOfMethod)) {
              _tmpMethod = null;
            } else {
              _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
            }
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final int _tmpRetryCount;
            _tmpRetryCount = _cursor.getInt(_cursorIndexOfRetryCount);
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            _item = new QueuedRequest(_tmpId,_tmpEndpoint,_tmpMethod,_tmpBody,_tmpTimestamp,_tmpRetryCount,_tmpEventId);
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
  public Object getFailedRequests(final int maxRetries,
      final Continuation<? super List<QueuedRequest>> $completion) {
    final String _sql = "SELECT * FROM queued_requests WHERE retry_count >= ? ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, maxRetries);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<QueuedRequest>>() {
      @Override
      @NonNull
      public List<QueuedRequest> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEndpoint = CursorUtil.getColumnIndexOrThrow(_cursor, "endpoint");
          final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfRetryCount = CursorUtil.getColumnIndexOrThrow(_cursor, "retry_count");
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "event_id");
          final List<QueuedRequest> _result = new ArrayList<QueuedRequest>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final QueuedRequest _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpEndpoint;
            if (_cursor.isNull(_cursorIndexOfEndpoint)) {
              _tmpEndpoint = null;
            } else {
              _tmpEndpoint = _cursor.getString(_cursorIndexOfEndpoint);
            }
            final String _tmpMethod;
            if (_cursor.isNull(_cursorIndexOfMethod)) {
              _tmpMethod = null;
            } else {
              _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
            }
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final int _tmpRetryCount;
            _tmpRetryCount = _cursor.getInt(_cursorIndexOfRetryCount);
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            _item = new QueuedRequest(_tmpId,_tmpEndpoint,_tmpMethod,_tmpBody,_tmpTimestamp,_tmpRetryCount,_tmpEventId);
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
  public Object getRequestsByType(final String endpoint,
      final Continuation<? super List<QueuedRequest>> $completion) {
    final String _sql = "SELECT * FROM queued_requests WHERE endpoint = ? ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (endpoint == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endpoint);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<QueuedRequest>>() {
      @Override
      @NonNull
      public List<QueuedRequest> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEndpoint = CursorUtil.getColumnIndexOrThrow(_cursor, "endpoint");
          final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfRetryCount = CursorUtil.getColumnIndexOrThrow(_cursor, "retry_count");
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "event_id");
          final List<QueuedRequest> _result = new ArrayList<QueuedRequest>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final QueuedRequest _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpEndpoint;
            if (_cursor.isNull(_cursorIndexOfEndpoint)) {
              _tmpEndpoint = null;
            } else {
              _tmpEndpoint = _cursor.getString(_cursorIndexOfEndpoint);
            }
            final String _tmpMethod;
            if (_cursor.isNull(_cursorIndexOfMethod)) {
              _tmpMethod = null;
            } else {
              _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
            }
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final int _tmpRetryCount;
            _tmpRetryCount = _cursor.getInt(_cursorIndexOfRetryCount);
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            _item = new QueuedRequest(_tmpId,_tmpEndpoint,_tmpMethod,_tmpBody,_tmpTimestamp,_tmpRetryCount,_tmpEventId);
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
  public Object getCriticalRequests(final Continuation<? super List<QueuedRequest>> $completion) {
    final String _sql = "SELECT * FROM queued_requests WHERE endpoint IN ('in', 'out') ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<QueuedRequest>>() {
      @Override
      @NonNull
      public List<QueuedRequest> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEndpoint = CursorUtil.getColumnIndexOrThrow(_cursor, "endpoint");
          final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfRetryCount = CursorUtil.getColumnIndexOrThrow(_cursor, "retry_count");
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "event_id");
          final List<QueuedRequest> _result = new ArrayList<QueuedRequest>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final QueuedRequest _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpEndpoint;
            if (_cursor.isNull(_cursorIndexOfEndpoint)) {
              _tmpEndpoint = null;
            } else {
              _tmpEndpoint = _cursor.getString(_cursorIndexOfEndpoint);
            }
            final String _tmpMethod;
            if (_cursor.isNull(_cursorIndexOfMethod)) {
              _tmpMethod = null;
            } else {
              _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
            }
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final int _tmpRetryCount;
            _tmpRetryCount = _cursor.getInt(_cursorIndexOfRetryCount);
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            _item = new QueuedRequest(_tmpId,_tmpEndpoint,_tmpMethod,_tmpBody,_tmpTimestamp,_tmpRetryCount,_tmpEventId);
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
  public Object getRequestById(final long id,
      final Continuation<? super QueuedRequest> $completion) {
    final String _sql = "SELECT * FROM queued_requests WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<QueuedRequest>() {
      @Override
      @Nullable
      public QueuedRequest call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEndpoint = CursorUtil.getColumnIndexOrThrow(_cursor, "endpoint");
          final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
          final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfRetryCount = CursorUtil.getColumnIndexOrThrow(_cursor, "retry_count");
          final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "event_id");
          final QueuedRequest _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpEndpoint;
            if (_cursor.isNull(_cursorIndexOfEndpoint)) {
              _tmpEndpoint = null;
            } else {
              _tmpEndpoint = _cursor.getString(_cursorIndexOfEndpoint);
            }
            final String _tmpMethod;
            if (_cursor.isNull(_cursorIndexOfMethod)) {
              _tmpMethod = null;
            } else {
              _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
            }
            final String _tmpBody;
            if (_cursor.isNull(_cursorIndexOfBody)) {
              _tmpBody = null;
            } else {
              _tmpBody = _cursor.getString(_cursorIndexOfBody);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final int _tmpRetryCount;
            _tmpRetryCount = _cursor.getInt(_cursorIndexOfRetryCount);
            final String _tmpEventId;
            if (_cursor.isNull(_cursorIndexOfEventId)) {
              _tmpEventId = null;
            } else {
              _tmpEventId = _cursor.getString(_cursorIndexOfEventId);
            }
            _result = new QueuedRequest(_tmpId,_tmpEndpoint,_tmpMethod,_tmpBody,_tmpTimestamp,_tmpRetryCount,_tmpEventId);
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
  public Object getQueuedRequestCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM queued_requests";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
  public Object getPendingRequestCount(final int maxRetries,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM queued_requests WHERE retry_count < ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, maxRetries);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
  public Object getFailedRequestCount(final int maxRetries,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM queued_requests WHERE retry_count >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, maxRetries);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
  public Object getCriticalRequestCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM queued_requests WHERE endpoint IN ('in', 'out')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
}
