package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private String searchKey;

    @BeforeTest
    @Parameters({"searchKey"})
    public void setupParameter(String searchKey) {
        this.searchKey = searchKey;
    }

    @Test
    public void googleSearchTest() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(searchKey);
        int resultCount = searchPage.getResult();
        Assert.assertTrue(resultCount > 0);
    }


}
