/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reopsitory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import model.ChiTietSanPham;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class ExcelHelper {

    private MonTheThaoRepository mttrp = new MonTheThaoRepository();
    private static MauSacRepository mauSacRp = new MauSacRepository();
    private static SizeRepository sizeRp = new SizeRepository();

    private static final int COLUMN_INDEX_Ma = 1;
    private static final int COLUMN_INDEX_IDMTT = 2;
    private static final int COLUMN_INDEX_IDMAUSAC = 3;
    private static final int COLUMN_INDEX_IDSIZE = 4;
    private static final int COLUMN_INDEX_IDSL = 5;
    private static final int COLUMN_INDEX_IDGia = 6;

    public ArrayList<ChiTietSanPham> readFileExcel(String path) throws FileNotFoundException, IOException {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();

        InputStream inputStream = new FileInputStream(path);

        Workbook workbook = getWorkbook(inputStream, path);

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (row.getRowNum() == 0) {
                continue;
            }

            Iterator<Cell> cellIterator = row.cellIterator();
            ChiTietSanPham ctsp = new ChiTietSanPham();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);

                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }

                int column_index = cell.getColumnIndex();
//                switch (column_index) {
//                    case COLUMN_INDEX_Ma ->
//                        ctsp.setMa((String) getCellValue(cell));
//                    case COLUMN_INDEX_IDMTT ->
//                        ctsp.setIdMonTheThao(mttrp.search((String) getCellValue(cell)));
//                    case COLUMN_INDEX_IDMAUSAC ->
//                        ctsp.setIdMauSac(mauSacRp.search((String) getCellValue(cell)));
//                    case COLUMN_INDEX_IDSIZE ->
//                        ctsp.setIdSize(sizeRp.search((String) getCellValue(cell)));
//                    case COLUMN_INDEX_IDSL ->
//                        ctsp.setMa((String) getCellValue(cell));
//                    case COLUMN_INDEX_IDGia ->
//                        ctsp.setMa((String) getCellValue(cell));
//                }
            }
            list.add(ctsp);
        }
        workbook.close();
        inputStream.close();
        return list;
    }

    public void writeFileExcel(ArrayList<ChiTietSanPham> list,JFileChooser duongdan) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach");
            XSSFRow row = null;
            Cell cell = null;

            row = sheet.createRow(0);

            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue("Id");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Môn Thể Thao");

            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue("Màu Sắc");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Size");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Số Lượng");

            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue("Giá");

            for (int i = 0; i < list.size(); i++) {
                ChiTietSanPham ctsp = list.get(i);
                row = sheet.createRow(i + 1);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(ctsp.getId());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(ctsp.getMa());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(ctsp.getIdMonTheThao().toString());

                cell = row.createCell(3, CellType.NUMERIC);
                cell.setCellValue(ctsp.getIdMauSac().getId());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(ctsp.getIdSize().toString());

                try {
                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue(ctsp.getSoLuong());
                } catch (Exception e) {
                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue("NULL");
                }

                cell = row.createCell(6, CellType.NUMERIC);
                cell.setCellValue(ctsp.getGia());

            }

            File f = new File(duongdan.getSelectedFile().getPath());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(f+".xlsx");
                workbook.write(fileOutputStream);
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Workbook getWorkbook(InputStream inputStream, String path) throws IOException {
        Workbook workbook = null;

        if (path.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (path.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }

    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluateInCell(cell).getStringCellValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            default:
                throw new AssertionError();
        }
        return cellValue;
    }
//
//    public static void main(String[] args) throws IOException {
//        ExcelHelper ex = new ExcelHelper();
//        ex.writeFileExcel(ex.readFileExcel("H:\\FileData.xlsx"));
//    }
}
