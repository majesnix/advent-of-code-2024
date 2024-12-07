package org.majesnix.aoc2024

import scala.io.Source.fromFile

def readDayInputFile(name: String): String =
  val input = fromFile(s"./src/main/scala/$name/input.txt")

  try input.mkString
  finally input.close()
  
def readFile(path: String): String =
  val input = fromFile(s"./src/main/scala/$path")

  try input.mkString
  finally input.close()

object Grid:
  type Grid[A] = Vector[Vector[A]]

  implicit class GridOps[A](grid: Grid[A]) {
    def slidingGrid(x: Int, y: Int): Iterator[Iterator[Grid[A]]] =
      grid
        .sliding(y)
        .map({ rows =>
          rows.map(_.sliding(x).toVector).transpose.iterator
        })

    def slidingGrid(size: Int): Iterator[Iterator[Grid[A]]] =
      slidingGrid(size, size)
  }
