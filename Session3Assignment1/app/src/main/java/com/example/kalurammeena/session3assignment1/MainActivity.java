package com.example.kalurammeena.session3assignment1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private EditText mSearch;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearch=(EditText)findViewById(R.id.searchText);
        mButton=(Button) findViewById(R.id.search);

        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String dataSearch = mSearch.getText().toString();
                Intent intent=new Intent();
                intent.setAction(intent.ACTION_VIEW);
                try {
                    dataSearch=URLEncoder.encode(dataSearch,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                intent.setData(Uri.parse("https://www.google.co.in/#q="+dataSearch));
                startActivity(intent);
            }

        });
    }
}
