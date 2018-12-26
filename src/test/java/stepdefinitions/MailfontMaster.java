package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.DataHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.FontMaster_page;

public class MailfontMaster {
	WebDriver driver;
	FontMaster_page fontMasterPage;
	public List<HashMap<String,String>> datamap;

	
	public MailfontMaster() {
		 this.driver=Hooks.driver;
		 this.fontMasterPage=new FontMaster_page(this.driver);
			datamap = DataHelper.data(System.getProperty("user.dir")+"//src//test//resources//testData/default.xlsx","Sheet1");

	}
	
	@Given("I stayed at testmaster homepage")
	public void i_stayed_at_testmaster_homepage() {
		this.driver.get("http://testmaster.vn/");
		this.driver.manage().window().maximize();
	    this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	}
	@When("I provide invalid mail {string} and click DangKy")
	public void i_provide_invalid_mail_and_click_DangKy(String string) {
		this.fontMasterPage.txtEmail.clear();
		this.fontMasterPage.txtEmail.sendKeys(string);
		this.fontMasterPage.btnGuiMail.click();
	    this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("I should see the err message for invalid mail")
	public void i_should_see_the_err_message_for_invalid_mail() {
		String s = "* Email không đúng định dạng";
		String s1 = this.fontMasterPage.mailErr.getText();
		assertEquals(s1, s);
	   
	}

	@When("I provide  existed account {string} and press Enter")
	public void i_provide_existed_account_and_press_Enter(String string) {
		this.fontMasterPage.txtEmail.clear();
		this.fontMasterPage.txtEmail.sendKeys(string);
		this.fontMasterPage.btnGuiMail.click();
	    this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	   
	}

	@Then("I should see the Exited_Mail message {string}")
	public void i_should_see_the_Exited_Mail_message(String string) {
		String s1 = this.fontMasterPage.mailTonTaiMess.getText();
		System.out.println(s1);
		String s2="E-mail "+string+ " đã được sử dụng, bạn hãy chọn một E-mail khác";
		assertEquals(s2,s1);
	   
	}
	
	
	@When("I provide not existed account {string} and press Enter")
	public void i_provide_not_existed_account_and_press_Enter(String string) throws InterruptedException {
		Date today = new Date();

		// formatting date in Java using SimpleDateFormat
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyHHmmSS");
		String date = DATE_FORMAT.format(today);
		System.out.println("Today in ddMMyyHHmmSS format : " + date);

		String s = date + string;
		System.out.println("Today in ddMMyyHHmmSS format : " + date + "nhap s  " + s);

		this.fontMasterPage.txtEmail.clear();
		this.fontMasterPage.txtEmail.sendKeys(s);
		Thread.sleep(4000);
		this.fontMasterPage.btnGuiMail.click();

		
		
		
		
	   
	}

	@Then("I should see the extra information is opened")
	public void i_should_see_the_extra_information_is_requested() throws InterruptedException {
		Thread.sleep(3000);
		//WebElement element = (new WebDriverWait(this.driver, 15))
		//		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"popover\"]/div[1]/p[1]/b")));
		//this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String s1 = this.fontMasterPage.statusNewSus.getText();
		
		Assert.assertEquals("Để phục vụ bạn được tốt hơn, bạn vui lòng cung cấp thêm các thông tin bên dưới.", s1);  
	   
	}

	@Then("I see  default value gender {string} and newsletter {string}")
	public void i_see_default_value_and(String string, String string2) {
		String lbGioiTinhMD = this.fontMasterPage.lbGioiTinhMD.getText();
		Assert.assertEquals(lbGioiTinhMD, string);

		String lbLoaiTinMD = this.fontMasterPage.lbLoaiTinMD.getText();
		Assert.assertEquals(lbLoaiTinMD, string2); 
	   
	}

	@When("I provide null_Name")
	public void i_provide_null_Name() {
		this.fontMasterPage.txtHoten.clear();
		//Thread.sleep(3000);
		
 
	   
	}

	@When("I provide gender")
	public void i_provide_gender() throws InterruptedException {
		Thread.sleep(3000);
		this.fontMasterPage.dropdownGioiTinh.click(); 
		Thread.sleep(3000);

		this.fontMasterPage.GioiTinhNam.click();
	   
	}

	@When("I provide newsletter")
	public void i_provide_newsletter() throws InterruptedException {
		Thread.sleep(3000);

		this.fontMasterPage.dropdownLoaiTin.click();
		Thread.sleep(3000);

		this.fontMasterPage.ValueLoaiTin.click();
	   
	}

	@When("T press btn DongY")
	public void t_press_btn_DongY() throws InterruptedException {
		this.fontMasterPage.btnDongY.click();
  
		Thread.sleep(5000);
	   
	}

	@Then("I should requested_Name message")
	public void i_should_requested_Name_message() {
		String txtMessHoTenRequired = this.fontMasterPage.txtMessHoTenRequired.getText();
		Assert.assertEquals(txtMessHoTenRequired, "This is required field");
	   
	}

	@When("I provide Name {string}")
	public void i_provide_Name(String string) {
		this.fontMasterPage.txtHoten.sendKeys(string);
		
	   
	}

	@Then("I should success alert")
	public void i_should_success_alert() {
	/*	// Get a handle to the open alert, prompt or confirmation
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert or prompt
		String s=alert.getText(); 
		System.out.println(alert.getText());
		
		Assert.assertEquals(s, "success");
		
		*/
		//switch_window(driver,"");
		
		String s= driver.findElement(By.xpath("//*[@id=\"popover\"]/div[1]/div[2]")).getText();
		System.out.println(s);
		Assert.assertEquals("Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký", s);
		
		//datamap.add(e)
		
	}



}
