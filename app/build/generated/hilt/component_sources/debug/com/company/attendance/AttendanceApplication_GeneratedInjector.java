package com.company.attendance;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = AttendanceApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface AttendanceApplication_GeneratedInjector {
  void injectAttendanceApplication(AttendanceApplication attendanceApplication);
}
