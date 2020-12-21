package com.example.pythonsum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    EditText Et1,Et2;
    Button Btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et1 = (EditText)findViewById(R.id.et1);
        Et2 = (EditText)findViewById(R.id.et2);
        Btn = (Button)findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);

        if(!Python.isStarted())
        {
            Python.start(new AndroidPlatform(this));
        }
        final Python py = Python.getInstance();
        PyObject pyobj = py.getModule("script");
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PyObject obj = pyobj.callAttr("main",Et1.getText().toString(),Et2.getText().toString());
                tv.setText(obj.toString());
            }
        });
    }
}