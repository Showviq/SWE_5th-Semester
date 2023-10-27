// Singleton: TextEditorConfig.java
public class TextEditorConfig{
    private static TextEditorConfig instance;
    private String defaultFont;
    private int fontSize;

    private TextEditorConfig(){
        // Initialize default configuration
        defaultFont = "Arial";
        fontSize = 12;
    }

    public static TextEditorConfig getInstance(){
        if(instance == null){
            instance = new TextEditorConfig();
        }
        return instance;
    }

    public String getDefaultFont(){
        return defaultFont;
    }

    public void setDefaultFont(String font){
        this.defaultFont = font;
    }

    public int getFontSize(){
        return fontSize;
    }

    public void setFontSize(int fontSize){
        this.fontSize = fontSize;
    }
}