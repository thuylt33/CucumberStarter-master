package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class FontMaster_page {
	private WebDriver driver;
	
	
	@FindBy(xpath="//div[@class='footer']//input")
	public WebElement txtEmail;
	@FindBy(xpath="//div[@class='footer']//button")
	public WebElement btnGuiMail;
	
	@FindBy(xpath="//div[@class='footer']//span")
	public WebElement mailErr;
	//Checkk Form 
	@FindBy(xpath="//*[@id=\"popover\"]/div[1]/p[1]/b")
	public WebElement statusNewSus;

	//Thong bao khi nhap mail ton tai dang ky
	@FindBy(xpath="//div[@class='modal fade in popover-dialog alert']//div[@class='body-message']")
	public WebElement mailTonTaiMess;
	
	////Form thong tin mo
	
	
	@FindBy(xpath="//div[@class='modal fade popover-dialog form extra-subscription-form in']//p/input")
	public WebElement txtHoten;
	
	@FindBy(xpath="//div[@class='modal fade popover-dialog form extra-subscription-form in']//button[@id='ddlGender']/span[1]")
	public WebElement lbGioiTinhMD;
	
	@FindBy(xpath="//button[@id='ddlGender']//span[2]")
	public WebElement dropdownGioiTinh;
	
	@FindBy(xpath="//ul[@aria-labelledby='ddlGender']/li/a")
	public WebElement GioiTinhNam;

	@FindBy(xpath="//button[@id='ddlNewsType']//span[2]")
	public WebElement dropdownLoaiTin;
	
	@FindBy(xpath="//ul[@aria-labelledby='ddlNewsType']/li[2]/a")
	public WebElement ValueLoaiTin;
	

	@FindBy(xpath="//div[@class='modal fade popover-dialog form extra-subscription-form in']//button[@id='ddlNewsType']/span[1]")
	public WebElement lbLoaiTinMD;
	//de trong ho ten
	@FindBy(xpath="//div[@class='popover-body']//div[@class ='error']")
	public WebElement txtMessHoTenRequired;
	
	@FindBy(xpath="//*[@id=\"allow-button\"]")
	public WebElement btnDongY;
	//message err when nhap hoten co ky tu dac biet
	@FindBy(xpath="")
	public WebElement MessValidateHoTen;
	
	
	
	public FontMaster_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
