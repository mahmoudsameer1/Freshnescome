package com.Freshness.PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Freshness.actiondriver.Action;
import com.Freshness.Base.Base;

public class HomePage extends Base{


	Action action = new Action();
	String actualtitle ="Stainless Steel Pots Deep Set 10 pieces";
	
	@FindBy(css = "a[href='/add'] > svg")
	private WebElement add_button;
	
	@FindBy(xpath = "//button[@class='sc-crozmw jrDktB flex justify-center items-center h-9 w-9 transition ease-in-out delay-150 duration-300']")
	private List<WebElement> edit_button;
	
	@FindBy(css = ".sc-gxYJeL")
	private WebElement search;
	
	@FindBy(xpath = "//div[@class='sc-kuWgmH brWvPg mt-4 cursor-pointer']")
	private List<WebElement> product_titles;
	
	@FindBy(xpath = "//div[@class='sc-kuWgmH brWvPg mt-4 cursor-pointer']")
	private WebElement product_title;
	
	@FindBy(xpath = ".//button[@class='sc-crozmw sc-jJTsDX jrDktB TnOul flex justify-center items-center h-9 w-9 transition ease-in-out delay-150 duration-300']")
	private List<WebElement> delete_product;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void createNewProductButton() {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		action.click(driver, add_button);
	}
	
	public void editLastProduct() throws InterruptedException {
	    Thread.sleep(3000);
	    WebElement lastEditButton = edit_button.get(edit_button.size() - 1);
	    action.click(driver, lastEditButton);
	}
	
	public void searchForProduct() throws InterruptedException {
	
		action.typestring(search, actualtitle);
		Thread.sleep(5000);
		String expectedTitle = action.getText(product_title);
		Assert.assertEquals(actualtitle, expectedTitle);

	}
	
	public void searchProduct() throws InterruptedException {
	    action.typestring(search,"Degree");
	    Thread.sleep(5000);
	    boolean searchTermFound = false;
	    for (int i = 0; i < product_titles.size(); i++) {
	        String result = product_titles.get(i).getText();
	        if (result.contains("Degree")) {
	            searchTermFound = true;
	        } else {
	            searchTermFound = false;
	            break;
	        }
	    }
	    Assert.assertTrue(searchTermFound, "Search term 'Degree' not found in any product title");
	}
    
    public void deleteproduct() throws InterruptedException {
    	
        Thread.sleep(3000);
        int beforeDeletionCount = product_titles.size();
        WebElement lastDeleteButton = delete_product.get(delete_product.size() - 1);
        action.click(driver, lastDeleteButton);
        Thread.sleep(3000);
        int afterDeletionCount = product_titles.size();
        Assert.assertEquals(afterDeletionCount, beforeDeletionCount - 1, "Product deletion failed.");
	}

}
