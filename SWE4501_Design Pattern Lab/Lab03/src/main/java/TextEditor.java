public class TextEditor{
    private FileFormatStrategy fileFormatStrategy;

    public void setFileFormatStrategy(FileFormatStrategy strategy){
        this.fileFormatStrategy = strategy;
    }

    public void saveDocument(String content){
        if (fileFormatStrategy != null){
            fileFormatStrategy.save(content);
        }
        else{
            System.out.println("Error: Please set a file format strategy before saving.");
        }
    }
}
