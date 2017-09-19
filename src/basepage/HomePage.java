package basepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import loginWz.LoginWzPage;

public class HomePage extends LoginWzPage {

	public HomePage(WebDriver driver, String url) {
		super(driver, url);
		driver.get(url);
	}
	
	By admittance = By.xpath("//header[@class='main-header']/nav/div[@class='btn-group']/button[1]");//׼��
	By customerManager = By.xpath("//section/ul/li[2]/a/span[1]");//�ͻ�����
	By createCustomer = By.linkText("�����ͻ�");//�����ͻ�
	By myCustomer = By.xpath("//section[@class='sidebar']/ul/li[2]/ul/li[2]/a");//�ҵĿͻ�
	By productManager = By.xpath("//aside/section/ul/li[3]/a/span[1]");//��Ʒ����
	By createProduct = By.xpath("//aside/section/ul/li[3]/ul/li[1]/a");//������Ʒ
	By productList = By.xpath("//section/ul/li[3]/ul/li[2]/a");//��Ʒ�б�
	By drawerManager = By.xpath("//section/ul/li[4]/a/span[1]");//��Ʊ�˹���
	By createDrawer= By.xpath("//section/ul/li[4]/ul/li[1]/a");//������Ʊ��
	By drawerList= By.xpath("//section/ul/li[4]/ul/li[2]/a");//��Ʊ���б�
	By customerInquiry= By.xpath("//section/ul/li[5]/a/span[1]");//�ͻ���ѯ
	By customerList= By.xpath("//section/ul/li[5]/ul/li/a");//�ͻ��б�
	
	public WebElement getadmittance(){
		return driver.findElement(admittance);
	}	
	public WebElement getcustomerManager(){
		return driver.findElement(customerManager);
	}
	public WebElement getCreateCustomer(){
		return driver.findElement(createCustomer);
	}	
	public WebElement getMyCustomer(){
		return driver.findElement(myCustomer);
	}
	
	public WebElement getProductManager(){
		return driver.findElement(productManager);
	}
	public WebElement getCreateProduct(){
		return driver.findElement(createProduct);
	}
	public WebElement getProductList(){
		return driver.findElement(productList);
	}
	public WebElement getDrawerManager(){
		return driver.findElement(drawerManager);
	}
	public WebElement getCreateDrawer(){
		return driver.findElement(createDrawer);
	}
	public WebElement getDrawerList(){
		return driver.findElement(drawerList);
	}
	public WebElement getCustomerInq(){
		return driver.findElement(customerInquiry);
	}
	public WebElement getCustomerList(){
		return driver.findElement(customerList);
	}
	
		
	//�����ͻ����
	public void createCustomer() throws InterruptedException{
		getadmittance().click();
		getcustomerManager().click();
		Thread.sleep(1000);
		getCreateCustomer().click();
	}
	//�ҵĿͻ����
	public void myCustomerEntry() throws InterruptedException{
		getadmittance().click();
		getcustomerManager().click();
		Thread.sleep(1000);
		getMyCustomer().click();
	}
	//������Ʒ���
	public void createProductEntry() throws InterruptedException{
		getadmittance().click();
		getProductManager().click();
		Thread.sleep(1000);
		getCreateProduct().click();
	}
	//��Ʒ�б����
	public void ProductListEntry() throws InterruptedException{
		getadmittance().click();
		getProductManager().click();
		Thread.sleep(1000);
		getProductList().click();
	}
	
	//������Ʊ�����
	public void createDrewerEntry() throws InterruptedException {
		getadmittance().click();
		getDrawerManager().click();
		Thread.sleep(1000);
		getCreateDrawer().click();
	}

	// ��Ʊ���б����
	public void drewerListEntry() throws InterruptedException {
		getadmittance().click();
		getDrawerManager().click();
		Thread.sleep(1000);
		getDrawerList().click();
	}
	
	// �ͻ���ѯ�б����
	public void customerList() throws InterruptedException {
		getadmittance().click();
		getCustomerInq().click();
		Thread.sleep(1000);
		getCustomerList().click();
	}
}
