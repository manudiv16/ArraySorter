
public class IntArraySorterCharts {
    private final int numValues = 200;
    private int[] array = ArrayBuilder.buildArray(numValues);
    private ChartCreator chart;
    private IntArraySorter sorter;
    private double[][] bubbleSortSwaps = new double[2][numValues];
    private double[][] insertionSortSwaps = new double[2][numValues];
    private double[][] selectionSortSwaps = new double[2][numValues];
    private double[][] quickSortSwaps = new double[2][numValues];
    private double[][] bubbleSortComps = new double[2][numValues];
    private double[][] insertionSortComps = new double[2][numValues];
    private double[][] selectionSortComps = new double[2][numValues];
    private double[][] quickSortComps = new double[2][numValues];

    private void shuffleGradeChart() {
        for (int shuffleGrade = 0; shuffleGrade < array.length; ++shuffleGrade) {
            shuffle(shuffleGrade, numValues);
            sorter.bubbleSort();
            addValues(bubbleSortSwaps, shuffleGrade, shuffleGrade, sorter.getNumSwaps());
            addValues(bubbleSortComps, shuffleGrade, shuffleGrade, sorter.getNumComparisons());
            shuffle(shuffleGrade, numValues);
            sorter.insertionSort();
            addValues(insertionSortSwaps, shuffleGrade, shuffleGrade, sorter.getNumSwaps());
            addValues(insertionSortComps, shuffleGrade, shuffleGrade, sorter.getNumComparisons());
            shuffle(shuffleGrade, numValues);
            sorter.quickSort();
            addValues(quickSortSwaps, shuffleGrade, shuffleGrade, sorter.getNumSwaps());
            addValues(quickSortComps, shuffleGrade, shuffleGrade, sorter.getNumComparisons());
            shuffle(shuffleGrade, numValues);
            sorter.selectionSort();
            addValues(selectionSortSwaps, shuffleGrade, shuffleGrade, sorter.getNumSwaps());
            addValues(selectionSortComps, shuffleGrade, shuffleGrade, sorter.getNumComparisons());
        }
        chart = new ChartCreator("Num Swaps by shuffle grade.  Array length = " + numValues, "Swaps", "Shuffle grade");
        chart.createChart(bubbleSortSwaps, insertionSortSwaps, selectionSortSwaps, quickSortSwaps);
        chart = new ChartCreator("Num Comparisons by shuffle grade. Array length = " + numValues, "Comparisons", "Shuffle grade");
        chart.createChart(bubbleSortComps, insertionSortComps, selectionSortComps, quickSortComps);
    }

    private void lengthGradeChart(){
        for (int length = 0; length < numValues; ++length) {
            shuffle(length, length);
            sorter.bubbleSort();
            addValues(bubbleSortSwaps, length, length, sorter.getNumSwaps());
            addValues(bubbleSortComps, length, length, sorter.getNumComparisons());
            shuffle(length, length);
            sorter.insertionSort();
            addValues(insertionSortSwaps, length, length, sorter.getNumSwaps());
            addValues(insertionSortComps, length, length, sorter.getNumComparisons());
            shuffle(length, length);
            sorter.quickSort();
            addValues(quickSortSwaps, length, length, sorter.getNumSwaps());
            addValues(quickSortComps, length, length, sorter.getNumComparisons());
            shuffle(length, length);
            sorter.selectionSort();
            addValues(selectionSortSwaps, length, length, sorter.getNumSwaps());
            addValues(selectionSortComps, length, length, sorter.getNumComparisons());
        }
        chart = new ChartCreator("Num Swaps by array length", "Swaps", "Array length");
        chart.createChart(bubbleSortSwaps, insertionSortSwaps, selectionSortSwaps, quickSortSwaps);
        chart = new ChartCreator("Num Comparisons by array length", "Comparisons", "Array length");
        chart.createChart(bubbleSortComps, insertionSortComps, selectionSortComps, quickSortComps);
    }

    private void addValues(double[][] array, int pos, int x, int y) {
        array[0][pos] = x;
        array[1][pos] = y;
    }

    private void shuffle(int shuffleLevel, int arrayLength) {
        array = ArrayBuilder.buildArray(arrayLength);
        sorter = new IntArraySorter(array);
        sorter.fisherYatesShuffle(shuffleLevel);
    }

    public static void main(String[] args) {
        IntArraySorterCharts test = new IntArraySorterCharts();
        test.run();
    }

    public void run() {
        shuffleGradeChart();
        lengthGradeChart();
    }
}
