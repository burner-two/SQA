package prac5; 
import jxl.Cell; 
import jxl.Sheet; 
import jxl.Workbook; 
import jxl.read.biff.BiffException; 
import jxl.*; 
import jxl.read.*; 
import jxl.write.*; 
import java.io.*; 
import org.testng.annotations.BeforeClass; 
import org.testng.annotations.Test; 
public class test { 
@BeforeClass 
public void fr() 
{ 
} 
@Test 
public void testImportExport() throws Exception 
{ 
FileInputStream fi= new FileInputStream("C:\\Selenium\\Book1.xls "); 
Workbook w=Workbook.getWorkbook(fi); 
Sheet s= w.getSheet(0); 
String a[][]=new String[s.getRows()][s.getColumns()]; 
FileOutputStream fo = new FileOutputStream ("C:\\Selenium\\Book2.xls"); 
WritableWorkbook wwb = Workbook.createWorkbook(fo); 
WritableSheet ws = wwb.createSheet("result",0); 
int c=0; 
for(int i=0;i<s.getRows();i++) 
{ 
for(int j=0;j<s.getColumns();j++) 
{ 
if(i>=1) 
{ 
} 
String b=new String(); 
b=s.getCell(5,i).getContents(); 
int x=Integer.parseInt(b); 
if(x<60) 
{ 
} 
c++; 
break; 
a[i][j]=s.getCell(j,i).getContents(); 
Label L2=new Label(j,i,a[i][j]); 
ws.addCell(L2); 
} 
} 
wwb.write(); 
wwb.close(); 
} 
}
