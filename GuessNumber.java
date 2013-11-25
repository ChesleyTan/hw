// Chesley Tan and Christopher Kim
// pd9
// HW32
// 2013-11-25
/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

/*==================================================
  the Breakdown:
  Given a range of 1 to n, the minimum number of tries needed to guess the number using the most
  efficient method is x tries such that 2^x is greater than n.  This is because the most efficient
  method is to decrease the range of by half (dividing by 2) each time.  We keep dividing the range
  by 2 until the range reaches a length of 0, meaning there is one number which must be the number
  we are looking for
	
  What is the max number of guesses if num is between 1 and 100? 7
  What is the max number of guesses if num is between 1 and 200? 8
  What is the max number of guesses if num is between 1 and 400? 9
  What is the max number of guesses if num is between 1 and 1000? 10
  What is the max number of guesses if num is between 1 and n? x such that 2^x > n
  
  ==================================================*/


import cs1.Keyboard; /* must have cs1 dir in same dir as this file 
                        for this to work */

public class GuessNumber {

    //instance vars
    private int _lo, _hi, _guessCtr, _target;



    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
            _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) {
        _lo = a;
        _hi = b;
        _guessCtr = 1;
        _target = (int) (Math.random() * (_hi - _lo) + _lo);
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
                        Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() {
        System.out.print("Guess a Number from " + _lo + " to " + _hi + ":");
        int number = Keyboard.readInt();
        if (number == _target) {
            System.out.println("Correct! It took " + _guessCtr + " guesses!");
        }
        else if (number > _target) {
            System.out.println("Too High");
            _guessCtr++;
            playRec();
        }
        else {
            System.out.println("Too Low");
            _guessCtr++;
            playRec();
        }        
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
                         Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() {
        System.out.print("Guess a Number from " +  _lo + " to " + _hi + ": ");
        int number;
        while((number = Keyboard.readInt()) != _target) {
            if (number > _target) {
                System.out.println(" Too High ");
                _guessCtr++;
                System.out.print("Guess a Number from " + _lo + " to " + _hi + ": ");
            }
            else {
                System.out.println(" Too Low ");
                _guessCtr++;
                System.out.print("Guess a Number from " + _lo + " to " + _hi + ": ");
            }
        }
        System.out.println("Correct! It took " + _guessCtr + " tries!");
                
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() { 
        //use one or the other below:
        //playRec();
        playIter();
    }


    //main method to run it all
    public static void main( String[] args ) {

        //instantiate a new game
        GuessNumber g = new GuessNumber(1,100);

        //start the game
        g.play();
    }


    /*==================================================
      _ _(_) -- 
      pre:  
      post: 
      ==================================================*/
}//end class
