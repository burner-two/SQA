import jxl.*;
import jxl.write.*;
import java.io.*;

public class P11 {
    public void testImportExport() throws Exception {
        // Input and output file streams
        Workbook w = Workbook.getWorkbook(new FileInputStream("C:\\Selenium\\P11\\Book1.xls"));
        WritableWorkbook wwb = Workbook.createWorkbook(new FileOutputStream("C:\\Selenium\\P11\\Book2.xls"));
        WritableSheet ws = wwb.createSheet("result", 0);

        // Copy headers and process rows
        Sheet s = w.getSheet(0);
        for (int j = 0; j < s.getColumns(); j++) ws.addCell(new Label(j, 0, s.getCell(j, 0).getContents()));
        int outputRow = 1;

        for (int i = 1; i < s.getRows(); i++) {
            String scoreStr = s.getCell(5, i).getContents();
            if (scoreStr.trim().isEmpty()) continue;

            try {
                if (Integer.parseInt(scoreStr) > 60) {
                    for (int j = 0; j < s.getColumns(); j++)
                        ws.addCell(new Label(j, outputRow, s.getCell(j, i).getContents()));
                    outputRow++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing score for row " + (i + 1) + ": " + scoreStr);
            }
        }

        wwb.write();
        wwb.close();
        System.out.println("Process completed: Only students with scores > 60 have been written to Book2.xls.");
    }

    public static void main(String[] args) {
        try {
            new P11().testImportExport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
