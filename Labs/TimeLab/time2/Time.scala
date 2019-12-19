package time2

class Time (private var h: Int,private var m: Int = 0){
  def hours = h
  def minutes = m
  def hours_= (x: Int) = if(x > 23 || x < 0) throw new IllegalArgumentException else h = x
  def minutes_= (x: Int) = if(x > 59 || x < 0) throw new IllegalArgumentException else m = x
  if(h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException
  def minutesSinceMidNight = (h * 60 + m) // it is better to use def here than a constant val/var, since every time we update hour/ minute, method is called to recalculate
  def before(other: Time): Boolean = minutesSinceMidNight < other.minutesSinceMidNight
  override def toString = h + ":" + (if(m >= 10)  m else ("0" + m))
  
}

object Time {
  def apply(hour: Int, minute: Int = 0) = new Time(hour, minute)
}