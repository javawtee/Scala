package GladiatorDuel

object Duel extends App {
  val maximus = new CrusherMasher("Optimus Prime")
  val bee = bumbleBee
  
  for(i<-0 until 5) { maximus.attack(bee); bee.attack(maximus) }
}