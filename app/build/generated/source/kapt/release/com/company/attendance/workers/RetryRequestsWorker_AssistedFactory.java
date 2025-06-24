package com.company.attendance.workers;

import androidx.hilt.work.WorkerAssistedFactory;
import dagger.assisted.AssistedFactory;

@AssistedFactory
public interface RetryRequestsWorker_AssistedFactory extends WorkerAssistedFactory<RetryRequestsWorker> {
}
