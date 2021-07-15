package ir.mk.learnx.model;

public class SubCourseList {
    private int id;
    private int lesson;
    private int courseId;
    private String title;
    private String progress;
    private int imageId;



    public SubCourseList(int id, int lesson, int courseId, String title, String progress, int imageId) {
        this.id = id;
        this.lesson = lesson;
        this.courseId = courseId;
        this.title = title;
        this.progress = progress;
        this.imageId = imageId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }
}
