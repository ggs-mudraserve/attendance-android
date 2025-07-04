// Generated by Dagger (https://dagger.dev).
package com.company.attendance.di;

import com.company.attendance.network.AuthInterceptor;
import com.company.attendance.utils.SessionManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class AppModule_ProvideAuthInterceptorFactory implements Factory<AuthInterceptor> {
  private final Provider<SessionManager> sessionManagerProvider;

  public AppModule_ProvideAuthInterceptorFactory(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  @Override
  public AuthInterceptor get() {
    return provideAuthInterceptor(sessionManagerProvider.get());
  }

  public static AppModule_ProvideAuthInterceptorFactory create(
      Provider<SessionManager> sessionManagerProvider) {
    return new AppModule_ProvideAuthInterceptorFactory(sessionManagerProvider);
  }

  public static AuthInterceptor provideAuthInterceptor(SessionManager sessionManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthInterceptor(sessionManager));
  }
}
