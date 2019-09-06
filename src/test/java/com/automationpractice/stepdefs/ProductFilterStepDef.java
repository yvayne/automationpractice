package com.automationpractice.stepdefs;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ProductFilterPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Step definitions for product filter.
 */
public class ProductFilterStepDef {
    private HomePage homePage;
    private ProductFilterPage productFilterPage;

    /**
     * Initializes an object {@link ProductFilterStepDef}.
     *
     * @param homePage          Home Page Object.
     * @param productFilterPage Product Filter Page Object.
     */
    public ProductFilterStepDef(final HomePage homePage, final ProductFilterPage productFilterPage) {
        this.homePage = homePage;
        this.productFilterPage = productFilterPage;
    }

    /**
     * Helps to  select a tab.
     *
     * @param tabName tab name.
     */
    @Given("I select {string} Tab")
    public void iSelectTab(final String tabName) {
        homePage.selectTab(tabName);
    }

    /**
     * Helps to select a category.
     *
     * @param categoryName category name.
     */
    @Given("I select {string} category")
    public void iSelectCategory(final String categoryName) {
        productFilterPage.selectCategory(categoryName);

    }

    /**
     * Helps to select a subcategory.
     *
     * @param subcategoryName subcategory name.
     */
    @Given("I select {string} subcategory")
    public void iSelectSubcategory(final String subcategoryName) {
        productFilterPage.selectSubCategory(subcategoryName);
    }

    /**
     * Helps to select a dress size.
     *
     * @param sizeFilter dress size.
     */
    @When("I select size {string} check box")
    public void iSelectSizeCheckBox(final String sizeFilter) {
        productFilterPage.selectSizeFilter(sizeFilter);
    }

    /**
     * Helps to select a color check box.
     *
     * @param colorFilter color name.
     */
    @When("I select {string} color check box")
    public void iSelectColorCheckBox(final String colorFilter) {
        productFilterPage.selectColorFilter(colorFilter);
    }

    /**
     * Helps to select an option from dropdown.
     *
     * @param option option value.
     */
    @When("I select {string} option in Sort By dropdown")
    public void iSelectOptionInSortByDropdown(final String option) {
        productFilterPage.selectOptionInSortByDropdown(option);
    }

    /**
     * Helps to verify the price for an specific product.
     *
     * @param productName          product name.
     * @param expectedCurrentPrice expected price.
     */
    @Then("Verify that {string} is displayed with a price of {string}")
    public void verifyThatIsDisplayedWithAPriceOf(final String productName, final String expectedCurrentPrice) {
        assertEquals(productFilterPage.getCurrentPrice(productName), expectedCurrentPrice);
    }

    /**
     * Helps to verify that listed items are sorted ascending by price.
     */
    @Then("Verify that the listed items have ascendant ordering by the price")
    public void verifyThatTheListedItemsHaveAscendantOrderingByThePrice() {
        List<String> currentPrices = productFilterPage.getCurrentPrices();
        List<String> sortedPrices = productFilterPage.getSortedPrices();
        assertEquals(currentPrices, sortedPrices);
    }
}
