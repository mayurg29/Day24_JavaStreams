// Java Stream Operations

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {
     public static void main(String[] args) {
        // Creating sample collection
        List<Integer> myNumberList = new ArrayList<>();
        for (int i = 0; i < 7; i++) myNumberList.add(i);

        // Lambda Function to print double value
        Function<Integer, Double> toDoubleFunction = n -> n.doubleValue();

        // Lambda Function to check even
        Predicate<Integer> isEvenFunction = n -> n > 0 && n % 2 == 0;

        // Method 1: Processing the Stream
        myNumberList.stream().forEach(n -> {
            System.out.println("Mth1: Stream forEach value::" + n);
        });

        // Method 2: Apply operations on the stream & store the result
        List<Double> streamList = myNumberList.stream().filter(isEvenFunction)
                		  .map(toDoubleFunction).toList();
        System.out.println("Mth2: Printing even double list::" + streamList);

        // Method 3: Listing the first even number
        Integer firstEven = myNumberList.stream().filter(isEvenFunction)
                	    .peek(n -> System.out.println("Peak even number: " + n))
                	    .findFirst().orElse(null);
        System.out.println("Mth3: First even::" + firstEven);

        //  Method 4: Minimum even number
        Integer min = myNumberList.stream().filter(isEvenFunction)
               	      .min((n1, n2) -> n1 - n2).orElse(null);
        System.out.println("Mth4: Min Even::" + min);

        // Method 5: Maximum even number
        Integer max = myNumberList.stream().filter(isEvenFunction)
                      .max(Comparator.comparingInt(n -> n)).orElse(null);
        System.out.println("Mth5: Max Even::" + max);

        // Method 6: Sum, Count & Average of numbers
        Integer sum = myNumberList.stream().reduce(0, Integer::sum);
        long count = myNumberList.stream().count();
        System.out.println("Mth6: Average of "+sum+"/"+count+" = "+sum/count);

        // Method 7: Checking all even, single even or none are divisible by six
        boolean oneEven = myNumberList.stream().anyMatch(isEvenFunction);
        boolean allEven = myNumberList.stream().allMatch(isEvenFunction);
        boolean noneMultOfSix = myNumberList.stream().noneMatch(i -> i > 0 && i % 6 == 0);
        System.out.println("AllEven: " + allEven + "\nOneEven: " + oneEven +
                           "\nNoneMultOfSix: " + noneMultOfSix);
    }
}
