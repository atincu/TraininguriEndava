import java.util.ArrayList;
import java.util.HashMap;

//Test sample
public class Main {
	public static void main(String[] args) {	
		System.out.println("As an ArrayList: ");
		ArrayList<LetterMapping> arrayList = LetterMapping.generateArrayList();
		System.out.println(arrayList);
		
		System.out.println("\nAs a HashMap: ");
		HashMap<String, Integer> hmapList = LetterMapping.generateHashMap();		
		System.out.println(hmapList);		
	}
}
