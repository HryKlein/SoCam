package IntegrationTests;

import no.ntnu.fp.gui.EcuPanel;
import no.ntnu.fp.storage.EcuDbStorage;
import org.junit.Test;
import static org.junit.Assert.*;
import no.ntnu.fp.model.SimpleEcu;
import static org.mockito.Mockito.mock;


public class EcuDbStorageTest {

    @Test
    public void testAddEcu_ShouldBeAdded(){
        EcuDbStorage ecuDbStorage = new EcuDbStorage();
        SimpleEcu simpleEcu = new SimpleEcu(0,4);
        EcuPanel ecuPanelMock = mock(EcuPanel.class);

        String[] expectedMsg = {"Ecu added to database","ok"};
        String[] actualMsg = ecuDbStorage.addEcu(simpleEcu, ecuPanelMock);

        assertEquals(expectedMsg[0], actualMsg[0]);

        
    }
}
