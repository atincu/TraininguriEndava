package Serialization;

import java.io.*;

public class CircularList implements Serializable{

	private static final long serialVersionUID = 1L;
	private Node start;
	private Node end;
	private int size;

	public CircularList(){
		start = null;
		end = null;
		size = 0;
	}
	
	public boolean isEmpty(){
        return start == null;
    }

	public void add(int val){
		if(start == null){
			start = new Node(null, val);
			end = start;
		}
		else{	
			Node newNode = new Node(start, val);
			end.setNextNode(newNode);
			end = newNode;
		}		
		size++;
	}

	public void remove(int pos){        
		if (pos == 0) {
            start = start.getNextNode();
            end.setNextNode(start);
            size--; 
            return ;
        }
        
        int count = 0;
        for (Node node = start.getNextNode(); count < size; node = node.getNextNode(), count = count + 1)
        	if ((count - 1) == pos){
        		 node.setNextNode(node.getNextNode().getNextNode());
        	}
        size-- ;
	}

	public void Display (){
		int count = 0;
		for(Node node = start; count < size; node = node.getNextNode(), count = count +1)
			System.out.println(node.getData() + " ");
	    }
	
	public static void main (String args[]){
		CircularList list = new CircularList();
		list.add(5);
		list.add(10);
		list.add(8);
		list.remove(2);
		System.out.println("Lista inainte de serializare: ");
		list.Display();
		
		//Serializare Lista
		try { 
			FileOutputStream fileOutputStream = new FileOutputStream("serialList.ser");  
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);  
			objectOutputStream.writeObject(list);  
		} 
		catch (FileNotFoundException e) {  
			  e.printStackTrace();  
		} 
		catch (IOException ioe) {  
			  ioe.printStackTrace();  
		} 
		//Deserializare Lista
		CircularList listDeserialized = null;
		 try {
			 FileInputStream fileInputStream = new FileInputStream("serialList.ser");  
			 ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);  
			 listDeserialized = (CircularList) inputStream.readObject();  
		} 
		 catch (FileNotFoundException e) {  
			   e.printStackTrace();  
		} 
		 catch (IOException ioe) {  
			   ioe.printStackTrace();  
		} 
		 catch (ClassNotFoundException cnf) {  
			   cnf.printStackTrace();  
		} 
		 
		 //Verificare
		 System.out.println("\nLista dupa deserializare: ");
		 listDeserialized.Display();
		 		
	}
}
