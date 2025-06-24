package com.company.attendance.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0007\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/company/attendance/data/local/Converters;", "", "()V", "dateToTimestamp", "", "date", "Lkotlinx/datetime/LocalDateTime;", "(Lkotlinx/datetime/LocalDateTime;)Ljava/lang/Long;", "fromDateTimestamp", "Lkotlinx/datetime/LocalDate;", "value", "(Ljava/lang/Long;)Lkotlinx/datetime/LocalDate;", "fromTimestamp", "(Ljava/lang/Long;)Lkotlinx/datetime/LocalDateTime;", "localDateToTimestamp", "(Lkotlinx/datetime/LocalDate;)Ljava/lang/Long;", "app_debug"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime fromTimestamp(@org.jetbrains.annotations.Nullable()
    java.lang.Long value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long dateToTimestamp(@org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime date) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDate fromDateTimestamp(@org.jetbrains.annotations.Nullable()
    java.lang.Long value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long localDateToTimestamp(@org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDate date) {
        return null;
    }
}