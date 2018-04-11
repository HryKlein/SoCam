package UnitTests;

import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.FactoryProject;
import no.ntnu.fp.model.SimpleEcu;
import no.ntnu.fp.model.Vehicle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FactoryProjectTest {
    
    ArrayList<Vehicle> vehicleList;
    ArrayList<String> softwareList; // to be edited to list of SW?
    ArrayList<SimpleEcu> ecuList;
    SimpleEcu simpleEcu1, simpleEcu2;
    Ecu ecu1, ecu2;
    Vehicle vehicle1, vehicle2;

    private FactoryProject f;
    public FactoryProjectTest(){

        simpleEcu1 = new SimpleEcu(001);
        simpleEcu2 = new SimpleEcu(002);
        ecu1 = new Ecu(01);
        ecu2 = new Ecu(02);

        vehicle1 = new Vehicle("ABCD01","This is the history log of the LADA", new ArrayList(Arrays.asList(ecu1,ecu2)), "LADA");
        vehicle2 = new Vehicle("ABCD02","This is the history log of the BMW", new ArrayList(Arrays.asList(ecu1,ecu2)), "BMW");

        vehicleList = new ArrayList();
        softwareList = new ArrayList();
        ecuList = new ArrayList();

        vehicleList.addAll(Arrays.asList(vehicle1, vehicle2));
        softwareList.addAll(Arrays.asList("IBM", "Macrosoft"));
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
    public void testGetSoftware() {
    }

    @Test
    public void testGetEcuCount() {
    }

    @Test
    public void testGetLatestSoftware() {
    }

    @Test
    public void testGetLatestVehicle() { assertEquals(vehicle2, (Vehicle)f.getLatestVehicle());
    }

    @Test
    public void testGetLatestEcu() {
    }

    @Test
    public void testGetSoftwareIndex() {
    }

    @Test
    public void testGetEcu() {
    }

    @Test
    public void testGetVehicleIndex() {
    }

    @Test
    public void testIndexOf() {
    }

    @Test
    public void testIterator() {
    }

    @Test
    public void testAddVehicle() {
    }

    @Test
    public void testAddSoftware() {
    }

    @Test
    public void testAddEcu() {
    }

    @Test
    public void testRemoveVehicle() {
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