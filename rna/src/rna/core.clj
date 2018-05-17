(ns rna.core
  (:gen-class))


(defn transcribe
	[nucleotide]
	(let [nuc (str nucleotide)]
		(if (= nuc "T")
			"U"
			nuc)))

(defn transcribe-to-rna
	[dna]
	(apply str (map transcribe dna)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (transcribe-to-rna (clojure.string/trim (slurp (nth args 0))))))
