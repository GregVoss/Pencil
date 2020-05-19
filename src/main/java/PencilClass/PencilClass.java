package PencilClass;

public class PencilClass {

    private String paperText = "";

    public void writeText(String textToWrite) {
        paperText += textToWrite;
    }

    public String readText() {
        return paperText;
    }

}
