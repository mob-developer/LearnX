package ir.mk.learnx.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import ir.mk.learnx.Home;
import ir.mk.learnx.R;
import ir.mk.learnx.model.Account;

public class SignUpActivity extends AppCompatActivity {
    private static final int SELECT_PICTURE = 100;
    private static ImageView imageView;
    private Uri profilePictureUri = Uri.EMPTY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button button = findViewById(R.id.sign_up_button);
        EditText usernameField = findViewById(R.id.sign_up_username);
        EditText emailField = findViewById(R.id.sign_up_email_field);
        EditText passwordField = findViewById(R.id.sign_up_password_field);
        EditText firstNameField = findViewById(R.id.sign_up_first_name);
        EditText lastNameField = findViewById(R.id.sign_up_last_name);
        imageView = findViewById(R.id.sign_up_profile_picture);
        imageView.setOnClickListener(v -> {
            openImageChooser();
        });


        button.setOnClickListener(v -> {
            if (!usernameField.getText().toString().isEmpty() && !emailField.getText().toString().isEmpty() &&
                    !getStringFromField(passwordField).isEmpty() && !firstNameField.getText().toString().isEmpty() &&
                    !getStringFromField(lastNameField).isEmpty()) {
                Account account = new Account(firstNameField.getText().toString(), lastNameField.getText().toString(),
                        0, 0, usernameField.getText().toString(),
                        passwordField.getText().toString(), emailField.getText().toString(), 0,
                profilePictureUri);
                Account.loginUser(getStringFromField(usernameField), getStringFromField(passwordField));
                Toast.makeText(this, "حساب کاربری با موفقیت ساخته شد", Toast.LENGTH_LONG).show();
                Intent i = new Intent(SignUpActivity.this, Home.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "خطایی رخ داده است دوباره تلاش کنید", Toast.LENGTH_LONG).show();
            }

        });


    }

    public String getStringFromField(EditText editText){
        return editText.getText().toString();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SignUpActivity.this, LandingPageActivity.class);
        startActivity(i);
    }

    public void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    imageView.setImageURI(null);
                    imageView.setImageURI(selectedImageUri);
                    imageView.setCropToPadding(true);
                    this.profilePictureUri = selectedImageUri;
                }
            }
        }
    }
}