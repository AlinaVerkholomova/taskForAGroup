import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountWords {

    /** without stream solution */
    public static void firstSolution(String fileName){
        File file = new File(fileName);
        TreeMap<String, Integer> countWords = new TreeMap<>();

        try {
            Scanner sc = new Scanner(file);
            do {
                String[] str = sc.nextLine().split("[.,;:()?! ]+");
                for (String word : str) {
                    word = word.toLowerCase();
                    if (!countWords.containsKey(word)){
                        countWords.put(word, 1);
                    }
                    else
                        countWords.put(word,countWords.get(word) + 1);

                }
            }
            while (sc.hasNextLine());
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.printf("File %s doesn't exist\n", file.getName());
        } catch (NoSuchElementException e) {
            System.out.println("No such element exception\n");
        }

        List<Map.Entry<String, Integer>> toSort = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : countWords.entrySet()) {
            toSort.add(stringIntegerEntry);
        }
        toSort.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (Map.Entry<String, Integer> stringIntegerEntry : toSort) {
            System.out.println(stringIntegerEntry);
        }
    }

    /** with stream solution */
    public static void secondSolution(String fileName){
        File file = new File(fileName);
        TreeMap<String, Integer> countWords = new TreeMap<>();

        try {
            Scanner sc = new Scanner(file);
            do {
                String[] str = sc.nextLine().split("[.,;:()?! ]+");
                for (String word : str) {
                    word = word.toLowerCase();
                    if (!countWords.containsKey(word)){
                        countWords.put(word, 1);
                    }
                    else
                        countWords.put(word,countWords.get(word) + 1);

                }
            }
            while (sc.hasNextLine());
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.printf("File %s doesn't exist\n", file.getName());
        } catch (NoSuchElementException e) {
            System.out.println("No such element exception\n");
        }

        countWords.entrySet().stream().sorted(Collections.
                reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter name of the file: ");
        String fileName = scanner.nextLine();

        firstSolution(fileName);
        System.out.println("---------------------------");
        secondSolution(fileName);

    }

}
