package IntegrationTests;

import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.NewVehiclePanel;
import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Vehicle;
import no.ntnu.fp.storage.FactoryDbStorage;
import no.ntnu.fp.storage.VehicleDbStorage;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class VehicleDbStorageTest {

    Vehicle veh;
    Ecu ecu;
    VehicleDbStorage vehicleDbStorage;
    NewVehiclePanel newVehiclePanel;
    FactoryDbStorage factoryDbStorage;


    // Service a vehicle. This consists of the following actions:
    //• Update the vehicle’s configuration info
    //• Update the vehicle’s configuration info in the vehicle database


    public void TestVehicleDbStorage_add() {
        factoryDbStorage = new FactoryDbStorage();
        vehicleDbStorage = new VehicleDbStorage();

        //Set up Ecu
        ecu = new Ecu(50);

        //Set up vehicle
        veh = new Vehicle();
        veh.addEcu(ecu);
        veh.setVehicleID("101");


        //Set up nvp
        newVehiclePanel = new NewVehiclePanel(new FactoryProjectPanel());
        newVehiclePanel.setModel(veh);
    }

    @Test
    public void TestUpdateVehicleConfigInfo() {
        //add vehicle
        TestVehicleDbStorage_add();
        int ecuId = veh.getLargestEcuId();
        String vehID = "101";

        //testing that veh is 101
        assertEquals(vehID,veh.getVehicleID());
        //checking ecuID
        assertEquals(ecuId, veh.getLargestEcuId());

        //Updating ecu on vehicle
        Ecu newEcu = new Ecu(ecuId + 1, 1, 2, true, 3);
        veh.addEcu(newEcu);
        vehicleDbStorage.updateVehicle(veh);
        int actualEcuID = veh.getLargestEcuId();

        //testing that ecu is updated
        assertEquals((ecuId + 1), actualEcuID);
    }

}
