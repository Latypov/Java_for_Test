package my.javapr.addressbook.tests;

import my.javapr.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by allan on 2/29/2016.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();


  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}