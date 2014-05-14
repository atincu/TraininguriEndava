
import java.util.*;

//class LetterMapping stores the mapping between a letter and it’s number
public class LetterMapping {
	private static char s;
	private static int value;
	
	LetterMapping (char s, int value){
		this.s = s;
		this.value = value;
	}
	
	public static char getCharacter(){
		return s;
	}
	
	public static int getValue (){
		return value;
	}
	
	//pentru ArrayList
	public String toString() {
		return "LetterMapping [s = " + s + ", value = " + value + "]";
	}
	
	//method that generates an ArrayList of LetterMapping objects for the whole alphabet
	public static ArrayList<LetterMapping> generateArrayList(){
		List<LetterMapping> list = new ArrayList<LetterMapping>();	
		char s = 'a';
	
		for (int i = 1; i < 27; i++) {		
			list.add(new LetterMapping(s, i));
			s++;
		}
				
		return (ArrayList<LetterMapping>) list;
	
}
	//method that generates a HashMap<String,Integer> of alphabet mappings
	public static HashMap<String, Integer> generateHashMap(){
		Map<String, Integer> hList = new HashMap<String, Integer>();
	
		char s = 'a';	
		for (int i = 1; i < 27; i++) {	
			hList.put(String.valueOf(s), new Integer(i));
			s++;	
		}
		return (HashMap<String, Integer>) hList;	
	}
}
