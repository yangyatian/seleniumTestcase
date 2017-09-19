package loginWz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginWzPage{
	protected WebDriver driver;	
	String url = "http://192.168.101.192:81/wz/login";
	public LoginWzPage(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;	
		driver.get(this.url);
	}	
		By usernameInput = By.xpath("//form/div[1]/input[@ng-model='loginInfo.loginName']");
		By passwordInput = By.xpath("//div/input[@type='password']");
		By loginSubmit = By.xpath("//button[@type='submit']");
		By loginNameText = By.xpath("//li[@class='dropdown user user-menu']/a/span[@class='ng-binding']");
	
	public WebElement loginInput(){
		return this.driver.findElement(usernameInput);
	}
	public WebElement passwordInput(){
		return this.driver.findElement(passwordInput);
	}
	public WebElement submitInput(){
		return this.driver.findElement(loginSubmit);
	}
	
	public void loginStep(String username , String password){
		loginInput().clear();
		loginInput().sendKeys(username);
		passwordInput().clear();
		passwordInput().sendKeys(password);
		submitInput().click();
	}
	
	public WebElement getNameText(){
		return this.driver.findElement(loginNameText);
	}
	
}
