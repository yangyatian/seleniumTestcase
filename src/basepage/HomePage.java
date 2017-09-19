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
	
	By admittance = By.xpath("//header[@class='main-header']/nav/div[@class='btn-group']/button[1]");//准入
	By customerManager = By.xpath("//section/ul/li[2]/a/span[1]");//客户管理
	By createCustomer = By.linkText("创建客户");//创建客户
	By myCustomer = By.xpath("//section[@class='sidebar']/ul/li[2]/ul/li[2]/a");//我的客户
	By productManager = By.xpath("//aside/section/ul/li[3]/a/span[1]");//产品管理
	By createProduct = By.xpath("//aside/section/ul/li[3]/ul/li[1]/a");//新增产品
	By productList = By.xpath("//section/ul/li[3]/ul/li[2]/a");//产品列表
	By drawerManager = By.xpath("//section/ul/li[4]/a/span[1]");//开票人管理
	By createDrawer= By.xpath("//section/ul/li[4]/ul/li[1]/a");//新增开票人
	By drawerList= By.xpath("//section/ul/li[4]/ul/li[2]/a");//开票人列表
	By customerInquiry= By.xpath("//section/ul/li[5]/a/span[1]");//客户查询
	By customerList= By.xpath("//section/ul/li[5]/ul/li/a");//客户列表
	
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
	
		
	//创建客户入口
	public void createCustomer() throws InterruptedException{
		getadmittance().click();
		getcustomerManager().click();
		Thread.sleep(1000);
		getCreateCustomer().click();
	}
	//我的客户入口
	public void myCustomerEntry() throws InterruptedException{
		getadmittance().click();
		getcustomerManager().click();
		Thread.sleep(1000);
		getMyCustomer().click();
	}
	//新增产品入口
	public void createProductEntry() throws InterruptedException{
		getadmittance().click();
		getProductManager().click();
		Thread.sleep(1000);
		getCreateProduct().click();
	}
	//产品列表入口
	public void ProductListEntry() throws InterruptedException{
		getadmittance().click();
		getProductManager().click();
		Thread.sleep(1000);
		getProductList().click();
	}
	
	//新增开票人入口
	public void createDrewerEntry() throws InterruptedException {
		getadmittance().click();
		getDrawerManager().click();
		Thread.sleep(1000);
		getCreateDrawer().click();
	}

	// 开票人列表入口
	public void drewerListEntry() throws InterruptedException {
		getadmittance().click();
		getDrawerManager().click();
		Thread.sleep(1000);
		getDrawerList().click();
	}
	
	// 客户查询列表入口
	public void customerList() throws InterruptedException {
		getadmittance().click();
		getCustomerInq().click();
		Thread.sleep(1000);
		getCustomerList().click();
	}
}
