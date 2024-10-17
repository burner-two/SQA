package praccfc3;

import jxl.*;
import jxl.write.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class themagicbox {

    // Method to handle the import and export of Excel data
    public void testImportExport() throws Exception {
        // Input Excel file
        FileInputStream fi = new FileInputStream("E:\\XL\\Book3.xls");
        Workbook w = Workbook.getWorkbook(fi);
        Sheet s = w.getSheet(0);

        // Output Excel file
        FileOutputStream fo = new FileOutputStream("E:\\XL\\Book4.xls");
        WritableWorkbook wwb = Workbook.createWorkbook(fo);
        WritableSheet ws = wwb.createSheet("result", 0);

        // Copy headers (if any) from the first row
        for (int j = 0; j < s.getColumns(); j++) {
            String header = s.getCell(j, 0).getContents();
            Label label = new Label(j, 0, header);
            ws.addCell(label);  // Write header to output file
        }

        int outputRow = 1;  // This keeps track of the row in the output sheet where we write data

        for (int i = 1; i < s.getRows(); i++) {  // Skip the first row (header row)
            String scoreStr = s.getCell(5, i).getContents();  // Assuming score is in the 6th column (index 5)

            if (scoreStr != null && !scoreStr.trim().isEmpty()) {
                try {
                    int score = Integer.parseInt(scoreStr);  // Parse score
                    if (score > 60) {  // Only process students who scored more than 60
                        // Copy the entire row to the output if the score is more than 60
                        for (int j = 0; j < s.getColumns(); j++) {
                            String cellValue = s.getCell(j, i).getContents();  // Get cell value from input
                            Label label = new Label(j, outputRow, cellValue);  // Create a label to write to output
                            ws.addCell(label);  // Write the label to the output sheet
                        }
                        outputRow++;  // Move to the next row in the output file
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing score for row " + (i + 1) + ": " + scoreStr);
                }
            }
        }

        // Write and close the output workbook
        wwb.write();
        wwb.close();
        fi.close();
        fo.close();
        System.out.println("Process completed: Only students with scores > 60 have been written to Book4.xls.");
    }

    // Main method to run the process
    public static void main(String[] args) {
        try {
            themagicbox tmb = new themagicbox();  // Create an instance of themagicbox
            tmb.testImportExport();  // Call the method to import and export the Excel data
        } catch (Exception e) {
            e.printStackTrace();  // Print any exceptions
        }
    }
}
