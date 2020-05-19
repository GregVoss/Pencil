package PencilClass;

public class PencilClass {

    private String paperText = "";
    private int durability = 1000;
    private int sharpenValue = 1000;
    private int pencilLength = 10;
    private int eraserDurability = 100;

    public PencilClass() {
    }

    public PencilClass(int pencilDurability) {
        durability = pencilDurability;
        sharpenValue = pencilDurability;
    }

    public PencilClass(int pencilDurability, int eraserDurability) {
        durability = pencilDurability;
        sharpenValue = pencilDurability;
        this.eraserDurability = eraserDurability;
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

    public int getEraserDurability() {
        return eraserDurability;
    }

    public void erase(String textToRemove) {
        int lastIndex = paperText.lastIndexOf(textToRemove);
        if(lastIndex != -1) {
            String prefix = paperText.substring(0, lastIndex);
            String suffix = paperText.substring(lastIndex + textToRemove.length());
            String spaceString="";
            for (int x = 0; x < textToRemove.length(); x++) {
                spaceString+=" ";
            }

            paperText = prefix+spaceString+suffix;
        }
    }
}
