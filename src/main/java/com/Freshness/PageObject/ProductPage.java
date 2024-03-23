package com.Freshness.PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Freshness.actiondriver.Action;
import com.github.javafaker.Faker;
import com.Freshness.Base.Base;

public class ProductPage extends Base{

	Action action = new Action();
    Faker faker = new Faker();
	
    String titletext = faker.lorem().characters(15, 20);
    String editedtitletext = faker.lorem().characters(31, 40);
    String Price = Integer.toString(faker.number().numberBetween(31, 99));
	
	@FindBy(xpath = "//input[@name='file']")
	private WebElement upload_file;
	
	@FindBy(name = "title")
	private WebElement title;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/div[2]/div[2]/input")
	private WebElement description;
	
	@FindBy(name = "price")
	private WebElement price;
	
	@FindBy(xpath = "//button[normalize-space()='Create Product']")
	private WebElement submit_button;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit_button1;
	
    @FindBy(xpath = "//div[@class='sc-kuWgmH brWvPg mt-4 cursor-pointer']")
	private List<WebElement> product_titles;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public void createproduct() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    String projectPath = System.getProperty("user.dir");
	    action.uploadFile(upload_file,projectPath + "\\Jacket.png");
		action.typestring(title, titletext);
		action.typestring(description, editedtitletext);
		action.typestring(price, Price);
		Thread.sleep(5000);
		action.click(driver, submit_button);
	}
	
	public boolean searchProduct() throws InterruptedException {
	    Thread.sleep(10000);
	    boolean found = false;
	    for (int i = 0; i < product_titles.size(); i++) {
	        String result = product_titles.get(i).getText();
	        if (result.equals(titletext) || result.equals(editedtitletext)) {
	            found = true;
	            break;
	        }
	    }
	    return found;
	}

	public void editProduct() throws InterruptedException {
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", title);
		action.typestring(title, titletext);
		Thread.sleep(5000);
		action.click(driver, submit_button1);
	}
}
