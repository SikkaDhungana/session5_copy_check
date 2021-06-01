package variousConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void windowHandleTest() {

		//System.out.println(driver.getTitle());
		String handle1 = driver.getWindowHandle();
		System.out.println(handle1);

		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("xpath");
		driver.findElement(By.xpath("//input[@id='ybar-search']")).click();

//		System.out.println(driver.getTitle());
//		String handle2 = driver.getWindowHandle();
//		System.out.println(handle2);

		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();

		// gives all the browsers open (getWindowHandles)
		// System.out.println(driver.getTitle());

		// Set<String> handles = driver.getWindowHandles();
		// System.out.println(handles);

		Set<String> handles = driver.getWindowHandles();
		for (String i : handles) {
			 System.out.println(i);
			driver.switchTo().window(i);
		}

		System.out.println(driver.getTitle());

		//to get back to yahoo again
		driver.switchTo().window(handle1);
		
		System.out.println(driver.getTitle());

		//driver.close();
	//	driver.quit();

	}
}
