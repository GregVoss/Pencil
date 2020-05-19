import PencilClass.PencilClass;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class PencilTest {

    @Test
    public void ThePencilClassExists() {
        PencilClass pencil = new PencilClass();
        assertNotNull(pencil);
    }

}

