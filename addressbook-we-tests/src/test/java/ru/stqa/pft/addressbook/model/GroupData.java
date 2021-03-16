package ru.stqa.pft.addressbook.model;

public class GroupData {
    private final String groupName;
    private final String formHeader;
    private final String formFooter;

    public GroupData(String groupName, String formHeader, String formFooter) {
        this.groupName = groupName;
        this.formHeader = formHeader;
        this.formFooter = formFooter;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getFormHeader() {
        return formHeader;
    }

    public String getFormFooter() {
        return formFooter;
    }
}
