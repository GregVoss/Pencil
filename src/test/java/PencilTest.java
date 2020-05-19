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
    public void pencilHasDefaultDurability() {
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

    @Test
    public void pencilErasesLastText() {
        pencil.writeText("Remove the last reference to text Adding an additional last for testing");
        pencil.erase("last");

        assertEquals("Remove the last reference to text Adding an additional      for testing", pencil.readText());
    }

    @Test
    public void eraserHasDefaultDurability() {
        assertEquals(100, pencil.getEraserDurability());
    }

    @Test
    public void eraserHasDeclaredDurability() {
        PencilClass pencilDurability = new PencilClass(5000, 200);
        assertEquals(200, pencilDurability.getEraserDurability());
    }

    @Test
    public void eraserLosesDurability() {
        pencil.writeText("Remove the last reference to text Adding an additional last for testing");
        pencil.erase("last");

        assertEquals(96, pencil.getEraserDurability());
    }

    @Test
    public void eraserDurabilityIsUnaffectedBySpaces() {
        pencil.writeText("Remove the last reference to text Adding an additional last for testing");
        pencil.erase("last for");

        assertEquals(93, pencil.getEraserDurability());
    }

    @Test
    public void eraserDoesNotEraseWhenDurabilityIsZero() {
        PencilClass emptyEraser = new PencilClass(1000, 0);
        emptyEraser.writeText("Text to write");
        emptyEraser.erase("t");

        assertEquals("Text to write", emptyEraser.readText());
    }

    @Test
    public void eraserOnlyRemovesLastPartWhenDurabilityIsLow() {
        PencilClass lowEraser = new PencilClass(1000, 10);
        lowEraser.writeText("This will help keep track of erasing Carcharodontosaurus long words");
        lowEraser.erase("Carcharodontosaurus");

        assertEquals("This will help keep track of erasing Carcharod           long words", lowEraser.readText());
    }

    @Test
    public void editingWritesNewTextOverTheFirstMultipleSpacedSection() {
        pencil.writeText("An apple a day keeps the doctor away");
        pencil.erase("apple");
        pencil.edit("onion");

        assertEquals("An onion a day keeps the doctor away", pencil.readText());
    }

    @Test
    public void replacesOverLappingCharactersWithAmpersands() {
        pencil.writeText("An apple a day keeps the doctor away");
        pencil.erase("apple");
        pencil.edit("artichoke");

        assertEquals("An artich@k@ay keeps the doctor away", pencil.readText());
    }

    @Test
    public void editingOnTheEndAppendsValues() {
        pencil.writeText("An apple a day keeps the doctor away");
        pencil.erase("away");
        pencil.edit("at bay");

        assertEquals("An apple a day keeps the doctor at bay", pencil.readText());
    }
}

