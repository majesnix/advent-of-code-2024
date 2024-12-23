package org.majesnix.aoc2024

import Day01.Day01.{calculateSimilarity, compareSmallestNumbers}
import Day02.Day02.howManyReportsAreSafe
import Day03.Day03.{sumUpValidInstructions, sumUpValidInstructionsIfDo}
import Day04.Day04.findXMAS

object Main:
  def main(args: Array[String]): Unit =
    // Day One
    compareSmallestNumbers()
    calculateSimilarity()

    // Day Two
    howManyReportsAreSafe()

    // Day Three
    sumUpValidInstructions()
    sumUpValidInstructionsIfDo()

    // Day Four
    findXMAS()

    // Day Five
    findCorrectOrderedUpdates()
