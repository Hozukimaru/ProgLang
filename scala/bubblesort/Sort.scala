package bubblesort {
	class Bubble {
		def start[T](order:String,input:Array[T])(implicit o: Ordering[T]) = {
			val sorter = new Sort(input)
			sorter.startSort(order)
		}
	}

	class Sort[T <% Ordered[T]](input: Array[T]) {
		def startSort(order:String) = {
			var changeOccured:Boolean = false
			var temp:T = input(1)
			do {
				changeOccured = false
				for( i <-1 to input.length-1) {
					if(compare(input(i),input(i-1),order)) {
						temp = input(i)
						input(i) = input(i-1)
						input(i-1) = temp
						changeOccured = true
					}
					
				}
			}while(changeOccured == true);
			this.print()
		}

		def compare(a:T,b:T,order:String):Boolean = {
			if(order == "ascending"){
				return a < b
			} else {
				return a > b
			}
		}

		def print() = {
			println(input.mkString("\n"))
		}
	}
}