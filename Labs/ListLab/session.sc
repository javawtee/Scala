/*
*		Thong Le - 011922131
*		CS152-2- Assignment 4 - List Processing I
*/

object session {
  println("Welcome to the Scala List Processing I")
                                                  //> Welcome to the Scala List Processing I
  
  // 4 versions: Iteration, traditional-style recursion, tail recursion, map-filter-reduce
  // for problem 1, 2, 6, 7 & 8
  
/*
 Problem 1: sum of odd cubes
 */
	  val testList = List(1,2,11,13,14,16,17,20,1000)
                                                  //> testList  : List[Int] = List(1, 2, 11, 13, 14, 16, 17, 20, 1000)
	 	def cube(x: Int) = x * x * x      //> cube: (x: Int)Int
	 	
	 	// iteration
	  def cubeSumIter(l: List[Int]): Int = {
	  	var sum = 0
	  	for(i <- l) if(i % 2 == 1) sum += cube(i)
	  	sum
	  }                                       //> cubeSumIter: (l: List[Int])Int
	  
	  // recursion
	  def cubeSumRecur(l: List[Int]):Int =
	  	if(l == Nil) 0
	  	else if(l.head %2 == 1) cube(l.head) + cubeSumRecur(l.tail)
	  			 else cubeSumRecur(l.tail)
                                                  //> cubeSumRecur: (l: List[Int])Int
	  
	  // tail recursion
	  def cubeTail(l: List[Int], result: Int = 0):Int =
	  	if(l == Nil) result
	  	else cubeTail(l.tail, if(l.head % 2 == 1) result + cube(l.head) else result)
                                                  //> cubeTail: (l: List[Int], result: Int)Int
	  
	  // MPF
	  def cubeMapRule(x: Int): Int = {
	  	if(x % 2 == 1) cube(x) else 0
	  }                                       //> cubeMapRule: (x: Int)Int
	  
	  // test
	  cubeSumIter(testList)                   //> res0: Int = 8442
	  cubeSumRecur(testList)                  //> res1: Int = 8442
	  cubeTail(testList)                      //> res2: Int = 8442
	  testList.map(cubeMapRule _).reduce(_ + _)
                                                  //> res3: Int = 8442
  
/*
problem 2: sum of Sums of list of lists of numbers
*/
	  val testList2 = List(List(1,2,3), List(4,5,6))
                                                  //> testList2  : List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))
	  
	  // iteration
	  def soSIter(l: List[List[Int]]) = {
	  	var sum = 0
	  	for(subL <- l){
	  		for(num <- subL) sum += num
	  	}
	  	sum
	  }                                       //> soSIter: (l: List[List[Int]])Int
	  
	  // sumSubList to do sum of a sub list of list
	  def sumSubList(l: List[Int]):Int = if(l == Nil) 0 else l.head + sumSubList(l.tail)
                                                  //> sumSubList: (l: List[Int])Int
	  
	  // recursion
	  def soSRecur(l: List[List[Int]]):Int =
	  	if(l == Nil) 0 else sumSubList(l.head) + soSRecur(l.tail)
                                                  //> soSRecur: (l: List[List[Int]])Int
	  
	 	// tail recursion
	  def soSTail(l: List[List[Int]], result:Int = 0):Int =
	  	if(l == Nil) result else soSTail(l.tail, result + sumSubList(l.head))
                                                  //> soSTail: (l: List[List[Int]], result: Int)Int
	 	
	 	// MPF
	 	def soSMapRule(l: List[Int]):Int = {
	 		var sum = 0
	 		for(i <- l) sum += i
	 		sum
	 	}                                 //> soSMapRule: (l: List[Int])Int
	 	
	 	// testing
	  soSIter(testList2)                      //> res4: Int = 21
	  soSRecur(testList2)                     //> res5: Int = 21
	 	soSTail(testList2)                //> res6: Int = 21
	 	testList2.map(soSMapRule _).reduce(_ + _)
                                                  //> res7: Int = 21
	 	
/*
problem 3: depth
*/

