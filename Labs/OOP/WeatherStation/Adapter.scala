// Target
trait IThermometer {
   // = avg degrees Farenheit
   def getMeanTemperature(cities: List[String]): Double
}

// Adaptee
class CelsiusTherm {
   // = degrees Celsius 
   def computeTemp(city: String) = 50 * math.random // fake temperature for now
}

object CelsiusTherm {
  def apply = new CelsiusTherm
}

//Adapter
class ThermoAdapter extends IThermometer {
  val adaptee = new CelsiusTherm
  def getMeanTemperature(cities: List[String]): Double = {
    var celciusTemp: Double = cities.map(adaptee.computeTemp(_)).reduce(_ + _) / cities.size
    // convert to Farenheit
    ((celciusTemp * 9/5) + 32) 
  }
}

object ThermoAdapter {
  def apply = new ThermoAdapter
}

