// Generated by Dagger (https://dagger.dev).
package com.company.attendance.utils;

import com.company.attendance.data.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class SessionManager_Factory implements Factory<SessionManager> {
  private final Provider<AuthRepository> authRepositoryProvider;

  public SessionManager_Factory(Provider<AuthRepository> authRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public SessionManager get() {
    return newInstance(authRepositoryProvider.get());
  }

  public static SessionManager_Factory create(Provider<AuthRepository> authRepositoryProvider) {
    return new SessionManager_Factory(authRepositoryProvider);
  }

  public static SessionManager newInstance(AuthRepository authRepository) {
    return new SessionManager(authRepository);
  }
}
