import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bubbleSortTest {
    @Test
    void array_ordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(2000));
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    void array_del_reves() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initReversedArray(2000));
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    void array_poco_desordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(2000));
        sorter.fisherYatesShuffle(2);
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    void array_muy_desordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(2000));
        sorter.fisherYatesShuffle(4);
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
    }
}