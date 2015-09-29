package main;

import java.sql.DatabaseMetaData;
import java.util.Iterator;

import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;

public class DiagnosticoEngine {
	private Rete engine;
    private WorkingMemoryMarker marker;
    private Database database;
   
   public DiagnosticoEngine(Database aDatabase ) throws JessException{	   
    // Create a Jess rule engine
    engine = new Rete();
    engine.reset();

    // Load the pricing rules
    engine.batch("diagnostic.clp");
    

    // Load the catalog data into working memory
    database = aDatabase;
//    engine.addAll(database.getCatalogEvaluation());

    // Mark end of catalog data for later
    marker = engine.mark();
}

private void loadOrderData(int situation) throws JessException {
    // Retrive the order from the database
	Situation sit = database.getSituation(situation);
    
	if (sit != null) {
		// Add the order and its contents to working memory
		engine.add(sit);
		engine.add(sit.getName());
		engine.add(sit.getSum());
		engine.addAll(sit.getEvaluations());
		engine.add(sit.getEscolaridade());
	}
}

public Iterator run(int situation) throws JessException {
    // Remove any previous order data, leaving only catalog data
	engine.resetToMark(marker);
	
	// Load data for this order
    loadOrderData(situation);
    
    // Fire the rules that apply to this order
    engine.run();
    
    // Return the list of offers created by the rules
    return engine.getObjects(new Filter.ByClass(Diagnostic.class));
}

}
