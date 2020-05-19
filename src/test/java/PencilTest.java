import PencilClass.PencilClass;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class PencilTest {

    PencilClass pencil;

    @Before
    public void setupTests() {
        pencil = new PencilClass();
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
    public void penHasDurability() {
        assertEquals(pencil.getDurability(), 1000);
    }

    @Test
    public void penHasDeclaredDurability() {
        PencilClass pencilDurability = new PencilClass(5000);
        assertEquals(pencilDurability.getDurability(), 5000);
    }
}

