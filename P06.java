import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
public class P06 { 
	public static void main(String args[])  { 
		System.setProperty("webdriver.gecko.driver","C://Selenium//geckodriver.exe"); 
		WebDriver driver=new FirefoxDriver(); 
		driver.get("http://apple.com/"); 
		java.util.List<WebElement> links = driver.findElements(By.tagName("a")); 
		System.out.println("total links :"+links.size()); 
		for(int i=0; i<links.size(); i=i+1) { 
			System.out.println("link"+i+" link name "+ links.get(i).getText()); 
		} 
	} 
}
