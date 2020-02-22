import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class WordsFrequency {
    public static Map<String, Integer> buildWordMap(String fileName) {
        Map<String, Integer> wordMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             DataInputStream dis = new DataInputStream(fis);
             BufferedReader br = new BufferedReader(new InputStreamReader(dis))) {

            Pattern pattern = Pattern.compile("\\s+");
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                String[] words = pattern.split(line);
                for (String word : words) {
                    if (wordMap.containsKey(word)) {
                        wordMap.put(word, (wordMap.get(word) + 1));
                    } else {
                        wordMap.put(word, 1);
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return wordMap;
    }

    public static List<Map.Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap) {
        Set<Map.Entry<String, Integer>> entries = wordMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        return list;
    }
}

