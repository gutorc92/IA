package main;

import java.io.Serializable;

public class Diagnostic implements Serializable {
	
	private String result;
	
	public Diagnostic(String result){
		this.result = result;
	}
	
	public String getResult(){
		return this.result;
	}

}
