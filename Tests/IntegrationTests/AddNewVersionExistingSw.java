package IntegrationTests;

import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.SoftwarePanel;
import no.ntnu.fp.model.Software;
import no.ntnu.fp.storage.SoftwareDbStorage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AddNewVersionExistingSw {

    FactoryProjectPanel fpPanel;
    SoftwarePanel swPanel;
    SoftwareDbStorage swDbStorage;

    public AddNewVersionExistingSw() {
        fpPanel = new FactoryProjectPanel();
        //swPanel = new SoftwarePanel(fpPanel);
        swPanel = mock(SoftwarePanel.class);
        swDbStorage = new SoftwareDbStorage();
    }

    @Test
    public void testAddNewVersionOfExistingSw() {
        assertEquals(0, swDbStorage.getBiggestSubId(5));

        Software sw = new Software(5, 1, "sw1.1.no");
        swDbStorage.addSoftware(sw, swPanel);

        Software software = mock(Software.class);



        assertEquals(1, swDbStorage.getBiggestSubId(5));

    }

}
