package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

	public static void main(String[] args) throws InterruptedException {

		// Initialize ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		 // Maximize the browser window
		driver.manage().window().maximize();
		
		// Open the auth.dev.vntech.io website
		driver.get("https://auth.dev.vntech.io/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[text()='Accept All']")).click();

		driver.findElement(By.xpath("//div[@class='MuiGrid-root jss11 css-rfnosa']")).click();

		// Enter the username and password of a registered user
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("thorat959@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Zxcvbnm1@");

		 // Click on the "Log In" or "Sign In" button
		driver.findElement(By.id("signin")).click();

		//validation
		String Actualtitle = driver.getTitle();
		String Expectedtitle ="Viral Nation";

		if (Expectedtitle.equals(Actualtitle)) {
			System.out.println("Valid User");
		} else {
			System.out.println("Invalid User");
		}
		
		 // Close the browser
		driver.close();

	}

}
