(ns count-nucleotides.core
  (:gen-class))

(defn count-nucleotides
	([dna]
		(count-nucleotides dna {:A 0 :C 0 :G 0 :T 0}))
	([dna counts]
		(if (empty? dna)
			counts
			(recur (subs dna 1) (update counts (keyword (subs dna 0 1)) inc)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (vals (count-nucleotides (clojure.string/trim (slurp (nth args 0)))))))
