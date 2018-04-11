package UnitTests;

import no.ntnu.fp.model.Ecu;
import org.junit.Test;

import java.beans.PropertyChangeSupport;

import static org.junit.Assert.*;

public class EcuTest {

    private Ecu ecu;

    public EcuTest() {
        ecu = new Ecu(0, 1, 2, true, 3);
    }

    @Test
    public void testAddPropertyChangeListener() {
        //Hvordan uten getter?

    }

    @Test
    public void testRemovePropertyChangeListener() {
        //Hvordan uten getter?
    }

    @Test
    public void testGetEcuId() {
        assertEquals(0, ecu.getEcuId());
    }

    @Test
    public void testSetEcuId() {
        ecu.setEcuId(1);
        assertEquals(1, ecu.getEcuId());
    }

    @Test
    public void testGetSwId() {
        assertEquals(1, ecu.getSwId());
    }

    @Test
    public void testSetSwId() {
        ecu.setSwId(2);
        assertEquals(2, ecu.getSwId());
    }

    @Test
    public void testGetSubSwId() {
        assertEquals(2, ecu.getSubSwId());
    }

    @Test
    public void testSetSubSwId() {
        ecu.setSubSwId(3);
        assertEquals(3, ecu.getSubSwId());
    }

    @Test
    public void testIsNewest() {
        assertTrue(ecu.isNewest());
    }

    @Test
    public void testSetNewest() {
        ecu.setNewest(false);
        assertFalse(ecu.isNewest());
    }

    @Test
    public void testGetECUID_PROPERTY_NAME() {
        assertEquals("ecuId", Ecu.getECUID_PROPERTY_NAME());
        assertEquals(Ecu.ECUID_PROPERTY_NAME, Ecu.getECUID_PROPERTY_NAME());
    }

    @Test
    public void testGetNewestSub() {
        assertEquals(3, ecu.getNewestSub());
    }

    @Test
    public void testSetNewestSub() {
        ecu.setNewestSub(4);
        assertEquals(4, ecu.getNewestSub());
    }
}