/*
 * Thong Le - 011922131
 * CS152-2- J.Pearce - Assignment 5- problem 2
 */

import scala.collection.mutable.ArrayBuffer

class Queue[T] (val capacity: Int = 100) {
  private val queue: ArrayBuffer[T] = new ArrayBuffer[T](capacity)
  def isEmpty = queue.size == 0
  def enqueue(e: T) { queue += e }
  def dequeue(): String = { if(!isEmpty) { val removed = queue(0); queue.remove(0); removed.toString } else this.toString }
  override def toString = if(this.isEmpty) "Empty Queue" else queue.toString
}

object Queue {
  def apply = new Queue[Any]
  def main(args: Array[String]) {
    val inputSize = 5
    val waitingList: Queue[Any] = Queue.apply
    val inputs = "abcdefghijklmnopqrstuvwxyz0123456789"
    val random = new scala.util.Random(System.nanoTime())
    for(i <- 0 until inputSize) 
      { waitingList.enqueue(inputs(random.nextInt(inputs.size))) }
    
    println("Initial Queue: " + waitingList.toString)
    
    for(i <- 0 until inputSize) 
      { println("Removed " + waitingList.dequeue); println(waitingList.toString) }
  }
}