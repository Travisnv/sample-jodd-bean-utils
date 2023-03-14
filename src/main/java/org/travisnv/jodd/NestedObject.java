package org.travisnv.jodd;

import java.util.List;

/**
 * Nested class which is field of TargetBean
 */
public class NestedObject {
    String nestedField;
    int nestedPrimitive;

    List<String> tasks;

    public String getNestedField() {
        return nestedField;
    }

    public void setNestedField(String nestedField) {
        this.nestedField = nestedField;
    }

    public int getNestedPrimitive() {
        return nestedPrimitive;
    }

    public void setNestedPrimitive(int nestedPrimitive) {
        this.nestedPrimitive = nestedPrimitive;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "NestedObject{" +
                "nestedField='" + nestedField + '\'' +
                ", nestedPrimitive=" + nestedPrimitive +
                ", tasks=" + tasks +
                '}';
    }
}
