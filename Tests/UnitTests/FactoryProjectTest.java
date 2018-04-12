package UnitTests;

import no.ntnu.fp.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FactoryProjectTest {
    
    ArrayList<Vehicle> vehicleList;
    ArrayList<Software> softwareList; // to be edited to list of SW?
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

        vehicle1 = new Vehicle("ABCD01","This is the history log of the LADA", new ArrayList(Arrays.asList(ecu1,ecu2)), "LADA");
        vehicle2 = new Vehicle("EFGH02","This is the history log of the BMW", new ArrayList(Arrays.asList(ecu1,ecu2)), "BMW");

        vehicleList = new ArrayList();
        softwareList = new ArrayList();
        ecuList = new ArrayList();

        vehicleList.addAll(Arrays.asList(vehicle1, vehicle2));
        softwareList.addAll(Arrays.asList(software1, software2));
        ecuList.addAll(Arrays.asList(simpleEcu1, simpleEcu2));

        f = new FactoryProject(vehicleList, softwareList, ecuList);

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
    public void testGetLatestSoftware() { assertEquals(software2, (Software) f.getSoftware(1));
    }

    @Test
    public void testGetLatestVehicle() { assertEquals(vehicle2, (Vehicle)f.getLatestVehicle());
    }

    @Test
    public void testGetLatestEcu() { assertEquals(simpleEcu2, (SimpleEcu)f.getLatestEcu());
    }

    @Test
    public void testGetSoftwareIndex() {
        assertEquals(0, f.getSoftwareIndex(software1));
    }

    @Test
    public void testGetEcu() {  assertEquals(simpleEcu1, (SimpleEcu) f.getEcu(0));
    }

    // Bug here? .contains in getVehicleIndex questionable?
    @Test
    public void testGetVehicleIndex() { assertEquals(0, f.getVehicleIndex("ABCD"));
    }

    @Test
    public void testIndexOf() { assertEquals(0, f.indexOf(vehicle1));
    }

    @Test
    public void testIterator() {
    }

    @Test
    public void testAddVehicle() {
        Vehicle vehicle3 = new Vehicle("IJKL03", "This is the history log of the SEAT", new ArrayList(Arrays.asList(ecu1, ecu2)), "SEAT");
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
        f.removeVehicle(vehicle2);
        assertEquals(1, f.getVehicleCount() );
    }

    @Test
    public void testAddPropertyChangeListener() {
    }

    @Test
    public void testRemovePropertyChangeListener() {
    }

    @Test
    public void testPropertyChange() {
    }

    @Test
    public void testEquals() {
    }

    //@Test
    //public void toString() {
    //}
}