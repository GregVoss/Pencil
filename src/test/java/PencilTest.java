import PencilClass.PencilClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class PencilTest {

    @Test
    public void thePencilClassExists() {
        PencilClass pencil = new PencilClass();

        assertNotNull(pencil);
    }

    @Test
    public void whenTextIsWrittenThePaperContainsTheText() {
        PencilClass pencil = new PencilClass();
        pencil.writeText("This is the Test");

        assertEquals(pencil.paperText, "This is the Test");
    }

    @Test
    public void whenTextIsWrittenItIsAppended() {
        PencilClass pencil = new PencilClass();
        pencil.writeText("This is the Test");
        pencil.writeText(" and this is the next Test");

        assertEquals(pencil.paperText, "This is the Test and this is the next Test");
    }
}

