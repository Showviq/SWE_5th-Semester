// MarkdownFormat.java
public class MarkdownFormat implements FileFormatStrategy{
    @Override
    public void save(String content) {
        System.out.println("Saving document in Markdown format:\n" + content);
    }
}
