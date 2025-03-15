import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.FileNotFoundException;

public class ListSimilarity {

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("./input.txt");
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    HashMap<Integer, Integer> freq = new HashMap<>();

    // Create the two lists from input file
    try (Scanner in = new Scanner(file)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        String[] stringNums = line.split("   ");
        int num1 = Integer.parseInt(stringNums[0]);
        int num2 = Integer.parseInt(stringNums[1]);

        list1.add(num1);
        list2.add(num2);
      }

      // get the frequency of each element from list 2
      for (int num : list2) {
        freq.put(num, 1 + freq.getOrDefault(num, 0));
      }
      
      int similarity = 0;

      // get the similarity between list1 and list2
      for (int i = 0; i < list1.size(); i++) {
        int val1 = list1.get(i);
        similarity += val1 * freq.getOrDefault(val1, 0);
      }

      System.out.println("The similarity is: " + similarity);
    }
    
  }

}
