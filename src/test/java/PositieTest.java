import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PositieTest {

    @Test(expected = AssertionError.class)
    public void addPositionWithNullColor(){
        Positie positie = new Positie(2, null);
    }

    @Test(expected = AssertionError.class)
    public void addPositionNumberToLow(){
        Positie positie = new Positie(25, Kleur.GROEN);
    }

    @Test(expected = AssertionError.class)
    public void addPositionWithInvalidNumberAndColor(){
        Positie positie = new Positie(25, null);
    }

    @Test
    public void testValidPosition(){
        Positie positie = new Positie(22, Kleur.PAARS);
    }

    @Test(expected = AssertionError.class)
    public void testAddNeigbourWithInvalidColor(){
        Positie positie = new Positie(22, Kleur.GROEN);
        positie.addNeighbor( null, positie);
    }

    @Test
    public void testAddNeigbourWithvalidColor(){
        Positie positie = new Positie(22, Kleur.GROEN);
        positie.addNeighbor( Kleur.ORANJE, positie);
    }

    @Test(expected = AssertionError.class)
    public void TestGetNextPositionWithInvalidPosition(){
        Positie positie = new Positie(22, Kleur.GROEN);
        positie.getNextPositions(null);
    }

    @Test
    public void TestGetNextPositionWithvalidPosition(){
        Positie positie = new Positie(22, Kleur.GROEN);
        positie.getNextPositions(positie);
    }



}
