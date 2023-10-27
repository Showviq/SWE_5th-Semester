// PlainTextFormat.java
public class PlainTextFormat implements FileFormatStrategy{
    @Override
    public void save(String content) {
        System.out.println("Saving document in plain text format:\n" + content);
    }
}
