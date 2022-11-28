package view;

import javax.swing.JFrame;
import model.MauSac;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import service.QuanLyChiTietHoaDon;
import service.QuanLyMauSac;
import service.ServiceImpl.HoaDonChiTietServiceImpl;
import service.ServiceImpl.MauSacServiceImpl;

public class SanPhamDaBan {
//    private static QuanLyMauSac qlMs = new MauSacServiceImpl();
//    private static QuanLyChiTietHoaDon quanLyChiTietHoaDonService = new HoaDonChiTietServiceImpl();
//
//    private static JFreeChart createChart(PieDataset dataset) {
//        JFreeChart chart = ChartFactory.createPieChart("CO CAU SAN PHAM BAN DUOC", dataset, true, true, true);
//        return chart;
//    }
//
//    private static PieDataset createDataset() {
//        DefaultPieDataset dataset = new DefaultPieDataset();
//        for (MauSac loaiSp : qlMs.select()) {
//            if (quanLyChiTietHoaDonService.percent(loaiSp)>0) {
//                dataset.setValue(loaiSp.toString(), quanLyChiTietHoaDonService.percent(loaiSp));
//            }
//        }
//        return dataset;
//    }
//
//    public static void main(String[] args) {
//        JFreeChart pieChart = createChart(createDataset());
//        ChartPanel chartPanel = new ChartPanel(pieChart);
//        JFrame frame = new JFrame();
//        frame.add(chartPanel);
//        frame.setTitle("Bieu do san pham ban ra");
//        frame.setSize(600, 400);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        frame.setVisible(true);
//    }
}
