package main;

import java.util.Iterator;

import jess.JessException;

public class Main {

	public static void main(String[] args) {
		Situation sit = new Situation("Josias");
		String args2[] = {"0","13","13","1","1"};
		for(int i= 0; i < 5; i++){
			if(i == 0){
				sit.setEscolaridade(Integer.parseInt(args[i]));
			}
			double number = Double.parseDouble(args2[i]);
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
