package ir.mk.learnx.model;

public class Server {
    //    public static String serverUrl = "http://192.168.43.191:80/learnx/";
    public static final int GRADE = 9;

    public static final String SERVER_URL = "http://learnx.himino.ir/";
    public static final String SERVER_URL_LEARN_MOVIE = SERVER_URL + "learn/" + GRADE + "/";
    public static final String SERVER_URL_LEARN_QUIZ = SERVER_URL + "quiz/learn.php?q=" + GRADE;
    public static final String SERVER_URL_QUIZ = SERVER_URL + "quiz/quiz.php?q=" + GRADE;
    public static final String SERVER_URL_STEPS = SERVER_URL + "learn/step.php?q=" + GRADE;

}
