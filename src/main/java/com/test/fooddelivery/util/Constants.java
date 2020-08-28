package com.test.fooddelivery.util;

import java.time.LocalTime;

public interface Constants {

  LocalTime MORNING_OPEN = LocalTime.of(8, 00);
  LocalTime MORNING_CLOSE = LocalTime.of(10, 00);
  double morningInflation = 0.10d;
  
  
  LocalTime AFTERNOON_OPEN = LocalTime.of(12, 00);
  LocalTime AFTERNOON_CLOSE = LocalTime.of(15, 00);
  double afternoonInflation = 0.15d;
  
  LocalTime EVENING_OPEN = LocalTime.of(21, 00);
  LocalTime EVENING_CLOSE = LocalTime.of(00, 00);
  double eveningInflation = 0.20d;
}
