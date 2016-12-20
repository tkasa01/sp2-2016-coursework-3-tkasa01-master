package battleship;
import java.util.*;
/**
 * Created by tkasa on 20/12/2016.
 */
public class EmptySea extends Ship{
    public EmptySea(int length) {
        super(length);
    }

    @Override
    public boolean shootAt(int row,int column){
       return true;
    }

    @Override
    public boolean isSunk(){
        return true;
    }

    @Override
    public String getShipType() {
        return "Empty Sea";
    }
}
