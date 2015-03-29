import bubblesort.Bubble
import quicksort.Quick

object Main {
	def main(args: Array[String]) = {
		val sortType: String = args(0) //bubble quick merge
		val varType: String = args(1) //int string float
		val order: String = args(2) //ascending decending
	
		args(0).toLowerCase() match {
			case "bubble" =>
				args(1).toLowerCase() match {
					case "int" =>
						var input:Array[Int] = Array.fill(10)(util.Random.nextInt(10))
						val sorter = new Bubble()
						sorter.start(order,input)
					case "string" =>
						val characters:String = "abcdefghijklmnqrstuvwxyz"
						var input:Array[String] = Array.fill(10)(util.Random.nextString(1))
						val sorter = new Bubble()
						sorter.start(order,input)
					case "float" => 
						var input:Array[Float] = Array.fill(10)(util.Random.nextFloat())
						val sorter = new Bubble()
						sorter.start(order,input)
					case _ => println("Invalid input")
						System.exit(1)
				}
			case "merge" =>
			case "quick" =>
				args(1).toLowerCase() match {
					case "int" =>
						var input:Array[Int] = Array.fill(10)(util.Random.nextInt(10))
						val sorter = new Quick()
						sorter.start(order,input)
					case "string" =>
						val characters:String = "abcdefghijklmnqrstuvwxyz"
						var input:Array[String] = Array.fill(10)(util.Random.nextString(1))
						val sorter = new Quick()
						sorter.start(order,input)
					case "float" => 
						var input:Array[Float] = Array.fill(10)(util.Random.nextFloat())
						val sorter = new Quick()
						sorter.start(order,input)
					case _ => println("Invalid input")
						System.exit(1)
					}
			case _ => println("invalid input")
		}
	}
}