		def depth(l: Any):Int = {
			l match {
	    	case h::t => math.max(1 + depth(h), depth(t))
	    	case _ => 0
			}
		}                                 //> depth: (l: Any)Int
		
		// test
		depth(List(List(List(1,2,List(3)))))
                                                  //> res8: Int = 4
		
/*
problem 6: return number of elements in list is true
*/
		val testList6 = 1::"a"::23::2::"a12"::Nil
                                                  //> testList6  : List[Any] = List(1, a, 23, 2, a12)
		// predicate to test
		def isEven[T](input: T) =
			input match{
				case input:Int => input % 2 == 0
				case input:Double => input % 2.0 == 0.0
				case _ => false
			}                         //> isEven: [T](input: T)Boolean
		
		// iteration
		def iter6[T](p: T=>Boolean, l: List[T]):Int = {
			 var count = 0
			 for(t <- l) if(p(t) == true) count += 1
			 count
		}                                 //> iter6: [T](p: T => Boolean, l: List[T])Int
		
	  // recursion
	  def rec6[T](p: T=>Boolean, l: List[T]): Int =
	  	if(l == Nil) 0 else if(p(l.head)) 1 + rec6(p, l.tail) else rec6(p, l.tail)
                                                  //> rec6: [T](p: T => Boolean, l: List[T])Int
	  	
	  // tail recursion
	  def tail6[T](p: T=>Boolean, l: List[T], res: Int = 0):Int =
	  	if(l == Nil) res else if (p(l.head)) tail6(p, l.tail, res + 1) else tail6(p, l.tail, res)
                                                  //> tail6: [T](p: T => Boolean, l: List[T], res: Int)Int
	  	
	  // MPF
	  testList6.filter(isEven).size           //> res9: Int = 1
	  
	  // test
		iter6(isEven _, testList6)        //> res10: Int = 1
	  rec6(isEven _, testList6)               //> res11: Int = 1
	  tail6(isEven, testList6)                //> res12: Int = 1
  
/*
problem 7: return true if all the elements in the list is true
*/
 		val testList7 = 2::4::6::Nil      //> testList7  : List[Int] = List(2, 4, 6)
  
  	// iteration
	  def iter7[T](p: T=>Boolean, l: List[T]):Boolean = {
	  	var passed = 0
	  	for(e <- l) if(p(e)) passed +=1
	  	if(passed == l.size) true else false
	  	}                                 //> iter7: [T](p: T => Boolean, l: List[T])Boolean
	  
	  // recursion
	  def rec7[T](p: T=>Boolean, l: List[T]): Boolean =
	  	if(l == Nil) true else if(!p(l.head)) false else rec7(p, l.tail)
                                                  //> rec7: [T](p: T => Boolean, l: List[T])Boolean
	  
	  
	  // tail recursion
	  def tail7[T](p: T=>Boolean, l: List[T], flag: Boolean = true): Boolean =
	  	if(!flag || l == Nil) flag else tail7(p, l.tail, p(l.head)) // Note: if there is a difference in the list, mark flag false; then return immediately
                                                  //> tail7: [T](p: T => Boolean, l: List[T], flag: Boolean)Boolean
	  
	  
	  // MPF
	  val mfr7 = testList7.size == testList7.filter(isEven).size
                                                  //> mfr7  : Boolean = true
	  
	  // test
	  iter7(isEven, testList)                 //> res13: Boolean = false
	  iter7(isEven, testList7)                //> res14: Boolean = true
	  rec7(isEven, testList)                  //> res15: Boolean = false
	  rec7(isEven, testList7)                 //> res16: Boolean = true
	  tail7(isEven, testList)                 //> res17: Boolean = false
	  tail7(isEven, testList7)                //> res18: Boolean = true
  
// problem 8: return true if any element in the list is true
		import util.control.Breaks._
		//val testList = List(1,2,11,13,14,16,17,20,1000) //declared at the beginning of the lab
		val testList8 = 1:: 3:: 5:: Nil   //> testList8  : List[Int] = List(1, 3, 5)
		
