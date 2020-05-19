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

        assertEquals(pencil.readText(), "This is the Test");
    }

    @Test
    public void whenTextIsWrittenItIsAppended() {
        pencil.writeText("This is the Test");
        pencil.writeText(" and this is the next Test");

        assertEquals(pencil.readText(), "This is the Test and this is the next Test");
    }

    @Test
    public void pencilHasDurability() {
        assertEquals(pencil.getDurability(), 1000);
    }

    @Test
    public void pencilHasDeclaredDurability() {
        PencilClass pencilDurability = new PencilClass(5000);
        assertEquals(pencilDurability.getDurability(), 5000);
    }

    @Test
    public void pencilLosesDurabilityWhenWriting() {
        pencil.writeText("Length7");
        assertEquals(pencil.getDurability(), 993);
    }

    @Test
    public void whenPencilIsEmptyItCannotWrite() {
        PencilClass blankPencil = new PencilClass(0);
        blankPencil.writeText("Length7");
        assertEquals(blankPencil.readText(), "");
    }
}

