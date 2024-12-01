package org.majesnix.aoc2024

import scala.io.Source.fromFile

object AdventHelpers {
  def readFile(name: String): String = {
    val input = fromFile(s"./src/main/scala/$name.txt")

    try input.mkString
    finally input.close()
  }
}
