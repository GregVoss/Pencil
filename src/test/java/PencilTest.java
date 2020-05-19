import PencilClass.PencilClass;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class PencilTest {

    PencilClass pencil;

    @Before
    public void setupTests() {
        pencil = new PencilClass(1000);
    }

    @Test
    public void thePencilClassExists() {
        assertNotNull(pencil);
    }

    @Test
    public void whenTextIsWrittenThePaperContainsTheText() {
        pencil.writeText("This is the Test");

        assertEquals("This is the Test", pencil.readText());
    }

    @Test
    public void whenTextIsWrittenItIsAppended() {
        pencil.writeText("This is the Test");
        pencil.writeText(" and this is the next Test");

        assertEquals("This is the Test and this is the next Test", pencil.readText());
    }

    @Test
    public void pencilHasDurability() {
        assertEquals(1000, pencil.getDurability());
    }

    @Test
    public void pencilHasDeclaredDurability() {
        PencilClass pencilDurability = new PencilClass(5000);
        assertEquals(5000, pencilDurability.getDurability());
    }

    @Test
    public void pencilLosesDurabilityWhenWriting() {
        pencil.writeText("Length7");
        assertEquals(993, pencil.getDurability());
    }

    @Test
    public void whenPencilIsEmptyItCannotWrite() {
        PencilClass blankPencil = new PencilClass(0);
        blankPencil.writeText("Length7");
        assertEquals("", blankPencil.readText());
    }

    @Test
    public void whenTextIsWrittenSpacesAreNotCounted() {
        pencil.writeText("The are 7 spaces and length of 33");
        assertEquals(974, pencil.getDurability());
    }
}

