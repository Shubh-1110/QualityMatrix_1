package selenium_tutorial;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class charmtracker {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\chromedriver_win32_83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://accounts.charmtracker.com/signin?hide_signup=true&hide_secure=true&hide_gsignup=true&servicename=charmhealth&serviceurl=https%3A%2F%2Fehr2.charmtracker.com%2Fehr%2Fmain.do");
		
		//Login the account
		driver.findElement(By.xpath("//input[@id='lid']")).sendKeys("Dev+6@deepscribe.ai");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("vgS9Y3RDhq2tnhE");
		driver.findElement(By.xpath("//div[@id='signin_submit']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Update Timezone')]")).click();
		Thread.sleep(5000);
		Set<String> PopupID=driver.getWindowHandles();
		System.out.println(PopupID.size());
		Iterator<String> it= PopupID.iterator();		
		String mainWindow=it.next();
		String popupWindow1=it.next();
		Thread.sleep(2000);
		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Chart Notes')]")).click();
		driver.findElement(By.xpath("//div[@class='v1-action-btn v1-action-btn-bg v1-cmcur']")).click();
		driver.findElement(By.xpath("//input[@id='SEARCH_PATIENT_FOR_ENCOUNTER']")).sendKeys("Dummy Patient");
		WebElement patient=driver.findElement(By.xpath("//div[@class='v1-rw-text']"));
		patient.click();
		driver.findElement(By.xpath("//div[contains(text(),'No, I want to create new Encounter')]")).click();
		WebElement visitType=driver.findElement(By.xpath("//select[@id='VISIT_TYPE']"));
		Select type=new Select(visitType);
		type.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		
		
		
	}

}
