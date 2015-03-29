package object bubblesort {
	class Bubble[T <% Ordered[T]](input: Array[T]) {
		def start() = {
			val sorter = new Sort(input)
			sorter.startSort()
		}
	}

	class Sort[T <% Ordered[T]](input: Array[T]) {
		def startSort() = {
			var changeOccured:Boolean = false
			var temp:T = input(1)
			do {
				changeOccured = false
				for( i <-1 to input.length) {
					if(input(i) > input(i-1)){
						temp = input(i)
						input(i) = input(i-1)
						input(i-1) = temp
						changeOccured = true
					}
					
				}
			}while(changeOccured == true);
			this.print()
		}

		def print() = {
			println(input.mkString("\n"))
		}
	}
}