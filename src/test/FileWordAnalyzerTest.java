import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FileWordAnalyzerTest {

    @Test
    public void getWordsOrderedAlphabetically() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("src/main/resources/text.txt",1,1);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        assertEquals(new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g")),fwa.getWordsOrderedAlphabetically());
    }
    @Test
    public void getPalindromeWords() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("src/main/resources/text.txt",2,2);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        assertEquals(new ArrayList<>(Arrays.asList("gorog","pap")),fwa.getStringsWhichPalindromes());
    }
    @Test
    public void getWordsWithSubstring() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("src/main/resources/text.txt",3,3);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        assertEquals(new ArrayList<>(Arrays.asList("efélbabsdnfk","efbabos")),fwa.getWordsContainingSubstring("bab"));
    }
}