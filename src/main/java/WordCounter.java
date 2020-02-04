import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class WordCounter {

    File file = new File(Objects.requireNonNull(WordCounter.class.getClassLoader().getResource("lyrics.txt")).getFile());
    private String input;
    private Set<String> shortWords = new LinkedHashSet<>();

    {
        try {
            input = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countWords() {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.split("\\s+");
        return words.length;
    }

    public void countShortWords() {
        int smallWord = 0;
        List<String> words = Arrays.asList(input.split("\\s+"));
        for (String word : words) {
            if (word.length() < 3) {
                smallWord++;
                shortWords.add(word);
            }
        }
        System.out.printf("Total short words number: %d%n", smallWord);
        System.out.printf("Short words list: \n%s%n", shortWords);
    }
}
