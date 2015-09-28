package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataBase implements Database {

	private List<Situation> situations;
	
	public void addSituation(Situation situation){
		if(situations == null){
			situations = new ArrayList<Situation>();
		}
		situations.add(situation);
	}
	
	@Override
	public Collection getCatalogEvaluation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Situation getSituation(int situation) {
		// TODO Auto-generated method stub
		System.out.println(situations.size());
		return situations.get(situation);
	}

	

}
