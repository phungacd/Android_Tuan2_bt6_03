package com.example.android_tuan2_bt6_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtten;
    TextView kqchon;
    Button btnnhap;
    ListView lstview;
    ArrayList<String> arrayList = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtten = findViewById(R.id.txtTen);
        kqchon = findViewById(R.id.txtselection);

        lstview = findViewById(R.id.lvperson);

        //Tạo  arrayList object
        arrayList = new ArrayList<String>();

        // Gán data source (Arraylist object ) vào ArrayAdapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);

        // Gán Adapter vào ListView
        lstview.setAdapter(adapter);

        btnnhap = findViewById(R.id.btnNhap);
        // Xử lý sự kiện  nút nhập
        btnnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(txtten.getText()+"");
                adapter.notifyDataSetChanged();

            }
        });

        lstview.setOnItemClickListener(new AdapterView
                .OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> arg0,View arg1,
                    int arg2,long arg3) {

                kqchon.setText("position : "+ arg2+
                        "; value ="+arrayList.get(arg2));
            }
        });

        lstview.setOnItemLongClickListener(new AdapterView
                .OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                arrayList.remove(arg2);//xóa phần tử thứ arg2
                adapter.notifyDataSetChanged();
                return false;
            }
        });


    }
}
