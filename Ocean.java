package battleship;
import java.util.*;
/**
 * Created by tkasa on 19/12/2016.
 */

public class Ocean {
    private static final int WIDTH = 10;
    private static final int LENGTH = 10;

    //variable to determine which ship is in any given location, as a matrix with 10 rows and 10 columns.
    private Ship[][] ships;

    private int shotsFired = 0;  // total number of shots fired by the user
    private int hitCount = 0;  // The number of times a shot hit a ship
    private int shipsSunk = 0;   // number of ships sunk(10 ships in all).
    boolean [][] hitPlace = new boolean[WIDTH][LENGTH];

    /**
     * The constructor creates the field where is going to place the ships. Two FOR loops create a 2D array with
     * WIDTH for rows and LENGTH for columns. The hitPlase it is 2D array, which place above the main Ocean and hides
     * the ships.
     */

    public Ocean() {
        this.ships = new Ship[WIDTH][LENGTH];
        for (int row = 0; row < WIDTH; row++) {
            for (int column = 0; column < LENGTH; column++) {
                ships[row][column] = new EmptySea();
                hitPlace[row][column] = false;
            }
        }
    }

    /**
     *  This method takes as a parameter every ship and check if is there a empty place to put the ship. WHILE loop
     *  contains local variables for checking the empty and convenient place. FOR loop takes cut area around the ship
     *  and check horizontally and vertically.
     * @param ship
     */
    public void randomlyPlaceShip(Ship ship) {
        Random random = new Random();
        boolean found = false;
        int shipLength = ship.getLength();
        int bowRow = 0;
        int bowColumn = 0;
        boolean positionHor = false;

        while (!found) {
            found = true;
            positionHor = random.nextBoolean();
            bowRow = random.nextInt(10 - ship.getLength());      //  the bow of the ship if horizontally
            bowColumn = random.nextInt(10 - ship.getLength());   // the bow of the ship  of vertically
/**
 *  minRow it is an integer which takes biggest number from Math.max() function, where the 0 is boundaries
 *  for left side or the bowRow for the ship which bigger than 0, that avoid go outside the boundaries.
 *  minColumn it is an integer which takes biggest number from Math.max() function for column above the ship.
 *  maxRow it is an integer which takes the minimum from the boundaries right side and bowColumn added ona more column,
 *  and takes a decision if the ship is horizontally or vertically.
 *  That cut the area around the ship. The nested FOR loop checks that area.
 */
            int minRow = Math.max(0,bowRow - 1);
            int minColumn = Math.max(0,bowColumn - 1);
            int maxRow = Math.min(LENGTH - 1,bowColumn + 1 + (positionHor ?  shipLength : 0 ));
            int maxColumn = Math.min(WIDTH - 1,bowRow + 1 + (positionHor ? 0 :  shipLength));

            for(int x = minRow; x <= maxColumn; x++){
                for(int y = minColumn; y <=maxRow; y++){
                    if(isOccupied(x,y)) { found  = false;}
                }
            }

        }

// The FOR loop builds ship with given length
        for (int i = 0; i < ship.getLength(); i++) {
            if (positionHor) {
                ships[bowRow][bowColumn+i] = ship;
            } else {
                ships[bowRow+i][bowColumn] = ship;
            }
        }
        ship.setBowRow(bowRow);
        ship.setBowColumn(bowColumn);
        ship.setHorizontal(positionHor);
    }

    public Ship [][] getShips(){
        return ships;
    }

    /**
     * The method placeAllShipsRandomly() creates all the ships and placed it on the Ocean
     */
    public void placeAllShipsRandomly() {

        final int BATTLESHIP = 1;
        final int CRUISERS = 2;
        final int DESTROYER = 3;
        final int SUBMARINE = 4;


        for (int i = 0; i < BATTLESHIP; i++) {
            randomlyPlaceShip(new Battleship());
        }
        for (int i = 0; i < CRUISERS; i++) {
            randomlyPlaceShip(new Cruiser());
        }
        for (int i = 0; i < DESTROYER; i++) {
            randomlyPlaceShip(new Destroyer());
        }
        for (int i = 0; i < SUBMARINE; i++) {
            randomlyPlaceShip(new Submarine());
        }

    }


    /**
     * This method isOccupied() takes two parameters of the ship and checks.
     * @param row
     * @param column
     * @return true, is the given location contains a ship, false if it does not.
     */

    public boolean isOccupied(int row, int column) {

        if (ships[row][column].isRealShip()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * The method hasSunkShipAt() takes parameters:
     * @param row
     * @param column
     * @return true if the given location contains a sunk ship, false if it does not.
     */

    public boolean hasSunkShipAt(int row, int column) {

        if (this.ships[row][column].isSunk()) {
            return true;
        }

        return false;
    }

    /**
     * The method getShipTypeAt() takes
     * @param row
     * @param column
     * @return the ship type at the given location(by calling the corresponding method of that ship).
     */

    public String getShipTypeAt(int row, int column) {
        String position = this.ships[row][column].getShipType();
        return position;
    }

    /**
     * The method shootAt() shoots at the part of the ship at that location.This method updates the number of
     * shots that have been fired, and the number of hits.
     * @param row
     * @param column
     * @return true, if the given location contains a real ship(not an EmpTySea),false if it does not.
     */


    public boolean shootAt(int row, int column) {

        this.shotsFired++;
        hitPlace[row][column]= true;

        if (ships[row][column].isRealShip()) {

            if (!ships[row][column].isSunk()) {

                ships[row][column].shootAt(row, column);

                this.hitCount++;

                if (ships[row][column].isSunk() == true) {
                    shipsSunk++;

                }

            }
            return true;

        } else {
            return false;
        }
    }

    /**
     * @return the number of shots fired.
     */
    public int getShotsFired() {

        return shotsFired;
    }

    /**
     * @return the number of hits recorded.
     */
    public int getHitCount() {
        return hitCount;
    }


    /**
     * @return the number of ship sunk.
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     *
     * @return true if all ship have been sunk, otherwise false.
     */
    public boolean isGameOver() {
        int allShipsSunk = 10;
        if (shipsSunk != allShipsSunk) {
            return false;

        } else
            return true;
    }

    /**
     * @return the width of the Ocean
     */
    public int getWidth(){
        return WIDTH;
       }

    /**
     * @return the length of the Ocean
     */
    public int getLength(){
        return LENGTH;
    }


    /**
     * Prints the ocean on stdout. To aid the user, row number should be displayed along the left edge of the array,
     and column number should be displayed along the top. Numbers should be 0 to 9.
     */
    public void print() {

        System.out.print("  ");
        for(int i = 0;i < ships.length;i++){
            System.out.print(i);
        }
        System.out.println("");

        for (int i = 0; i < ships.length; i++) {
            System.out.print(i + " ");

            for (int  j = 0; j < ships[i].length; j++) {

                if (hitPlace[i][j] == false) {
                    System.out.print(".");
                }else {
                    if (isOccupied(i, j)) {
                        if(ships[i][j].isSunk()){
                            System.out.print("X");
                        }else{
                            System.out.print("S");
                        }
                    } else {
                        System.out.print("-");
                    }
                }
            }

            System.out.println();
        }

    }


}

























