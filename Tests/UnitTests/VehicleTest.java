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
    public void testgetEcuCount() {

    }

    @Test
    public void testgetEcu() {
    }

    @Test
    public void testaddEcu() {
        Ecu ecu2 = new Ecu(2);
        veh.addEcu(ecu2);
        assertEquals(2, veh.getEcuCount());
    }

    @Test
    public void testremoveEcu() {
    }

    @Test
    public void testgetLargestEcuId() {
    }

    @Test
    public void testgetVehicleID() {
    }

    @Test
    public void testfindDot() {
    }

    @Test
    public void testsetVehicleID() {
    }

    @Test
    public void testgetHistoryLog() {
    }

    @Test
    public void testsetHistoryLog() {
    }

    @Test
    public void testgetEcus() {
    }

    @Test
    public void testsetEcus() {
    }

    @Test
    public void testgetSeries() {
    }

    @Test
    public void testsetSeries() {
    }
}