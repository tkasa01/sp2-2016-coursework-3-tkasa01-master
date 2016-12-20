package battleship;
import java.util.*;
/**
 * Created by tkasa on 19/12/2016.
 */
public class Ocean {
    Ship [][] ships;
    int shotFired;
    int hitCount;
    int shipSunk;

    public Ocean(){

    }
    public void placeAllShipsRandomly(){

    }
    public boolean isOccupied(int row, int column){
        return true;
    }


    public boolean hasSunkShipAt(int row, int column) {
        return true;
    }


    public String getShipAt(int row, int column){
        return null;
    }

    public  boolean shootAt(int row, int column){
        return true;
    }

    public int getShotFired() {
        return shotFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getShipSunk() {
        return shipSunk;
    }
    public boolean isGameOver(){
        return true;
    }

    public Ship [][] getShipsArray(){
        return null;
    }

    public void print(){

    }


}


























