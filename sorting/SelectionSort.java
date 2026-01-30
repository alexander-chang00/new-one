package sorting;

public class SelectionSort implements SelectionSort {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!");

        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;
        }
    }
}
