import java.util.*;


public class MultipleThreads implements Runnable{	
	int start;
	int end;
	ArrayList<Integer> chunk;
	ArrayList<Integer> resultList;
	
	
	MultipleThreads (ArrayList<Integer> chunk, ArrayList<Integer> resultList, int start, int end){
		this.chunk = chunk;
		this.resultList = resultList;
		this.start = start;
		this.end = end;		
	}
	
	//test if it is prime
	boolean isPrime(int n) {
	    for(int i = 2; i < n; i++) {
	        if(n % i == 0)
	            return false;
	    }
	    return true;
	}

	public void run() {	
		for(int i = start; i < end; i++)		
			if(isPrime(chunk.get(i))){
				synchronized (resultList) {				
					resultList.add(chunk.get(i));
				}		
			}
	}
	
	//test sample
	public static void main(String[] args) throws InterruptedException{
		
		//number of chunks
		int chunks = 5;
		
		ArrayList<Integer> list  = new ArrayList<Integer>();	
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		
		//creating a random list
		for(int i = 0; i < 50; i++)
			list.add(i+2);
		Collections.shuffle(list);
	
		MultipleThreads multipleThreads[] = new MultipleThreads[chunks];
		Thread thread[] = new Thread[chunks];
		
		int contor = (int)list.size()/chunks;
		
		for (int i = 0; i < chunks; i++){
			if (i != chunks - 1){
				multipleThreads[i] = new MultipleThreads(list, resultList, contor * i, (i+1) * contor);			
			}
			else {
				multipleThreads[i] = new MultipleThreads(list, resultList, contor * i, list.size());
			}
			
			thread[i] = new Thread (multipleThreads[i]);
			thread[i].start();
			thread[i].join();
		}
				
		System.out.println("The resultList has a number of: " + resultList.size() + " elements!");
		for(int i=0; i<resultList.size(); i++)
		    System.out.print(resultList.get(i) + " ");
	}
}
