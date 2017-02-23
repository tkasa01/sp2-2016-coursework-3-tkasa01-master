package battleship;
import java.util.*;
/**
 * Created by tkasa on 20/12/2016.
 */
/*3 ships for 2 places
*
 */
public class Destroyer extends Ship{

    /**
     *  constructor
     */
    public Destroyer ()
    {
        super(2);
    }

    /**
     * @return the string name of the ship
     */
    @Override
    public String getShipType() {

        return "destroyer" ;
    }
}
