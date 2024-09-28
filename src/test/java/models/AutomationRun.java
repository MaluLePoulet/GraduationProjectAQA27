package models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class AutomationRun {

    private int id;
    private String name;
    private String source;
    private int status;

    @SerializedName("project_id")
    private int projectId;

    @SerializedName("source_id")
    private int sourceId;

    @SerializedName("is_completed")
    private boolean isCompleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutomationRun that = (AutomationRun) o;
        return status == that.status && projectId == that.projectId && sourceId == that.sourceId && isCompleted == that.isCompleted && Objects.equals(name, that.name) && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, source, status, projectId, sourceId, isCompleted);
    }

    @Override
    public String toString() {
        return "AutomationRun{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", status=" + status +
                ", projectId=" + projectId +
                ", sourceId=" + sourceId +
                ", isCompleted=" + isCompleted +
                '}';
    }
}