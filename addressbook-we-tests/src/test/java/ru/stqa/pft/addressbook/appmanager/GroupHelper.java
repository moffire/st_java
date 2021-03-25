package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
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

    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<GroupData>();
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

    public void selectGroupById(String id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

}
