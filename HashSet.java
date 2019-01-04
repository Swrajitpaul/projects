import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class MyHashSet {

    /** Initialize your data structure here. */
    List<Integer> al;
    public MyHashSet() {
        al = new ArrayList<>();
    }
    
    public void add(int key) {
        boolean exist = false;
        for(int i: al){
            if(i == key){
                exist = true;
                break;
            } 
        }
        
        if(exist == false){
            al.add(key);
        }
    }
    
    public void remove(int key) {
         for(int i: al){
             if(i == key){
                 al.remove(new Integer(i));
                 break;
             }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for(int i: al){
            if(i == key){
                return true;
            } 
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	try {
			FileInputStream infile = new FileInputStream(args[0]);
			Scanner scan = new Scanner(infile);
			MyHashSet hs = new MyHashSet();
			while(scan.hasNext()) {
				hs.add(scan.nextInt());
			}
			scan.close();
			System.out.print("all the input values have been placed into the set");
			
			Scanner s = new Scanner(System.in); 
			String input = "";
			while(!input.equalsIgnoreCase("q")) {
				System.out.print("Enter an integer to look for or q to quit: ");
				try {
					input = scan.next();
					if(hs.contains(Integer.parseInt(input)) == true) {
						System.out.print(true);
					}
				}
				catch (NumberFormatException e) {
					System.out.println("Not a number");
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}


