import org.junit.Test;

import static org.junit.Assert.*;

public class PuzzelTest {

    @Test(expected = AssertionError.class)
    public void TestPuzzelWithInvalidPosition(){
        Puzzel puzzel = new Puzzel(24, 24);
    }

    @Test
    public void TestPuzzelWithValidPosition(){
        Puzzel puzzel = new Puzzel(22, 22);
    }
}