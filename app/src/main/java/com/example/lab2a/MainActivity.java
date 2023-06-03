package com.example.lab2a;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        checkBox = findViewById(R.id.checkBox);

        button.setOnClickListener(v -> {
            String inputText = editText.getText().toString();
            textView.setText(inputText);


            String toastMessage = getResources().getString(R.string.toast_message);
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
        });



        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String status = isChecked ? "on" : "off";
            String message = "The checkbox is now " + status;

            Snackbar snackbar = Snackbar.make(buttonView, message, Snackbar.LENGTH_LONG);
            snackbar.setAction("Undo", v -> checkBox.setChecked(!isChecked));
            snackbar.show();
        });
    }
}