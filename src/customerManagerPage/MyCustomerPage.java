package customerManagerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import action.TAction;
import basepage.HomePage;

public class MyCustomerPage extends HomePage{

	public MyCustomerPage(WebDriver driver, String url) {
		super(driver, url);
		driver.get(url);
	}
	
	By draft = By.xpath("//section[2]/div/ul/li[1]/a");//�ݸ�	
	By pending = By.xpath("//div/section[2]/div/ul/li[2]/a");//�����
	
	By customerIdInput = By.id("search_LIKE_customerCode");//�ͻ����������
	By customerNameInput = By.id("search_LIKE_customerName");//�ͻ����������
	By serviceAgent = By.id("search_LIKE_customerServiceExecutive");//�ͻ�רԱ
	By taxTypeSelect = By.xpath("//div/select[1]");//��ҵ����
	
	By date = By.id("reservation");//����ʱ��
	By startDayinput = By.name("daterangepicker_start");//��ʼʱ��
	By endDayinput = By.name("daterangepicker_end");//����ʱ��
	
	By dateSubmit = By.xpath("//form/div/div/div[3]/div/div/div/div/div/div/i");
	By searchButton = By.xpath("//*[@id='toolbar']/button[1]");//��ѯ��ť
	By resetButton = By.xpath("//*[@id='toolbar']/button[2]");//���ð�ť
	
	By idResult = By.xpath("//*[@id='simpletable']/tbody/tr[1]/td[1]");
	By nameResult = By.xpath("//*[@id='simpletable']/tbody/tr[1]/td[2]");
	By dateResult = By.xpath("//*[@id='simpletable']/tbody/tr[1]/td[4]");
	By companyTypeResult = By.xpath("//*[@id='simpletable']/tbody/tr[1]/td[3]");
	By customerServiceResult = By.xpath("//*[@id='simpletable']/tbody/tr[1]/td[5]");
	
	public WebElement getDraft(){
		return driver.findElement(draft);
	}
	public WebElement getPending(){
		return driver.findElement(pending);
	}
	
	public WebElement getCustomerIdInput(){
		return driver.findElement(customerIdInput);
	}
	public WebElement getCustomerNameInput(){
		return driver.findElement(customerNameInput);
	}
	public WebElement getServiceAgent(){
		return driver.findElement(serviceAgent);
	}
	public WebElement getTaxType(){
		return driver.findElement(taxTypeSelect);
	}
	public WebElement getdate(){
		return driver.findElement(date);
	}
	public WebElement getStartDayinput(){
		return driver.findElement(startDayinput);
	}
	public WebElement getEndDayinput(){
		return driver.findElement(endDayinput);
	}
	public WebElement getDateSubmit(){
		return driver.findElement(dateSubmit);
	}	
	public WebElement getSearchButton(){
		return driver.findElement(searchButton);
	}
	public WebElement getResetButton(){
		return driver.findElement(resetButton);
	}
	//�׸����������Ԫ�ض�λ
	public WebElement getIdResult(){
		return driver.findElement(idResult);
	}
	public WebElement getNameResult(){
		return driver.findElement(nameResult);
	}
	public WebElement getDateResult(){
		return driver.findElement(dateResult);
	}
	public WebElement getCompanyTypeResult(){
		return driver.findElement(companyTypeResult);
	}
	public WebElement getCustomerServiceResult(){
		return driver.findElement(customerServiceResult);
	}
	
	//�����׸���������еĴ�������10λ����
	public String fristCreateDate(){
		String createDate = getDateResult().getText();
		String createDt = createDate.substring(0, 10);
		createDt = createDt.replace("-", "");
		return createDt;
	}
	
	String customerID ="100";
	String customerName="customer";
	String agent = "�ͻ�רԱ";
	String visibleText = "һ����˰��";
	String startDay = "2017-01-01";
	String endDay = "2017-10-01";
	String myCustomerUrl = "http://192.168.101.192:81/wz/customer/list";
	
	public void gotoMyCustomerByUrl(){
		TAction taction = new TAction(driver);
		taction.goTo(myCustomerUrl);
	}
	//�����ҳ����id
	public void idSearch2(String customerID) throws InterruptedException{
		getPending().click();
		getCustomerIdInput().sendKeys(customerID);
		Thread.sleep(2000);
		getSearchButton().click();
	}
		
	//�ݸ�ҳ
	public void idSearch(String customerID) throws InterruptedException{
		getDraft().click();//����ݸ�ҳ
		getCustomerIdInput().sendKeys(customerID);
		Thread.sleep(2000);
		getSearchButton().click();
	}
	public void nameSearch(String customerName) throws InterruptedException{
		getDraft().click();
		getCustomerNameInput().sendKeys(customerName);
		Thread.sleep(2000);
		getSearchButton().click();
	}
	public void agentSearch(String agent) throws InterruptedException{
		getDraft().click();
		getServiceAgent().sendKeys(agent);
		Thread.sleep(2000);
		getSearchButton().click();
	}
		
	public void TaxTypeSearch(String visibleText) throws InterruptedException{		
		getDraft().click();
		new Select(getTaxType()).selectByVisibleText(visibleText);
		Thread.sleep(2000);
		getSearchButton().click();
	}
	public void dateSearch(String startDay, String endDay) throws InterruptedException{

		getDraft().click();
		getdate().click();
		getStartDayinput().clear();
		getStartDayinput().sendKeys(startDay);
		getEndDayinput().clear();
		getEndDayinput().sendKeys(endDay);
		getDateSubmit().click();
		Thread.sleep(2000);
		getSearchButton().click();
	}
}
