package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends NavigationHelper {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void create(GroupData groupData) {
        click(By.name("new"));
        fillGroupForm(groupData);
        click(By.name("submit"));
        groupPage();
    }

    public void modify(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupPage();
    }

    public void delete(int index) {
        selectGroup(index);
        deleteSelectedGroups();
        groupPage();
    }

    public void deleteSelectedGroups() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }

    public void fillGroupForm(GroupData groupData) {
        fillField(By.name("group_name"), groupData.getGroupName());
        fillField(By.name("group_header"), groupData.getFormHeader());
        fillField(By.name("group_footer"), groupData.getFormFooter());
    }

    public List<GroupData> groupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            GroupData group = new GroupData()
                    .withId(id)
                    .withGroupName(name);
            groups.add(group);
        }
        return groups;
    }

    public boolean isGroupPresents() {
        return isElementPresent(By.name("selected[]"));
    }

    public void selectGroup(int index) {
        try {
            driver.findElements(By.name("selected[]")).get(index).click();
        } catch (IndexOutOfBoundsException ex) {
            driver.findElements(By.name("selected[]")).get(0).click();
        }

    }

}
