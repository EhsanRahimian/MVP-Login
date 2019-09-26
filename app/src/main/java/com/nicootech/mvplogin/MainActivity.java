package com.nicootech.mvplogin;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nicootech.mvplogin.Presenter.ILoginPresenter;
import com.nicootech.mvplogin.Presenter.LoginPresenter;
import com.nicootech.mvplogin.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    EditText edt_email, edt_password;
    Button btn_Login;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial View
        btn_Login = findViewById(R.id.btn_login);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);

        //Initial
        loginPresenter = new LoginPresenter(this);

        //Event
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edt_email.getText().toString(),edt_password.getText().toString());
            }
        });
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this, message,Toast.LENGTH_SHORT).show();

    }
}
