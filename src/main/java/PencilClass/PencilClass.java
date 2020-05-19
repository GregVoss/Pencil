package PencilClass;

public class PencilClass {

    private String paperText = "";
    private int durability = 1000;
    private int sharpenValue = 1000;
    private int pencilLength = 10;

    public PencilClass() {
    }

    public PencilClass(int pencilDurability) {
        durability = pencilDurability;
        sharpenValue = pencilDurability;
    }

    public void writeText(String textToWrite) {
        for(int charPlace = 0; charPlace < textToWrite.length() && durability > 0; charPlace++) {
            char currentChar = textToWrite.charAt(charPlace);

            if(Character.isUpperCase(currentChar) && durability < 2) {
                break;
            }

            if(!Character.isWhitespace(currentChar)) {
                durability = Character.isUpperCase(currentChar)?durability-2:durability-1;
            }

            paperText += currentChar;
        }
    }

    public String readText() {
        return paperText;
    }

    public int getDurability() {
        return durability;
    }

    public void sharpen() {
        if(pencilLength>0) {
            durability = sharpenValue;
            pencilLength--;
        }
    }

    public int getLength() {
        return pencilLength;
    }

}
