import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Executor {
    public static void start() {
        WordCounter wordCounter = new WordCounter();
        System.out.println("Total number of words in the file: " + wordCounter.countWords());
        wordCounter.countShortWords();

        Map<String, Integer> wordMap = WordsFrequency.buildWordMap(Objects.requireNonNull
                (Executor.class.getClassLoader().getResource("lyrics.txt")).getFile());
        List<Map.Entry<String, Integer>> list = WordsFrequency.sortByValueInDecreasingOrder(wordMap);
        System.out.println("List of repeated word from file and their count: ");
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }
    }
}
