package battleship;
import java.util.*;
/**
 * Created by tkasa on 20/12/2016.
 */
public class EmptySea extends Ship{
   private int length ;

    public EmptySea() {
        super(1);
    }

    /**
     * This method overrides the method shootAt(int row, int column)that is inherited fromShip, and always returns
     * false that nothing was hit.
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean shootAt(int row, int column){

        return false;
    }

    /**
     * This method overrides isSunk() that is inherited from Ship,and always returns false to indicate
     * that you didn't sink anything.
     * @return
     */
    @Override
    public boolean isSunk(){

        return false;
    }

    /**
     * This method returns false, the empty sea, is not a real ship.
     * @return
     */
    @Override
    public boolean isRealShip(){
        return false;
    }

    /**
     * @return the string name of the ship
     */
    @Override
    public String getShipType() {

        return "empty sea";
    }
}
