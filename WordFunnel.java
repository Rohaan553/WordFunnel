import java.io.*;
import java.util.*;
/**
	The OneLessWordMatching program asks the user for a text file containing a word list with each word on a separate line.
	It then produces the possible variations of the word if 1 letter was removed from it and then checks those combinations
	against the word list to see which of them actually exist/are other real words. It then returns an array with the combinations
	that are other existing words.
*/
class WordFunnel{
	public static void main(String[] args) throws FileNotFoundException 
	{
		/**Checks if a file was passed in because otherwise the program would throw a FileNotFoundException.*/
		if(args.length == 0){
			System.out.println("Please enter a filename after the program call next time!");
			System.exit(-1);
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String for Comparison:");
		String str1 = scan.next();
		File file = new File(args[0]);
		Scanner filescan = new Scanner(file);
		ArrayList<String> validCombinations = new ArrayList<String>();
		String[] combinations = new String[str1.length()];
		/**Creates the combinations of the word with 1 letter removed from each combination in sequence.*/
		for(int i = 0; i < str1.length(); i++){
			combinations[i] = (str1.substring(0,i) + str1.substring(i+1)); 
		}
		/**Sorts the array because the subsequent while loop containing a for loop removes matched combinations
		in order to improve runtime.*/
		Arrays.sort(combinations);
		int combinationsPointer = 0;
		/**Tests the values in the file against the combination in order to find matches. The for loop's iteration variable
		is set equal to combinationsPointer in order to eliminate matched possibilities from the comparisons to better runtime*/
		while(filescan.hasNext()){
			String str2 = filescan.nextLine();
			for(int j = combinationsPointer; j < combinations.length; j++){
				if (combinations[j].equals(str2)){
					validCombinations.add(str2);
					combinationsPointer++;
					break;
				}
			}
		}
		System.out.println(validCombinations);
		filescan.close();
	}
}