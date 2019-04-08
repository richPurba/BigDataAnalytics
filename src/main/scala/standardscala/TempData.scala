package standardscala

case class TempData(day:Int , doy:Int, month:Int, year:Int, precip: Double, snow:Double, tave:Double, tmax:Double, tmin:Double)

 object TempData {
  def main(args: Array[String]):Unit={
    val sourceData = scala.io.Source.fromFile("MN212142_9392.csv");
    val lines = sourceData.getLines().drop(1);//dropping the header first line

    val data = lines.filterNot(_.contains(",.,")).map{ line =>
      val p = line.split(",")
      TempData(p(0).toInt, p(1).toInt, p(2).toInt, p(4).toInt,p(5).toDouble,p(6).toDouble,p(7).toDouble,p(8).toDouble,p(9).toDouble)
    }.toArray
    sourceData.close()
    println(data.length)
    data.take(5) foreach println

  }
}
