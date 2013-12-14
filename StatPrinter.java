// Chesley Tan
// pd9
// HW43
// 2013-12-14

/*===========================================
An AP-style question, for practice:
Write the StatPrinter class below. The StatPrinter Object receives an
ArrayList of nonnegative integers, then builds a frequency ArrayList in which
the index values are the data and the entry at the index is the frequency.
For example, if the received data is    2,3,2,5,1,3    then the frequency 
list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
the maximum value of the data.

A capability of the class is to calculate local modes from the frequency 
list. A local mode is a value that is greater than the value at index-1 
and greater than the value at index+1. A local mode is never at the end
points of the list. For example, if the frequency list is [1,2,1,4,2,3,5] 
then the local modes are 2 and 4.

This class is also capable of printing a histogram of the frequencies, using
'*' to indicate a frequency amount. To print a histogram, the user specifies
the longest sequence of '*' and then all other values are printed in 
proportion to this value. For example, if longest bar is 10 and the frequency
list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

0 : **
1 : ****
2 : **
3 : ********
4 : ****
5 : ******
6 : **********

For each method, state run time efficiency using Big O notation.

Tips for Awesome:
* Look over all fxns, think a bit, decide which to tackle first.
	( Simplest?  Prerequisites? . . . )
* Develop 1 fxn at a time, test it, then move to next.
* For coding today, what extra code do you need to get past Mr. Compiler?
===========================================*/

import java.util.ArrayList;

public class StatPrinter {

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION __ **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data)+1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    public StatPrinter( ArrayList <Integer> data ) { 
		_frequency = new ArrayList<Integer>(); //Initialize _frequency
		for (int i = 0;i<max(data)+1;i++){ //Initially fill _frequency with 0s
			_frequency.add(0);
		}
		for (int i = 0;i<data.size();i++){ //Increment frequency of data.get(i)
				_frequency.set(data.get(i),_frequency.get(data.get(i))+1);
		}
    }


    //*************** QUESTION __ **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    public Integer max( ArrayList <Integer> data ) { 
		int max = data.get(0); //Initial value for max	
		for (int i = 1;i<data.size();i++){ //Start checking at index 1
			if (data.get(i) > max){ //Check for new max value
				max = data.get(i);
			}
		}
		return max;
    }


    //*************** QUESTION __ **************************
    //postcond: returns true if i>0 and i<_frequency.size()-1
    //          and _frequency.get(i-1) < _frequency.get(i)
    //          and _frequency.get(i+1) < _frequency.get(i)
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    public boolean isLocalMode( int i ) { 
		return (i>0 && i<_frequency.size()-1) && (_frequency.get(i-1) < _frequency.get(i)) && (_frequency.get(i+1) < _frequency.get(i));
    }


    //*************** QUESTION __ **************************
    //postcond: returns list of modes in _frequency
    public ArrayList <Integer> getLocalModes() {
		ArrayList<Integer> retArr = new ArrayList<Integer>();	
		for (int i = 0;i<_frequency.size();i++){
			if (isLocalMode(i)){ //Iterates through, checking for a local mode
				retArr.add(i);
			}
		}
		return retArr;
    }


    //*************** QUESTION __ **************************
    //precond:  longestBar > 0
    public void printHistogram( int longestBar ) { 
		double multiplier = longestBar * 1.0 / max(_frequency);
		int counter; //Keep track of number of stars as they are printed
		for (int i = 0;i<_frequency.size();i++){
			counter = (int) Math.round(_frequency.get(i) * multiplier);
			System.out.print(i + " : ");
			while (counter > 0){ //Count down as stars are printed one at a timeuntil the desired number is reached
				System.out.print("*");
				counter--;
			}
			System.out.println(); //Move cursor to next line
		}
		
    }
	public static void main(String[] args){
		ArrayList<Integer> data = new ArrayList<Integer>();
		data.add(0);
		data.add(1);
		data.add(1);
		data.add(1);
		data.add(1);
		data.add(2);
		data.add(2);
		data.add(4);
		data.add(4);
		data.add(3);
		data.add(5);
		StatPrinter stat1 = new StatPrinter(data);
		System.out.println("Data: " + data);
		System.out.println("Local Modes: " + stat1.getLocalModes());
		System.out.println("Note that 2 is not a local mode because there are more 1s than 2s");
		System.out.println("Data Histogram (longest bar 4):");
		stat1.printHistogram(4);
		System.out.println("Data Histogram (longest bar 8):");
		stat1.printHistogram(8);
	}
 
}//end class StatPrinter
