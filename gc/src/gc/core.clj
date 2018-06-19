(ns gc.core
  (:require [clojure.string :as str]))


(defn get-gc-content
	[code strand]
	(vector 
		code 
		(* 100 (float
			(/ (count 
				(filter #(or (= \C %) (= \G %)) strand)) 
			(count strand))))))

(defn get-max-gc-content
	[codes-and-strands]
	(apply max-key second 
		(map 
			(fn [[code strand]] (get-gc-content code strand)) 
			codes-and-strands)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def input (slurp (nth args 0)))
  (def codes 
  	(map #(str/replace % ">" "") 
  	(filter #(re-matches #">Rosalind_\d{4}" %) 
  		(str/split input #"\n"))))
  (def strands 
  	(map #(str/replace % "\n" "")
  		(drop-while empty?
  		(str/split input #">Rosalind_\d{4}\n"))))
  (println (get-max-gc-content (zipmap codes strands))))