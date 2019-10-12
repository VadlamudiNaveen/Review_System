package info.androidhive.firebase.global;

import android.app.Application;

public class Global extends Application {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String aEmail) {
        email = aEmail;
    }
}
