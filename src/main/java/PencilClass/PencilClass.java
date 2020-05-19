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
        String spacelessText = textToWrite.replaceAll("\\s", "");

        if(durability > 0) {
            paperText += textToWrite;
            durability = durability - spacelessText.length();
        }
    }

    public String readText() {
        return paperText;
    }

    public int getDurability() {
        return durability;
    }

}
