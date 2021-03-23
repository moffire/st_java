package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
    private final String id;
    private final String groupName;
    private final String formHeader;
    private final String formFooter;

    public GroupData(String id, String groupName, String formHeader, String formFooter) {
        this.id = id;
        this.groupName = groupName;
        this.formHeader = formHeader;
        this.formFooter = formFooter;
    }

    public GroupData(String groupName, String formHeader, String formFooter) {
        this.id = null;
        this.groupName = groupName;
        this.formHeader = formHeader;
        this.formFooter = formFooter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(id, groupData.id) && Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                '}';
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
