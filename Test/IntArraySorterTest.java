import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntArraySorterTest {

    @Test
    void test_insertion_sort(){
        System.out.println("INSERTION SORT TEST: ");

        System.out.println("Array ordenado: ");
        IntArraySorter sorter = new IntArraySorter(initArray(50, false));
        sorter.insertionSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array ordenado al revés: ");
        sorter = new IntArraySorter(initArray(50, true));
        sorter.insertionSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array poco desordenado: ");
        sorter = new IntArraySorter(initArray(50, false));
        sorter.fisherYatesShuffle(sorter.getArrayLength()/3);
        sorter.insertionSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array muy desordenado: ");
        sorter = new IntArraySorter(initArray(50, false));
        sorter.fisherYatesShuffle(sorter.getArrayLength());
        sorter.insertionSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());
    }
    @Test
    void test_bubble_sort() {
        System.out.println("BUBBLE SORT TEST: ");

        System.out.println("Array ordenado: ");
        IntArraySorter sorter = new IntArraySorter(initArray(50, false));
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array ordenado al revés: ");
        sorter = new IntArraySorter(initArray(50, true));
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array poco desordenado: ");
        sorter = new IntArraySorter(initArray(50, false));
        sorter.fisherYatesShuffle(sorter.getArrayLength()/3);
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array muy desordenado: ");
        sorter = new IntArraySorter(initArray(50, false));
        sorter.fisherYatesShuffle(sorter.getArrayLength());
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());
    }

    @Test
    void test_selection_sort() {
        System.out.println("SELECTION SORT TEST: ");

        System.out.println("Array ordenado: ");
        IntArraySorter sorter = new IntArraySorter(initArray(50, false));
        sorter.selectionSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array ordenado al revés: ");
        sorter = new IntArraySorter(initArray(50, true));
        sorter.selectionSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array poco desordenado: ");
        sorter = new IntArraySorter(initArray(50, false));
        sorter.fisherYatesShuffle(sorter.getArrayLength()/3);
        sorter.selectionSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());


        System.out.println("Array muy desordenado: ");
        sorter = new IntArraySorter(initArray(50, false));
        sorter.fisherYatesShuffle(sorter.getArrayLength());
        sorter.selectionSort();
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());
    }

    @Test
    void test_quick_sort() {
        System.out.println("QUICK SORT TEST: ");

        System.out.println("Array ordenado: ");
        IntArraySorter sorter = new IntArraySorter(initArray(50, false));
        sorter.quickSort(0, sorter.getArrayLength());
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array ordenado al revés: ");
        sorter = new IntArraySorter(initArray(50, true));
        sorter.quickSort(0, sorter.getArrayLength());
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array poco desordenado: ");
        sorter = new IntArraySorter(initArray(50, false));
        sorter.fisherYatesShuffle(sorter.getArrayLength()/3);
        sorter.quickSort(0, sorter.getArrayLength());
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());

        System.out.println("Array muy desordenado: ");
        sorter = new IntArraySorter(initArray(50, false));
        sorter.fisherYatesShuffle(sorter.getArrayLength());
        sorter.quickSort(0, sorter.getArrayLength());
        assertTrue(sorter.isSorted());
        printResults(sorter.getNumComparisons(), sorter.getNumSwaps());
    }

    int[] initArray(int length, boolean reverse) {
        int[] array = new int[length];
        if(reverse){
            for (int i = array.length - 1; i >= 0; --i) {
                array[array.length - 1 - i] = i;
            }
        }else{
            for (int j = 0; j < array.length; ++j) {
                array[j] = j;
            }
        }
        return array;
    }

    void printResults(int numComparisons, int numSwaps){
        String output = String.format("%d comparaciones, %d swaps", numComparisons, numSwaps);
        System.out.println(output);
    }
}