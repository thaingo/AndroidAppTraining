package com.example.thaingo.myapplication;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ListActivity {
  /*ListView listView;
  String[] countries = new String[]{"Vietnam", "Russia", "US", "Malaysia", "Japan"};*/
  /*int[] flagId =
      new int[]{R.drawable.flag_vn, R.drawable.flag_ru, R.drawable.flag_us, R.drawable.flag_my, R.drawable.flag_jp};*/

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String[] countries = new String[]{"Vietnam", "Russia", "US", "Malaysia", "Japan"};

   /* setContentView(R.layout.activity_main);
    listView = findViewById(R.id.listCountries);*/

    ListAdapter countriesAdapter =
        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
    setListAdapter(countriesAdapter);
    getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s = ((TextView) view).getText() + " " + position;
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
      }
    });
  }
}
