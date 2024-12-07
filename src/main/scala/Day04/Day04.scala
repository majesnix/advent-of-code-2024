package org.majesnix.aoc2024
package Day04

import Grid.*

object Day04:
  private val input: String = readDayInputFile("Day04")
  // split string by separator, transform to vector, transform string to char vector
  private val inputAsGrid = input.linesIterator.toVector.map(_.toVector)

  /** X M A S
    */
  private def horizontal(grid: Grid[Char]): Int =
    grid
      .map(_.sliding(4).count(_ == "XMAS".toSeq))
      .sum

  /**
   * X . . .
   * . M . .
   * . . A .
   * . . . S
   */
  private def diagonal(grid: Grid[Char]): Int =
    grid
      .slidingGrid(4)
      .flatten
      .count(w =>
        w(0)(0) == 'X' && w(1)(1) == 'M' && w(2)(2) == 'A' && w(3)(3) == 'S'
      )

  /**
   * M . S
   * . A .
   * M . S
   */
  private def findMASes(grid: Grid[Char]): Int =
    grid
      .slidingGrid(3)
      .flatten
      .count(g =>
        g(0)(0) == 'M' && g(0)(2) == 'S' && g(1)(1) == 'A' && g(2)(
          0
        ) == 'M' && g(2)(2) == 'S'
      )

  def findXMAS(): Unit =
    val transposedGirds = Seq(
      inputAsGrid,
      inputAsGrid.map(_.reverse),
      inputAsGrid.transpose,
      inputAsGrid.transpose.map(_.reverse)
    )
    val reversedGrids = Seq(
      inputAsGrid,
      inputAsGrid.map(_.reverse),
      inputAsGrid.reverse,
      inputAsGrid.reverse.map(_.reverse)
    )

    println(
      s"XMAS: ${transposedGirds.map(horizontal).sum +
          reversedGrids.map(diagonal).sum}"
    )

    val example: String = readFile("Day04/example.txt")
    val exampleAsGird = example.linesIterator.toVector.map(_.toVector)

    val exampleGirds = Seq(
      exampleAsGird,
      exampleAsGird.map(_.reverse),
      exampleAsGird.transpose,
      exampleAsGird.transpose.map(_.reverse)
    )

    println(s"X-MAS example ${exampleGirds.map(findMASes).sum}")

    println(
      s"X-MAS ${transposedGirds.map(findMASes).sum}"
    )
