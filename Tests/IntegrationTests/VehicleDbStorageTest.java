package IntegrationTests;

import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.NewVehiclePanel;
import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Vehicle;
import no.ntnu.fp.storage.FactoryDbStorage;
import no.ntnu.fp.storage.VehicleDbStorage;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleDbStorageTest {

    Vehicle veh;
    Ecu ecu;
    VehicleDbStorage vehicleDbStorage;
    NewVehiclePanel newVehiclePanel;
    FactoryDbStorage factoryDbStorage;

    public VehicleDbStorageTest() {
        factoryDbStorage = new FactoryDbStorage();
        vehicleDbStorage = new VehicleDbStorage();

        //Set up Ecu
        ecu = new Ecu(50);

        //Set up v
        veh = new Vehicle();
        veh.addEcu(ecu);
        veh.setVehicleID("30");


        //Set up nvp
        newVehiclePanel = new NewVehiclePanel(new FactoryProjectPanel());
        newVehiclePanel.setModel(veh);
    }

    @Test
    public void updateVehicleConfigInfo() {
        Vehicle vehicle = vehicleDbStorage.getVehicle(100);
        int ecuId = vehicle.getLargestEcuId();
        Ecu newEcu = new Ecu(ecuId + 1, 1, 2, true, 3);

        vehicleDbStorage.updateVehicle(veh);
        assertEquals(ecuId + 1, vehicleDbStorage.getVehicle(100).getLargestEcuId());
    }

}
