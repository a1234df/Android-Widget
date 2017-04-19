package com.app.spinner2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView ListView01;
    private TextView TextView01;
    String[] s1 =
            { "", "", "Android", "IOS", "I9000", "IMax", "NANO", "P1000","Android1", "Nokia3300", "", "" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView01 = (ListView) findViewById(R.id.ListView01);
        TextView01 = (TextView) findViewById(R.id.TextView01);

        ArrayAdapter<String> list1 = new ArrayAdapter<String>(this,
                R.layout.file_row, s1);
        ListView01.setAdapter(list1);
        ListView01.setCacheColorHint(00000000);
        ListView01.setFastScrollEnabled(true);
        ListView01.setFadingEdgeLength(100);
        ListView01.setOnScrollListener(new ListView.OnScrollListener()
        {
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount)
            {
                // TODO Auto-generated method stub
                TextView01.setText(s1[firstVisibleItem + 2]);
            }

            public void onScrollStateChanged(AbsListView view, int scrollState)
            {
                // TODO Auto-generated method stub
            }
        });
        ListView01.setOnItemClickListener(new ListView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int id,
                                    long arg3)
            {
                // TODO Auto-generated method stub
                ListView01.setSelectionFromTop(id - 2, 0);
                TextView01.setText(s1[id]);
            }
        });
        ListView01.setOnItemSelectedListener(new ListView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View v,
                                       int id, long arg3)
            {
                // TODO Auto-generated method stub
                TextView01.setText(s1[id]);
            }

            public void onNothingSelected(AdapterView<?> arg0)
            {
                // TODO Auto-generated method stub
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.spinner, menu);
        return true;
    }
}
