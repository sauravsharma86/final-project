package pojo;

public class Content {

    private long contentId;
    private long uploaderId;
    private String uploadedTime;
    private String fileName;
    private String description;

    public Content(long contentId, long uploaderId, String uploadedTime, String fileName, String description) {
        this.contentId = contentId;
        this.uploaderId = uploaderId;
        this.uploadedTime = uploadedTime;
        this.fileName = fileName;
        this.description = description;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public long getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(long uploaderId) {
        this.uploaderId = uploaderId;
    }

    public String getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime(String uploadedTime) {
        this.uploadedTime = uploadedTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
