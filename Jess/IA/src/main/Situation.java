package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Situation implements Serializable {
	private String name;
	private List<Evaluation> evaluations;
	private double sum;
	
	public Situation(String name, List<Evaluation> evaluations, String result){
		this.name = name;
		this.evaluations = evaluations;
		this.sum = 0;
		
	}
	
	public Situation(String name){
		this.name = name;
		this.evaluations = new ArrayList<Evaluation>();
		this.sum = 0;
	}
	
	public void addEvaluation(Evaluation ev){
		evaluations.add(ev);
	}
	
	public Situation(String name, List<Evaluation> evaluations){
		this.name = name;
		this.evaluations = evaluations;
		
	}
	
	public void sumEvaluations(){
		for(Evaluation ev : evaluations){
			sum += ev.getNumber();
		}
	}
	
	public String getName(){
		return name;
	}
	
	public List<Evaluation> getEvaluations(){
		return evaluations;
	}

	public double getSum() {
		this.sumEvaluations();
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
}
