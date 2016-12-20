package battleship;

/**
 * Created by tkasa on 20/12/2016.
 */
public class OceanTest {
    public static void main(String [] args){
        Ocean ship = new Ocean(); // create a new object for testing
        int  [] location = {2,3,4};
        ship.setLocation(location);

        String userGuess = "3";
        ship.checkGuess(userGuess);
    }
}
