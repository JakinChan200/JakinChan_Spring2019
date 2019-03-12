package textExcel;
//import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel {

	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
    	boolean runAgain = true;
    	Grid grid = new Spreadsheet();
    	
    	while(runAgain) {
    		System.out.print("Enter a command: ");
    		String userInput = console.nextLine();
    		if(userInput.equals("quit")){
    			runAgain = false;
    			console.close();
    			System.out.println("Have a nice day!");
    		}else {
        		System.out.println(grid.processCommand(userInput));

    		}
    	}
	}
}
 