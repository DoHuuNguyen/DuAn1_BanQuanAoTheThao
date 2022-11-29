package view;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import service.QuanLyHoaDon;
import service.ServiceImpl.HoaDonServiceImpl;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class DoanhThu  extends javax.swing.JFrame{
    public DoanhThu(){
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Doanh Thu Hàng Tháng");
    }
    private static QuanLyHoaDon qlHd = new HoaDonServiceImpl();
    
    public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Bieu do doanh thu trong cac thang",
                "Thang", "Doanh thu",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 1; i <= 12; i++) {
            dataset.addValue(qlHd.turnover(i), "Doanh thu", i+"");
        }
        return dataset;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoanhThu().setVisible(true);
            }
        });
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ doanh thu cac thang trong nam 2022");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
