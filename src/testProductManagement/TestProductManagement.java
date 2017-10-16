package testProductManagement;

import static org.junit.Assert.*;
import action.TAction;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import productMngPage.ProductMngPage;

public class TestProductManagement {

	WebDriver driver;
	String baseUrl = "http://192.168.101.192:81/wz/login";
	String username = "yyt";
	String password = "123456";
	String productName = "testProduct";
	String brandName = "brandName";
	String model = "test_1999";
	String price = "199";
	String customerId = "10124";
	String unit1 = "��";

	TAction tAction;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		tAction = new TAction(driver);
		tAction.goTo(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@After
	public void tearDown() throws Exception {
		tAction = new TAction(driver);
		tAction.quit();
	}

	// ����������Ʒ
	@Test
	public void testCreateProduct() throws InterruptedException {
		ProductMngPage productMng = new ProductMngPage(driver, baseUrl);
		//����������Ʒ����
		productMng.createStep(baseUrl, username, password, customerId, productName, brandName, model, price, unit1);
		//���Դ����Ĳ�Ʒ�����Ƿ����б���
		assertTrue(tAction.findElement("xpath", "//tbody/tr[1]/td[3]")
				.getText().equals(productName));
	}

}
