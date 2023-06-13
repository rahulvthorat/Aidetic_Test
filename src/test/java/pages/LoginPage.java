package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public static WebElement element = null;

	//loginPage Elements
	public static WebElement Accept_cookies(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()='Accept All']"));
		return element;
	}

	public static WebElement login_link(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='MuiGrid-root jss11 css-rfnosa']"));
		return element;
	}

	public static WebElement textbox_username(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='email']"));
		return element;
	}

	public static WebElement textbox_password(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='password']"));
		return element;
	}

	public static WebElement login_button(WebDriver driver) {
		element = driver.findElement(By.id("signin"));
		return element;
	}

	public static WebElement welcome_Message(WebDriver driver) {
		element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]"));
		return element;

	}

}
