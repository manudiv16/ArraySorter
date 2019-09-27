
public class IntArraySorterCharts {
    private int[] array = ArrayInit.initArray(1500);
    private ChartCreator chart;
    private IntArraySorter sorter;
    private double[][] bubbleSortData = new double[2][array.length];
    private double[][] insertionSortData = new double[2][array.length];
    private double[][] selectionSortData = new double[2][array.length];
    private double[][] quickSortData = new double[2][array.length];

    private void numSwapsChart(){
        chart = new ChartCreator("Swaps chart", "Swaps");
        for(int i = 0; i < array.length;++i) {
            shuffle(i);
            sorter.bubbleSort();
            addValues(bubbleSortData, i, sorter.getNumSwaps());
            shuffle(i);
            sorter.insertionSort();
            addValues(insertionSortData, i, sorter.getNumSwaps());
            shuffle(i);
            sorter.quickSort();
            addValues(quickSortData, i, sorter.getNumSwaps());
            shuffle(i);
            sorter.selectionSort();
            addValues(selectionSortData, i, sorter.getNumSwaps());
        }
        chart.createChart(bubbleSortData, insertionSortData, selectionSortData, quickSortData);
    }

    private  void numComparisonsChart() {
        chart = new ChartCreator("Comparisons chart", "Comparisons");
        for (int i = 0; i < array.length; ++i) {
            shuffle(i);
            sorter.bubbleSort();
            addValues(bubbleSortData, i, sorter.getNumComparisons());
            shuffle(i);
            sorter.insertionSort();
            addValues(insertionSortData, i, sorter.getNumComparisons());
            shuffle(i);
            sorter.quickSort();
            addValues(quickSortData, i, sorter.getNumComparisons());
            shuffle(i);
            sorter.selectionSort();
            addValues(selectionSortData, i, sorter.getNumComparisons());
        }
        chart.createChart(bubbleSortData, insertionSortData, selectionSortData, quickSortData);
    }

    private void addValues(double[][] array, int pos, int data){
        array[0][pos] = pos;
        array[1][pos] = data;
    }

    private void shuffle(int shuffleLevel){
        sorter = new IntArraySorter(array);
        sorter.fisherYatesShuffle(shuffleLevel);
    }

    public static void main(String[] args) {
        IntArraySorterCharts test = new IntArraySorterCharts();
        test.run();
    }

    public void run(){
        numSwapsChart();
        numComparisonsChart();
    }
}
