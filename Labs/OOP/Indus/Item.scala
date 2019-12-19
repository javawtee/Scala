

class Item (val description: Description) {
  protected var id: Int = 0
  def getId = id
}

object Item { 
  var nextId : Int = 0
  def apply(desc: Description) = { nextId += 1; val item = new Item(desc) ; item.id = nextId; item }
}