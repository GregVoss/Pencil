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
        pencil.writeText("length7");
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
        pencil.writeText("there are 7 spaces and length of 35");
        assertEquals(972, pencil.getDurability());
    }

    @Test
    public void onlyWriteUntilEmpty() {
        PencilClass shortPencil = new PencilClass(5);
        shortPencil.writeText("a longer sentence");
        assertEquals("a long", shortPencil.readText());
    }

    @Test
    public void whenTextIsWrittenUpperCaseisDoubled() {
        pencil.writeText("Caps");
        assertEquals(995, pencil.getDurability());
    }

    @Test
    public void whenOnlyOneSpaceLeftTheLastLetterCannotBeCaps() {
        PencilClass shortPencil = new PencilClass(5);
        shortPencil.writeText("carpS");
        assertEquals("carp", shortPencil.readText());
    }

    @Test
    public void pencilHasSharpenedValueEqualToOriginalLength() {
        pencil.writeText("This will remove characters");
        pencil.sharpen();

        assertEquals(1000, pencil.getDurability());
    }

    @Test
    public void pencilHasDefaultLength() {
        assertEquals(10, pencil.getLength());
    }

    @Test
    public void whenPencilIsSharpenedTheLengthIsReducedByOne() {
        pencil.sharpen();

        assertEquals(9, pencil.getLength());
    }

    @Test
    public void whenPencilHasZeroLengthItCannotSharpen() {
        for(int count = 0; count < 12; count++) {
            pencil.writeText("test");
            pencil.sharpen();
        }

        assertEquals(992, pencil.getDurability());
    }
}

