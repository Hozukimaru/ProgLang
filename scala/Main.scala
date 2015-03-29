import bubblesort.Bubble

object Main {
	def main(args: Array[String]) = {
		val sortType: String = args(0)
		val varType: String = args(1)
		val order: String = args(2)

		args(1).toLowerCase() match {
			case "int" =>
				var input:Array[Any] = Array.fill(10)(util.Random.nextInt(10))
		}
		
		args(0).toLowerCase() match {
			case "bubble" =>
				val sorter = new Bubble(input)
				sorter.start()
			case "merge" =>
			case "quick" =>
		}
	}
}