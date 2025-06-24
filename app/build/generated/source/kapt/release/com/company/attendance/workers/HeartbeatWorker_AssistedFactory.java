package com.company.attendance.workers;

import androidx.hilt.work.WorkerAssistedFactory;
import dagger.assisted.AssistedFactory;

@AssistedFactory
public interface HeartbeatWorker_AssistedFactory extends WorkerAssistedFactory<HeartbeatWorker> {
}
