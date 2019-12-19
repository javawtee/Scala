object DnD {
   def main(args: Array[String]): Unit = {
     val random = new scala.util.Random(System.nanoTime())
     val puff = new Dragon("Puff")
     val thor = new Knight("Thor")
     while(!puff.isDead && !thor.isDead) {
        random.nextInt(2) match {
          case 0 => thor.attack(puff)
          case 1 => if(!puff.isDead) puff.attack(thor)
          case _ => None
        }
     }
     println((if(puff.isDead) puff.name else thor.name) + " died... Game over!")
   }
}
  
  abstract class Character (val name: String) { 
    val attackMove : String
    var isDead : Boolean
    var health: Int = 100
    val random = new scala.util.Random(System.nanoTime())
    def attack(victim: Character) = { 
       val damage = random.nextInt(100)
       println(name + " is " + attackMove + " " +victim.name + " " + damage + " damage")
       if(damage > victim.health) { victim.health = 0; victim.isDead = true }
       else {
         victim.health = victim.health - damage
         print(victim.name + ".health = " + victim.health + "\n")
       }
    }
  }
  
  class Knight(name: String) extends Character(name) {
    override val attackMove = "stabbing"
    override var isDead = false
    def attack(victim: Dragon) = super.attack(victim)
  }
  
  class Dragon(name: String) extends Character(name) {
    override val attackMove = "flamming"
    override var isDead = false
    def attack(victim: Knight) = super.attack(victim)
  }