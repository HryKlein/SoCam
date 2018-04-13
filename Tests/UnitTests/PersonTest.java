package UnitTests;

import no.ntnu.fp.model.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private int custId = 1;
    private String name = "test";
    private String email = "test@mail.me";
    private String street = "street1";
    private String city = "city1";
    private String vehicleID = "123";

    private Person p;

    public PersonTest(){
        p = new Person(custId, name, email, street, city, vehicleID);
    }

    @Test
    public void testGetName() {
        assertEquals(name, p.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals(email, p.getEmail());
    }

    @Test
    public void testGetStreet() {
        assertEquals(street, p.getStreet());
    }

    @Test
    public void testGetId() {
        assertFalse(p.getId() < 0);
    }

    @Test
    public void testGetCity() {
        assertEquals(city, p.getCity());
    }

    @Test
    public void testGetVehicleID() {
        assertEquals(vehicleID, p.getVehicleID());
    }

    @Test
    public void testGetCustId() {
        assertEquals(custId, p.getCustId());
    }

    @Test
    public void testSetName() {
        p.setName("ida");
        assertEquals("ida", p.getName());
    }

    @Test
    public void testSetEmail() {
        p.setEmail("lala@mail.no");
        assertEquals("lala@mail.no", p.getEmail());
    }

    @Test
    public void testSetStreet() {
        p.setStreet("hei");
        assertEquals("hei", p.getStreet());
    }

    @Test
    public void testSetCity() {
        p.setCity("tromso");
        assertEquals("tromso", p.getCity());
    }

    @Test
    public void testSetVehicleID() {
        p.setVehicleID("abc");
        assertEquals("abc", p.getVehicleID());
    }

    @Test
    public void testSetCustId() {
        p.setCustId(3);
        assertEquals(3, p.getCustId());
    }

    @Test
    public void testEquals() {
        Person p1 = new Person(2, "name", "email", "street", "city", "2");
        Person p2 = new Person(2, "name", "email", "street", "city", "2");
        Person p3 = new Person(3, "navn", "email", "street", "city", "2");
        Person p4 = new Person(2, "name", "emayl", "street", "city", "2");
        Person p5 = new Person(3, "name", "email", "streit", "city", "2");

        assertFalse(p2.equals(p4));
        assertFalse(p2.equals(p3));
        assertFalse(p2.equals(p5));
        assertTrue(p2.equals(p1));
    }
}