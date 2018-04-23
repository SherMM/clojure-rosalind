(ns revc.core
  (:gen-class))

(defn get-comp
	[nucleotide]
	(get  {:A "T" :T "A" :C "G" :G "C"} (keyword nucleotide)))

(defn complement-dna
	([dna]
		(complement-dna dna ""))
	([dna strand]
		(if (empty? dna)
			(clojure.string/join "" (reverse strand))
			(recur (subs dna 1) (str strand (get-comp (subs dna 0 1)))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (complement-dna (clojure.string/trim (slurp (nth args 0))))))
