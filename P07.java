package prac7; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxProfile; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.firefox.ProfilesIni; 
import org.openqa.selenium.remote.DesiredCapabilities; 
import org.openqa.selenium.support.ui.Select; 
public class tester 
{ 
public static void main(String args[]) 
{ 
System.setProperty("webdriver.gecko.driver","C://IDE//geckodriver-v0.21.0-win64//geckodriver.exe"); 
WebDriver driver=new FirefoxDriver(); 
driver.get("file:///C:/IDE/test.html"); 
java.util.List<WebElement>links = driver.findElements(By.xpath("//select/option")); 
System.out.println("Total no of items in Combo-Box are : " +links.size()); 
System.out.println("The name of items are"); 
for (int i = 0; i < links.size(); i++) 
{ 
System.out.println("Item " +(i+1)+ " Item name "+ links .get(i).getText()); 
} 
} 
} 
Test.html 
<html> 
<body> 
<select name="menu"> 
<option value="0" selected>zero</option> 
<option value="1">one</option> 
<option value="2">two</option> 
<option value="3">three</option> 
<option value="other">four</option> 
</select> 
</body> 
</html>
