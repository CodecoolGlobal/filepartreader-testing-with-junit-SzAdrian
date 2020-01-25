import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader(){
        filePath = "";
        fromLine = 0;
        toLine = 0;
    }


    public void setup(String filePath,Integer fromLine,Integer toLine){
        if(toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("pls dont do dis");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public List<String> read(String filePath)
    {
        List<String> records = new ArrayList<String>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null)
            {
                records.add(line);
            }
            reader.close();
            return records;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }
    }

    public String readLines(){
        List<String> allText = read(filePath);
        return String.join("\n",allText.subList(fromLine-1,toLine));
    }
}
