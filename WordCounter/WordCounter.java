import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Word Counter Application");
        System.out.println("Enter '1' to input text manually, or '2' to provide a file:");
        int choice = scanner.nextInt();

        if (choice == 1) {
            scanner.nextLine(); 
            System.out.println("Enter your text:");
            text = scanner.nextLine();
        } else if (choice == 2) {
            scanner.nextLine(); 
            System.out.println("Enter the path to the file:");
            String filePath = scanner.nextLine();
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please check the file path and try again.");
                scanner.close();
                return;
            }
        } else {
            System.out.println("Invalid choice. Please enter '1' or '2'.");
            scanner.close();
            return;
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        System.out.println("Total number of words: " + wordCount);


        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "and", "is", "in", "it", "of", "a", "an")); 
        int uniqueWordCount = 0;
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                if (wordFrequencyMap.get(word) == 1) {
                    uniqueWordCount++;
                }
            }
        }

        System.out.println("Number of unique words: " + uniqueWordCount);
        System.out.println("Word Frequency Statistics:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

   
    private static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        Scanner fileScanner = new Scanner(new File(filePath));
        while (fileScanner.hasNextLine()) {
            text.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return text.toString();
    }
}