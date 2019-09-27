public class IntArraySorterCharts {
    private ChartCreator chart;
    private final int xAxisMaxValues = 200;
    private int xAxisValue;
    private int shuffleGrade;
    private int[] array;
    private IntArraySorter sorter;

    private double[][] bubbleSortSwaps = new double[2][xAxisMaxValues];
    private double[][] insertionSortSwaps = new double[2][xAxisMaxValues];
    private double[][] selectionSortSwaps = new double[2][xAxisMaxValues];
    private double[][] quickSortSwaps = new double[2][xAxisMaxValues];

    private double[][] bubbleSortComps = new double[2][xAxisMaxValues];
    private double[][] insertionSortComps = new double[2][xAxisMaxValues];
    private double[][] selectionSortComps = new double[2][xAxisMaxValues];
    private double[][] quickSortComps = new double[2][xAxisMaxValues];

    private void shuffleGradeChart() {
        array = ArrayBuilder.buildArray(xAxisMaxValues);
        for (shuffleGrade = 0; shuffleGrade < array.length; ++shuffleGrade) {
            xAxisValue = shuffleGrade;
            testBubbleSortAndStore(shuffleGrade, array.length, xAxisValue);
            testInsertionSortAndStore(shuffleGrade, array.length, xAxisValue);
            testSelectionSortAndStore(shuffleGrade, array.length, xAxisValue);
            testQuickSortAndStore(shuffleGrade, array.length, xAxisValue);
        }
        buildLinealCharts("Shuffle Grade");
    }

    private void lengthGradeChart(){
        for (int arrayLength = 0; arrayLength < xAxisMaxValues; ++arrayLength) {
            xAxisValue = arrayLength;
            shuffleGrade = arrayLength;
            testBubbleSortAndStore(shuffleGrade, arrayLength, xAxisValue);
            testInsertionSortAndStore(shuffleGrade, arrayLength, xAxisValue);
            testSelectionSortAndStore(shuffleGrade, arrayLength, xAxisValue);
            testQuickSortAndStore(shuffleGrade, arrayLength, xAxisValue);
        }
        buildLinealCharts("Array length");
    }

    private void testBubbleSortAndStore(int shuffleGrade, int arrayLength, int XAxisData){
        buildSorterAndShuffle(shuffleGrade, arrayLength);
        sorter.bubbleSort();
        addValues(bubbleSortSwaps, XAxisData, sorter.getNumSwaps());
        addValues(bubbleSortComps, XAxisData, sorter.getNumComparisons());
    }

    private void testInsertionSortAndStore(int shuffleGrade, int arrayLength, int XAxisData){
        buildSorterAndShuffle(shuffleGrade, arrayLength);
        sorter.insertionSort();
        addValues(insertionSortSwaps, XAxisData, sorter.getNumSwaps());
        addValues(insertionSortComps, XAxisData, sorter.getNumComparisons());
    }
    private void testSelectionSortAndStore(int shuffleGrade, int arrayLength, int XAxisData){
        buildSorterAndShuffle(shuffleGrade, arrayLength);
        sorter.selectionSort();
        addValues(selectionSortSwaps, XAxisData, sorter.getNumSwaps());
        addValues(selectionSortComps, XAxisData, sorter.getNumComparisons());
    }

    private void testQuickSortAndStore(int shuffleGrade, int arrayLength, int XAxisData) {
        buildSorterAndShuffle(shuffleGrade, arrayLength);
        sorter.quickSort();
        addValues(quickSortSwaps, XAxisData, sorter.getNumSwaps());
        addValues(quickSortComps, XAxisData, sorter.getNumComparisons());
    }

    private void buildLinealCharts(String xAxisName){
        chart = new ChartCreator("Num Swaps by " + xAxisName, "Swaps", xAxisName);
        chart.createChart(bubbleSortSwaps, insertionSortSwaps, selectionSortSwaps, quickSortSwaps);
        chart = new ChartCreator("Num Comparisons by " + xAxisName, "Comparisons", xAxisName);
        chart.createChart(bubbleSortComps, insertionSortComps, selectionSortComps, quickSortComps);
    }

    private void addValues(double[][] array, int x, int y) {
        array[0][x] = x;
        array[1][x] = y;
    }

    private void buildSorterAndShuffle(int shuffleLevel, int arrayLength) {
        buildSorter(arrayLength);
        sorter.fisherYatesShuffle(shuffleLevel);
    }

    private void buildSorter(int arrayLength){
        array = ArrayBuilder.buildArray(arrayLength);
        sorter = new IntArraySorter(array);
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