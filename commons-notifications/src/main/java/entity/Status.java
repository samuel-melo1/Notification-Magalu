package entity;

public class Status {

    private Long statusId;
    private String description;
    public Status(){
    }
    public Status(Long statusId, String description) {
        this.statusId = statusId;
        this.description = description;
    }
    public Long getStatusId() {
        return statusId;
    }
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}