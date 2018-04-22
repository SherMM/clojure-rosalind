(ns rna.core
  (:gen-class))


(defn transcribe
	[nucleotide]
	(if (= nucleotide "T")
		"U"
		nucleotide))

(defn transcribe-to-rna
	([dna]
		(transcribe-to-rna dna ""))
	([dna rna]
		(if (empty? dna)
			rna
			(recur (subs dna 1) (str rna (transcribe (subs dna 0 1)))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (transcribe-to-rna (clojure.string/trim (slurp (nth args 0))))))
