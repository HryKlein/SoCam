package IntegrationTests;

import no.ntnu.fp.gui.AddEcuAction;
import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.NWPEcuPanel;
import no.ntnu.fp.gui.NewVehiclePanel;
import no.ntnu.fp.model.FactoryProject;
import org.junit.Test;

import java.awt.event.ActionEvent;

public class AddEcuActionTest {

    @Test
    public void actionPerformedTest(){
        NWPEcuPanel panel = new NWPEcuPanel(new NewVehiclePanel(new FactoryProjectPanel()));
        AddEcuAction action = new AddEcuAction(panel);

        action.actionPerformed(new ActionEvent(null, 0, ""));

        panel.
    }
}
