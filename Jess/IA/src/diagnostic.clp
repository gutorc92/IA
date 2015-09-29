(import main.*)
(deftemplate Situation       (declare (from-class Situation)))
(deftemplate Diagnostic      (declare (from-class Diagnostic)))
(deftemplate Evaluation 	 (declare (from-class Evaluation))) 


(defrule giving-diagnostic2
(Situation {sum <= 22 && escolaridade == 1 }) 
=> 
(add (new Diagnostic "Defeito Cognitivo"))) 

(defrule giving-diagnostic 
(Situation {sum < 11 && escolaridade == 0 }) 
=> 
(add (new Diagnostic "Defeito Cognitivo"))) 

(defrule giving-diagnostic3 
(Situation {sum < 27 && escolaridade == 3 }) 
=> 
(add (new Diagnostic "Defeito Cognitivo")))

(defrule giving-diagnostic4
(Situation {sum > 11 && escolaridade == 0 }) 
=> 
(add (new Diagnostic "Não apresenta defeito Cognitivo"))) 

(defrule giving-diagnostic5 
(Situation {sum > 22 && escolaridade == 1 }) 
=> 
(add (new Diagnostic "Não apresenta defeito Cognitivo"))) 

(defrule giving-diagnostic6 
(Situation {sum > 27 && escolaridade == 3 }) 
=> 
(add (new Diagnostic "Não apresenta defeito Cognitivo")))
