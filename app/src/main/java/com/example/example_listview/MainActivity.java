package com.example.example_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     ListView lvnhanvien;
     EditText edtName, edtNamSinh;
     RadioButton rbNam, rbNu;
     Button btnThem;

     private List<NhanVien > mNhanViens;
     private NhanVienAdapter mNhanVienAdapter;
    private  NhanVien nhanVien;

     private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UI_SETUP();

        mNhanViens = new ArrayList<>();
        mNhanVienAdapter = new NhanVienAdapter(MainActivity.this, mNhanViens, R.layout.custom_employee);

        rbNam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (CompoundButton buttonView, boolean ischecked) {
                rbNu.setChecked(false);
            }
        });

        rbNu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (CompoundButton buttonView, boolean ischecked) {
                rbNam.setChecked(false);
            }
        });

        btnThem.setOnClickListener(this);
    }

    private void UI_SETUP() {
        lvnhanvien = (ListView) findViewById(R.id.lv_NhanVIen);
        edtNamSinh = (EditText) findViewById(R.id.edt_Birthday);
        edtName = (EditText) findViewById(R.id.edt_Name);
        rbNam = (RadioButton) findViewById(R.id.rb_Nam);
        rbNu = (RadioButton) findViewById(R.id.rb_Nu);
        btnThem = (Button) findViewById(R.id.btn_Them);
    }

    public void Xoa(final int i){
        Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        mNhanViens.remove(i);
        mNhanVienAdapter.notifyDataSetChanged();
    }

    public void Sua(final int i){
        Toast.makeText(this, "Sửa NV", Toast.LENGTH_SHORT).show();
        final NhanVien nhanVien = mNhanViens.get(i);

        View dialogSheetView = LayoutInflater.from(MainActivity.this).inflate(R.layout.edit_nhanvien, null);
        BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);
        dialog.setContentView(dialogSheetView);

        final EditText edtNhanVien = (EditText) dialogSheetView. findViewById(R. id.edt_Name);
        final EditText edtNamSinh = (EditText) dialogSheetView.findViewById (R. id.edt_Birthday);
        final RadioButton rbNam = (RadioButton) dialogSheetView.findViewById(R. id.rb_Nam);
        final RadioButton rbNu = (RadioButton) dialogSheetView. findViewById(R.id.rb_Nu);
        Button btnCapNhat = (Button) dialogSheetView. findViewById(R. id.btn_CapNhat);

        edtNhanVien.setText(mNhanViens.get(i).getName());
        edtNamSinh.setText(mNhanViens.get(i).getBirthday());

        if (mNhanViens.get(i).getSex().equals("Nam")){
            rbNam.setChecked(true);
        }else{
            rbNam.setChecked(true);
        }

        if(rbNam.isChecked()){
            sex="Nam";
            nhanVien.setHinhanh(R.drawable.man);
            nhanVien.setSex(sex);
        }else {
            sex="Nữ";
            nhanVien.setHinhanh(R.drawable.woman);
            nhanVien.setSex(sex);
        }

        rbNam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rbNu.setChecked(false);
            }
        });

        rbNu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rbNam.setChecked(false);
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Ten = edtNhanVien.getText().toString().trim();
                final String Namsinh = edtNamSinh.getText().toString().trim();
                nhanVien.setName(Ten);
                nhanVien.setBirthday(Namsinh);
                mNhanVienAdapter.notifyDataSetChanged();
                lvnhanvien.setAdapter(mNhanVienAdapter);
            }
        });

        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Them:
                final String name = edtName.getText().toString().trim();
                final String birthday = edtNamSinh.getText().toString().trim();


                if(rbNam.isChecked()){
                    sex = "Nam";
                    nhanVien = new NhanVien(name, birthday, sex, R.drawable.man);
                }else {
                    sex="Nữ";
                    nhanVien = new NhanVien(name, birthday, sex, R.drawable.woman);
                }

                mNhanViens.add(nhanVien);
                lvnhanvien.setAdapter(mNhanVienAdapter);
                mNhanVienAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }
}