package com.example.yenphuong.bonus2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ManHinhKetQua2 extends AppCompatActivity {
    String maTinh, ngay, tinhx, kq1, kq2, kq3, kq4, kq5, kq6, kq7, kq8, kqdb, tvtieude;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tvdb, tvtd;
    ArrayList<String> listLv;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_ket_qua2);

        tv1 = (TextView) findViewById(R.id.textViewGiai1);
        tv2 = (TextView) findViewById(R.id.textViewGiai2);
        tv3 = (TextView) findViewById(R.id.textViewGiai3);
        tv4 = (TextView) findViewById(R.id.textViewGiai4);
        tv5 = (TextView) findViewById(R.id.textViewGiai5);
        tv6 = (TextView) findViewById(R.id.textViewGiai6);
        tv7 = (TextView) findViewById(R.id.textViewGiai7);
        tv8 = (TextView) findViewById(R.id.textViewGiai8);
        tvdb = (TextView) findViewById(R.id.textViewGiaiDb);

        tvtd = (TextView) findViewById(R.id.textViewNgayXoSo);

        lv = (ListView)findViewById(R.id.lvkq);

        Bundle bundle3 = getIntent().getExtras();
        this.maTinh = bundle3.getString("maTinh").toString();
        this.ngay = bundle3.getString("ngay").toString();
        this.tinhx = bundle3.getString("tinh").toString();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new getKetQuaXoSo().execute("http://thanhhungqb.tk:8080/kqxsmn");
            }
        });
    }

    class getKetQuaXoSo extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            //Toast.makeText(ManHinhKetQua2.this, tinhx, Toast.LENGTH_LONG).show();

            try {
                listLv = new ArrayList<String>();


                JSONObject root = new JSONObject(s);
                JSONObject ngayx = root.getJSONObject(maTinh);
                JSONObject tinh = ngayx.getJSONObject(ngay);
                JSONArray ketqua1 = tinh.getJSONArray("1");
                kq1 = "Giai 1: \n" + ketqua1.getString(0);
                JSONArray ketqua2 = tinh.getJSONArray("2");
                kq2 = "Giai 2: \n" + ketqua2.getString(0);
                JSONArray ketqua3 = tinh.getJSONArray("3");
                kq3 = "Giai 3: ";
                for (int i = 0; i < ketqua3.length(); i++){
                    kq3 = kq3 + "\n" + ketqua3.getString(i);
                }
                JSONArray ketqua4 = tinh.getJSONArray("4");
                kq4 = "Giai 4: ";
                for (int j = 0; j < ketqua4.length(); j++){
                    kq4 = kq4 + "\n" + ketqua4.getString(j);
                }
                JSONArray ketqua5 = tinh.getJSONArray("5");
                kq5 = "Giai 5: \n" + ketqua5.getString(0);
                JSONArray ketqua6 = tinh.getJSONArray("6");
                kq6 = "Giai 6: ";
                for (int k = 0; k < ketqua6.length(); k++){
                    kq6 = kq6 + "\n" + ketqua6.getString(k);
                }
                JSONArray ketqua7 = tinh.getJSONArray("7");
                kq7 = "Giai 7: \n" + ketqua7.getString(0);
                JSONArray ketqua8 = tinh.getJSONArray("8");
                kq8 = "Giai 8: \n" + ketqua8.getString(0);
                JSONArray ketquadb = tinh.getJSONArray("DB");
                kqdb = "Giai Dac Biet: \n" + ketquadb.getString(0);

                tvtieude = tinhx + " Ngay " + ngay;

                listLv.add(tvtieude);
                listLv.add(kq1);
                listLv.add(kq2);
                listLv.add(kq3);
                listLv.add(kq4);
                listLv.add(kq5);
                listLv.add(kq6);
                listLv.add(kq7);
                listLv.add(kq8);
                listLv.add(kqdb);

                ArrayAdapter adapter = new ArrayAdapter(
                        ManHinhKetQua2.this,
                        android.R.layout.simple_list_item_1,
                        listLv
                );

                lv.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    private static String docNoiDung_Tu_URL(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}


