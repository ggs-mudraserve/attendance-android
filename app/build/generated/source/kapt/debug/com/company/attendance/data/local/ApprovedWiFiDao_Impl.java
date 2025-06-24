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
import com.company.attendance.data.model.ApprovedWiFiNetwork;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class ApprovedWiFiDao_Impl implements ApprovedWiFiDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ApprovedWiFiNetwork> __insertionAdapterOfApprovedWiFiNetwork;

  private final EntityDeletionOrUpdateAdapter<ApprovedWiFiNetwork> __deletionAdapterOfApprovedWiFiNetwork;

  private final EntityDeletionOrUpdateAdapter<ApprovedWiFiNetwork> __updateAdapterOfApprovedWiFiNetwork;

  private final SharedSQLiteStatement __preparedStmtOfDeleteNetworkByBSSID;

  private final SharedSQLiteStatement __preparedStmtOfClearAllNetworks;

  private final SharedSQLiteStatement __preparedStmtOfDeactivateAllNetworks;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastValidated;

  public ApprovedWiFiDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfApprovedWiFiNetwork = new EntityInsertionAdapter<ApprovedWiFiNetwork>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `approved_wifi_networks` (`bssid`,`label`,`ssid`,`last_validated`,`is_active`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ApprovedWiFiNetwork entity) {
        if (entity.getBssid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getBssid());
        }
        if (entity.getLabel() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getLabel());
        }
        if (entity.getSsid() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSsid());
        }
        statement.bindLong(4, entity.getLastValidated());
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(5, _tmp);
      }
    };
    this.__deletionAdapterOfApprovedWiFiNetwork = new EntityDeletionOrUpdateAdapter<ApprovedWiFiNetwork>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `approved_wifi_networks` WHERE `bssid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ApprovedWiFiNetwork entity) {
        if (entity.getBssid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getBssid());
        }
      }
    };
    this.__updateAdapterOfApprovedWiFiNetwork = new EntityDeletionOrUpdateAdapter<ApprovedWiFiNetwork>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `approved_wifi_networks` SET `bssid` = ?,`label` = ?,`ssid` = ?,`last_validated` = ?,`is_active` = ? WHERE `bssid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ApprovedWiFiNetwork entity) {
        if (entity.getBssid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getBssid());
        }
        if (entity.getLabel() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getLabel());
        }
        if (entity.getSsid() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSsid());
        }
        statement.bindLong(4, entity.getLastValidated());
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(5, _tmp);
        if (entity.getBssid() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getBssid());
        }
      }
    };
    this.__preparedStmtOfDeleteNetworkByBSSID = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM approved_wifi_networks WHERE bssid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearAllNetworks = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM approved_wifi_networks";
        return _query;
      }
    };
    this.__preparedStmtOfDeactivateAllNetworks = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE approved_wifi_networks SET is_active = 0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLastValidated = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE approved_wifi_networks SET last_validated = ? WHERE bssid = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertNetwork(final ApprovedWiFiNetwork network,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfApprovedWiFiNetwork.insert(network);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertNetworks(final List<ApprovedWiFiNetwork> networks,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfApprovedWiFiNetwork.insert(networks);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNetwork(final ApprovedWiFiNetwork network,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfApprovedWiFiNetwork.handle(network);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNetwork(final ApprovedWiFiNetwork network,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfApprovedWiFiNetwork.handle(network);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNetworkByBSSID(final String bssid,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNetworkByBSSID.acquire();
        int _argIndex = 1;
        if (bssid == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, bssid);
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
          __preparedStmtOfDeleteNetworkByBSSID.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object clearAllNetworks(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllNetworks.acquire();
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
          __preparedStmtOfClearAllNetworks.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deactivateAllNetworks(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeactivateAllNetworks.acquire();
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
          __preparedStmtOfDeactivateAllNetworks.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLastValidated(final String bssid, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastValidated.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 2;
        if (bssid == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, bssid);
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
          __preparedStmtOfUpdateLastValidated.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ApprovedWiFiNetwork>> getAllApprovedNetworks() {
    final String _sql = "SELECT * FROM approved_wifi_networks WHERE is_active = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"approved_wifi_networks"}, new Callable<List<ApprovedWiFiNetwork>>() {
      @Override
      @NonNull
      public List<ApprovedWiFiNetwork> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBssid = CursorUtil.getColumnIndexOrThrow(_cursor, "bssid");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfSsid = CursorUtil.getColumnIndexOrThrow(_cursor, "ssid");
          final int _cursorIndexOfLastValidated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_validated");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
          final List<ApprovedWiFiNetwork> _result = new ArrayList<ApprovedWiFiNetwork>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ApprovedWiFiNetwork _item;
            final String _tmpBssid;
            if (_cursor.isNull(_cursorIndexOfBssid)) {
              _tmpBssid = null;
            } else {
              _tmpBssid = _cursor.getString(_cursorIndexOfBssid);
            }
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final String _tmpSsid;
            if (_cursor.isNull(_cursorIndexOfSsid)) {
              _tmpSsid = null;
            } else {
              _tmpSsid = _cursor.getString(_cursorIndexOfSsid);
            }
            final long _tmpLastValidated;
            _tmpLastValidated = _cursor.getLong(_cursorIndexOfLastValidated);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new ApprovedWiFiNetwork(_tmpBssid,_tmpLabel,_tmpSsid,_tmpLastValidated,_tmpIsActive);
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
  public Object getAllApprovedNetworksSync(
      final Continuation<? super List<ApprovedWiFiNetwork>> $completion) {
    final String _sql = "SELECT * FROM approved_wifi_networks WHERE is_active = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ApprovedWiFiNetwork>>() {
      @Override
      @NonNull
      public List<ApprovedWiFiNetwork> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBssid = CursorUtil.getColumnIndexOrThrow(_cursor, "bssid");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfSsid = CursorUtil.getColumnIndexOrThrow(_cursor, "ssid");
          final int _cursorIndexOfLastValidated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_validated");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
          final List<ApprovedWiFiNetwork> _result = new ArrayList<ApprovedWiFiNetwork>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ApprovedWiFiNetwork _item;
            final String _tmpBssid;
            if (_cursor.isNull(_cursorIndexOfBssid)) {
              _tmpBssid = null;
            } else {
              _tmpBssid = _cursor.getString(_cursorIndexOfBssid);
            }
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final String _tmpSsid;
            if (_cursor.isNull(_cursorIndexOfSsid)) {
              _tmpSsid = null;
            } else {
              _tmpSsid = _cursor.getString(_cursorIndexOfSsid);
            }
            final long _tmpLastValidated;
            _tmpLastValidated = _cursor.getLong(_cursorIndexOfLastValidated);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new ApprovedWiFiNetwork(_tmpBssid,_tmpLabel,_tmpSsid,_tmpLastValidated,_tmpIsActive);
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
  public Object getNetworkByBSSID(final String bssid,
      final Continuation<? super ApprovedWiFiNetwork> $completion) {
    final String _sql = "SELECT * FROM approved_wifi_networks WHERE bssid = ? AND is_active = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (bssid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, bssid);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ApprovedWiFiNetwork>() {
      @Override
      @Nullable
      public ApprovedWiFiNetwork call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBssid = CursorUtil.getColumnIndexOrThrow(_cursor, "bssid");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfSsid = CursorUtil.getColumnIndexOrThrow(_cursor, "ssid");
          final int _cursorIndexOfLastValidated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_validated");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
          final ApprovedWiFiNetwork _result;
          if (_cursor.moveToFirst()) {
            final String _tmpBssid;
            if (_cursor.isNull(_cursorIndexOfBssid)) {
              _tmpBssid = null;
            } else {
              _tmpBssid = _cursor.getString(_cursorIndexOfBssid);
            }
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final String _tmpSsid;
            if (_cursor.isNull(_cursorIndexOfSsid)) {
              _tmpSsid = null;
            } else {
              _tmpSsid = _cursor.getString(_cursorIndexOfSsid);
            }
            final long _tmpLastValidated;
            _tmpLastValidated = _cursor.getLong(_cursorIndexOfLastValidated);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _result = new ApprovedWiFiNetwork(_tmpBssid,_tmpLabel,_tmpSsid,_tmpLastValidated,_tmpIsActive);
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
  public Object getAllApprovedBSSIDs(final Continuation<? super List<String>> $completion) {
    final String _sql = "SELECT bssid FROM approved_wifi_networks WHERE is_active = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<String>>() {
      @Override
      @NonNull
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
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
  public Object getApprovedNetworkCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM approved_wifi_networks WHERE is_active = 1";
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
  public Object getStaleNetworks(final long threshold,
      final Continuation<? super List<ApprovedWiFiNetwork>> $completion) {
    final String _sql = "SELECT * FROM approved_wifi_networks WHERE last_validated < ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, threshold);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ApprovedWiFiNetwork>>() {
      @Override
      @NonNull
      public List<ApprovedWiFiNetwork> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBssid = CursorUtil.getColumnIndexOrThrow(_cursor, "bssid");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfSsid = CursorUtil.getColumnIndexOrThrow(_cursor, "ssid");
          final int _cursorIndexOfLastValidated = CursorUtil.getColumnIndexOrThrow(_cursor, "last_validated");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
          final List<ApprovedWiFiNetwork> _result = new ArrayList<ApprovedWiFiNetwork>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ApprovedWiFiNetwork _item;
            final String _tmpBssid;
            if (_cursor.isNull(_cursorIndexOfBssid)) {
              _tmpBssid = null;
            } else {
              _tmpBssid = _cursor.getString(_cursorIndexOfBssid);
            }
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final String _tmpSsid;
            if (_cursor.isNull(_cursorIndexOfSsid)) {
              _tmpSsid = null;
            } else {
              _tmpSsid = _cursor.getString(_cursorIndexOfSsid);
            }
            final long _tmpLastValidated;
            _tmpLastValidated = _cursor.getLong(_cursorIndexOfLastValidated);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new ApprovedWiFiNetwork(_tmpBssid,_tmpLabel,_tmpSsid,_tmpLastValidated,_tmpIsActive);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
