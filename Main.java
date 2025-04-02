import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Employee[] a = {

                new Employee("Alice", 30),
                new Employee("Bob", 25),
                new Employee("Charlie", 35),
                new Employee("Dave", 28)
        };

//        Double[] a = {10.2, 7.1, 6.2, 9.2, 3.2, 2.2};

        mergeSort(a, 0, a.length - 1);

        System.out.println("Sorted Employee Ages:");

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array, int l, int r) {

        if (r <= l)

            return;

        int m = l + (r - l) / 2;

        mergeSort(array, l, m);

        mergeSort(array, m + 1, r);

        mergeArrays(array, l, m, r);

    }

    private static <T extends Comparable<T>> void mergeArrays(T[] array, int l, int m, int r) {

        int n1 = m - l + 1;

        int n2 = r - m;
        T[] left = Arrays.copyOfRange(array, l, m+1);
        T[] right = Arrays.copyOfRange(array, m + 1, r + 1);

//        T[] left = (T[]) Array.newInstance(array.getClass().getComponentType(), n1);
//
//        T[] right = (T[]) Array.newInstance(array.getClass().getComponentType(), n2);

        for (int i = 0; i < n1; i++) {

            left[i] = array[l + i];

        }

        for (int j = 0; j < n2; j++) {
            right[j] = array[m + j + 1];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i].compareTo(right[j]) < 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < n1) {
            array[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            array[k] = right[j];
            k++;
            j++;
        }
    }
}


//
//public class Main {
//    public static void main(String[] args) {
//        Integer[] a = {10, 7, 6, 9, 3, 2};
//        int low = 0;
//        int high = a.length - 1;
//        GenericSort.mergeSort(a, low, high, Integer::compareTo);
//
//        System.out.println(Arrays.toString(a));
//    }
//}


//    public static void main(String[] args) {
//
//        Integer[] a = {10, 7, 6, 9, 3, 2};
//        int low = 0;
//        int high = a.length - 1;
//
//        GenericSort1.mergeSort(a, low, high, Integer::compareTo);
//    }
//
//
//}

//        Integer[] arr = {4, 2, 7, 1, 9, 3};
//        GenericSort1.mergeSort(arr, 0, arr.length - 1, Integer::compareTo);
