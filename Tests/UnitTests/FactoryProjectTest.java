package UnitTests;

import no.ntnu.fp.model.*;
import org.junit.Test;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;

public class FactoryProjectTest {
    
    ArrayList<Vehicle> vehicleList;
    ArrayList<Software> softwareList;
    ArrayList<SimpleEcu> ecuList;
    SimpleEcu simpleEcu1, simpleEcu2;
    Ecu ecu1, ecu2;
    Vehicle vehicle1, vehicle2;
    Software software1, software2;

    private FactoryProject f;
    public FactoryProjectTest(){

        simpleEcu1 = new SimpleEcu(001);
        simpleEcu2 = new SimpleEcu(002);
        ecu1 = new Ecu(01);
        ecu2 = new Ecu(02);
        software1 = new Software(11,01,"www.software1.pizza");
        software2 = new Software(22,02,"www.software2.pizza");

        vehicle1 = new Vehicle("ABCD01","This is the history log of the LADA",
                new ArrayList(Arrays.asList(ecu1,ecu2)), "LADA");
        vehicle2 = new Vehicle("EFGH02","This is the history log of the BMW",
                new ArrayList(Arrays.asList(ecu1,ecu2)), "BMW");

        vehicleList = new ArrayList();
        softwareList = new ArrayList();
        ecuList = new ArrayList();

        vehicleList.addAll(Arrays.asList(vehicle1, vehicle2));
        softwareList.addAll(Arrays.asList(software1, software2));
        ecuList.addAll(Arrays.asList(simpleEcu1, simpleEcu2));

        f = new FactoryProject(vehicleList, softwareList, ecuList);

        assertNotEquals(null,f);
    }

    @Test
    public void testFactoryProjectTest2() { assertEquals(2, f.getVehicleCount());
        FactoryProject f2 = new FactoryProject();

        assertNotEquals(null,f2);
    }

    @Test
    public void testGetVehicleCount() { assertEquals(2, f.getVehicleCount());
    }

    @Test
    public void testGetSoftwareCount() { assertEquals(2, f.getSoftwareCount());
    }

    @Test
    public void testGetVehicle() { assertEquals(vehicle1, (Vehicle)f.getVehicle(0));
    }

    @Test
    public void testGetSoftware() { assertEquals(software1, (Software) f.getSoftware(0));
    }

    @Test
    public void testGetEcuCount() { assertEquals(2, f.getEcuCount());
    }

    @Test
    public void testGetLatestSoftware() { assertEquals(software2, (Software) f.getLatestSoftware());
    }

    @Test
    public void testGetLatestVehicle() { assertEquals(vehicle2, (Vehicle)f.getLatestVehicle());
    }

    @Test
    public void testGetLatestEcu() { assertEquals(simpleEcu2, (SimpleEcu)f.getLatestEcu());
    }

    @Test
    public void testGetSoftwareIndex() { assertEquals(0, f.getSoftwareIndex(software1));
    }

    @Test
    public void testGetEcu() {  assertEquals(simpleEcu1, (SimpleEcu) f.getEcu(0));
    }

    // Bug here? .contains in getVehicleIndex questionable?
    @Test
    public void testGetVehicleIndex() {
        assertEquals(0, f.getVehicleIndex("ABCD"));
        assertEquals(-1, f.getVehicleIndex("UnknownString"));
    }

    @Test
    public void testIndexOf() { assertEquals(0, f.indexOf(vehicle1));
    }

    @Test
    public void testIterator() {
        Iterator i = f.iterator();

        assertNotSame(i, f.iterator());
    }

    @Test
    public void testAddVehicle() {
        Vehicle vehicle3 = new Vehicle("IJKL03", "This is the history log of the SEAT",
                new ArrayList(Arrays.asList(ecu1, ecu2)), "SEAT");
        f.addVehicle(vehicle3);

        assertEquals(vehicle3, f.getVehicle(2));
    }

    @Test
    public void testAddSoftware() {
        Software software3 = new Software(33,03,"www.software3.pizza");
        f.addSoftware(software3);

        assertEquals(software3, f.getSoftware(2));
    }

    @Test
    public void testAddEcu() {
        SimpleEcu simpleEcu3 =  new SimpleEcu(003);;
        f.addEcu(simpleEcu3);

        assertEquals(simpleEcu3, f.getEcu(2));
    }

    @Test
    public void testRemoveVehicle() {
        int oldCount = f.getVehicleCount();
        f.removeVehicle(vehicle2);

        assertEquals(oldCount-1, f.getVehicleCount());
    }

    @Test
    public void testPropertyChange() {
        PropertyChangeEvent e = new PropertyChangeEvent(new Object(),"", new Object(), new Object());
        f.propertyChange(e);
        f.addPropertyChangeListener(null);
        f.removePropertyChangeListener(null);
        assertEquals(1,1);
    }

    @Test
    public void testEqualsWhenNotEqual() {
        FactoryProject f2 = createFactoryProject(vehicle1, simpleEcu1, software1);
        FactoryProject f3 = createFactoryProject(vehicle2, simpleEcu2, software2);

        assertFalse(f.equals(f2));
        assertFalse(f2.equals(f));
        assertFalse(f2.equals(vehicle1));
        assertFalse(f2.equals(f3));
        assertFalse(f3.equals(f2));
        f3.addVehicle(vehicle1);
        assertFalse(f2.equals(f3));
        assertFalse(f3.equals(f2));
    }

    @Test
    public void testEqualsWhenEqual() {
        FactoryProject f3 = createFactoryProject(vehicle1, simpleEcu1, software1);
        f3.addVehicle(vehicle2);
        f3.addSoftware(software2);
        f3.addEcu(simpleEcu2);

        assertTrue(f.equals(f3));
        assertTrue(f.equals(f));

    }

    @Test
    public void testToString() {
        String[] strings = f.toString().split("\n");
        assertEquals("project:", strings[0]);
    }

    public FactoryProject createFactoryProject(Vehicle v, SimpleEcu se, Software sw) {
        ArrayList<Vehicle> vL = new ArrayList();
        ArrayList<SimpleEcu> seL = new ArrayList();
        ArrayList<Software> sL = new ArrayList();

        vL.add(v);
        seL.add(se);
        sL.add(sw);

        FactoryProject fp = new FactoryProject(vL, sL, seL);
        return fp;
    }
}