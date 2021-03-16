package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
      driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      String baseUrl = "http://localhost/addressbook/group.php";
      driver.get(baseUrl);
      login(new GroupLogin("admin", "secret"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private void login(GroupLogin groupLogin) {
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys(groupLogin.getAdmin());
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys(groupLogin.getSecret());
      driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    protected void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
      driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).clear();
      driver.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).clear();
      driver.findElement(By.name("group_header")).sendKeys(groupData.getFormHeader());
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).clear();
      driver.findElement(By.name("group_footer")).sendKeys(groupData.getFormFooter());
    }

    protected void initGroupCreation() {
      driver.findElement(By.name("new")).click();
    }

    protected void gotoGroupPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    protected void deleteSelectedGroups() {
      driver.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
    }

    protected void selectGroup() {
      driver.findElement(By.name("selected[]")).click();
    }
}
