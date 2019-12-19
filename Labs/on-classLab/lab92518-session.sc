object lab92518 {
  println("Welcome to the Scala List Processing Lab")
                                                  //> Welcome to the Scala List Processing Lab
  
  case class Note(val amplitude: Double, val frequency: Double, val duration: Double = 1.0)

	val symphony1 = List(Note(3, 30), Note(3.1, 40, .25), Note(3.2, -10, .5), Note(2.1, 5, .75), Note(3.9, -2))
                                                  //> symphony1  : List[lab92518.Note] = List(Note(3.0,30.0,1.0), Note(3.1,40.0,0.
                                                  //| 25), Note(3.2,-10.0,0.5), Note(2.1,5.0,0.75), Note(3.9,-2.0,1.0))
 def duration(score: List[Note]):Double =
     if (score == Nil) 0.0
     else score.head.duration + duration(score.tail)
                                                  //> duration: (score: List[lab92518.Note])Double

 def maxAmp( score : List[Note]): Double =
 	if	(score == Nil)  0.0 else math.max(score.head.amplitude, maxAmp(score.tail))
                                                  //> maxAmp: (score: List[lab92518.Note])Double
  //  ((x:Int) => (x > 1) ? print("A") : print("B"))(2)
                                                
                                                  
	maxAmp(symphony1)                         //> res0: Double = 3.9
	def maxFreq( score: List[Note]): Double =
	if (score == Nil) 0.0
	 			 else math.max(score.head.frequency, maxFreq(score.tail))
                                                  //> maxFreq: (score: List[lab92518.Note])Double
	 maxFreq(symphony1)                       //> res1: Double = 40.0
	
	def getDuration(n : Note) = n.duration    //> getDuration: (n: lab92518.Note)Double
	symphony1.map(getDuration)                //> res2: List[Double] = List(1.0, 0.25, 0.5, 0.75, 1.0)
	def max (a: Double , b : Double )  = if (a<b ) b else a
                                                  //> max: (a: Double, b: Double)Double
	def maxAmp1 (scores : List[Note]) : Double = {
	def helper (result : Double , unseen  : List[Note]) : Double =
		if (unseen== Nil) result else
		helper (max (result, unseen.head.amplitude ), unseen.tail)
		
		helper (0.0, scores)
	}                                         //> maxAmp1: (scores: List[lab92518.Note])Double
	maxAmp1(symphony1)                        //> res3: Double = 3.9
	def getAmplitude(n: Note) = n.amplitude   //> getAmplitude: (n: lab92518.Note)Double
	
	def  maxAmp3(score: List[Note]) = score.map(getAmplitude).reduce(max)
                                                  //> maxAmp3: (score: List[lab92518.Note])Double
	maxAmp3(symphony1)                        //> res4: Double = 3.9
	
	def noise (note: Note)= note.frequency <0 //> noise: (note: lab92518.Note)Boolean
	
	def  filterNoise(score: List[Note]) : List[Note] =  {
		var result : List[Note] = Nil
		for (note <- score ) if (!noise (note)) result = result :+ note
		result
	}                                         //> filterNoise: (score: List[lab92518.Note])List[lab92518.Note]
 
  def filterNoiseRecur(score: List[Note]): List[Note] =
  	if(score == Nil) Nil
  	else  if(noise(score.head)) filterNoiseRecur(score.tail)
  	else score.head:: filterNoiseRecur(score.tail)
                                                  //> filterNoiseRecur: (score: List[lab92518.Note])List[lab92518.Note]
  	
  def filterNoiseTail(score: List[Note]) = {
  	def helper(result: List[Note], unseen: List[Note]): List[Note] =
  		if(unseen == Nil) result
  		else if(noise(unseen.head)) helper(result, unseen.tail)
  		else helper(score.head::result, unseen.tail)
  	helper(Nil, score)
  }                                               //> filterNoiseTail: (score: List[lab92518.Note])List[lab92518.Note]
  
  def filterNoiseMFR(score: List[Note]) = score.filter(!noise(_))
                                                  //> filterNoiseMFR: (score: List[lab92518.Note])List[lab92518.Note]
                                                  
// UPDATED ON 092618

		def makeFibs(fib1: Int, fib2: Int):Stream[Int] = fib1 #:: makeFibs(fib2, fib1 + fib2)
                                                  //> makeFibs: (fib1: Int, fib2: Int)Stream[Int]
		
		val fibs = makeFibs(1,1)          //> fibs  : Stream[Int] = Stream(1, ?)
		
		fibs(3)                           //> res5: Int = 3
		
		val sqFibs = fibs.map((x:Int)=>x*x)
		
		def makeFives: Stream[Int] = 5 #:: makeFives
		
		
		
}