package com.Freshness.HomePageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Freshness.PageObject.HomePage;
import com.Freshness.PageObject.ProductPage;
import com.Freshness.Base.Base;

public class HomePageTest extends Base{

	private static HomePage homepage;
	private static ProductPage productPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Test(priority=1,description="Add a new product and verify it’s added successfully")
	public void createNewProduct() throws InterruptedException{
	    homepage = new HomePage();
	    productPage = new ProductPage();
	    homepage.createNewProductButton();
	    productPage.createproduct();
	    boolean productFound = productPage.searchProduct();
	    Assert.assertTrue(productFound, "Newly created product not found");
	}
	
	@Test(priority=2,description="Edit a product and verify it’s edited successfully")
	public void editeProduct() throws InterruptedException{
	    homepage = new HomePage();
	    productPage = new ProductPage();
	    homepage.editLastProduct(); // Edit the last added product
	    productPage.editProduct();
	    boolean productFound = productPage.searchProduct();
	    Assert.assertTrue(productFound, "Edited product not found");
	}
	
	@Test(priority=3,description="Delete a product and verify it’s deleted successfully")
	public void deleteProduct() throws InterruptedException{
		homepage = new HomePage();
		homepage.deleteproduct();
	}
	
	
	@Test(priority=4,description="Search for a product and verify the search results")
	public void searchForOneProduct() throws InterruptedException{
		homepage = new HomePage();
		homepage.searchForProduct();
	}
	
	@Test(priority=5,description="Use a search keyword that matches multiple products and verify the results")
	public void searchproduct() throws InterruptedException {
		homepage = new HomePage();
		homepage.searchProduct();
	}
}
