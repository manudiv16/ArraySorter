import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class quick_sort_test {

    @Test
    void array_ordenado() {
        IntArraySorter sorter = new IntArraySorter(ArrayInit.initArray(50));
        sorter.quickSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    void array_ordenado_al_reves() {
        IntArraySorter sorter = new IntArraySorter(ArrayInit.initReversedArray(50));
        sorter.quickSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    void array_poco_desordenado() {
        IntArraySorter sorter = new IntArraySorter(ArrayInit.initArray(50));
        sorter.fisherYatesShuffle(20);
        sorter.quickSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    void array_muy_desordenado() {
        IntArraySorter sorter = new IntArraySorter(ArrayInit.initArray(50));
        sorter.fisherYatesShuffle(50);
        sorter.quickSort();
        assertTrue(sorter.isSorted());
    }

}