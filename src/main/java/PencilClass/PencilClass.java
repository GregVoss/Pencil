package PencilClass;

public class PencilClass {

    private String paperText = "";
    private int durability = 1000;

    public PencilClass() {
    }

    public PencilClass(int pencilDurability) {
        durability = pencilDurability;
    }

    public void writeText(String textToWrite) {
        paperText += textToWrite;
    }

    public String readText() {
        return paperText;
    }

    public int getDurability() {
        return durability;
    }

}
