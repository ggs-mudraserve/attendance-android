// Generated by Dagger (https://dagger.dev).
package com.company.attendance.di;

import com.company.attendance.data.local.AttendanceRecordDao;
import com.company.attendance.data.local.QueuedRequestDao;
import com.company.attendance.data.remote.AttendanceApiService;
import com.company.attendance.data.repository.AttendanceRepository;
import com.company.attendance.service.RequestQueueManager;
import com.company.attendance.service.WiFiMonitoringService;
import com.company.attendance.utils.DeviceUtils;
import com.company.attendance.utils.PreferencesManager;
import com.company.attendance.utils.WiFiValidator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.github.jan.supabase.SupabaseClient;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideAttendanceRepositoryFactory implements Factory<AttendanceRepository> {
  private final Provider<SupabaseClient> supabaseClientProvider;

  private final Provider<AttendanceApiService> apiServiceProvider;

  private final Provider<QueuedRequestDao> queuedRequestDaoProvider;

  private final Provider<PreferencesManager> preferencesManagerProvider;

  private final Provider<DeviceUtils> deviceUtilsProvider;

  private final Provider<WiFiValidator> wifiValidatorProvider;

  private final Provider<WiFiMonitoringService> wifiMonitoringServiceProvider;

  private final Provider<RequestQueueManager> requestQueueManagerProvider;

  private final Provider<AttendanceRecordDao> attendanceRecordDaoProvider;

  public AppModule_ProvideAttendanceRepositoryFactory(
      Provider<SupabaseClient> supabaseClientProvider,
      Provider<AttendanceApiService> apiServiceProvider,
      Provider<QueuedRequestDao> queuedRequestDaoProvider,
      Provider<PreferencesManager> preferencesManagerProvider,
      Provider<DeviceUtils> deviceUtilsProvider, Provider<WiFiValidator> wifiValidatorProvider,
      Provider<WiFiMonitoringService> wifiMonitoringServiceProvider,
      Provider<RequestQueueManager> requestQueueManagerProvider,
      Provider<AttendanceRecordDao> attendanceRecordDaoProvider) {
    this.supabaseClientProvider = supabaseClientProvider;
    this.apiServiceProvider = apiServiceProvider;
    this.queuedRequestDaoProvider = queuedRequestDaoProvider;
    this.preferencesManagerProvider = preferencesManagerProvider;
    this.deviceUtilsProvider = deviceUtilsProvider;
    this.wifiValidatorProvider = wifiValidatorProvider;
    this.wifiMonitoringServiceProvider = wifiMonitoringServiceProvider;
    this.requestQueueManagerProvider = requestQueueManagerProvider;
    this.attendanceRecordDaoProvider = attendanceRecordDaoProvider;
  }

  @Override
  public AttendanceRepository get() {
    return provideAttendanceRepository(supabaseClientProvider.get(), apiServiceProvider.get(), queuedRequestDaoProvider.get(), preferencesManagerProvider.get(), deviceUtilsProvider.get(), wifiValidatorProvider.get(), wifiMonitoringServiceProvider.get(), requestQueueManagerProvider.get(), attendanceRecordDaoProvider.get());
  }

  public static AppModule_ProvideAttendanceRepositoryFactory create(
      Provider<SupabaseClient> supabaseClientProvider,
      Provider<AttendanceApiService> apiServiceProvider,
      Provider<QueuedRequestDao> queuedRequestDaoProvider,
      Provider<PreferencesManager> preferencesManagerProvider,
      Provider<DeviceUtils> deviceUtilsProvider, Provider<WiFiValidator> wifiValidatorProvider,
      Provider<WiFiMonitoringService> wifiMonitoringServiceProvider,
      Provider<RequestQueueManager> requestQueueManagerProvider,
      Provider<AttendanceRecordDao> attendanceRecordDaoProvider) {
    return new AppModule_ProvideAttendanceRepositoryFactory(supabaseClientProvider, apiServiceProvider, queuedRequestDaoProvider, preferencesManagerProvider, deviceUtilsProvider, wifiValidatorProvider, wifiMonitoringServiceProvider, requestQueueManagerProvider, attendanceRecordDaoProvider);
  }

  public static AttendanceRepository provideAttendanceRepository(SupabaseClient supabaseClient,
      AttendanceApiService apiService, QueuedRequestDao queuedRequestDao,
      PreferencesManager preferencesManager, DeviceUtils deviceUtils, WiFiValidator wifiValidator,
      WiFiMonitoringService wifiMonitoringService, RequestQueueManager requestQueueManager,
      AttendanceRecordDao attendanceRecordDao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAttendanceRepository(supabaseClient, apiService, queuedRequestDao, preferencesManager, deviceUtils, wifiValidator, wifiMonitoringService, requestQueueManager, attendanceRecordDao));
  }
}
