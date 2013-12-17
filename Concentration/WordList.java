// Chesley Tan
// pd9
// HW44
// 2013-12-16
import java.util.ArrayList;
/*========================================
Another sample AP question. 1 of 4 free-response questions, 
for which you will have about 1hr45min.
Note that for today's work, you will have to implement a constructor 
and a main method yourself for testing...

The following class WordList is designed to store and manipulate a 
list of words. The incomplete class declaration is shown below. 
You will be asked to implement two methods.
========================================*/

public class WordList {

    private ArrayList<String> myList; // contains Strings made up of letters
	
	public WordList(){
		myList = new ArrayList<String>(); // Initialize a new WordList
		myList.add("cat");  // Add values to the new WordList
		myList.add("dog");
		myList.add("cow");
		myList.add("pig");
		myList.add("bat");
		myList.add("ape");
		myList.add("eel");
		myList.add("rat");
	}
    //postcond: returns the number of words in this WordList that are 
    //          exactly len letters long
    public int numWordsOfLength(int len) { 
    	int counter = 0;
		for (int i = 0;i<myList.size();i++){
			if (myList.get(i).length() == len){
				counter++;
			}
		}
		return counter;
	}

    //postcond: all words that are exactly len letters long have been removed 
    //          from this WordList, with order of remaining words unchanged
    public void removeWordsOfLength(int len) { 
    	for (int i = 0;i<myList.size();i++){
			if (myList.get(i).length() == len){
				myList.remove(i);
				i--;
			}
		}
	}
	// Accessor methods to allow limited public access of myList
	public int size(){
		return myList.size();
	}
	public String get(int i){
		return myList.get(i);
	}
}

