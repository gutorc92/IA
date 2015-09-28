(import main.*)
(deftemplate Situation       (declare (from-class Situation)))
(deftemplate Diagnostic      (declare (from-class Diagnostic)))


(defrule giving-diagnostic 
(Situation {sum > 30}) 
=> 
(add (new Diagnostic "doido"))) 