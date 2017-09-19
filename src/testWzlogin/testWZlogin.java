package testWzlogin;

import static org.junit.Assert.*;
import loginWz.LoginWzPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testWZlogin {
	WebDriver driver;
	String url = "http://192.168.101.192:81/wz/login";
	String username = "yyt";
	String password = "123456";
	String fwUsername = "testfw001";
	String shUsername = "testsh001";
	String tsUsername = "testts001";
	String cwUsername = "testcw001";
	
	String [][] dataUp = {
			{"yyt" , ""},
			{"" , "123456"}	
	};
	
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		System.out.println("Test start");
	}

	

	@Test
	public void testlogin() throws InterruptedException {	
		LoginWzPage loginwz = new LoginWzPage(driver, url);
		String loginNameText = "超级";
		loginwz.loginStep(username, password);
		Thread.sleep(3000);
		assertTrue(driver.getCurrentUrl().contains("welcome"));
		assertTrue(loginwz.getNameText().getText().contains(loginNameText));
		
	}
	
	@Test
	public void testloginError() throws InterruptedException {
		LoginWzPage loginwz = new LoginWzPage(driver, url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		for(String[] item: dataUp){
			String rusername = item[0];
			String rpassword = item[1];
			loginwz.loginStep(rusername, rpassword);
			
		}		
	}
	
	@Test
	public void testfwlogin() throws InterruptedException {
		LoginWzPage loginwz = new LoginWzPage(driver, url);
		String loginServiceText = "服务";
		driver.manage().window().maximize();
		Thread.sleep(1000);
		loginwz.loginStep(fwUsername, password);
		Thread.sleep(3000);
		assertTrue(driver.getCurrentUrl().contains("welcome"));
		assertTrue(loginwz.getNameText().getText().contains(loginServiceText));
	}
	
	@Test
	public void testshlogin() throws InterruptedException {
		LoginWzPage loginwz = new LoginWzPage(driver, url);
		String loginCheckText = "审核";
		driver.manage().window().maximize();
		Thread.sleep(1000);
		loginwz.loginStep(shUsername, password);
		Thread.sleep(3000);
		assertTrue(driver.getCurrentUrl().contains("welcome"));
		assertTrue(loginwz.getNameText().getText().contains(loginCheckText));
	}
	
	@Test
	public void testtslogin() throws InterruptedException {
		LoginWzPage loginwz = new LoginWzPage(driver, url);
		String loginTaxText = "退税";
		driver.manage().window().maximize();
		Thread.sleep(3000);
		loginwz.loginStep(tsUsername, password);
		Thread.sleep(3000);
		assertTrue(driver.getCurrentUrl().contains("welcome"));
		assertTrue(loginwz.getNameText().getText().contains(loginTaxText));
	}
	
	@Test
	public void testcwlogin() throws InterruptedException {
		LoginWzPage loginwz = new LoginWzPage(driver, url);
		String loginAffText = "财务";
		driver.manage().window().maximize();
		Thread.sleep(3000);
		loginwz.loginStep(cwUsername, password);
		Thread.sleep(3000);
		assertTrue(driver.getCurrentUrl().contains("welcome"));
		assertTrue(loginwz.getNameText().getText().contains(loginAffText));
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Test end");
		
	}
}
