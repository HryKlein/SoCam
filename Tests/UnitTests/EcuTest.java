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

    @Test
    public void testFirstConstructor() {
        int ecuID = 1;
        Ecu e1 = new Ecu(ecuID);

        assertEquals(ecuID, e1.getEcuId());
        assertEquals(0, e1.getSwId());
        assertEquals(0, e1.getSubSwId());
    }

    @Test
    public void testSecondConstructor() {
        int ecuID = 1;
        int swID = 2;
        int sub = 3;
        Ecu e2 = new Ecu(ecuID, swID, sub);

        assertEquals(ecuID, e2.getEcuId());
        assertEquals(swID, e2.getSwId());
        assertEquals(sub, e2.getSubSwId());
    }

    @Test public void testThirdConstructor(){
        Ecu e3 = ecu = new Ecu(0, 1, 2, true, 3);

        assertEquals(0, e3.getEcuId());
        assertEquals(1, e3.getSwId());
        assertEquals(2, e3.getSubSwId());
        assertEquals(3, e3.getNewestSub());
        assertEquals(true, e3.isNewest());
    }
}