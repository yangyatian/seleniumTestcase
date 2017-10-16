package testCreateCusomer;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import loginWz.LoginWzPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import basepage.HomePage;
import customerManagerPage.MyCustomerPage;

public class TestMyCustomer{
	
	WebDriver driver;
	private String baseUrl;
	String customerID ="100";
	String customerName="customer";
	String agent = "���Կͻ�רԱ";
	String visibleText = "һ����˰��";
	String startDay = "2017-01-01";
	String endDay = "2017-10-01";
	String username = "yyt";
	String password = "123456";
	String CustomerServiceExe = "���Կͻ�רԱ";
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
	    baseUrl = "http://192.168.101.192:81/wz/login";
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	  
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	//ͨ���û�id����
	public void testIdSearch() throws InterruptedException {
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
	    loginwz.loginStep(username, password);
		HomePage homePage = new HomePage(driver, baseUrl);
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		homePage.myCustomerEntry();
		Thread.sleep(2000);
		myCustomer.getDraft().click();//����ݸ�ҳ
		myCustomer.idSearch(customerID);
		assertTrue(myCustomer.getIdResult().getText().contains(customerID));
	}
	@Test
	//ͨ���û���������
	public void testNameSearch() throws InterruptedException {
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		HomePage homePage = new HomePage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(2000);
		homePage.myCustomerEntry();
		Thread.sleep(2000);
		myCustomer.getDraft().click();
		myCustomer.nameSearch(customerName);
		assertTrue(myCustomer.getNameResult().getText().contains(customerName));
	}
	@Test
	//ͨ������ʱ������
	public void testDateSearch() throws InterruptedException {
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		HomePage homePage = new HomePage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(2000);
		homePage.myCustomerEntry();
		Thread.sleep(2000);
		myCustomer.getDraft().click();
		myCustomer.dateSearch(startDay, endDay);
		String createDate = myCustomer.getDateResult().getText();
		String createDt = createDate.substring(0, 10);
		createDt = createDt.replace("-", "");
		String startTime = startDay.replace("-", "");
		String endTime = endDay.replace("-", "");
		assertTrue(Long.valueOf(startTime) <= Long.valueOf(createDt) && Long.valueOf(createDt) <= Long.valueOf(endTime));
	}
	@Test
	//ͨ������רԱ����
	public void testAgentSearch() throws InterruptedException {
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		HomePage homePage = new HomePage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(2000);
		homePage.myCustomerEntry();
		Thread.sleep(2000);
		myCustomer.getDraft().click();
		myCustomer.agentSearch(agent);
		assertTrue(myCustomer.getCustomerServiceResult().getText().equals(agent));
		
	}
	@Test
	//ͨ����˰��������
	public void testTaxTypeSearch() throws InterruptedException {
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		HomePage homePage = new HomePage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(2000);
		homePage.myCustomerEntry();
		Thread.sleep(2000);
		myCustomer.getDraft().click();
		myCustomer.TaxTypeSearch(visibleText);
		assertTrue(myCustomer.getCompanyTypeResult().getText().contains(visibleText));
	}
	
	@Test
	//�����ҳͨ���û�id����
	public void test2IdSearch() throws InterruptedException {
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		HomePage homePage = new HomePage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(2000);
		homePage.myCustomerEntry();
		Thread.sleep(2000);
		myCustomer.getPending().click();
		myCustomer.idSearch(customerID);
		assertTrue(myCustomer.getIdResult().getText().contains(customerID));
	}


}
