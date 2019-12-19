object Warrior {
  println("Welcome to the Midterm Review")        //> Welcome to the Midterm Review
  
  // problem 6
  class Warrior(val name: String) {
  	var health: Int = 100
  	var strategy: Warrior=>Unit = null
  	
  	def attack(opponent: Warrior) {
  		println(this.name + " is attacking " + opponent.name)
  		strategy(opponent)
  		println(opponent.name + "'s health = " + opponent.health)
  	}
  }
  
  def spitFire(opponent: Warrior) {
  	println("Spits fire")
  	opponent.health -= 10
  }                                               //> spitFire: (opponent: Warrior.Warrior)Unit
  
  def stomp(opponent: Warrior) {
  	println("Stomp")
  	opponent.health -= 7
  }                                               //> stomp: (opponent: Warrior.Warrior)Unit
  
  val red = new Warrior("Red Army")               //> red  : Warrior.Warrior = Warrior$Warrior$1@2d209079
  red.strategy = spitFire
  val blue = new Warrior("Blue Army")             //> blue  : Warrior.Warrior = Warrior$Warrior$1@2752f6e2
  blue.strategy = stomp
  
  red.attack(blue)                                //> Red Army is attacking Blue Army
                                                  //| Spits fire
                                                  //| Blue Army's health = 90
  red.strategy = stomp
  red.attack(blue)                                //> Red Army is attacking Blue Army
                                                  //| Stomp
                                                  //| Blue Army's health = 83
                                                  
  
  
  //====================================
}