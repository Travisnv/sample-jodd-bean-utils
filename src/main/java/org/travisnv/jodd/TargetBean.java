package org.travisnv.jodd;

import java.util.List;

/**
 * Target bean which have nested object
 */
public class TargetBean {
    String name;
    String description;
    List<String> tasks;

    List<NestedObject> nestedObjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<NestedObject> getNestedObjects() {
        return nestedObjects;
    }

    public void setNestedObjects(List<NestedObject> nestedObjects) {
        this.nestedObjects = nestedObjects;
    }

    @Override
    public String toString() {
        return "TargetBean{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", nestedObjects=" + nestedObjects +
                '}';
    }
}
