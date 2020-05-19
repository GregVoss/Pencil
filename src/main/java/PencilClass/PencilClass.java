package PencilClass;

public class PencilClass {

    private String paperText = "";
    private int durability = 1000;

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
