package AutomationPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends DriverSetup {

	//logout method
	public static void logout() {
		driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).click();
		driver.findElement(By.xpath("(//a[@class=\"oxd-userdropdown-link\"])[4]")).click();
	}
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

		driver.findElement(By.name("firstName")).sendKeys("Harihar");

		driver.findElement(By.name("middleName")).sendKeys("krishna");

		driver.findElement(By.name("lastName")).sendKeys("dhakal");

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).clear();

		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("1111");

		driver.findElement(By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"])")).click();

		//validate if the employee is added
		Thread.sleep(5000);
		String message_expected = "Personal Details";
		String message_actual = driver.findElement(By.xpath("(//h6[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"])[1]")).getText();
		Assert.assertEquals(message_expected, message_actual);

		logout();

	}
	@Test(priority=4)
	public static void searchemployee() throws InterruptedException {
		login();
		//click on pim in sidebar
		driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]")).click();
		//type employee name
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Harihar krishna dhakal");
		//click on search
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")).click();
		//validate if the records are found
		Thread.sleep(5000);
		String message_expected = "No Records Found";
		String message_actual = driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span\"])[1]")).getText();
		if(message_actual==message_expected) {
			System.out.println("no records are found");
		}
		else {
			System.out.println("records are found");
		}
		Thread.sleep(5000);
		logout();
	}
	@Test(priority=5)
	public static void deleteemployee() throws InterruptedException {
		login();
		//click on pim in sidebar
		driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]")).click();
		//type employee name
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Harihar krishna dhakal");
		//click on search
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")).click();
		//validate if the records are found
		Thread.sleep(5000);
		String message_expected = "No Records Found";
		String message_actual = driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span\"])[1]")).getText();
		if(message_actual==message_expected) {
			System.out.println("no records are found");
		}
		else {
			System.out.println("records are found");
		}
		//click on delete icon from records
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
		//click on yes, delete message button
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]")).click();
		Thread.sleep(5000);
		logout();
	}
	@Test(priority=6)
	public static void myinfo() throws InterruptedException {
		login();
		//click on myinfo in sidebar
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]")).click();
		//change name
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='';", driver.findElement(By.name("firstName")));
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).sendKeys("NewName");
		//click on save
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"])[1]")).click();
		Thread.sleep(5000);
		logout();
	}
	@Test(priority=7)
	public static void Buzz() throws InterruptedException {
		login();
		//click on buzz in sidebar
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[12]/a[1]")).click();
		//change name
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@class=\"oxd-buzz-post-input\"]")).sendKeys("Hello Everyone");
		//click on post
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(3000);
		logout();
	}
	@Test(priority=8)
	public static void forgotpassword() throws InterruptedException {
		//click on forgotpassword
		driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-login-forgot-header\"]")).click();
		//type name
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("NewUser");
		//click on resetpassword
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset\"]")).click();
		//validation 
		Thread.sleep(3000);
		String message_expected = "Reset Password link sent successfully";
		String message_actual = driver.findElement(By.xpath("//h6[@class=\"oxd-text oxd-text--h6 orangehrm-forgot-password-title\"]")).getText();
		if(message_actual==message_expected) {
			System.out.println("Reset Password link sent successfully");
		}
		else {
			System.out.println("error");
		}
		Thread.sleep(3000);
		driver.close();
	}
}
