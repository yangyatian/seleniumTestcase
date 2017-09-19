package testCreateCusomer;

import java.util.concurrent.TimeUnit;
import loginWz.LoginWzPage;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import action.TAction;
import customerManagerPage.CreateCustomerPage;

public class TestWZcreateC {
  WebDriver driver;
  private String baseUrl;
  String username = "yyt";
  String password = "123456";
  private StringBuffer verificationErrors = new StringBuffer();
  String customerN = "customer" + System.currentTimeMillis();
  String visibleText = "一般纳税人";
  String comAddress = "日落大道test0010";
  String comTel = "13411112222";

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "http://192.168.101.192:81/wz/login";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  //完整创建用户过程
  public void test01() throws Exception {
	TAction action = new TAction(driver, baseUrl);
	
	//登录
    driver.get(baseUrl);
    LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
	loginwz.loginStep(username, password);
	Thread.sleep(3000);
	assertTrue(driver.getCurrentUrl().contains("welcome"));
    //新增客户第一页
	CreateCustomerPage createCustomer = new CreateCustomerPage(driver, baseUrl);
	createCustomer.createFirstPage(customerN,visibleText,comAddress,comTel);
	Thread.sleep(1000);
	assertEquals("添加成功", action.closeAlertAndGetItsText());
    //新增客户第二页
    createCustomer.createSecondPage();
    Thread.sleep(1000);
    //合作信息页
    createCustomer.Cooperative();
    //联系人信息页
    createCustomer.contactMessage();
    Thread.sleep(1000);
    assertEquals("保存成功", action.closeAlertAndGetItsText());
    //境外贸易商信息
    createCustomer.OverseasContact();
    Thread.sleep(1000);
    assertEquals("保存成功", action.closeAlertAndGetItsText());   
    //证照信息页面
    createCustomer.licenseInfo();
    Thread.sleep(2000);  
    assertEquals("是否保存并提交审核?", action.closeAlertAndGetItsText());   
  }
  
  //@Test
  //新建客户信息不上传图片和境外信息并保存草稿
  public void test02() throws Exception {
	TAction action = new TAction(driver, baseUrl);
	//登录
    driver.get(baseUrl);
    LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
	loginwz.loginStep(username, password);
	Thread.sleep(3000);
	assertTrue(driver.getCurrentUrl().contains("welcome"));
    //新增客户第一页
	CreateCustomerPage createCustomer = new CreateCustomerPage(driver, baseUrl);
	createCustomer.createFirstPage(customerN,visibleText,comAddress,comTel);
	Thread.sleep(1000);
	assertEquals("添加成功", action.closeAlertAndGetItsText());
    //新增客户第二页
    createCustomer.createSecondPage();
    Thread.sleep(1000);
    //合作信息页
    createCustomer.Cooperative();
    //联系人信息页
    createCustomer.contactMessage();
    Thread.sleep(1000);
    assertEquals("保存成功", action.closeAlertAndGetItsText());
    //境外贸易商信息不填写
    //证照信息不填写
    createCustomer.getSaveDraft().click();
    Thread.sleep(2000);  
    assertEquals("草稿保存成功", action.closeAlertAndGetItsText()); 
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
