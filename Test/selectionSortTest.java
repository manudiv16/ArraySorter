import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class selectionSortTest {
    @Test
    void array_ordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(50));
        sorter.selectionSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    public void array_del_reves() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initReversedArray(50));
        sorter.selectionSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    public void array_poco_desordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(50));
        sorter.fisherYatesShuffle(2);
        sorter.selectionSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    public void array_muy_desordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(50));
        sorter.fisherYatesShuffle(4);
        sorter.selectionSort();
        assertTrue(sorter.isSorted());
    }


}