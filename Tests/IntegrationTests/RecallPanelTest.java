package IntegrationTests;

import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.RecallPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import org.junit.Test;
import static com.sun.javafx.fxml.expression.Expression.add;
import static org.junit.Assert.*;

public class RecallPanelTest {

    GridBagConstraints constraints;

    public void setUp(){
        constraints = new GridBagConstraints();
        Insets insets = new Insets(2, 2, 2, 2);
        constraints.insets = insets;
        constraints.anchor = GridBagConstraints.LINE_START;
    }

    @Test
    public void testRecallActionPerformed(){
        FactoryProjectPanel fP = new FactoryProjectPanel();
        RecallPanel recallPanel = fP.getRecallPanel();
        JButton getEmailsBtn = new JButton("Get list");
        JButton sendBtn = new JButton("Send");
        addGridBagComponent(sendBtn, 3, constraints, 0);
        addGridBagComponent(getEmailsBtn, 3, constraints,1);

        recallPanel.actionPerformed(new ActionEvent(getEmailsBtn, ActionEvent.ACTION_PERFORMED, "", System.currentTimeMillis(), 0));
        recallPanel.actionPerformed(new ActionEvent(sendBtn, ActionEvent.ACTION_PERFORMED, "", System.currentTimeMillis(), 0));

        String expected = "Status: Emails sent!";
        assertEquals(expected, fP.getStatusBar());
    }

    private void addGridBagComponent(Component c, int row, GridBagConstraints constraints, int col) {
        constraints.gridx = col;
        constraints.gridy = row;
        constraints.gridheight = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 1.0;
        add(c, constraints);
    }
}
