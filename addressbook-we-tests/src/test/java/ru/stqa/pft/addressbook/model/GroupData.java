package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
    private String id;
    private String groupName;
    private String formHeader;
    private String formFooter;

    public GroupData withId(String id) {
        this.id = id;
        return this;
    }

    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withFormHeader(String formHeader) {
        this.formHeader = formHeader;
        return this;
    }

    public GroupData withFormFooter(String formFooter) {
        this.formFooter = formFooter;
        return this;
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
