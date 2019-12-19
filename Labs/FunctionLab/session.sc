object session {
  println("Welcome to the Scala Combinator")      //> Welcome to the Scala Combinator
  
   // problem 1
      def compose[A,B](f: A=>B, g: A=>A):A=>B = ((x:A)=> f(g(x)))
                                                  //> compose: [A, B](f: A => B, g: A => A)A => B

      val h = compose(((x:Int)=>x*x), ((x:Int)=>3*x))
                                                  //> h  : Int => Int = session$$$Lambda$10/453211571@1d251891
      val h2 = compose(((x:Int)=>"HW "+x),((x:Int)=>x))
                                                  //> h2  : Int => String = session$$$Lambda$10/453211571@7c30a502

    // problem 2
	    def selfIter[T](f: T=>T, n:Int):T=>T = {
	       (x:T)=> if(n == 0) x else compose(selfIter(f,n-1),f)(x)
	    }                                     //> selfIter: [T](f: T => T, n: Int)T => T
	    def inc(x: Double) = x + 1            //> inc: (x: Double)Double
	    def double(x: Double) = 2 * x         //> double: (x: Double)Double
	    
	    selfIter(inc,3)(2)                    //> res0: Double = 5.0
	    selfIter(double, 2)(2)                //> res1: Double = 8.0

    // problem 3
	    def countPass[T](a: Array[T]) = {
        var count = 0
        for(e<-a) e match {case e:Boolean => count += 1 case _ => None}
        println("Passed: " + count)
	    }                                     //> countPass: [T](a: Array[T])Unit
	    countPass(Array("a", 2.0, 1, 'c', true, false)) //Passed: 2
                                                  //> Passed: 2
    // problem 4
	    def recur(baseVal: Int, combiner: (Int, Int)=> Int ):Int=>Int = {
         def r(n:Int) = if(n == 0) baseVal else combiner(recur(baseVal, combiner)(n-1), n)
         r _
	    }                                     //> recur: (baseVal: Int, combiner: (Int, Int) => Int)Int => Int

      val fact = recur(1, ((a: Int, b:Int )=> a*b))
                                                  //> fact  : Int => Int = session$$$Lambda$19/1627960023@22f71333
    // problem 5
    def parseDigits(digits: String): Option[Int] = if (digits.matches("[0-9]*")) Some(digits.toInt) else None
                                                  //> parseDigits: (digits: String)Option[Int]
  	def deOptionize[T](f: Option[T]) = {
			try {
				f match {
					case Some(a) => println(a)
					case None => throw new Exception("Invalid input")
				}
			} catch {
				case e:Exception => println(e)
			}
	}                                         //> deOptionize: [T](f: Option[T])Unit
  
  parseDigits("1")                                //> res2: Option[Int] = Some(1)
  parseDigits("1a")                               //> res3: Option[Int] = None
  deOptionize(parseDigits("1a"))                  //> java.lang.Exception: Invalid input

  
}