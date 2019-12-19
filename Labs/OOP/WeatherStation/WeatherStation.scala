
object WeatherStation extends App {
  val thermometer: IThermometer = new ThermoAdapter
  val avgTemp = thermometer.getMeanTemperature(List("LA", "SF", "SLC", "Rio"))
  println("avg temp = " + avgTemp)
}