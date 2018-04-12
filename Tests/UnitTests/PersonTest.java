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
        //Hvordan teste denne? Går jo på current time..

        //Holder dette? Evt. finnes det f.eks. noen måte å teste at den er unik på?
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
}