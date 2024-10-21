import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;

public class P08 { 
public static void main(String[] args) { 
	System.setProperty("webdriver.gecko.driver","C://Users//Admin//Desktop//SQA//LIB//geckodriver.exe"); 
	WebDriver driver=new FirefoxDriver(); 
	driver.get("file:///C:/Users/Admin/Desktop/SQA/PAGES/P08/second.html"); 
	java.util.List<WebElement> optioncount = driver.findElements(By.xpath("//input[@type='checkbox']")); 
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
