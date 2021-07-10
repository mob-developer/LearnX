package ir.mk.learnx.model;

public class CourseList {
    private int id;
    private String title;
    private String progress;
    private int imageId;

    public CourseList(int id, String title, String progress, int imageId) {
        this.id = id;
        this.title = title;
        this.progress = progress;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
