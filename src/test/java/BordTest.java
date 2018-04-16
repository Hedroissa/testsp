import org.junit.Test;

import static org.junit.Assert.*;

public class BordTest {

    @Test
    public void testBord(){ }

    @Test(expected = AssertionError.class)
    public void testgetBurenNullToestand(){
        Bord bord = new Bord();
        bord.getBuren(null);
    }

    @Test(expected = AssertionError.class)
    public void testisGoalNullToestand(){
        Bord bord = new Bord();
        bord.isGoal(null);
    }




}