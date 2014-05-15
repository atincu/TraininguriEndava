package Serialization;

import java.io.Serializable;

public class Car implements Serializable{

	private static final long serialVersionUID = -2276640560710622125L;
	private String color;
	
	Car() {};

	Car (String color){
		this.color = color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public String getColor(){
		return color;
	}	
}