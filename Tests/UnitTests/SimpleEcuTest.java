package UnitTests;

import no.ntnu.fp.model.SimpleEcu;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleEcuTest {

    private SimpleEcu sEcu;

    public SimpleEcuTest() {
        sEcu = new SimpleEcu(0, 1);
    }

    @Test
    public void testGetEcuId() {
        assertEquals(0, sEcu.getEcuId());
    }

    @Test
    public void testSetEcuId() {
        sEcu.setEcuId(1);
        assertEquals(1, sEcu.getEcuId());
    }

    @Test
    public void testGetSwId() {

        assertEquals(1, sEcu.getSwId());
    }

    @Test
    public void testSetSwId() {
        sEcu.setSwId(0);

        assertEquals(0, sEcu.getSwId());
    }

    @Test
    public void testSecondConstructor(){
        SimpleEcu se = new SimpleEcu();

        assertEquals(0, se.getEcuId());
        assertEquals(0, se.getSwId());
    }

    @Test
    public void testPropChangedListeners() {
        sEcu.addPropertyChangeListener(null);
        sEcu.removePropertyChangeListener(null);

        assertTrue(true);
    }
}