		// iteration
		def iter8[T](p: T=> Boolean, l: List[T]): Boolean = {
			var flag = false
			for(e <- l) breakable {if(p(e)) flag = true; break}
			flag
		}                                 //> iter8: [T](p: T => Boolean, l: List[T])Boolean
		
		// recursion
		def recur8[T](p: T=> Boolean, l: List[T]): Boolean =
			if(l == Nil) false else if(p(l.head)) true else recur8(p, l.tail)
                                                  //> recur8: [T](p: T => Boolean, l: List[T])Boolean
		
		
		// tail recursion
		def tail8[T](p: T=> Boolean, l: List[T], flag: Boolean = false): Boolean =
			if(flag == true || l == Nil) flag else tail8(p, l.tail, p(l.head))
                                                  //> tail8: [T](p: T => Boolean, l: List[T], flag: Boolean)Boolean
			
		
		// MPF
		def mfr8[T](l: List[T]): Boolean = l.filter(isEven).size > 0
                                                  //> mfr8: [T](l: List[T])Boolean
		
		// test
		iter8(isEven, testList)           //> res19: Boolean = true
		iter8(isEven, testList8)          //> res20: Boolean = false
		recur8(isEven, testList)          //> res21: Boolean = true
		recur8(isEven, testList8)         //> res22: Boolean = false
		tail8(isEven, testList)           //> res23: Boolean = true
		tail8(isEven, testList8)          //> res24: Boolean = false
		mfr8(testList)                    //> res25: Boolean = true
		mfr8(testList8)                   //> res26: Boolean = false
		
/*
problem 10: return true if a given list of integers sorted in ascending order
*/
		val testList10 = 1::2::4::10::20::31::Nil
                                                  //> testList10  : List[Int] = List(1, 2, 4, 10, 20, 31)
		val testList10b = 1::2::4::31::20::Nil
                                                  //> testList10b  : List[Int] = List(1, 2, 4, 31, 20)
		def func10(l: List[Int]):Boolean =
			if(l == Nil) true else
			if(l.tail != Nil && l.head > l.tail.head) false else func10(l.tail)
                                                  //> func10: (l: List[Int])Boolean
			
		func10(testList10)                //> res27: Boolean = true
		func10(testList10b)               //> res28: Boolean = false
		
/*
 problem 13: stream
 */
		// infinite long 1's
		def add1(in: Int = 1):Stream[Int] = 1 #:: add1()
                                                  //> add1: (in: Int)Stream[Int]
		val inf1 = add1()                 //> inf1  : Stream[Int] = Stream(1, ?)
		inf1.take(10).toList              //> res29: List[Int] = List(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
		inf1                              //> res30: Stream[Int] = Stream(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, ?)

		// non negative integers
		def nonNeg(in: Int = 0):Stream[Int] = in #:: nonNeg(in +1)
                                                  //> nonNeg: (in: Int)Stream[Int]
		val nNeg = nonNeg()               //> nNeg  : Stream[Int] = Stream(0, ?)
		nNeg.take(6).toList               //> res31: List[Int] = List(0, 1, 2, 3, 4, 5)
		nNeg                              //> res32: Stream[Int] = Stream(0, 1, 2, 3, 4, 5, ?)
		
		// non negative even integers
		def nonNegEven(in: Int = 0):Stream[Int] = in #:: nonNegEven(in + 2)
                                                  //> nonNegEven: (in: Int)Stream[Int]
		val nNegEven = nonNegEven()       //> nNegEven  : Stream[Int] = Stream(0, ?)
		nNegEven.take(7).toList           //> res33: List[Int] = List(0, 2, 4, 6, 8, 10, 12)
		nNegEven                          //> res34: Stream[Int] = Stream(0, 2, 4, 6, 8, 10, 12, ?)
		
		// all squares
		def allSq(in: Int = 0):Stream[Int] = (in * in) #:: allSq(in + 1)
                                                  //> allSq: (in: Int)Stream[Int]
		val aSq = allSq()                 //> aSq  : Stream[Int] = Stream(0, ?)
		aSq.take(3).toList                //> res35: List[Int] = List(0, 1, 4)
		aSq                               //> res36: Stream[Int] = Stream(0, 1, 4, ?)
	
	}