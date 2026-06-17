package Show;

public class GeneUtility {
    // a generic method to print arrays

    public static <T> void PrintArr(T[] arr) {
        for (T element : arr) {
            System.out.println(element + " ");
        }
        System.out.println();
    }
}
