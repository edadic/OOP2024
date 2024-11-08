package week6.labs;

import java.util.ArrayList;
import java.util.List;

public class GenericsTasks {
    public static <T extends Number> void sumEvenAndOdd(List<T> numbers) {
        if(numbers.get(0) instanceof Integer) {
            int sumEven = 0;
            int sumOdd = 0;
            for (T number : numbers) {
                if (number.intValue() % 2 == 0) {
                    sumEven += number.intValue();
                }
                else {
                    sumOdd += number.intValue();
                }
            }
            System.out.println("Sum of even numbers: " + sumEven);
            System.out.println("Sum of odd numbers: " + sumOdd);
        }
        else {
            double sumEven = 0;
            double sumOdd = 0;
            for (T number : numbers) {
                if (number.intValue() % 2 == 0) {
                    sumEven += number.doubleValue();
                }
                else {
                    sumOdd += number.doubleValue();
                }
            }
            System.out.println("Sum of even numbers: " + sumEven);
            System.out.println("Sum of odd numbers: " + sumOdd);
        }

    }

    public static <T> List<T> reverseList(List<T> list){
        List<T> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    public static void main(String[] args) {
       /* List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Double> numbers2 = List.of(1.1, 2.2, 3.3, 4.4, 5.5, 6.6);

        System.out.println("Integer list");
        sumEvenAndOdd(numbers);
        System.out.println();
        System.out.println("Double list");
        sumEvenAndOdd(numbers2);*/

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        List<String> stringList = List.of("a", "b", "c", "d", "e", "f");
        System.out.println("Integer list: " + integerList);
        System.out.println("Reversed integer list: " + reverseList(integerList));
        System.out.println("String list: " + stringList);
        System.out.println("Reversed string list: " + reverseList(stringList));

    }
}
