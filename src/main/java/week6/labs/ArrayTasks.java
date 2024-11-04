package week6.labs;

import java.util.Arrays;

class ArrayTasks {
    public static void main(String[] args) {
        int [] values = {6,5,8,6,11};
        System.out.println("smallest: " + smallest(values));
        System.out.println("Index of smallest: " + indexOfSmallest(values));
        System.out.println();

        int [] values2 = {-1,6,9,8,12};
        System.out.println(indexOfTheSmallestStartingFrom(values2, 1));
        System.out.println(indexOfTheSmallestStartingFrom(values2, 2));
        System.out.println(indexOfTheSmallestStartingFrom(values2, 4));
        System.out.println();

        int [] values3 = {3, 2, 5, 4, 8};
        System.out.println(Arrays.toString(values3));
        swap(values3, 1, 0);
        System.out.println(Arrays.toString(values3));
        swap(values3, 0, 3);
        System.out.println(Arrays.toString(values3));
        System.out.println();

        int[] values4 = {5,1,3,4,2};
        printElegantly(values4);
        System.out.println();
    }

    public static int smallest(int[] array) {
        int smallest = array[0];
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    public static int indexOfSmallest(int[] array) {
        int smallest = array[0];
        int index = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int smallest = array[index];
        int smallestIndex = index;
        for (int i = index; i < array.length-1; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printElegantly(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length-1]);
    }
}

