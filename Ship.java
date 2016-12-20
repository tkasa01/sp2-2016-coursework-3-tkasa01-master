package battleship;
import java.util.*;
/**
 * Created by tkasa on 19/12/2016.
 */
public abstract class Ship {

    // the row(0 to 9) which contains the bow (front) of the ship.
    int bowRow;

    // the column (0 to 9) which contains the bow (front)of the ship.
    int bowColumn;

    //the number of squares occupied by the ship. An "empty sea" location has length 1.
    int length;

    //set to true if the ship occupies a single row, false otherwise.
    boolean horizontal;

    /* an array of booleans telling whether that part of the ship has been hit (fired upon).
    * Battleship  use 4 locations; cruisers use 3; destroyers 2; submarines and empty sea 1.
    * Here hit[0] stands for the location at the bow of the ship.
    * */
    boolean [] hit;


    public Ship(int length){


    }

    public int getBowRow(){
        return 0;
    }

    public int getBowColumn(){
        return 0;
    }

    public boolean isHorizontal() {
        return true;
    }

    public int getLength() {
        return length;
    }


    public abstract String getShipType();



    public void setBowRow(int row) {
        this.bowRow = row;
    }

    public void setBowColumn(int column) {
        this.bowColumn = column;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean shootAt(int row, int column){
        return true;
    }

    public  boolean isRealShip(){

        return true;
    }

    public boolean isSunk(){
        return true;
    }

}
































