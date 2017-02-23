package battleship;
import java.util.*;

public class Battleship extends Ship {

    /**
     * constructor
     */
    public Battleship() {

        super(4);
    }

    /**
     *
     * @return the string name of the ship
     */
    @Override
    public String getShipType() {
        return "battleship";
    }



}
