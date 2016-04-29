package my.javapr.addressbook.tests;

import my.javapr.addressbook.appmanager.ApplicationManager;
import my.javapr.addressbook.model.ContactData;
import my.javapr.addressbook.model.Contacts;
import my.javapr.addressbook.model.GroupData;
import my.javapr.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by allan on 2/29/2016.
 */
@Listeners(MyTestListener.class)
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));


  @BeforeSuite
  public void setUp(ITestContext context) throws Exception {
    app.init();
    context.setAttribute("app", app);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  //Edit Configuration: VM options:   -ea -DverifyUI=true
  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  //Edit Configuration: VM options:   -ea -DverifyUI=true
  public void verifyContactListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream().map((g) -> new ContactData().withId(g.getId()).withFirstname(g.getFirstname())
              .withLastname(g.getLastname()).withMobilePhone(g.getMobilePhone()
                      .replaceAll("\\s+", ""))).collect(Collectors.toSet())));
    }
  }
}