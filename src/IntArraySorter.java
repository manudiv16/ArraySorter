import java.util.concurrent.ThreadLocalRandom;

public class IntArraySorter {
    private final int[] array;
    private int numComparisons;
    private int numSwaps;

    public int getNumComparisons() {
        return numComparisons;
    }

    public int getNumSwaps() {
        return numSwaps;
    }

    public int getArrayLength(){
        return array.length;
    }
    public IntArraySorter(int[] array) {
        this.array = array;
    }

    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        numSwaps += 1;
    }

    public boolean lessThanOrEqual(int i1, int i2) {
        numComparisons += 1;
        return i1 <= i2;
    }

    public void bubbleSort() {
        for (int s = 0; s < array.length; s++) {
            int swaps = numSwaps;
            for (int i = array.length - 1; i > s; i--) {
                if (!lessThanOrEqual(array[i - 1], array[i])) {
                    swap(i - 1, i);
                }
            }
            if (numSwaps == swaps) {
                break;
            }
        }
    }

    public void selectionSort() {

        for (int i = 0; i < array.length + 1; i++) {
            int min = i;
            for (int j = 1 + i; j < array.length; j++) { // no tornar a veure els nombres mes petits
                if (lessThanOrEqual(array[j],array[min])){ // cerca numero mes petit
                    min = j;
                }
            }
            if (min != i) { // sha modificat el index del nambre mes petit despres del for ?
                swap(i, min);
            }
        }
    }



    public void insertionSort() {
        for (int s = 1; s < array.length; ++s) {
            int insert = s;
            for (int i = s - 1; i >= 0; i--) {
                if (!lessThanOrEqual(array[i], array[insert])) {
                    swap(i, insert);
                    insert = i;
                } else {
                    break;
                }
            }
        }
    }
    public void quickSort() {
        int right = array.length-1;
        int left = 0;
        quickSort(left,right);

    }
    public void quickSort(int start, int end) {
        if (start < end) {
            int pivot = partition(start, end);
            quickSort(start, pivot);
            quickSort(pivot + 1, end);
        }
    }

    private int partition(int left,int right){
        int pivot = array[left];
        while (true) {
            while (array[left] < pivot) left++;
            while (pivot<array[right]) right--;
            if (left < right) {
                swap(left,right);
            }else {
                return right;
            }
        }
    }


}



