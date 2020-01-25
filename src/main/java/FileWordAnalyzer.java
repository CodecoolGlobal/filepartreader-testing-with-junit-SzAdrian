import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;
    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically (){
        return Arrays.stream(filePartReader.readLines().split(" ")).sorted().collect(Collectors.toList());
    }

    public List getWordsContainingSubstring (String subString ){
        return Arrays.stream(filePartReader.readLines().split(" "))
                .filter(i -> i.contains(subString))
                .collect(Collectors.toList());
    }


    public List getStringsWhichPalindromes (){
        return Arrays.stream(filePartReader.readLines().split(" "))
                .filter(i -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    return i.contentEquals(stringBuilder.reverse());
                })
                .collect(Collectors.toList());
    }
}
