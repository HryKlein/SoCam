package UnitTests;

import no.ntnu.fp.model.Software;
import org.junit.Test;

import static org.junit.Assert.*;

public class SoftwareTest {

    private Software sw;

    public SoftwareTest() {
        sw = new Software(1, 1, "software.com");
    }

    @Test
    public void testAddPropertyChangeListener() {
    }

    @Test
    public void testRemovePropertyChangeListener() {
    }

    @Test
    public void testGetSwVersion() {
        assertEquals(1, sw.getSwVersion());
    }

    @Test
    public void testSetSwVersion() {
        sw.setSwVersion(2);
        assertEquals(2, sw.getSwVersion());
    }

    @Test
    public void testGetMinorVersion() {
        assertEquals(1, sw.getMinorVersion());
    }

    @Test
    public void testSetMinorVersion() {
        sw.setMinorVersion(2);
        assertEquals(2, sw.getMinorVersion());
    }

    @Test
    public void testGetUrl() {
        assertEquals("software.com", sw.getUrl());
    }

    @Test
    public void testSetUrl() {
        sw.setUrl("vg.no");
        assertEquals("vg.no", sw.getUrl());
    }
}