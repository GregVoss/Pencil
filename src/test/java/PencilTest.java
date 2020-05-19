import PencilClass.PencilClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class PencilTest {

    @Test
    public void ThePencilClassExists() {
        PencilClass pencil = new PencilClass();
        assertNotNull(pencil);
    }

    @Test
    public void WhenTextIsWrittenThePaperContainsTheText() {
        PencilClass pencil = new PencilClass();
        pencil.writeText("This is the Test");
        assertEquals(pencil.paperText, "This is the Test");
    }
}

