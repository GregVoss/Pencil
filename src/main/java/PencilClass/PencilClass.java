package PencilClass;

public class PencilClass {

    private String paperText = "";
    private int pencilDurability = 1000;
    private int sharpenValue = 1000;
    private int pencilLength = 10;
    private int eraserDurability = 100;

    public PencilClass() {
    }

    public PencilClass(int pencilDurability) {
        this.pencilDurability = pencilDurability;
        sharpenValue = pencilDurability;
    }

    public PencilClass(int pencilDurability, int eraserDurability) {
        this.pencilDurability = pencilDurability;
        sharpenValue = pencilDurability;
        this.eraserDurability = eraserDurability;
    }

    public void writeText(String textToWrite) {
        for(int charPlace = 0; charPlace < textToWrite.length() && pencilDurability > 0; charPlace++) {
            char currentChar = textToWrite.charAt(charPlace);

            if(Character.isUpperCase(currentChar) && pencilDurability < 2) {
                break;
            }

            if(!Character.isWhitespace(currentChar)) {
                pencilDurability = Character.isUpperCase(currentChar)?pencilDurability-2:pencilDurability-1;
            }

            paperText += currentChar;
        }
    }

    public String readText() {
        return paperText;
    }

    public void sharpen() {
        if(pencilLength>0) {
            pencilDurability = sharpenValue;
            pencilLength--;
        }
    }

    public void erase(String textToRemove) {
        if(eraserDurability > 0)
        {
            int lastIndex = paperText.lastIndexOf(textToRemove);
            int amountToRemove = textToRemove.length();

            if(textToRemove.length() > eraserDurability) {
                lastIndex += textToRemove.length() - eraserDurability;
                amountToRemove = eraserDurability;
            }

            if(lastIndex != -1) {
                String prefix = paperText.substring(0, lastIndex);
                String suffix = paperText.substring(lastIndex + amountToRemove);
                String spaceString=getEmptyString(amountToRemove);

                paperText = prefix+spaceString+suffix;
            }

            int cleanedLength = textToRemove.replaceAll("\\s", "").length();
            eraserDurability = cleanedLength>eraserDurability?0:eraserDurability-cleanedLength;
        }
    }

    public void edit(String textToReplace) {
        int lastIndex = paperText.indexOf("  ")+1;
        String prefix = paperText.substring(0, lastIndex);
        String suffix = paperText.substring(lastIndex + textToReplace.length());

        String middleString = generateConflictString(textToReplace, paperText.substring(lastIndex, lastIndex+textToReplace.length()));

        paperText = prefix+middleString+suffix;
    }

    private String generateConflictString(String textToReplace, String oldSubstring) {
        String generatedString = "";

        for(int counter=0; counter<textToReplace.length(); counter++) {
            if(Character.isWhitespace(oldSubstring.charAt(counter))) {
                generatedString += textToReplace.charAt(counter);
            }
            else {
                generatedString += "@";
            }
        }

        return generatedString;
    }


    /**  GET Methods **/

    public int getDurability() {
        return pencilDurability;
    }

    public int getLength() {
        return pencilLength;
    }

    public int getEraserDurability() {
        return eraserDurability;
    }

    public String getEmptyString(int lengthOfString) {
        String spaceString="";
        for (int x = 0; x < lengthOfString; x++) {
            spaceString+=" ";
        }

        return  spaceString;
    }
}
