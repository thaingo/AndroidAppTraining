package com.example.thaingo.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

  public static final String EXTRA_MESSAGE = "com.example.thaingo.myapplication.MESSAGE";
  public static final String REQUEST_RESULT = "REQUEST_RESULT";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void sendMessageIntent(View view) {
    Intent intent = new Intent(this, DisplayMessageActivity.class);
    EditText editText = findViewById(R.id.editText);
    String message = editText.getText().toString();
    intent.putExtra(EXTRA_MESSAGE, message);

    startActivityForResult(intent, 1);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    if (resultCode == RESULT_OK) {
      Toast.makeText(this, Integer.toString(intent.getIntExtra(REQUEST_RESULT, 0)), Toast.LENGTH_LONG).show();
    }
  }

  public void launchBuiltInAppIntent(View view) {
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse("https://www.google.com.vn"));
    startActivity(intent);
  }
}
