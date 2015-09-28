(import main.*)
(deftemplate Situation       (declare (from-class Situation)))
(deftemplate Diagnostic      (declare (from-class Diagnostic)))
(deftemplate Evaluation 	 (declare (from-class Evaluation))) 


(defrule giving-diagnostic 
(Situation {sum > 30}) 
=> 
(add (new Diagnostic "doido"))) 