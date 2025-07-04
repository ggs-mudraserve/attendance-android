// Generated by Dagger (https://dagger.dev).
package com.company.attendance.utils;

import android.content.Context;
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
public final class NotificationUtils_Factory implements Factory<NotificationUtils> {
  private final Provider<Context> contextProvider;

  public NotificationUtils_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NotificationUtils get() {
    return newInstance(contextProvider.get());
  }

  public static NotificationUtils_Factory create(Provider<Context> contextProvider) {
    return new NotificationUtils_Factory(contextProvider);
  }

  public static NotificationUtils newInstance(Context context) {
    return new NotificationUtils(context);
  }
}
