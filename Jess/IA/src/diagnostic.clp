(import main.*)
(deftemplate Situation       (declare (from-class Situation)))
(deftemplate Diagnostic      (declare (from-class Diagnostic)))
(deftemplate Evaluation 	 (declare (from-class Evaluation))) 

(bind ?hd (new java.util.ArrayList))

(defrule giving-diagnostic 
(Situation {sum > 30}) 
=> 
(add (new Diagnostic "doido"))) 

(defrule giving-diagnostic2  
(Situation (?sum&:(sum > 10)))
=> 
(add (new Diagnostic "levemente doido"))) 