package time2

object TestTime2 extends App {
  try {
    val t1 = Time(22, 5)
    val t2 = Time(20,10)
    println("t1 = " + t1)
    println("t2 = " + t2)
    println("t1 < t2 = " + t1.before(t2))
    println("t1 minutes since midnight = " + t1.minutesSinceMidNight)
    t1.hours = (20)
    println("t1 < t2 = " + t1.before(t2))
    t1.minutes = 60
    //val t3 = Time(14, 60) // oops!
  } catch {
    case e: IllegalArgumentException => println(e)
  }
}