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
                if (array[j] < array[min]) { // cerca numero mes petit
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

    /* --------------------PRIVATE METHODS----------------------- */


    private int partition(int start,int end){
        int pivotIndex = selectPivot(); //Selecciona el pivot amb el metode que sigui.
        int pivot = array[pivotIndex];
        swap(pivotIndex, end - 1); //Envia el pivot al final del segment i treballa desde start fins a end - 2
        while (true) {
            int left = searchLeftItem(start, end); //Busca desde lesquerra un element mes gran que el pivot, retornan el index;
            int right = searchRightItem(start, end); //Busca desde la dreta un element mes petit que el pivot, retorna el index;
            if (left < right) {
                swap(left,right);
            }else {
                swap(left, end - 1); //canvia el pivot per l'element que hi ha a left, que serà més gran que ell.
                return left; //Retorna la posicio en la que es troba ara el pivot;
            }
        }
    }


}



