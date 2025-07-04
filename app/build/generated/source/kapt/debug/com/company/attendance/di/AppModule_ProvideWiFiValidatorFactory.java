// Generated by Dagger (https://dagger.dev).
package com.company.attendance.di;

import android.content.Context;
import com.company.attendance.service.WiFiMonitoringService;
import com.company.attendance.utils.WiFiValidator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideWiFiValidatorFactory implements Factory<WiFiValidator> {
  private final Provider<Context> contextProvider;

  private final Provider<WiFiMonitoringService> wifiMonitoringServiceProvider;

  public AppModule_ProvideWiFiValidatorFactory(Provider<Context> contextProvider,
      Provider<WiFiMonitoringService> wifiMonitoringServiceProvider) {
    this.contextProvider = contextProvider;
    this.wifiMonitoringServiceProvider = wifiMonitoringServiceProvider;
  }

  @Override
  public WiFiValidator get() {
    return provideWiFiValidator(contextProvider.get(), wifiMonitoringServiceProvider.get());
  }

  public static AppModule_ProvideWiFiValidatorFactory create(Provider<Context> contextProvider,
      Provider<WiFiMonitoringService> wifiMonitoringServiceProvider) {
    return new AppModule_ProvideWiFiValidatorFactory(contextProvider, wifiMonitoringServiceProvider);
  }

  public static WiFiValidator provideWiFiValidator(Context context,
      WiFiMonitoringService wifiMonitoringService) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideWiFiValidator(context, wifiMonitoringService));
  }
}
