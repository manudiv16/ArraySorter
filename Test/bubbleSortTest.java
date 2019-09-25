import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bubbleSortTest {
    @Test
    void array_ordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(50));
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    public void array_del_reves() {
        IntArraySorter sorter;
        sorter = new IntArraySorter(arrayInit.initReversedArray(50));
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    public void array_poco_desordenado() {
        IntArraySorter sorter;
        sorter = new IntArraySorter(arrayInit.initArray(50));
        sorter.fisherYatesShuffle(2);
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    public void array_muy_desordenado() {
        IntArraySorter sorter;
        sorter = new IntArraySorter(arrayInit.initArray(50));
        sorter.fisherYatesShuffle(4);
        sorter.bubbleSort();
        assertTrue(sorter.isSorted());
    }
}