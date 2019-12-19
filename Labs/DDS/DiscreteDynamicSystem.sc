object compoundInterest {
  println("Welcome to the Scala Discrete Dynamic System")
                                                  //> Welcome to the Scala Discrete Dynamic System
  
  val numPeriods = 12                             //> numPeriods  : Int = 12
  
  // problem 7
  def value(count: Int): Double =
  	if(count == numPeriods) 1.0
  	else value(count +1) + value(count+1) * 1.0/numPeriods
                                                  //> value: (count: Int)Double
  	
  def valueTail(currVal: Double, count: Int) :Double =
  	if(count == numPeriods) currVal
  	else valueTail(currVal + (currVal /numPeriods), count +1)
                                                  //> valueTail: (currVal: Double, count: Int)Double
  	
	 valueTail(1, 0)                          //> res0: Double = 2.613035290224677
  
  // problem 1 - control loop with tail recursion
  def controlLoop[S](state: S, cycle: Int, halt: (S, Int)=>Boolean, update: (S, Int) =>S): S =
  	if(halt(state, cycle) == true) state else controlLoop(update(state, cycle), cycle+1, halt, update)
                                                  //> controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S
                                                  //| , Int) => S)S
  	
 	controlLoop(1.0, 0, (state: Double, cycle: Int)=> cycle == numPeriods, (state: Double, cycle: Int)=> state + state/12)
                                                  //> res1: Double = 2.613035290224677
                                                  
  // problem 2 - population growth
  val limit = 10 * 10 * 10 * 10 * 10              //> limit  : Int = 100000
  controlLoop(1.0, 0, (state: Double, cycle: Int)=> state > limit, (state: Double, cycle: Int)=> state * 2)
                                                  //> res2: Double = 131072.0
  
  // problem 3
  def solve(f: Double=>Double): Double = {
  	val delta = 1e-10
  	
  	def deriv(f: Double=>Double) = (x:Double)=> (f(x + delta) - f(x))/delta
  	
  	def goodEnough( guess: Double, numTests: Int):Boolean = math.abs(f(guess)) <= delta
  	
  	def improve( guess: Double, numTests: Int):Double = guess - (f(guess) / deriv(f)(guess))
  	
  	controlLoop(1.0, 0, goodEnough, improve)
  }                                               //> solve: (f: Double => Double)Double
  
  // problem 4
  def sqRoot(x:Double) = solve((y:Double) => y*y -x)
                                                  //> sqRoot: (x: Double)Double
  sqRoot(49.0)                                    //> res3: Double = 6.999999999999653
  
  // problem 5
 	def cubeRoot(x: Double) = solve((y: Double)=> y*y*y - x)
                                                  //> cubeRoot: (x: Double)Double
  cubeRoot(27.0)                                  //> res4: Double = 3.0000000000003024
  
  // problem 6
  def nTh(x: Double, n: Int): Double = if(n==0) 1 else x* nTh(x, n-1)
                                                  //> nTh: (x: Double, n: Int)Double
  def nThRoot(x: Double, n: Int):Double = solve((y:Double)=>nTh(y, n) - x)
                                                  //> nThRoot: (x: Double, n: Int)Double
  nThRoot(1000.0,5)                               //> res5: Double = 3.9810717055349985
}