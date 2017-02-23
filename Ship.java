package battleship;
import java.util.*;
/**
 * Created by tkasa on 19/12/2016.
 */
public  abstract class Ship {

    // the row(0 to 9) which contains the bow (front) of the ship.
    private int bowRow;

    // the column (0 to 9) which contains the bow (front)of the ship.
    private int bowColumn ;

    //the number of squares occupied by the ship. An "empty sea" location has length 1.
    private int length ;

    //set to true if the ship occupies a single row, false otherwise.
    private boolean horizontal;

    /* an array of booleans telling whether that part of the ship has been hit (fired upon).
    * Battleship  use 4 locations; cruisers use 3; destroyers 2; submarines and empty sea 1.
    * Here hit[0] stands for the location at the bow of the ship.
    * */
    private boolean [] hit ;

    /**
    * Constructor
    */
   public Ship( int length){
       if(length < 1){
           throw new IllegalArgumentException("The length should not be smaller than 1");
       }else{

          this.length = length;
          this.hit = new boolean[length];
          for (int i = 0; i < length; i++){
               hit[i] = false;
          }
       }
   }

    /**
     *
     * @return the bow of the ship if it is horizontally
     */
    public int getBowRow(){
        return bowRow;
    }

    /**
     *
     * @returnt he bow of the ship if it is vertically
     */
    public int getBowColumn(){
        return bowColumn;
    }

    /**
     * @return the ship is horizontal
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * @return the length of the ship
     */
    public int getLength() {
        return length;
    }

    /**
     * @return the type of the ship, to be implemented in subclasses
     */
    public abstract String getShipType();

    /**
     * The method setBowRow() sets the parameter integer row
     * @param  row
     */
    public void setBowRow(int row) {
         this.bowRow  = row;
    }

    /**
     * The method setBowColumn() sets the parameter integer column
     * @param column
     */
    public void setBowColumn(int column) {
         this.bowColumn = column;
    }

    /**
     * The method setHorizontal() sets the ship horizontally
     * @param horizontal
     */
    public void setHorizontal(boolean horizontal) {

        this.horizontal =  horizontal;
    }

    /**
     * The method shootAt() checks if a part of the ship occupies the given row and column,of the ship is hit.
     * @param row
     * @param column
     * @return return isSunk() method if all the ship is hit
     */
    public boolean shootAt(int row, int column) {
          int mark = 0;

            if( this.isHorizontal()){
                  mark =  column - this.getBowColumn();

            } else {

                    mark = row - this.getBowRow();
            }

            hit[mark] = true;
            return this.isSunk();
     }

    /**
     *
     * @retur true, to ease development of classes for real ships.
     */
    public  boolean isRealShip(){

        return true;
    }

    /**
     * @return true, if every part of the ship has been hit, false otherwise.
     */
    public boolean isSunk(){

        for(int i = 0; i < this.length; i++){

            if(!this.hit[i]){
               return false;
            }
        }
        return true;
    }

}































