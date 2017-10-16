package productMngPage;

import org.openqa.selenium.WebDriver;

import action.TAction;
import basepage.HomePage;

public class ProductMngPage extends HomePage {

	public ProductMngPage(WebDriver driver, String url) {
		super(driver, url);
		driver.get(url);
	}

	public void createStep(String baseUrl, String username, String password, String customerId, String productName, String brandName, String model, String price, String unit1) throws InterruptedException {
		// ��¼		
		this.loginStep(username, password);
		// ���׼��->��Ʒ����->������Ʒ
		this.createProductEntry();
		TAction tAction = new TAction(driver);
		// ������Ʒҳ�����ͻ�
		tAction.findElementClick("name", "customerName");
		// ͨ��id������ѡ������˵Ŀͻ�
		tAction.findElementSendKeys("id", "search_EQ_customerCode", customerId);
		tAction.findElementClick("xpath", "//form/div[1]/div/div[3]/button");
		tAction.findElementClick("name", "checked");
		tAction.findElementClick("xpath",
				"//div/div[@class='modal-footer']/button[1]");
		// ����Ʒ��,Ʒ�ƣ��ͺŵ�
		tAction.findElementSendKeys("name", "productName", productName);
		tAction.findElementSendKeys("name", "brandName", brandName);
		tAction.findElementSendKeys("name", "model", model);
		tAction.findElementSendKeys("name", "price", price);

		tAction.webList("//form[@name='$parentForm']/descendant::select[2]")
				.selectByVisibleText(unit1);
		tAction.findElementSendKeys("xpath",
				"//form/div/div[11]/div/div/textarea", customerId);
		// �л�����ƷͼƬҳ
		tAction.findElementClick("xpath",
				"//section[2]/div/div/div[1]/ul/li[2]/a");
		// �ϴ�ͼƬ���ҵ��ű��µ�inputֱ�Ӵ�ͼƬ·����
		tAction.findElementSendKeys("xpath", "//body/label[1]/input",
				"C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
		tAction.sleep(2000);
		tAction.webButton("//div/button-group/div/button[1]").click();
		tAction.sleep(1000);
		tAction.clickAlertSure();
		tAction.sleep(1000);
		tAction.clickAlertSure();
		tAction.sleep(1000);
		tAction.findElementClick("xpath", "//section[2]/div/ul/li[2]/a");
	}

}
