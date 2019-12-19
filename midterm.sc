/*
		Thong Le - 011922131
		CS152 - J.Pearce - Fall 2018
		Midterm - Date: 10/11/18
*/

object Midterm {
  //problem 1: sum firsts
	  def sumFirsts(lists: List[List[Int]]): Int =
	  	if(lists == Nil) 0
	  	else if(lists.head != Nil) lists.head.head + sumFirsts(lists.tail) else sumFirsts(lists.tail)
                                                  //> sumFirsts: (lists: List[List[Int]])Int
	  sumFirsts(List(List(1), Nil, List(4), List(5,3,4)))
                                                  //> res0: Int = 10
	  sumFirsts(Nil)                          //> res1: Int = 0
 	//====================
 	
 	//problem 2: Accummulator
 		trait Command { def execute(): Unit } // type=>Unit
 		
	 	object accumulator {
	     var accum: Int = 0
	     def execute(program: Command*) = {
	        accum = 0
	        for(cmmd <- program) cmmd.execute() // updates accum
	        accum
	     }
	  }
	  
	  // ADD
	  class Add(val value: Int) extends Command {
	  	def execute = {
	  		accumulator.accum = accumulator.accum + value
	  	}
	  }
	  
	  object Add { def apply(v: Int) = new Add(v) }
	  
	  // MUL
	  class Mul(val value: Int) extends Command {
	  	def execute = {
	  		accumulator.accum = accumulator.accum * value
	  	}
	  }
	  
	  object Mul { def apply(v:Int) = new Mul(v) }
	  
	  // SET
	  class Set(val value: Int) extends Command {
	  	def execute = {
	  		accumulator.accum = value
	  	}
	  }
	  
	  object Set { def apply(v: Int) = new Set(v) }
	  
	  // ITER
	  class Iter(val cmmd: Command, val iters: Int) extends Command {
	  	def execute = {
	  		for(i <- 0 until iters)
	  			cmmd.execute()
	  	}
	  }
	  
	  object Iter { def apply(cmmd:Command, v: Int) = new Iter(cmmd, v) }
	  
	  accumulator.execute(Set(2), Mul(3), Iter(Mul(2), 5))
                                                  //> res2: Int = 192
 	//====================
 	
 	// problem 3: ApplyFuns
 	
 	val myFuns = List((x: Int)=>2 * x, (x: Int)=> x * x, (x: Int) => x + 1) // = a list of transformer functions
                                                  //> myFuns  : List[Int => Int] = List(Midterm$$$Lambda$11/1468177767@edf4efb, M
                                                  //| idterm$$$Lambda$12/434091818@2f7a2457, Midterm$$$Lambda$13/398887205@566776
                                                  //| ad)
 	
 	def applyFuns[T, S](t: T, transformers: List[T=>S]): List[S] = transformers.map(_(t))
                                                  //> applyFuns: [T, S](t: T, transformers: List[T => S])List[S]
 	 
	applyFuns(20, myFuns)                     //> res3: List[Int] = List(40, 400, 21)
 	
 	//====================
 	
 	// ======================================================= END ===================================================================
}