import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class quick_sort_test {

    @Test
    void array_ordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(50));
        sorter.quickSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    void array_ordenado_al_reves() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initReversedArray(50));
        sorter.quickSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    void array_poco_desordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(50));
        sorter.fisherYatesShuffle(2);
        sorter.quickSort();
        assertTrue(sorter.isSorted());
    }

    @Test
    void muy_desordenado() {
        IntArraySorter sorter = new IntArraySorter(arrayInit.initArray(50));
        sorter.fisherYatesShuffle(4);
        sorter.quickSort();
        assertTrue(sorter.isSorted());
    }

}