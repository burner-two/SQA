import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;
import java.io.*;

public class P10 {
    public static void main(String[] args) {
        try {
            FileInputStream fi = new FileInputStream("C:\\Selenium\\Book1.xls");
            Workbook w = Workbook.getWorkbook(fi);
            Sheet s = w.getSheet(0);
            WritableWorkbook wwb = Workbook.createWorkbook(new FileOutputStream("C:\\Selenium\\Book2.xls"));
            WritableSheet ws = wwb.createSheet("result", 0);

            for (int i = 0; i < s.getRows(); i++) {
                for (int j = 0; j < s.getColumns(); j++) {
                    ws.addCell(new Label(j, i, s.getCell(j, i).getContents()));
                }
            }
            ws.addCell(new Label(6, 0, "Result"));

            for (int i = 1; i < s.getRows(); i++) {
                boolean pass = true;
                for (int j = 2; j < s.getColumns(); j++) {
                    String cellValue = s.getCell(j, i).getContents();
                    if (cellValue.isEmpty() || !isNumeric(cellValue) || Integer.parseInt(cellValue) <= 35) {
                        pass = false;
                        break;
                    }
                }
                ws.addCell(new Label(6, i, pass ? "pass" : "fail"));
            }

            wwb.write();
            wwb.close();
            fi.close();
            System.out.println("Process completed and result written to Book2.xls.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
