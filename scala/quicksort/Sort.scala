package quicksort {
	class Quick {
		def start[T](order:String,input:Array[T])(implicit o: Ordering[T]) = {
			val sorter = new Sort(input)
			sorter.startSort(order)
		}
	}

	class Sort[T <% Ordered[T]](input: Array[T]) {
		def startSort(order:String) = {
			quicksort(input,0,input.length-1,order)
			print()
		}

		def quicksort(input:Array[T],start:Int,end:Int,order:String):Array[T] = {
			if(start < end) {
				var pivot:T = input(end)
				var i:Int = start
				var j:Int = end

				while(i != j) {
					if(compare(input(i),pivot,order)) {
						i = i+1
					} else {
						input(j) = input(i)
						input(i) = input(j-1)
						j = j-1
					}
				}
				input(j) = pivot
				quicksort(input,start,j-1,order)
				quicksort(input,j+1,end,order)
			}
			return input
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