package testCreateCusomer;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import loginWz.LoginWzPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import customerManagerPage.MyCustomerPage;

public class TestMyCustomer{
	
	WebDriver driver;
	private String baseUrl;
	String customerID ="100";
	String customerName="customer";
	String agent = "测试客户专员";
	String visibleText = "一般纳税人";
	String startDay = "2017-01-01";
	String endDay = "2017-10-01";
	String username = "yyt";
	String password = "123456";
	String CustomerServiceExe = "测试客户专员";
	
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
	//通过用户id搜索
	public void testIdSearch() throws InterruptedException {
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
	    loginwz.loginStep(username, password);
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		myCustomer.gotoMyCustomerByUrl();
		Thread.sleep(2000);
		myCustomer.idSearch(customerID);
		assertTrue(myCustomer.getIdResult().getText().contains(customerID));
	}
	@Test
	//通过用户名称搜索
	public void testNameSearch() throws InterruptedException {
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(2000);
		myCustomer.gotoMyCustomerByUrl();
		Thread.sleep(2000);
		myCustomer.nameSearch(customerName);
		assertTrue(myCustomer.getNameResult().getText().contains(customerName));
	}
	@Test
	//通过成立时间搜索
	public void testDateSearch() throws InterruptedException {
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		loginwz.loginStep(username, password);//登录
		Thread.sleep(2000);
		myCustomer.gotoMyCustomerByUrl();//转到我的客户页面
		Thread.sleep(2000);
		myCustomer.dateSearch(startDay, endDay);//输入起始时间搜索
		String createDt = myCustomer.fristCreateDate();//获取首行结果创建时间
		String startTime = startDay.replace("-", "");
		String endTime = endDay.replace("-", "");
		//断言搜索结果创建时间是否在搜索时间区间内
		assertTrue(Long.valueOf(startTime) <= Long.valueOf(createDt) && Long.valueOf(createDt) <= Long.valueOf(endTime));
	}
		
	@Test
	//通过服务专员搜索
	public void testAgentSearch() throws InterruptedException {
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(2000);
		myCustomer.gotoMyCustomerByUrl();
		Thread.sleep(2000);
		myCustomer.agentSearch(agent);
		assertTrue(myCustomer.getCustomerServiceResult().getText().equals(agent));		
	}
	
	@Test
	//通过纳税类型搜索
	public void testTaxTypeSearch() throws InterruptedException {
		MyCustomerPage myCustomer =new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(2000);
		myCustomer.gotoMyCustomerByUrl();
		Thread.sleep(2000);
		myCustomer.TaxTypeSearch(visibleText);
		assertTrue(myCustomer.getCompanyTypeResult().getText().contains(visibleText));
	}
	
	@Test
	//待审核页通过用户id搜索
	public void test2IdSearch() throws InterruptedException {
		MyCustomerPage myCustomer = new MyCustomerPage(driver, baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(2000);
		myCustomer.gotoMyCustomerByUrl();
		Thread.sleep(2000);		
		myCustomer.idSearch2(customerID);
		assertTrue(myCustomer.getIdResult().getText().contains(customerID));
	}


}
