import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 

public class P07 { 
	public static void main(String args[]) 
	{ 
		System.setProperty("webdriver.gecko.driver","C://Users//Admin//Desktop//SQA//LIB//geckodriver.exe"); 
		WebDriver driver=new FirefoxDriver(); 
		driver.get("file:///C:/Users/Admin/Desktop/SQA/PAGES/P07/test.html"); 
		java.util.List<WebElement>links = driver.findElements(By.xpath("//select/option")); 
		System.out.println("Total no of items in Combo-Box are : " +links.size()); 
		System.out.println("The name of items are"); 
		for (int i = 0; i < links.size(); i++) { 
			System.out.println("Item " +(i+1)+ " Item name "+ links .get(i).getText()); 
		} 
	} 
} 
