import org.junit.Test;

import static org.junit.Assert.*;

public class ToestandTest {

    @Test
    public void ToestandTest(){
        Toestand toestand = new Toestand(11, 12, 4);
        Toestand testtoestand = new Toestand(12, 11, 3);
        assertTrue(toestand.equals(testtoestand));
    }


    @Test(expected = AssertionError.class)
    public void TestToestandWithInvalidPositions() {
        Toestand toestand = new Toestand(43, -2, 2);
    }

    @Test(expected = AssertionError.class)
    public void TestToestandWithInvalidTurn() {
        Toestand toestand = new Toestand(23, 13, -2);
    }




}