

class Description (val description: String, val price: Double, val supplier: String) extends Equals {
  override def canEqual(other: Any) = other.isInstanceOf[Description]
  override def equals(other: Any) = {
    other match {
      case d: Description => this.canEqual(d) && (this.description == d.description) &&
                             (this.price == d.price) && (this.supplier == d.supplier)
      case _ => false
    }
  }
  override def toString = description + "; $" + price + "; " + supplier
}

object Description { def apply(desc: String, price: Double, supplier: String) = new Description(desc, price, supplier) }