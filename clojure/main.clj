(ns clojure.main
(:import java.util.ArrayList)
(:require [clojure.bubbleSort.Sort :as Sort]))

;[def characters "abcdefghijklmnopqrstuvwxyz")
;(defn makeArray[10]
;	(apply temp (repeatedly 10 #(rand-nth characters))))

(println (Sort/bubbleSort (ArrayList. [10 9 8 7 6 5 4 3 2 1])))
(println "asd")