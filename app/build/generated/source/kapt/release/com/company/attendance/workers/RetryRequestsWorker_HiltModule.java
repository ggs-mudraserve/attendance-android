package com.company.attendance.workers;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
@InstallIn(SingletonComponent.class)
@OriginatingElement(
    topLevelClass = RetryRequestsWorker.class
)
public interface RetryRequestsWorker_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.company.attendance.workers.RetryRequestsWorker")
  WorkerAssistedFactory<? extends ListenableWorker> bind(
      RetryRequestsWorker_AssistedFactory factory);
}
