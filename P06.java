package testing; 
importorg.openqa.selenium.By; 
importorg.openqa.selenium.WebDriver; 
importorg.openqa.selenium.WebElement; 
importorg.openqa.selenium.firefox.FirefoxDriver; 
importorg.openqa.selenium.firefox.FirefoxProfile; 
importorg.openqa.selenium.firefox.ProfilesIni; 
importorg.openqa.selenium.remote.DesiredCapabilities; 
importorg.openqa.selenium.support.ui.Select; 
public class test 
{ 
public static void main(String args[]) 
{ 
System.setProperty("webdriver.gecko.driver","C://Selenium//geckodriver-v0.21.0- 
win64//geckodriver.exe"); 
WebDriver driver=new FirefoxDriver(); 
driver.get("http://toolsqa.wpengine.com/"); 
java.util.List<WebElement> links = driver.findElements(By.tagName("a")); 
System.out.println("total links :"+links.size()); 
for(inti=0; i<links.size(); i=i+1) 
{ 
System.out.println("link"+i+" link name "+ links.get(i).getText()); 
} 
} 
}
