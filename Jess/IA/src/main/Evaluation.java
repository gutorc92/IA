package main;

import java.io.Serializable;

public class Evaluation implements Serializable {
	private double number;
	
	public Evaluation(double number){
		this.number = number;
	}
	
	public double getNumber(){
		return number;
	}
}
