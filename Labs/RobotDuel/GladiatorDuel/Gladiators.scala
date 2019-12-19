
package GladiatorDuel

class Gladiator (val name:String) {
  var HP:Int = 100
  def damage(amtOfDmg:Int = 5) = if(HP >= amtOfDmg) HP -= amtOfDmg
  def attack(opponent: Gladiator) = println(s"$name is attacking ${opponent.name}")
}

trait Slasher {
  def slash(opponent: Gladiator) {println(s"Slash, slash, slashing ${opponent.name}"); opponent.damage(10); println(s"${opponent.name}'s health = ${opponent.HP}")}
}

trait Crusher {
  def crush(opponent: Gladiator) = {println(s"Crush, crush, crushing ${opponent.name}");opponent.damage(10); println(s"${opponent.name}'s health = ${opponent.HP}")}
}

trait Masher {
  def mash(opponent: Gladiator) = {println(s"Mash, mash, mashing ${opponent.name}");opponent.damage(10); println(s"${opponent.name}'s health = ${opponent.HP}")}
}

class CrusherMasher(override val name:String) extends Gladiator(name) with Crusher with Masher {
  override def attack(opponent:Gladiator) { super.attack(opponent); super.crush(opponent); super.mash(opponent) }
}

object bumbleBee extends Gladiator("Bumble Bee") with Slasher with Masher{
  override def attack(opponent:Gladiator) { super.attack(opponent); super.slash(opponent); super.mash(opponent)}
}