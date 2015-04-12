(ns clojure.main
(:import java.util.ArrayList))

(defn bubbleSort
  ([inputArray] (bubbleSort compare inputArray))
  ([cmp inputArray]
    (letfn [(swap! [i j]
        (let [temp (.get inputArray i)]
            (doto inputArray
                (.set i (.get inputArray j))
                    (.set j temp))))
                        (sorter [stop-i]
                        (let [changeOccurred (atom false)]
                            (doseq [i (range stop-i)]
                            (if (pos? (compare (.get inputArray i) (.get inputArray (inc i))))
                            (do
                                (swap! i (inc i))
                                (reset! changeOccurred true))))
                                @changeOccurred))]
        (doseq [stop-i (range (dec (.size inputArray)) -1 -1)
        :while (sorter stop-i)])
    inputArray)))

;compares array values then merges them in order
(defn merge* [firstHalf secondHalf]
  	(cond (nil? firstHalf) secondHalf
        (nil? secondHalf) firstHalf
        true (let [[fh & *firstHalf] firstHalf
                [sh & *secondHalf] secondHalf]
               	(if (>= 0 (compare fh sh)) (cons fh (merge* *firstHalf secondHalf))
                    (cons sh (merge* firstHalf *secondHalf))))))
 
;splits array and calls merge on both halves of the array
(defn mergeSort [inputArray]
	(let [[fh & *inputArray] inputArray]
		(if (nil? *inputArray) 
 		inputArray
      		(let [[firstHalf secondHalf] (split-at (/ (count inputArray) 2) inputArray)]
        	(merge* (mergeSort firstHalf) (mergeSort secondHalf))))))

;compare the pivot to y and call quicksort on each half of the array
;with the pivot as the dividing point
(defn quickSort [inputArray]
	(if (empty? inputArray) 
		'()
	(let [[pivot & sortedArray] inputArray]
		(lazy-cat (quickSort (for [y sortedArray :when (> 0 (compare  y pivot))] y))
			(list pivot)
			(quickSort (for [y sortedArray :when (<= 0 (compare y pivot))] y))))))

;create array of letters randomly selected from the characters string
(def characters "abcdefghijklmnopqrstuvwxyz")
(defn makeStringArray [length]
	(apply str (repeatedly length #(rand-nth characters))))

; get input for variable type and sort type
(println "Enter variable type [int/string/merge]")
(def varType (read-line))
(println "Enter sort type [bubble/quick/merge]")
(def sortType (read-line))

; create ArrayList for variable type
(case varType 
	"int" (def inputArray (ArrayList. (repeatedly 10 #(rand-int 10))))
	"string" (def inputArray (ArrayList. (repeatedly 10 #(makeStringArray 1))))
	"float" (def inputArray (ArrayList. (repeatedly 10 #(rand 10))))
	"wrong variable type")

; print unsorted
(println inputArray)
; call sort function
(case sortType
	"bubble" (println (bubbleSort inputArray))
	"quick"	(println (quickSort inputArray))
	"merge" (println (mergeSort inputArray))
	"Wront sort type")