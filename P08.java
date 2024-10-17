package prac8; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxProfile; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.firefox.ProfilesIni; 
import org.openqa.selenium.remote.DesiredCapabilities; 
import org.openqa.selenium.support.ui.Select; 
public class Prac8 { 
public static void main(String[] args) { 
System.setProperty("webdriver.gecko.driver","C://IDE//geckodriver-v0.21.0-win64//geckodriver.exe"); 
WebDriver driver=new FirefoxDriver(); 
driver.get("C:\\IDE\\second.html"); 
java.util.List<WebElement> optioncount = 
driver.findElements(By.xpath("//input[@type='checkbox']")); 
System.out.println("total items:"+optioncount.size()); 
for(int i=0;i<optioncount.size();i=i+2) { 
optioncount.get(i).click(); 
} 
int checkedcount=0,uncheckedcount=0; 
for(int i=0;i<optioncount.size();i++) { 
System.out.println(i+" checkbox is selected:"+ optioncount.get(i).isSelected()); 
if(optioncount.get(i).isSelected()) { 
checkedcount++; 
} 
else { 
uncheckedcount++; 
} 
} 
System.out.println("Total number of selected checkbox:"+checkedcount); 
System.out.println("Total number of unselected checkbox:"+uncheckedcount); 
} 
} 
Second.html 
<html> 
<body> 
<form> 
<input type="checkbox">SSC<br/> 
<input type="checkbox">HSC<br/> 
<input type="checkbox">BSC CS<br/> 
<input type="checkbox">BSC IT<br/> 
<input type="checkbox">B COM<br/> 
</form> 
</body> 
</html> 
