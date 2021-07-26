package ir.mk.learnx.model;

import android.net.Uri;

import java.util.ArrayList;

public class Account {
    private static ArrayList<Account> allAccount = new ArrayList<>();
    private static Account loggedInAccount = null;
    // for each account
    private final String firstName;
    private final String lastName;
    private final int age;
    private final int phoneNumber;
    private final String username;
    private final String password;
    private final String email;
    private final Uri profilePictureUri;
    private int score;

    public Account(String firstName, String lastName, int age, int phoneNumber, String username, String password, String email, int score, Uri profilePictureUri) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.email = email;
        this.score = score;
        this.profilePictureUri = profilePictureUri;
        allAccount.add(this);
    }

    public static ArrayList<Account> getAllAccount() {
        return allAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }



    public static String loginUser(String username, String password) {
        for (Account account : allAccount) {
            if (account.username.equals(username)) {
                if (account.password.equals(password)) {
                    loggedInAccount = account;
                    return "successful";
                } else
                    return "invalid password";
            }
        }

        return "invalid username";


    }

    public static void setLoggedInAccount(Account loggedInAccount) {
        Account.loggedInAccount = loggedInAccount;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static Account getLoggedInAccount() {
        return loggedInAccount != null ? loggedInAccount : new Account("میهمان","",
                0,0,"","","",0, Uri.EMPTY);
    }

    public Uri getProfilePictureUri() {
        return profilePictureUri;
    }
}
