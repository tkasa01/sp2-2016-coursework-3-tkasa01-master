package battleship;
import java.util.*;
/**
 * Created by tkasa on 20/12/2016.
 */
public class Submarine extends Ship{


    public Submarine () {

        super(1);
    }

    /**
     *
     * @return the string name of the ship
     */
    @Override
    public String getShipType() {
        return "submarine" ;
    }
}
