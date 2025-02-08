package AutomationPractice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends DriverSetup {


	//Testing using incorrect credentials
	@Test(priority = 1)
	public void invaidlogin() {

		driver.findElement(By.name("username")).sendKeys("Adminnn");
		driver.findElement(By.name("password")).sendKeys("admin123333");
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
		
		//validate the confirmation message
		String message_expected = "Invalid credentials";
		String message_actual = driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")).getText();
		Assert.assertEquals(message_expected, message_actual);
	}
	//Testing using proper credentials
	@Test(priority = 2)
	public static void login() {

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();

	}
	
	@Test(priority = 3)
	public static void addemployee() throws InterruptedException {

		driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]")).click();

		driver.findElement(By.xpath("(//a[@class=\"oxd-topbar-body-nav-tab-item\"])[2]")).click();

		driver.findElement(By.name("firstName")).sendKeys("ram");

		driver.findElement(By.name("middleName")).sendKeys("krishna");

		driver.findElement(By.name("lastName")).sendKeys("dhakal");

		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]")).clear();

		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]")).sendKeys("1111");

		driver.findElement(By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"])")).click();

		//validate if the employee is added
		Thread.sleep(5000);
		String message_expected = "Personal Details";
		String message_actual = driver.findElement(By.xpath("(//h6[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"])[1]")).getText();
		Assert.assertEquals(message_expected, message_actual);

	}


}
