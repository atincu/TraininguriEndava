package Serialization;

import java.io.*;

public class Audi extends Car{
	
	private String name;
	
	Audi (String color, String name){
		super(color);
		this.name = name;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	private void writeObject (ObjectOutputStream oos)throws IOException {
        throw new NotSerializableException();	
	}
	
	private void readObject (ObjectInputStream ois)throws IOException {
        throw new NotSerializableException();	
	}
	
	


}
