package battleship;

/**
 * Created by tkasa on 20/12/2016.
 */
public class ShipTest {
    public Ship battleship = new Battleship();
    public Ship cruiser = new Cruiser();
    public Ship destroyer = new Destroyer();
    public Ship emptySea = new EmptySea();
    public Ship submarine = new Submarine();

      @Test
    public void testGetLength(){
        assertEquals(battleship.getLength(),4);
        assertEquals(cruiser.getLength(),3);
        assertEquals(destroyer.getLength(),2);
        assertEquals(emptySea.getLength(),1);
        assertEquals(submarine.getLength(),1);
    }

    @Test
    public void testBowColumn(){
        battleship.setBowRow(0);
        assertEquals(battleship.getBowRow(),0);

        cruiser.setBowRow(9);
        assertEquals(cruiser.getBowRow(),9);

        destroyer.setBowColumn(4);
        assertEquals(destroyer.getBowColumn(),4);

    }

    @Test
    public void testGetShipType() {

        assertEquals("battleship",battleship.getShipType());
        assertEquals("submarine",submarine.getShipType());
        assertEquals("destroyer",destroyer.getShipType());
        assertEquals("empty sea",emptySea.getShipType());
        assertEquals("cruiser",cruiser.getShipType());
    }

    @Test
    public void testIsHorizontal() {
        battleship.setHorizontal(true);
        assertTrue(battleship.isHorizontal());

        battleship.setHorizontal(false);
        assertFalse(battleship.isHorizontal());

    }

    @Test
    public void testIsSunk()throws Exception {
        submarine.setBowRow(5);
        submarine.setBowColumn(4);
        submarine.setHorizontal(true);
        assertFalse(submarine.isSunk());
        submarine.shootAt(5,4);
        assertTrue(submarine.isSunk());

        battleship.setBowRow(2);
        battleship.setBowColumn(7);
        battleship.setHorizontal(false);
        assertFalse(battleship.isSunk());

        battleship.shootAt(2,7);
        assertFalse(battleship.isSunk());
        battleship.shootAt(3,7);
        assertFalse(battleship.isSunk());
        battleship.shootAt(4,7);
        assertFalse(battleship.isSunk());
        battleship.shootAt(5,7);
        assertTrue(battleship.isSunk());
    }


}
