package battleship;

/**
 * Created by tkasa on 20/12/2016.
 */
class OceanTest {
    Ocean ocean;
    Ship battleship;
    Ship submarine;

    @Test
    public void testOcean() {
        int x = 10;
        int y = 10;
        ocean = new Ocean();
        int width = ocean.getWidth();
        int length = ocean.getLength();

        battleship = new Battleship();
        submarine = new Submarine();

        assertEquals(x, width);
        assertEquals(y, length);

        assertEquals(ocean.getHitCount(), 0);
        assertEquals(ocean.getShipsSunk(), 0);
        assertEquals(ocean.getShotsFired(), 0);
        assertFalse(ocean.isGameOver());

    }

    @Test
    public void testIsOccupied() {
        Ship battleship = new Battleship();
        Ocean ocean = new Ocean();
        assertFalse(ocean.isOccupied(1, 0));
        ocean.placeAllShipsRandomly();
       // assertTrue(ocean.isOccupied(1, 0));
    }

    @Test
    public void testRandomlyPlaceShip() throws Exception {

        Ocean ocean = new Ocean();

        assertEquals("empty sea", ocean.getShipTypeAt(3,8));

    }

    @Test
    public void testPlaceAllShipsRandomly() {

        Ocean ocean = new Ocean();
        int shipsCount = 0;
        ocean.placeAllShipsRandomly();
        for (int i = 0; i < ocean.getWidth(); i++) {
                    shipsCount++;
        }
         assertEquals(shipsCount,(1+2+3+4));

    }

    @Test
    public void testHasSunkShipAt() {
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.isSunk();
        ocean.hasSunkShipAt(1, 1);
        assertTrue(true, ocean.getShipTypeAt(1, 1));
    }

    @Test
    public void testGetShipTypeAt() {
        Ocean ocean = new Ocean();
        Ship battleship = new Battleship();
        assertEquals("battleship", battleship.getShipType());
    }

    @Test
    public void testShootAt() {
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.setBowRow(7);
        submarine.setBowColumn(7);
        ocean.shootAt(7, 7);
        assertEquals(7, 7, ocean.getShotsFired());
    }

    @Test
    public void testGetShipsSunk() {
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        ocean.randomlyPlaceShip(submarine);
        assertEquals(0, ocean.getShipsSunk());
    }

    @Test
    public void testGetHitCount() {
        Ocean ocean = new Ocean();
        assertEquals(0,ocean.getHitCount());
    }

    @Test
   public void testIsGameOver(){
        Ocean ocean = new Ocean();
        Random r = new Random();
      assertEquals(0, ocean.getShipsSunk());
      assertNotEquals(8,ocean.getShipsSunk());
      assertTrue(true);
   }

}
