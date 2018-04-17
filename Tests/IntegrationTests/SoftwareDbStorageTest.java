package IntegrationTests;

import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.SoftwarePanel;
import no.ntnu.fp.model.Software;
import no.ntnu.fp.storage.SoftwareDbStorage;
import org.junit.Test;

import java.sql.Connection;

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

}
