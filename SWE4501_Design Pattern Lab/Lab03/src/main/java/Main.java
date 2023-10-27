public class Main{
    public static void main(String[] args){
        TextEditorConfig config = TextEditorConfig.getInstance();
        config.setDefaultFont("Times New Roman");
        config.setFontSize(14);

        TextEditor editor = new TextEditor();

        editor.setFileFormatStrategy(new PlainTextFormat());
        editor.saveDocument("This is a plain text document.");

        editor.setFileFormatStrategy(new MarkdownFormat());
        editor.saveDocument("This is a Markdown document.");

        editor.setFileFormatStrategy(new PdfFormat());
        editor.saveDocument("This is a PDF document.");
    }
}
