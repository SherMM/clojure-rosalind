(ns revc.core
  (:gen-class))

(defn get-comp
	[nucleotide]
	(get  {:A "T" :T "A" :C "G" :G "C"} (keyword (str nucleotide))))

(defn complement-dna
	[dna]
	(apply str (reverse (map get-comp dna))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (complement-dna (clojure.string/trim (slurp (nth args 0))))))
