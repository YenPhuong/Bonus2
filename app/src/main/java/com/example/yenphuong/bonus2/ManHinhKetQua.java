package com.example.yenphuong.bonus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ManHinhKetQua extends AppCompatActivity {
    String tinh;

    ListView lvKetQuaTinh;
    TextView textViewPosition;
    Integer vitri;
    ArrayList<String> ngay;
    String maTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_ket_qua);

        lvKetQuaTinh = (ListView)findViewById(R.id.listViewKetQuaTinh);
        textViewPosition = (TextView)findViewById(R.id.textViewKqTinh);
        ngay = new ArrayList<String>();

        Bundle bundle = getIntent().getExtras();
        vitri = bundle.getInt("tinh");
        switch (vitri){
            case 0: tinh = "An Giang";
                    maTinh = "AG";
                    ngay.add("20-04");
                    break;
            case 1: tinh = "Binh Duong";
                    maTinh = "BD";
                    ngay.add("14-04");
                    ngay.add("21-04");
                    break;
            case 2: tinh = "Bac Lieu";
                    maTinh = "BL";
                    ngay.add("18-04");
                    ngay.add("25-04");
                    break;
            case 3: tinh = "Binh Phuoc";
                    maTinh = "BP";
                    ngay.add("15-04");
                    ngay.add("22-04");
                    break;
            case 4: tinh = "Binh Thuan";
                    maTinh = "BTH";
                    ngay.add("20-04");
                    break;
            case 5: tinh = "Ca Mau";
                    maTinh = "CM";
                    ngay.add("17-04");
                    ngay.add("24-04");
                    break;
            case 6: tinh = "Can Tho";
                    maTinh = "CT";
                    ngay.add("19-04");
                    ngay.add("26-04");
                    break;
            case 7: tinh = "Thanh Pho Ho Chi Minh";
                    maTinh = "HCM";
                    ngay.add("17-04");
                    ngay.add("22-04");
                    ngay.add("24-04");
                    break;

        }

        textViewPosition.setText(tinh);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ngay);
        lvKetQuaTinh.setAdapter(adapter1);

        lvKetQuaTinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent2to3 = new Intent(ManHinhKetQua.this, ManHinhKetQua2.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("maTinh", maTinh);
                bundle2.putString("tinh", tinh);
                bundle2.putString("ngay", ngay.get(position));
                intent2to3.putExtras(bundle2);
                startActivity(intent2to3);

            }
        });
    }
}
