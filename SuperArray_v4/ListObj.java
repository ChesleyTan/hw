/*==================================================
  interface ListObj
  Declares methods that will be implemented by any 
  class wishing to adhere to this specification.
  This interface specifies behaviors of a list of objects.
  ==================================================*/

public interface ListObj {

    // Return number of meaningful elements in the list
    int size();

    // Append an object to the end. Return true.
    boolean add( Object o ); 

    // Insert an object at index
    void add( int index, Object o ); 

    // Retrieve the object at index
    Object get( int index );

    // Overwrite the object at index
    Object set( int index, Object o );

    // Remove the object at index,
    // shifting any elements after it to the left.
    // Return removed value.
    Object remove( int index );

}//end interface ListObj
