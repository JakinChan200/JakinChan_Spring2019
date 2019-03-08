package textExcel;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel {

	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
    	boolean runAgain = true;
    	while(runAgain) {
    		System.out.print("Enter a command: ");
    		String userInput = console.nextLine();
    		System.out.println(processCommand(userInput));
    		System.out.println("Do you want to add another command? (type \"quit\" to stop)");
    		if(console.nextLine().equals("quit")){
    			runAgain = false;
    			console.close();
    			System.out.println("Have a nice day!");
    		}
    	}
	}
	
	public 
}
 