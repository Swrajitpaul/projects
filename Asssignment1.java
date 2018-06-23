/**
 * Author : Swrajit Paul
 * project 1 cs340 fall 2017
 * 
 * 
 * Description: using the file is loaded and each line of the file is searched for specific commands. If the command is found then it is called from the circular linked list class, followed by the output.
 *
 *code skeleton---
 *
 *
 *
 *main method
 *	try to open the file
 *		while the file has lines
 * 			try to read the commands from the line 
 * 				if the command matches the string call this particular command
 * 	
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Asssignment1 {

	public static void main(String[] args) {
		
		CircularLinkedList<String> CList = new CircularLinkedList<>(); // an instance name CList is initialized
		
		try { // try to open the file
			
			FileInputStream fStream = new FileInputStream("assignment1.txt"); // takes in the assignment1.txt file
			
			Scanner scan = new Scanner(fStream); // scans the file
			
			StringTokenizer token; // declared variable to be instantiated later
			
					
			while (scan.hasNextLine()) { // while the file has a next line the loop executes
				
				try { // try tokenizing the line and reading the line
					
					token = new StringTokenizer(scan.nextLine()); // a line is take into stringtokenizer
					
					String temporaryString = token.nextToken().toString(); // a string is created with the first element of the line 
					
					if (temporaryString.equals("clear")) { // if the the string equals the command clear
						
						CList.clear(); // call the method clear
						
						System.out.println("The circular linked list is now empty");
						
						System.out.println();
					}
					
					if (temporaryString.equals("size")) { // if the command in the line is size
						
						int temp = CList.size();
						
						System.out.println("The circular linked list contains " + temp + " strings");
						
						System.out.println();
					}

					if (temporaryString.equals("is_empty")) { // if the command is empty
						
						if(CList.isEmpty()) {
							
							System.out.println("The circular linked list is empty");
							
							System.out.println();
						}
						
						else {
							
							System.out.println("The circular linked list is not empty");
							
							System.out.println();
						}
					}
					
					if (temporaryString.equals("get")){ // if the command is get
						
						String temp = token.nextToken().toString();
						
						Integer index = new Integer(temp);
						
						String returnString = CList.get(index);
						
						System.out.println("The string at position " + index +" in the circular linked list is '" + returnString + "'" );
						
						System.out.println();
					}
					
					if (temporaryString.equals("set")) { // if the command is set
						
						String temp = token.nextToken().toString();
						
						Integer index = new Integer(temp);
						
						String newString = "";
						
						while(token.hasMoreTokens()) {
							
							newString += token.nextToken().toString() + " ";
						}
						
						String oldString = CList.get(index);
						
						CList.set(index, newString);
						
						System.out.println("The string " + newString +"replaces the string " + oldString + " at position " + index + " in the circular linked list.");
						
						System.out.println();
					}
					
					if (temporaryString.equals("add")) { // if the command is add
						
						String temp = token.nextToken().toString();
						
						Integer index = new Integer(temp);
						
						String newString = "";
						
						while(token.hasMoreTokens()) {
							
							newString += token.nextToken().toString() + " ";
						}
						
						CList.add(index, newString);
						
						System.out.println("Added the string " + newString + "at position " + index + " in the circular linked list");
						
						System.out.println();
					}
					
					if (temporaryString.equals("add_last")) { // if the command id add_last
						
						String newString = "";
						
						while(token.hasMoreTokens()) {
							
							newString += token.nextToken().toString() + " ";
						}
						
						CList.add(newString);
						
						System.out.println("Added the string " + newString + "to the end of the circular linked list");
						
						System.out.println();
					}
					
					if (temporaryString.equals("remove")) { // if the command is remove
						
						String temp = token.nextToken().toString();
						
						Integer index = new Integer(temp);
						
						String oldString = CList.get(index);
						
						CList.remove(index);
						
						System.out.println("Removed the string " + oldString +"at position " + index + " from the circular linked list");
						
						System.out.println();
					}
					
					if (temporaryString.equals("rotate")) { // if the command is rotate
						
						CList.rotate();
						
						System.out.println("The value at the head of the circular linked list was rotated to the tail of the circular linked list.");
						
						System.out.println();
					}
					
					if (temporaryString.equals("print_list")) { // if the command is print
						
						System.out.println("The circular linked list contains");
						
						Iterator it = CList.iterator();
						
						while (it.hasNext()) {
							
							System.out.println(it.next());
						}
						System.out.println();
					}
				} catch (Exception e) {
					
					break;
				}
				
				
			} // end of while loop
			
			scan.close();
		
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found");
			
			e.printStackTrace();
		
		} // end of catch block
	
		
	} // end of main method

} // end of class
