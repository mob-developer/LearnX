package ir.mk.learnx.model;

public class Server {
//    public static String serverUrl = "http://192.168.43.191:80/learnx/";
    public static final int grade = 9;

    public static final String serverUrl = "http://learnx.himino.ir/";
    public static final String serverUrlLearnMovie = serverUrl + "learn/"+grade+"/";
    public static final String serverUrlQuiz = serverUrl + "quiz/learn.php?q=9";
    public static final String serverUrlSteps = serverUrl + "learn/step.php?q=9";

}
