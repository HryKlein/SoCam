package UnitTests;

import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Vehicle;
import org.junit.Test;
import java.util.ArrayList;
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
    }

    @Test
    public void testGetVehicleID() {
    }

    @Test
    public void testFindDot() {
    }

    @Test
    public void testSetVehicleID() {
    }

    @Test
    public void testGetHistoryLog() {
    }

    @Test
    public void testSetHistoryLog() {
    }

    @Test
    public void testGetEcus() {
    }

    @Test
    public void testSetEcus() {
    }

    @Test
    public void testGetSeries() {
    }

    @Test
    public void testSetSeries() {
    }
}