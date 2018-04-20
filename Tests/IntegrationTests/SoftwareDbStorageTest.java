package IntegrationTests;

import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.SoftwarePanel;
import no.ntnu.fp.model.Software;
import no.ntnu.fp.storage.SoftwareDbStorage;
import org.junit.Test;

import static org.junit.Assert.*;

public class SoftwareDbStorageTest {

    private SoftwareDbStorage sdbs;
    private Software sw;
    private SoftwarePanel swp;

    public SoftwareDbStorageTest() {
        sdbs = new SoftwareDbStorage();
        sw = new Software();
        swp = new SoftwarePanel(new FactoryProjectPanel());
    }

    //The tests in these file are for the following requirement:
    //The CM can enter new versions of existing software into the software
    //archive. Each software component has a unique part number. Versioning is done by subnumbering.
    //E.g. if a software component has part number 123456, then the first version
    //has part number 123456.0, the next version has part number 123456.1 and so on.

    @Test
    public void testAddNewVersionOfExistingSw_incrementBy1() {
        SoftwarePanel swPanel = new SoftwarePanel(new FactoryProjectPanel());
        SoftwareDbStorage swDbStorage = new SoftwareDbStorage();

        int subId = swDbStorage.getBiggestSubId(5) + 1;

        Software sw = new Software(5, subId, "sw1.1.no");

        swPanel.setModel(sw);
        swDbStorage.addSoftware(sw, swPanel);

        assertEquals(subId, swDbStorage.getBiggestSubId(5));

    }

    @Test
    public void testAddNewVersionOfExistingSw_subIdTooBig() {
        SoftwarePanel swPanel = new SoftwarePanel(new FactoryProjectPanel());
        SoftwareDbStorage swDbStorage = new SoftwareDbStorage();

        int subId = swDbStorage.getBiggestSubId(5) + 2;

        Software sw = new Software(5, subId, "sw1.1.no");

        swPanel.setModel(sw);
        swDbStorage.addSoftware(sw, swPanel);

        assertEquals(subId - 1, swDbStorage.getBiggestSubId(5));

    }

    @Test
    public void testAddNewVersionOfExistingSw_subIdTooSmall() {
        SoftwarePanel swPanel = new SoftwarePanel(new FactoryProjectPanel());
        SoftwareDbStorage swDbStorage = new SoftwareDbStorage();

        int subId = swDbStorage.getBiggestSubId(5);

        Software sw = new Software(5, subId, "sw1.1.no");

        swPanel.setModel(sw);
        swDbStorage.addSoftware(sw, swPanel);

        assertEquals(subId + 1, swDbStorage.getBiggestSubId(5));

    }
    @Test
    public void testAddNewSoftware_notInDb(){
        SoftwarePanel swPanel = new SoftwarePanel(new FactoryProjectPanel());
        SoftwareDbStorage swDbStorage = new SoftwareDbStorage();
        assertFalse(swDbStorage.swInSwArchive(11));
        Software newSw = new Software(11, 1, "swnew.no");

        try{
            swPanel.setModel(newSw);
            swDbStorage.addSoftware(newSw,swPanel);
        }
        catch (Exception e){

        }
        
        assertTrue(swDbStorage.swInSwArchive(11));


    }

}
