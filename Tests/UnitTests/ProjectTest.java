package UnitTests;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;
import org.junit.Test;

import java.beans.PropertyChangeEvent;
import java.util.Iterator;

import static org.junit.Assert.*;

public class ProjectTest {

    Project project;
    private int custId = 1;
    private String name = "Anniken";
    private String email = "anniken@email.com";
    private String street = "Singsakerbakken";
    private String city = "Trondheim";
    private String vehicleId = "1";

    public ProjectTest() {
        project = new Project();
    }

    @Test
    public void testGetPersonCount() {
        assertEquals(0, project.getPersonCount());
        Person p = new Person(custId, name, email, street, city, vehicleId);
        project.addPerson(p);
        assertEquals(1, project.getPersonCount());
    }

    @Test
    public void testGetLargestCustId() {
        assertEquals(0, project.getLargestCustId());
        Person p = new Person(custId, name, email, street, city, vehicleId);
        Person p2 = new Person(2);
        project.addPerson(p);
        project.addPerson(p2);
        assertEquals(2, project.getLargestCustId());
    }

    @Test
    public void testGetPerson() {
        Person p = new Person(custId, name, email, street, city, vehicleId);
        Person p2 = new Person(2);
        project.addPerson(p);
        project.addPerson(p2);
        assertEquals(p2, project.getPerson(1));
        assertEquals(p, project.getPerson(0));
    }

    @Test
    public void testGetPersonIndexByName() {
        Person p = new Person(custId, name, email, street, city, vehicleId);
        project.addPerson(p);
        assertTrue(project.getPersonIndex(name).contains(0));
        assertEquals(1, project.getPersonIndex(name).size());
        assertFalse(project.getPersonIndex("hei").contains(0));
        assertEquals(0, project.getPersonIndex("hei").size());
    }

    @Test
    public void testGetPersonIndexByVehicleIdWhenNoHit() {
        assertEquals(-1, project.getPersonIndex(5));
    }

    @Test
    public void testGetPersonIndexByVehicleIdWhenHit() {
        Project proj = new Project();
        Person p = new Person(custId, name, email, street, city, vehicleId);
        proj.addPerson(p);

        int expectedId = 0;
        int actualId = proj.getPersonIndex(1);

        assertEquals(expectedId, actualId);
    }

    @Test
    public void testIndexOf() {
        Person p = new Person(custId, name, email, street, city, vehicleId);
        assertEquals(-1, project.indexOf(p));
        project.addPerson(p);
        assertEquals(0, project.indexOf(p));
    }

    @Test
    public void testIterator() {
        Person p = new Person(custId, name, email, street, city, vehicleId);
        Iterator it = project.iterator();
        assertFalse(it.hasNext());
        project.addPerson(p);
        assertTrue(it.hasNext());
    }

    @Test
    public void testAddPerson() {
        Person p = new Person(custId, name, email, street, city, vehicleId);
        assertFalse(project.contains(p));
        project.addPerson(p);
        assertTrue(project.contains(p));
    }

    @Test
    public void testContains() {
        Person p = new Person(custId, name, email, street, city, vehicleId);
        assertFalse(project.contains(p));
        project.addPerson(p);
        assertTrue(project.contains(p));
    }

    @Test
    public void testRemovePerson() {
        Person p = new Person(custId, name, email, street, city, vehicleId);
        project.addPerson(p);
        assertTrue(project.contains(p));
        project.removePerson(p);
        assertFalse(project.contains(p));
    }

    @Test
    public void testPropertyChange() {
        PropertyChangeEvent e = new PropertyChangeEvent(new Object(),"", new Object(), new Object());
        project.propertyChange(e);
        project.addPropertyChangeListener(null);
        project.removePropertyChangeListener(null);

        assertTrue(true);
    }

    @Test
    public void testEquals() {
        Project project2 = new Project();
        Person p = new Person(custId, name, email, street, city, vehicleId);
        project.addPerson(p);
        assertFalse(project.equals(project2));
        assertFalse(project2.equals(p));
        project2.addPerson(p);
        assertTrue(project.equals(project2));
    }

    @Test
    public void testEquals2() {
        Project project1 = new Project();
        Project project2 = new Project();
        Person p = new Person(-1, name, email, street, city, vehicleId);
        Person p1 = new Person(-1, name, email, street, city, vehicleId);
        project1.addPerson(p);
        project2.addPerson(p1);


        assertFalse(project1.equals(project2));
    }

    @Test
    public void testToString() {
        Person p = new Person(custId, name, email, street, city, vehicleId);
        Person p2 = new Person(custId, "Nora", "nora@mail.com", street, city, vehicleId);
        project.addPerson(p);
        project.addPerson(p2);
        assertEquals("project:\nName: Anniken; Email: anniken@email.com; Street: Singsakerbakken\nName: Nora; Email: nora@mail.com; Street: Singsakerbakken\n", project.toString());
    }
}