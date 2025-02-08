package AutomationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	public static ChromeDriver driver;

	@BeforeSuite
	public static void setup() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.manage().window().maximize();
		
		 // Explicit wait for username field
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

	}

	@AfterSuite
	static void exit() throws InterruptedException {

		Thread.sleep(5000);
		driver.close();
	}



}
