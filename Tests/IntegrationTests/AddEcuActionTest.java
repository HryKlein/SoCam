package IntegrationTests;

import no.ntnu.fp.gui.AddEcuAction;
import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.NWPEcuPanel;
import no.ntnu.fp.gui.NewVehiclePanel;
import no.ntnu.fp.gui.EcuListModel;
import no.ntnu.fp.model.Vehicle;
import org.junit.Test;
import javax.swing.*;
import static org.junit.Assert.*;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class AddEcuActionTest {

    @Test
    public void actionPerformedTest() throws MalformedURLException {
        NWPEcuPanel panel = new NWPEcuPanel(new NewVehiclePanel(new FactoryProjectPanel()));
        AddEcuAction action = new AddEcuAction(panel);
        panel.setModel(new EcuListModel(new Vehicle(), new URL("http://www.google.no")));

        int oldEcuId = panel.getModel().getProject().getLargestEcuId();

        action.actionPerformed(new ActionEvent(new JButton(), 0, ""));

        int newEcuId = panel.getModel().getProject().getLargestEcuId();

        assertEquals(oldEcuId + 1, newEcuId);

    }
}
