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
    topLevelClass = HeartbeatWorker.class
)
public interface HeartbeatWorker_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.company.attendance.workers.HeartbeatWorker")
  WorkerAssistedFactory<? extends ListenableWorker> bind(HeartbeatWorker_AssistedFactory factory);
}
