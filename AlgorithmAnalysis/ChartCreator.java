import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ChartCreator {
    private String chartTitle;
    private String Yaxis;
    private String Xaxis;

    public ChartCreator(String chartTitle, String Yaxis, String Xaxis){
        this.chartTitle = chartTitle;
        this.Yaxis = Yaxis;
        this.Xaxis = Xaxis;
    }

    public void createChart(double[][] bubbleSortData, double[][] insertionSortData, double[][] selectionSortData, double[][] qsData) {
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("Bubble sort", bubbleSortData);
        dataset.addSeries("Insertion sort", insertionSortData);
        dataset.addSeries("Selection sort", selectionSortData);
        dataset.addSeries("Quick sort", qsData);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true,  false);
        setRenderSettings(renderer);
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, Xaxis, Yaxis, dataset);
        chart.getXYPlot().setRenderer(renderer);

        BufferedImage image = chart.createBufferedImage(1200, 700);
        createImage(image, chartTitle);
    }

    private void createImage(BufferedImage image, String chartTitle){
        try {
            ImageIO.write(image, "png", new File(chartTitle + ".png"));
        } catch (IOException exc) {
            System.out.println("Error creating image.");
        }
    }

    private void setRenderSettings(XYLineAndShapeRenderer renderer){
        setSeriesPaint(renderer);
        setSeriesStroke(renderer);
    }

    private void setSeriesPaint(XYLineAndShapeRenderer renderer){
        renderer.setSeriesPaint(0, Color.ORANGE);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.RED);
    }

    private void setSeriesStroke(XYLineAndShapeRenderer renderer){
        renderer.setSeriesStroke(0, new BasicStroke(2));
        renderer.setSeriesStroke(1, new BasicStroke(2));
        renderer.setSeriesStroke(2, new BasicStroke(2));
        renderer.setSeriesStroke(3, new BasicStroke(2));
    }
}
