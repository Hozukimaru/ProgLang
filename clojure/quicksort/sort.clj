(ns clojure.bubblesort.sort (:import java.util.ArrayList))

(defn quickSort [inputArray]
	(if (empty? inputArray) 
		'()
		(let [[pivot & tempArray] inputArray]
			(lazy-cat (quickSort (for [y tempArray :when (<  y pivot)] y))
				(list pivot)
				(quickSort (for [y tempArray :when (>= y pivot)] y))))))
(println (quickSort (ArrayList. [10 9 8 7 6 5 4 3 2 1])))