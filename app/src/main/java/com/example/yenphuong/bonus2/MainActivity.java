package com.example.yenphuong.bonus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTinh;
    ArrayList<String> arrayTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTinh = (ListView)findViewById(R.id.listViewTinh);
        arrayTinh = new ArrayList<String>();

        arrayTinh.add("An Giang");
        arrayTinh.add("Binh Duong");
        arrayTinh.add("Bac Lieu");
        arrayTinh.add("Binh Phuoc");
        arrayTinh.add("Binh Thuan");
        arrayTinh.add("Ca Mau");
        arrayTinh.add("Can Tho");
        arrayTinh.add("Thanh Pho Ho Chi Minh");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayTinh);
        lvTinh.setAdapter(adapter);

        lvTinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1to2 = new Intent(MainActivity.this, ManHinhKetQua.class);
                Bundle bundle = new Bundle();
                bundle.putInt("tinh",position);
                intent1to2.putExtras(bundle);
                startActivity(intent1to2);

            }
        });
        //xuly = new XuLyKetQua(positionTinh);
        //xuly.getJsonContent();


    }





}
