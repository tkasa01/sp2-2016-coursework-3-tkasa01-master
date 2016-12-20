package battleship;

/**
 * Created by tkasa on 20/12/2016.
 */
public class SimpleShip {
    private int [] location;
    private int numberOfHits;

    public void setLocations(int [] loc){
        location = loc;
    }

    public String checkGuess (String Userguess){

        String result = "miss";

        int guess = Integer.parseInt(Userguess);

        for (int loc :location){
            if( guess == loc){

                result = numberOfHits == location.length ? "kill" : "hit";
                break;
            }
        }

    }
}
