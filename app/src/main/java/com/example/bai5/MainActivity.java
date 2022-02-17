package com.example.bai5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText tongkh,doanhthu,tongkhvip,thanhtien,soluong,tenKH;
    CheckBox khvip;
    Button tinhtt,tiep,thongke,thoat;
    ArrayList<KhachHang>kh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tenKH = findViewById(R.id.et_tenkh);
        soluong = findViewById(R.id.et_soluong);
        thanhtien = findViewById(R.id.et_thanhtien);
        tongkhvip = findViewById(R.id.et_khvip);
        tongkh = findViewById(R.id.et_tongkh);
        doanhthu = findViewById(R.id.et_tongdoanhthu);
        khvip = findViewById(R.id.chb_khvip);
        tinhtt = findViewById(R.id.btn_tinhtt);
        tiep = findViewById(R.id.btn_tiep);
        thongke = findViewById(R.id.btnthongke);
        thoat = findViewById(R.id.btn_thoat);
        kh = new ArrayList<KhachHang>();

        tinhtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(khvip.isChecked()==true){
                    int tt = (Integer.parseInt(soluong.getText().toString())*20000)*90/100;
                    KhachHang a = new KhachHang();
                    a.setTenKH(tenKH.getText().toString());
                    a.setSoLuong(Integer.parseInt(soluong.getText().toString()));
                    a.setThanhTien(tt);
                    a.setVip(true);
                    kh.add(a);
                    thanhtien.setText(Integer.toString(tt));
                }else if(khvip.isChecked()==false){
                    int tt = (Integer.parseInt(soluong.getText().toString())*20000);
                    KhachHang a = new KhachHang();
                    a.setTenKH(tenKH.getText().toString());
                    a.setSoLuong(Integer.parseInt(soluong.getText().toString()));
                    a.setThanhTien(tt);
                    a.setVip(false);
                    kh.add(a);
                    thanhtien.setText(Integer.toString(tt));
                }
            }
        });
        tiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenKH.requestFocus();
            }
        });
        thongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tongkh.setText(Integer.toString(kh.size()));
                int tongvip = 0;
                int dt = 0;
                for (KhachHang khachhang:kh) {
                    dt += khachhang.getThanhTien();
                    if(khachhang.getVip()==true){
                        tongvip++;
                    }
                }
                tongkhvip.setText(Integer.toString(tongvip));
                doanhthu.setText(Integer.toString(dt));
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Xác nhận");
                builder.setMessage("Bạn có chắc muốn thoát?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}