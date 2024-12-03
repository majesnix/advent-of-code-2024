package org.majesnix.aoc2024
package Day03

import AdventHelpers.readFile

object Day03:
  private val input = readFile("Day03/input")
  private val mulMatcher = """mul\((\d{1,3}),(\d{1,3})\)""".r

  def sumUpValidInstructions(): Unit =
    println(
      s"result: ${mulMatcher
          .findAllIn(input)
          .map(m => "\\d+".r.findAllIn(m).toList.map(_.toInt).product)
          .sum}"
    )

  def sumUpValidInstructionsIfDo(): Unit =
    val allMatcher = """(mul\((\d{1,3}),(\d{1,3})\)|do(n't)?\(\))""".r

    val (_, result) = allMatcher.findAllIn(input).foldLeft((true, 0)) {
      case ((_, sum), "don't()")           => (false, sum)
      case ((_, sum), "do()")              => (true, sum)
      case ((true, sum), mulMatcher(a, b)) => (true, sum + (a.toInt * b.toInt))
      case ((flag, sum), _)                => (flag, sum)
    }
    println(s"result only do: $result")
