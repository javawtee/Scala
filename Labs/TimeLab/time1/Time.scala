/*
 *  Thong Le - 011922131
 *  CS 152 - Fall 2018 - J. Pearce
 *  Assignment 5 - OOP Scala - TimeLab
 */
package time1

class Time (val hour: Int, val minute: Int = 0){
  if(hour < 0 || hour > 23 || minute < 0 || minute > 59) throw new IllegalArgumentException
  val minutesSinceMidNight = (hour * 60 + minute)
  def before(other: Time): Boolean = minutesSinceMidNight < other.minutesSinceMidNight
  override def toString = hour + ":" + (if(minute >= 10)  minute else ("0" + minute))
}

object Time {
  def apply(hour: Int, minute: Int = 0) = new Time(hour, minute)
}