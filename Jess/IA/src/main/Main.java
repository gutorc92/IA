package main;

import java.util.Iterator;

import jess.JessException;

public class Main {

	public static void main(String[] args) {
		Situation sit = new Situation("Josias");
		String args2[] = {"10","20","5","4"};
		for(int i= 0; i < 10; i++){
			double number = Double.parseDouble(args[i]);
			Evaluation ev = new Evaluation(number);
			sit.addEvaluation(ev);
		}
		try {
			DataBase database = new DataBase();
			database.addSituation(sit);
			DiagnosticoEngine engine = new DiagnosticoEngine(database);
	
			processDiagnostic(database, engine, 0);

		} catch (JessException e) {
			e.printStackTrace();
		}

	}

	private static void processDiagnostic(DataBase database, DiagnosticoEngine engine, int diagnostic) throws JessException {		
		
		Iterator diag = engine.run(diagnostic);
		while(diag.hasNext()){
			Diagnostic d = (Diagnostic)diag.next();
			System.out.println(d.getResult());
		}
		
	}
}
