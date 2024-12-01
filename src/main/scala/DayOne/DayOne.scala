package org.majesnix.aoc2024
package DayOne

import AdventHelpers.readFile

object DayOne {
  private val input = readFile("DayOne/input").split("\n").toList

  private var unsortedLeftList: List[Int] = List()
  private var unsortedRightList: List[Int] = List()
  // create left/right list
  input.foreach(entry => {
    entry.split(" {3}") match
      case Array(left, right) =>
        unsortedLeftList = unsortedLeftList :+ left.toInt
        unsortedRightList = unsortedRightList :+ right.toInt
  })

  def compareSmallestNumbers(): Unit = {
    println(s"Total distance: ${unsortedLeftList.sorted
        .zip(unsortedRightList.sorted)
        .map((left, right) => {
          (left - right).abs
        })
        .sum}")
  }

  def calculateSimilarity(): Unit = {
    println(s"Similarity score: ${unsortedLeftList.map { id =>
        id * unsortedRightList.count(_ == id)
      }.sum}")
  }
}
