package com.example.yenphuong.bonus2;

import java.util.ArrayList;

/**
 * Created by yenphuong on 4/27/17.
 */

public class XuLyKetQua {
    public int maTinh;
    public ArrayList<KetQuaXoSo> ketqua;

    public XuLyKetQua(int maTinh1){
        this.maTinh = maTinh1;
    }

    public ArrayList<KetQuaXoSo> getJsonContent(){
        if (maTinh == 0){
            ketqua = new ArrayList<KetQuaXoSo>();

        }
        return  ketqua;
    }
}
