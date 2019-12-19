/*
 *  Thong Le - 011922131
 *  CS 152 - Fall 2018 - J. Pearce
 *  Assignment 5 - OOP Scala - TimeLab
 */
package time1

object TestTime1 extends App {
  try {
    val t1 = Time(3, 45)
    val t2 = Time(3,5)
    println("t1 = " + t1)
    println("t2 = " + t2)
    println("t1 < t2 = " + t1.before(t2))
    println("t1 minutes since midnight = " + t1.minutesSinceMidNight)
    val t3 = Time(14, 60) // oops!
  } catch {
    case e: IllegalArgumentException => println(e)
  }
  
}