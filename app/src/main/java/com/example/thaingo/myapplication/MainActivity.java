package com.example.thaingo.myapplication;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ListActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String[] countries = new String[]{"Vietnam", "Russia", "US", "Malaysia", "Japan"};

    ListView listView = getListView();

    listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    ListAdapter countriesAdapter =
        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, countries);
    listView.setAdapter(countriesAdapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s = ((TextView) view).getText() + " " + position;
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
      }
    });
  }
}
