package com.Freshness.PageObject;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Freshness.actiondriver.Action;
import com.github.javafaker.Faker;
import com.Freshness.Base.Base;

public class ProductPage extends Base{
	
	public ProductPage() {
		 PageFactory.initElements(driver, this);
	}

	Action action = new Action();
	
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
	
	@FindBy(xpath = "//button[@class='sc-crozmw jrDktB flex justify-center items-center h-9 w-9 transition ease-in-out delay-150 duration-300']")
	private List<WebElement> edit_button;
	
    @FindBy(xpath = "//div[@class='sc-kuWgmH brWvPg mt-4 cursor-pointer']")
	private List<WebElement> product_titles;

	public void createproduct(String textTitle,String descriptiontext, String Price) throws InterruptedException {
        File file = new File("Jacket.png");
        String filePath = file.getAbsolutePath();
		action.uploadFile(upload_file, filePath);
		action.typestring(title, textTitle);
		action.typestring(description, descriptiontext);
		action.typestring(price, Price);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(submit_button));
		action.click(driver, submit_button);
	}
	
//	public void editProduct(String textTitle, String editedTitle) throws InterruptedException {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(driver -> {
//	        List<String> titles = product_titles.stream().map(WebElement::getText).collect(Collectors.toList());
//	        return titles.contains(textTitle);
//	    });
//	    WebElement lastEditButton = edit_button.get(edit_button.size() - 1);
//	    action.click(driver, lastEditButton);
//		Thread.sleep(5000);
//		title.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//		action.typestring(title, editedTitle);
//		action.click(driver, submit_button1);
//	}
//}

}