// Generated by Dagger (https://dagger.dev).
package com.company.attendance.di;

import com.company.attendance.data.repository.AuthRepository;
import com.company.attendance.utils.PreferencesManager;
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
public final class AppModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<SupabaseClient> supabaseClientProvider;

  private final Provider<PreferencesManager> preferencesManagerProvider;

  public AppModule_ProvideAuthRepositoryFactory(Provider<SupabaseClient> supabaseClientProvider,
      Provider<PreferencesManager> preferencesManagerProvider) {
    this.supabaseClientProvider = supabaseClientProvider;
    this.preferencesManagerProvider = preferencesManagerProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(supabaseClientProvider.get(), preferencesManagerProvider.get());
  }

  public static AppModule_ProvideAuthRepositoryFactory create(
      Provider<SupabaseClient> supabaseClientProvider,
      Provider<PreferencesManager> preferencesManagerProvider) {
    return new AppModule_ProvideAuthRepositoryFactory(supabaseClientProvider, preferencesManagerProvider);
  }

  public static AuthRepository provideAuthRepository(SupabaseClient supabaseClient,
      PreferencesManager preferencesManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthRepository(supabaseClient, preferencesManager));
  }
}
