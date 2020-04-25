package com.example.subform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubFormActivity extends AppCompatActivity {
    private Button subButton;
    private Button clearButton;
    private TextView name;
    private TextView email;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_form);
        subButton = findViewById(R.id.subButton);
        clearButton = findViewById(R.id.clearButton);
        textView = findViewById(R.id.formTextView);
        name = findViewById(R.id.nameEditText);
        email = findViewById(R.id.mailEditText);
        clearAction();
        subAction();
    }

    public void subAction() {
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pattern pattern = Pattern.compile("^[\\w-_.]*[\\w-_.]@[\\w].+[\\w]+[\\w]$");
                Matcher matcher = pattern.matcher(email.getText());
                if (matcher.matches()) {
                    textView.setText(String.format(
                            getString(R.string.subText),
                            name.getText(),
                            email.getText()));
                    name.setText("");
                    email.setText("");
                } else {
                    textView.setText(R.string.errorTextView);
                }
            }
        });
    }

    public void clearAction() {
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                textView.setText(R.string.formTextView);
            }
        });
    }
}
