package praccfc3;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;
import java.io.*;

public class prac4prac {

    // Method to import and export Excel data
    public void testImportExport() throws Exception {
        // File paths for input and output Excel files
        FileInputStream fi = new FileInputStream("E:\\XL\\Book3.xls");
        Workbook w = Workbook.getWorkbook(fi);
        Sheet s = w.getSheet(0);  // Access the first sheet of the workbook

        // FileOutputStream for the output file (Book4.xls)
        FileOutputStream fo = new FileOutputStream("E:\\XL\\Book4.xls");
        WritableWorkbook wwb = Workbook.createWorkbook(fo);
        WritableSheet ws = wwb.createSheet("result", 0);  // Create a sheet named "result"

        // Reading and writing data to the new sheet
        for (int i = 0; i < s.getRows(); i++) {
            for (int j = 0; j < s.getColumns(); j++) {
                String cellValue = s.getCell(j, i).getContents();  // Read cell contents
                Label L2 = new Label(j, i, cellValue);  // Create a label to write to new sheet
                ws.addCell(L2);  // Add label (cell) to the writable sheet
            }
        }

        // Add the "Result" column header in column 6 (G column)
        Label resultHeader = new Label(6, 0, "Result");
        ws.addCell(resultHeader);

        // Processing the "Result" column based on cell values
        for (int i = 1; i < s.getRows(); i++) {  // Start from row 1 (skip header row)
            boolean pass = true;
            for (int j = 2; j < s.getColumns(); j++) {  // Start checking from column 2
                String cellValue = s.getCell(j, i).getContents();  // Read the content of each cell
                
                // Ensure cell is not empty and contains a number before parsing
                if (cellValue != null && !cellValue.trim().isEmpty() && isNumeric(cellValue)) {
                    int marks = Integer.parseInt(cellValue);  // Parse the string as integer
                    if (marks <= 35) {  // If marks are less than or equal to 35, fail
                        pass = false;
                        break;
                    }
                } else {
                    pass = false;  // If cell is empty or not numeric, mark as fail
                    break;
                }
            }

            // Write pass or fail to column 6 (G column)
            Label resultLabel = new Label(6, i, pass ? "pass" : "fail");
            ws.addCell(resultLabel);
        }

        // Write to the output workbook and close it
        wwb.write();
        wwb.close();
        fi.close();
        fo.close();
        
        System.out.println("Process completed and result written to Book4.xls.");
    }

    // Utility method to check if a string is numeric
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Main method to run the test
    public static void main(String[] args) {
        try {
            prac4prac p = new prac4prac();  // Create an instance of prac4prac
            p.testImportExport();  // Call the testImportExport method
        } catch (Exception e) {
            e.printStackTrace();  // Print any exceptions that occur during execution
        }
    }
}
