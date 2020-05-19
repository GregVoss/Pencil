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
        for(int charPlace = 0; charPlace < textToWrite.length() && durability > 0; charPlace++) {
            char currentChar = textToWrite.charAt(charPlace);

            paperText += currentChar;

            if(!Character.isWhitespace(currentChar)) {
                durability--;
            }
        }
    }

    public String readText() {
        return paperText;
    }

    public int getDurability() {
        return durability;
    }

}
