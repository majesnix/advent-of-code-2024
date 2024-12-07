package org.majesnix.aoc2024
package Day02

object Day02:
  private val input = readDayInputFile("Day02").split("\n").toList

  private def isSafe(list: List[Int])(implicit
      ord: Ordering[Int]
  ): Boolean =
    if (list.size < 2) {
      true
    } else {
      list.lazyZip(list.tail).forall { case (a, b) =>
        ord.lt(a, b) && (a - b).abs <= 3 && a != b
      } || list.lazyZip(list.tail).forall { case (a, b) =>
        ord.gt(a, b) && (a - b).abs <= 3 && a != b
      }
    }

  private def isSafeWithDampener(report: List[Int])(implicit
      ord: Ordering[Int]
  ) =
    report.indices.exists { ind =>
      {
        val dropped = report.take(ind) ::: report.drop(ind + 1)
        val diffs = dropped.zip(dropped.tail).map { case (i, j) => i - j }
        diffs.forall(i => 0 < i && i <= 3) || diffs.forall(i =>
          -3 <= i && i < 0
        )
      }
    }

  def howManyReportsAreSafe(): Unit =
    val reports =
      input.map(report => report.split(" ").toList.map(_.trim.toInt))

    var safeReports = 0
    reports.foreach(report => {
      if (isSafe(report)) safeReports += 1
    })

    var safeReportsWithDampener = 0
    reports.foreach(report => {
      if (isSafeWithDampener(report)) {
        safeReportsWithDampener += 1
      }
    })

    println(s"safe reports $safeReports")
    println(s"safe reports with dampener $safeReportsWithDampener")
