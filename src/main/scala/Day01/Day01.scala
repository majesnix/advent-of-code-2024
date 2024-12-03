package org.majesnix.aoc2024
package Day01

import AdventHelpers.readFile

object Day01:
  private val input = readFile("Day01/input").split("\n").toList

  private var unsortedLeftList: List[Int] = List()
  private var unsortedRightList: List[Int] = List()
  // create left/right list
  input.foreach(entry => {
    entry.split(" {3}") match
      case Array(left, right) =>
        unsortedLeftList = unsortedLeftList :+ left.toInt
        unsortedRightList = unsortedRightList :+ right.toInt
  })

  def compareSmallestNumbers(): Unit =
    println(s"Total distance: ${unsortedLeftList.sorted
        .zip(unsortedRightList.sorted)
        .map((left, right) => {
          (left - right).abs
        })
        .sum}")

  def calculateSimilarity(): Unit =
    println(s"Similarity score: ${unsortedLeftList.map { id =>
        id * unsortedRightList.count(_ == id)
      }.sum}")
