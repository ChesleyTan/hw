// Chesley Tan
// pd 9
// HW49
// 2014-01-08
/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below, categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] _matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
		_matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
		_matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() {
		return _matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
		return _matrix[c-1][r-1];
    }


    //return true if this location is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
		return (_matrix[c-1][r-1] == null);
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
		Object temp = get(r,c);
		_matrix[c-1][r-1] = newVal;
		return temp;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
		String retStr = "";
		for (int i = 0;i<_matrix[0].length;i++){
			retStr += "| ";
			for (Object[] o:_matrix){
				retStr += o[i] + " ";
			}
			retStr = retStr.substring(0,retStr.length()-1) + " |\n";
		}
		return retStr;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
    	if (!(rightSide instanceof Matrix))
    		return false;
		else if (((Matrix)rightSide).size() == this.size()){
			for (int i = 0;i<_matrix.length;i++){
				for (int u = 0;u<_matrix[0].length;u++){
					Object a = get(i+1,u+1);
					Object b = ((Matrix)rightSide).get(i+1,u+1);
					if (a == null && b == null)
						continue;
					else if (!(a.equals(b)))
						return false;
				}
			}
			return true;
		}
		else{
			return false;
		}
    }


    //return true if target is in this matrix; false otherwise
    public boolean isFound( Object target ) {
		for (Object[] o:_matrix){
			for (int i = 0;i<o.length;i++){
				if (o[i] == null){
					if (target == null)
						return true;
					else
						continue;
				}
				else if (o[i].equals(target))
					return true;
			}
		}
		return false;
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
		for (int row = 1;row<_matrix.length + 1;row++){
			set(row,c1,set(row,c2,get(row,c1)));
		}
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
		for (int column = 1;column<_matrix[0].length + 1;column++){
			set(r1,column,set(r2,column,get(r1,column)));
		}
    }


    //main method for testing
    public static void main( String[] args ) {
		Matrix m = new Matrix(2);
		Matrix q = new Matrix(2);
		System.out.println(m);
		System.out.println("Matrix m = Matrix q? " + m.equals(q) + "\n");
		m.set(1,2,"22w222");
		m.set(2,1,"qwerty");
		System.out.println(m);
		System.out.println("Matrix m = Matrix q? " + m.equals(q));
		System.out.println("\"22w222\" found in m? " + m.isFound("22w222"));
		System.out.println("\"null\" found in m? " + m.isFound(null));
		System.out.println("\nSwap Columns!");
		m.swapColumns(1,2);
		System.out.println(m);
		System.out.println("Swap Rows!");
		m.swapRows(1,2);
		System.out.println(m);
    }

}//end class Matrix
