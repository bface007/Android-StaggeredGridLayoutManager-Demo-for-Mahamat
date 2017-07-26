package com.bfacedemo.demopourmahamat.utils;

/**
 * Created by bface007 on 26/07/2017.
 */

public class TimeUtils {
  public static String getFormattedTime(long time) {
    long seconds = time / 1000;

    if(seconds < 60)
      return String.valueOf(seconds + " sec");

    long minutes = seconds / 60;

    if(minutes < 60)
      return String.valueOf(minutes + " min");
    else
      return String.valueOf( Math.round((float)(minutes / 60)) + "hrs");
  }
}
