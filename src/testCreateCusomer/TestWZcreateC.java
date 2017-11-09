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
	String OSName = "Tom";
	String selectArea1 = "�й����";
	String customerEditUrl = "http://192.168.101.192:81/wz/customer/edit";
	String captialNum = "1000";
	String moneyText = "USD";
	String RegistrationNo = "11011011";
	String Entity = "test0101";
	String id = "110203198504034315";
	String Tnum = "20";
	String testword = "����";
	String Tnum2 = "100000";
	String selectStype = "T/T";
	String testEmail = "yy@yy.c";
	String industry = "ʳƷ";
	String CustomerServiceExe = "���Կͻ�רԱ";
	String jpgPath1 = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg";
	String jpgPath2 = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg";
	String testName = "testname";
	String testMNumber = "13422221111";
	String Num = "1";
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://192.168.101.192:81/wz/login";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	// ���������û�����
	public void test01() throws Exception {
		TAction action = new TAction(driver, baseUrl);
		// ��¼
		driver.get(baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(3000);
		assertTrue(driver.getCurrentUrl().contains("welcome"));
		// �����ͻ���һҳ
		CreateCustomerPage createCustomer = new CreateCustomerPage(driver,baseUrl);
		
		createCustomer.createFirstPage(customerEditUrl, customerN, visibleText, comAddress,comTel);
		Thread.sleep(1000);
		assertEquals("��ӳɹ�", action.closeAlertAndGetItsText());
		// �����ͻ��ڶ�ҳ
		createCustomer.createSecondPage(comAddress, captialNum, moneyText, RegistrationNo, Entity, id, comTel, testEmail, CustomerServiceExe, industry, Tnum, testword, Tnum2, selectStype);
		Thread.sleep(1000);
		// ������Ϣҳ
		createCustomer.Cooperative(Num);
		// ��ϵ����Ϣҳ
		createCustomer.contactMessage(testName, testMNumber, testEmail);
		Thread.sleep(1000);
		assertEquals("����ɹ�", action.closeAlertAndGetItsText());
		// ����ó������Ϣ
		createCustomer.OverseasContact(OSName, selectArea1);
		Thread.sleep(1000);
		assertEquals("����ɹ�", action.closeAlertAndGetItsText());
		// ֤����Ϣҳ��
		createCustomer.licenseInfo(jpgPath1, jpgPath2);
		Thread.sleep(2000);
		assertTrue(createCustomer.getNewCustomerName().contains("customer"));
	}

	@Test
	// �½��ͻ���Ϣ���ϴ�ͼƬ�;�����Ϣ������ݸ�
	public void test02() throws Exception {
		TAction action = new TAction(driver, baseUrl);
		// ��¼
		driver.get(baseUrl);
		LoginWzPage loginwz = new LoginWzPage(driver, baseUrl);
		loginwz.loginStep(username, password);
		Thread.sleep(3000);
		assertTrue(driver.getCurrentUrl().contains("welcome"));
		// �����ͻ���һҳ
		CreateCustomerPage createCustomer = new CreateCustomerPage(driver,
				baseUrl);
		createCustomer.createFirstPage(customerEditUrl, customerN, visibleText, comAddress,comTel);
		Thread.sleep(1000);
		assertEquals("��ӳɹ�", action.closeAlertAndGetItsText());
		// �����ͻ��ڶ�ҳ
		createCustomer.createSecondPage(comAddress, captialNum, moneyText, RegistrationNo, Entity, id, comTel, testEmail, CustomerServiceExe, industry ,Tnum, testword, Tnum2, selectStype);
		Thread.sleep(1000);
		// ������Ϣҳ
		createCustomer.Cooperative(Num);
		// ��ϵ����Ϣҳ
		createCustomer.contactMessage(testName, testMNumber, testEmail);
		Thread.sleep(1000);
		assertEquals("����ɹ�", action.closeAlertAndGetItsText());
		// ����ó������Ϣ����д
		// ֤����Ϣ����д
		createCustomer.getSaveDraft().click();
		Thread.sleep(2000);
		assertEquals("�ݸ屣��ɹ�", action.closeAlertAndGetItsText());		
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
