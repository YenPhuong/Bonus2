package com.example.yenphuong.bonus2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yenphuong on 4/27/17.
 */

public class KetQuaAdapter extends BaseAdapter{
    Context myContext;
    int myLayout;
    List<KetQuaXoSo> arrayKetqua;

    public KetQuaAdapter(Context context, int layout, List<KetQuaXoSo> mangKetqua){
        myContext = context;
        myLayout = layout;
        arrayKetqua = mangKetqua;
    }
    @Override
    public int getCount() {
        return arrayKetqua.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout, null);

        TextView txtNgay = (TextView)convertView.findViewById(R.id.textViewNgayXoSo);
        txtNgay.setText(arrayKetqua.get(position).NgayXoSo);

        TextView txtgiai1 = (TextView)convertView.findViewById(R.id.textViewGiai1);
        txtNgay.setText(arrayKetqua.get(position).Kq1);

        TextView txtgiai2 = (TextView)convertView.findViewById(R.id.textViewGiai2);
        txtNgay.setText(arrayKetqua.get(position).Kq2);

        TextView txtgiai3 = (TextView)convertView.findViewById(R.id.textViewGiai3);
        txtNgay.setText((CharSequence) arrayKetqua.get(position).Kq3);

        TextView txtgiai4 = (TextView)convertView.findViewById(R.id.textViewGiai4);
        txtNgay.setText((CharSequence) arrayKetqua.get(position).Kq4);

        TextView txtgiai5 = (TextView)convertView.findViewById(R.id.textViewGiai5);
        txtNgay.setText(arrayKetqua.get(position).Kq5);

        TextView txtgiai6 = (TextView)convertView.findViewById(R.id.textViewGiai6);
        txtNgay.setText((CharSequence) arrayKetqua.get(position).Kq6);

        TextView txtgiai7 = (TextView)convertView.findViewById(R.id.textViewGiai7);
        txtNgay.setText(arrayKetqua.get(position).Kq7);

        TextView txtgiai8 = (TextView)convertView.findViewById(R.id.textViewGiai1);
        txtNgay.setText(arrayKetqua.get(position).Kq8);


        return convertView;
    }
}
