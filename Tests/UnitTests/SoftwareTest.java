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
    public void testRemovePropertyChangeListener() {
        sw.removePropertyChangeListener(null);

        assertTrue(true);
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

    @Test
    public void testEmptyConstructor(){
        Software s = new Software();

        assertEquals(0, s.getSwVersion());
        assertEquals(0, s.getMinorVersion());
        assertEquals("", s.getUrl());
    }
}