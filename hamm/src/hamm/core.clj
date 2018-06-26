(ns hamm.core
  (:require [clojure.string :as str]))


(defn count-mismatches
	[[x y]]
	(if (= x y) 0 1))


(defn calculate-hamming
  [strands]
  (reduce + (map count-mismatches 
  	(apply map list strands))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (calculate-hamming (str/split (slurp (nth args 0)) #"\n"))))
