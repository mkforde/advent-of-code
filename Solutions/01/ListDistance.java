import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileNotFoundException;

public class ListDistance {

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("./input.txt");
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    int totalDistance = 0;


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

      // sort the lists in ascending order
      Collections.sort(list1);
      Collections.sort(list2);



      // get the distance between the lists
      for (int i = 0; i < list1.size(); i++) {
        int distance = Math.abs(list1.get(i) - list2.get(i));
        totalDistance += distance;
      }

      System.out.println("The total distance is: " + totalDistance);
    }
    
  }

}
