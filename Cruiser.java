package battleship;
import java.util.*;
/**
 * Created by tkasa on 20/12/2016.
 */
public class Cruiser extends Ship {
    /**
     * constructor
     */
    public Cruiser ()
    {
        super(3);
    }

    /**
     *
     * @return the string name of the ship
     */
    @Override
    public String getShipType() {

        return "cruiser" ;
    }
}
