package com.wimsonevel.androidmvp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wimsonevel.androidmvp.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView tvEmail;

    public static void start(Context context, User user) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.class.getSimpleName(), user);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmail = (TextView) findViewById(R.id.tv_email);

        User user = getIntent().getParcelableExtra(MainActivity.class.getSimpleName());
        tvEmail.setText(user.getEmail());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
