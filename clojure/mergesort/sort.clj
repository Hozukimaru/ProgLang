(defn merge* [firstHalf secondHalf]
  	(cond (nil? firstHalf) secondHalf
        (nil? secondHalf) firstHalf
        true (let [[l & *firstHalf] firstHalf
                [r & *secondHalf] secondHalf]
               	(if (<= l r) (cons l (merge* *firstHalf secondHalf))
                    (cons r (merge* firstHalf *secondHalf))))))
 
(defn mergeSort [inputArray]
	(let [[l & *inputArray] inputArray]
		(if (nil? *inputArray) 
 		inputArray
      		(let [[firstHalf secondHalf] (split-at (/ (count inputArray) 2) inputArray)]
        	(merge* (mergeSort firstHalf) (mergeSort secondHalf))))))