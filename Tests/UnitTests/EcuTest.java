package UnitTests;

import no.ntnu.fp.model.Ecu;
import org.junit.Test;

import java.beans.PropertyChangeSupport;

import static org.junit.Assert.*;

public class EcuTest {

    private PropertyChangeSupport propChangeSupp;

    public final static String SOFTWARE_PROPERTY_NAME = "swId";
    public final static String SUBSOFTWARE_PROPERTY_NAME = "subSwId";
    public final static String ECUID_PROPERTY_NAME = "ecuId";

    private Ecu ecu;

    public EcuTest() {
        ecu = new Ecu(0, 1, 2, true, 3);
    }

    @Test
    public void testAddPropertyChangeListener() {
    }

    @Test
    public void testRemovePropertyChangeListener() {
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
    }

    @Test
    public void testSetSwId() {
    }

    @Test
    public void testGetSubSwId() {
    }

    @Test
    public void testSetSubSwId() {
    }

    @Test
    public void testIsNewest() {
    }

    @Test
    public void testSetNewest() {
    }

    @Test
    public void testGetECUID_PROPERTY_NAME() {
    }

    @Test
    public void testGetNewestSub() {
    }

    @Test
    public void testSetNewestSub() {
    }
}