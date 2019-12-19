import scala.io.StdIn._
import scala.collection.mutable.Map

object Indus extends App {
  override def main(args: Array[String]) {
    var dvds = Map[Description, Int]()
    /*var flag = true // user wants to input more dvds
    while(flag) {
      println("Enter description (i.e: The Matrix DVD): ")
      val desc = readLine()
      
      var priceFlag = false
      var price : Double = 0
      while(!priceFlag) {
        try {
          println("Enter price: ")
          price = readLine().toDouble
          priceFlag = true
        } catch {
          case e: NumberFormatException => println("Invalid price format")
        }
      }
      
      println("Enter supplier (i.e: DVD World): ")
      val supplier = readLine()
      
      val dvd = Item(new Description(desc, price, supplier))
      
      // proceed to mutable Map
      if(!dvds.isEmpty && dvds.contains(dvd.description)) dvds(dvd.description) += 1
      else dvds += (dvd.description -> 1) 
        s
      println("Item added successfully. Continue (Y, N)?")
      val option = readLine()
      if(option == 'N') flag = false
    }*/ // take input from user
    def addStock(dvd: Item) {
      if (!dvds.keySet.exists(_ == dvd.description)) dvds += dvd.description -> 1 // add element
      else dvds(dvds.filter(_._1 == dvd.description).keys.head) += 1
      println("Successfully added item with id: " + dvd.getId + " to Inventory")
    }
    
    val dvd1 = Item(new Description("The Matrix DVD", 15.50, "DVD World"))
    val dvd2 = Item(new Description("The Matrix DVD", 15.50, "DVD World"))
    val dvd3 = Item(new Description("Iron Man DVD", 15.50, "DVD Planet"))
    val dvd4 = Item(new Description("Iron Man DVD", 15.50, "DVD Planet"))
    val dvd5 = Item(new Description("The Matrix DVD", 15.50, "DVD World"))
    val dvd6 = Item(new Description("The Matrix DVD", 15.50, "DVD World"))
    val dvd7 = Item(new Description("The Matrix DVD", 15.50, "DVD World"))
    val dvd8 = Item(new Description("The Terminator DVD", 13.25, "DVD World"))
    val dvd9 = Item(new Description("The Terminator DVD", 13.25, "DVD World"))
    val dvd10 = Item(new Description("The Terminator DVD", 13.25, "DVD World"))
    addStock(dvd1)
    addStock(dvd2)
    addStock(dvd3)
    addStock(dvd4)
    addStock(dvd5)
    addStock(dvd6)
    addStock(dvd7)
    addStock(dvd8)
    addStock(dvd9)
    addStock(dvd10)
    
    // print inventory
    println("=== Print Inventory ===")
    dvds.keys.foreach { i =>
      print(i.toString + " == # in stock: " + dvds(i) + "\n")
    }
  }
}