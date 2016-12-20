package test;

import com.grid.BaseTestGrid;
import com.grid.WebDriverInstansiator;
import com.pageobjects.GooglePage;
import org.testng.annotations.*;

/**
 * Created by Serhii_Pirohov on 23.06.2015.
 */
public class TestGoogleSearch extends BaseTestGrid {

    GooglePage googlePage;

    @BeforeMethod
    public void setUp() {
        googlePage = new GooglePage(WebDriverInstansiator.getDriver());
    }

    @Test
    public void shouldBeBlogTitle() {
        googlePage.open();
        googlePage.search("automation remarks");

    }
}
