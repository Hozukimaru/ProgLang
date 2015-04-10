(ns clojure.bubbleSort.Sort (:import java.util.ArrayList))
 
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
                                (if (pos? (cmp (.get inputArray i) (.get inputArray (inc i))))
                                (do
                                    (swap! i (inc i))
                                    (reset! changeOccurred true))))
                                    @changeOccurred))]
        (doseq [stop-i (range (dec (.size inputArray)) -1 -1)
        :while (sorter stop-i)])
    inputArray)))
(println (bubbleSort (ArrayList. [10 9 8 7 6 5 4 3 2 1])))