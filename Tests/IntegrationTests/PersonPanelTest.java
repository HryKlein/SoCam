package IntegrationTests;

import no.ntnu.fp.gui.PersonPanel;
import no.ntnu.fp.gui.ProjectPanel;
import no.ntnu.fp.model.Person;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonPanelTest {

    @Test
    public void testA(){
        ProjectPanel p = new ProjectPanel();
        PersonPanel pp = new PersonPanel(p);
        pp.setModel(new Person(1));
        pp.setEditable(true);
        

    }
}
