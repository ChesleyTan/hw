// Chesley Tan
// pd9
// HW44
// 2013-12-16

/*========================================
class Concentration
Facilitates playing game of Concentration,
aka Memory.
========================================*/

import java.util.ArrayList;
import cs1.Keyboard;

public class Concentration {

    //instance variables
    //storage for 4x4 grid of Tiles. _board.size() == 16        
    private ArrayList<Tile> _board; 

    //count of Tiles with faces visible
    private int _numberFaceUp;  

    //list of Strings used for Tile vals
    private WordList _list;

    private static int _numRows = 4;

	public Concentration(){
		_list = new WordList();
		_board = new ArrayList<Tile>();
		for (int i = 0;i<(_numRows * _numRows) / _list.size();i++){ //Repeat to fill up board completely
			for (int u = 0;u<_list.size();u++){ //Initially add animals from _list to _board
				_board.add(new Tile(_list.get(i)));
			}
		}
		for (int i = 0;i<50;i++){// Randomize positions of animals on grid
			int random1 = (int) (_board.size() * Math.random());
			int random2 = (int) (_board.size() * Math.random());
			_board.set(random1,_board.set(random2,_board.get(random1)));
		}
	}
	/*  Method intended for testing/debugging
	public void revealBoard(){
		for (int i = 0;i<_board.size();i++){
			if (!_board.get(i).isFaceUp()){
				_board.get(i).flip();
			}
		}
		printBoard();
	}
	*/

	// Method for printing out grid
	public void printBoard(){
		for (int i = 0;i<_board.size();i++){
			if (i % _numRows == _numRows - 1){
				System.out.print(_board.get(i));
				System.out.println();
			}
			else{
				System.out.print(_board.get(i) + "\t");
			}
		}
	}
	// Method to check if game is over
	public boolean areAllTilesUp(){
		for (int i = 0;i<_board.size();i++){
			if (!_board.get(i).isFaceUp())
				return false;
		}
		return true;
	}
	// Method to run the game
	public void play(){
		//revealBoard(); for testing/debugging
		// Prints out numbering guide for grid
		System.out.println("The numbering of the board is as follows: ");
		for (int i = 1;i<_board.size() + 1;i++){
			if (i % _numRows == 0){
				System.out.print(i);
				System.out.println();
			}
			else{
				System.out.print(i + "\t");
			}
		}
		// Plays game until the game is over (when all the tiles are flipped)
		while(!areAllTilesUp()){
			System.out.println("Choose a tile to flip: ");
			int tileNumber1 = Keyboard.readInt() - 1;// subtract 1 to account for array start at index 0 while display to user starts at index 1
			// while loop checks for a valid input, if not then prompt again
			while (tileNumber1 > (_numRows * _numRows - 1) || _board.get(tileNumber1).isFaceUp()){
				printBoard();
				System.out.println("That tile is already flipped or that is an invalid tile. Please choose a different one");
				tileNumber1 = Keyboard.readInt() - 1;// subtract 1 to account for array start at index 0 while display to user starts at index 1
			}
			_board.get(tileNumber1).flip();
			System.out.println("You flipped a " + _board.get(tileNumber1) + "!");
			printBoard();
			System.out.println("Choose a second tile to flip: ");
			int tileNumber2 = Keyboard.readInt() - 1;// subtract 1 to account for array start at index 0 while display to user starts at index 1
			// while loop checks for a valid input, if not then prompt again
			while (tileNumber2 > (_numRows * _numRows - 1) || _board.get(tileNumber2).isFaceUp()){
				printBoard();
				System.out.println("That tile is already flipped or that is an invalid tile. Please choose a different one");
				tileNumber2 = Keyboard.readInt() - 1;// subtract 1 to account for array start at index 0 while display to user starts at index 1
			}
			_board.get(tileNumber2).flip();
			System.out.println("You flipped a " + _board.get(tileNumber1) + "!");
			printBoard();
			// Decides if the user found a match or not.
			// If no match, then both tiles are flipped back over.
			if (_board.get(tileNumber1).equals(_board.get(tileNumber2))){
				System.out.println("You found a match!");
			}
			else{
				System.out.println("No Match!");
				_board.get(tileNumber1).flip();
				_board.get(tileNumber2).flip();
			}
			
		}
	}
    //DO NOT MODIFY main()
    public static void main( String[] args ) {
        Concentration game = new Concentration();
        game.play();
    }

}//end class Concentration


