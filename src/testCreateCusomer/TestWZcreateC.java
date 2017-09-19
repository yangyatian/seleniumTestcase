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
  String visibleText = "һ����˰��";
  String comAddress = "������test0010";
  String comTel = "13411112222";

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "http://192.168.101.192:81/wz/login";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  //���������û�����
  public void test01() throws Exception {
	TAction action = new TAction(driver, baseUrl);
	
	//��¼
    driver.get(baseUrl);
    LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
	loginwz.loginStep(username, password);
	Thread.sleep(3000);
	assertTrue(driver.getCurrentUrl().contains("welcome"));
    //�����ͻ���һҳ
	CreateCustomerPage createCustomer = new CreateCustomerPage(driver, baseUrl);
	createCustomer.createFirstPage(customerN,visibleText,comAddress,comTel);
	Thread.sleep(1000);
	assertEquals("��ӳɹ�", action.closeAlertAndGetItsText());
    //�����ͻ��ڶ�ҳ
    createCustomer.createSecondPage();
    Thread.sleep(1000);
    //������Ϣҳ
    createCustomer.Cooperative();
    //��ϵ����Ϣҳ
    createCustomer.contactMessage();
    Thread.sleep(1000);
    assertEquals("����ɹ�", action.closeAlertAndGetItsText());
    //����ó������Ϣ
    createCustomer.OverseasContact();
    Thread.sleep(1000);
    assertEquals("����ɹ�", action.closeAlertAndGetItsText());   
    //֤����Ϣҳ��
    createCustomer.licenseInfo();
    Thread.sleep(2000);  
    assertEquals("�Ƿ񱣴沢�ύ���?", action.closeAlertAndGetItsText());   
  }
  
  //@Test
  //�½��ͻ���Ϣ���ϴ�ͼƬ�;�����Ϣ������ݸ�
  public void test02() throws Exception {
	TAction action = new TAction(driver, baseUrl);
	//��¼
    driver.get(baseUrl);
    LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
	loginwz.loginStep(username, password);
	Thread.sleep(3000);
	assertTrue(driver.getCurrentUrl().contains("welcome"));
    //�����ͻ���һҳ
	CreateCustomerPage createCustomer = new CreateCustomerPage(driver, baseUrl);
	createCustomer.createFirstPage(customerN,visibleText,comAddress,comTel);
	Thread.sleep(1000);
	assertEquals("��ӳɹ�", action.closeAlertAndGetItsText());
    //�����ͻ��ڶ�ҳ
    createCustomer.createSecondPage();
    Thread.sleep(1000);
    //������Ϣҳ
    createCustomer.Cooperative();
    //��ϵ����Ϣҳ
    createCustomer.contactMessage();
    Thread.sleep(1000);
    assertEquals("����ɹ�", action.closeAlertAndGetItsText());
    //����ó������Ϣ����д
    //֤����Ϣ����д
    createCustomer.getSaveDraft().click();
    Thread.sleep(2000);  
    assertEquals("�ݸ屣��ɹ�", action.closeAlertAndGetItsText()); 
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
