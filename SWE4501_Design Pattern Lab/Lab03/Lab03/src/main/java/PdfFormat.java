// PdfFormat.java
public class PdfFormat implements FileFormatStrategy{
    @Override
    public void save(String content) {
        System.out.println("Saving document in PDF format:\n" + content);
    }
}
