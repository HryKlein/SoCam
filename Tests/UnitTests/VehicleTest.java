package UnitTests;

import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Vehicle;
import org.junit.Test;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle veh;
    private ArrayList<Ecu> ecuList = new ArrayList<Ecu>();
    private Ecu ecu = new Ecu(0);
    private String id = "1";
    private String history = "hiiistory";
    private String series = "hey";

    public VehicleTest() {
        ecuList.add(ecu);
        veh = new Vehicle(id, history, ecuList, series);
    }

    @Test
    public void testGetEcuCount() {
        assertEquals(1, veh.getEcuCount());
    }

    @Test
    public void testGetEcu() {
        assertEquals(ecu, veh.getEcu(0));
    }

    @Test
    public void testAddEcu() {
        Ecu ecu2 = new Ecu(2);
        veh.addEcu(ecu2);
        assertEquals(2, veh.getEcuCount());
        assertEquals(ecu2, veh.getEcu(1));
    }

    @Test
    public void testRemoveEcu() {
        assertEquals(1, veh.getEcuCount());
        veh.removeEcu(ecu);
        assertEquals(0, veh.getEcuCount());
    }

    @Test
    public void testGetLargestEcuId() {
        Ecu ecu2 = new Ecu(2);
        veh.addEcu(ecu2);
        assertEquals(2, veh.getLargestEcuId());
        Vehicle veh2 = new Vehicle();
        assertEquals(0, veh2.getLargestEcuId());
    }

    @Test
    public void testGetVehicleID() {
        assertEquals(id, veh.getVehicleID());
    }

    @Test
    public void testFindDot() {
        String stringWithDot = "string.with.dot";
        String stringWithoutDot = "stringwithoutdot";
        assertEquals(6, veh.findDot(stringWithDot));
        assertEquals(-1, veh.findDot(stringWithoutDot));
    }

    @Test
    public void testSetVehicleID() {
        veh.setVehicleID("23");
        assertEquals("23", veh.getVehicleID());
    }

    @Test
    public void testGetHistoryLog() {
        assertEquals(history, veh.getHistoryLog());
    }

    @Test
    public void testSetHistoryLog() {
        veh.setHistoryLog("this is a historylog");
        assertEquals("this is a historylog", veh.getHistoryLog());
    }

    @Test
    public void testGetEcus() {
        Ecu ecu2 = new Ecu(2);
        veh.addEcu(ecu2);
        ArrayList ecus = veh.getEcus();
        assertTrue(ecus.contains(ecu) && ecus.contains(ecu2));
        assertEquals(2, ecus.size());
    }

    @Test
    public void testSetEcus() {
        Ecu ecu2 = new Ecu(2);
        Ecu ecu3 = new Ecu(3);
        ArrayList<Ecu> ecus = new ArrayList<>(Arrays.asList(ecu2, ecu3));
        veh.setEcus(ecus);
        assertEquals(ecus, veh.getEcus());
    }

    @Test
    public void testGetSeries() {
        assertEquals(series, veh.getSeries());
    }

    @Test
    public void testSetSeries() {
        veh.setSeries("this is a series");
        assertEquals("this is a series", veh.getSeries());
    }

    @Test
    public void testContains() {
        Ecu ecu2 = new Ecu(2);
        assertFalse(veh.contains(ecu2));
        veh.addEcu(ecu2);
        assertTrue(veh.contains(ecu2));
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, veh.indexOf(ecu));
        Ecu ecu2 = new Ecu(2);
        assertEquals(-1, veh.indexOf(ecu2));
        veh.addEcu(ecu2);
        assertEquals(1, veh.indexOf(ecu2));
    }

    @Test
    public void testIterator() {
        Vehicle veh2 = new Vehicle();
        Iterator it = veh2.iterator();
        assertFalse(it.hasNext());
        veh2.addEcu(ecu);
        assertTrue(it.hasNext());

    }

    @Test
    public void testPropertyChanged(){
        PropertyChangeEvent e = new PropertyChangeEvent(new Object(),"", new Object(), new Object());
        veh.propertyChange(e);
    }

}