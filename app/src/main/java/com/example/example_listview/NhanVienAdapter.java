package com.example.example_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class NhanVienAdapter extends BaseAdapter {

    private MainActivity mContext;
    private List<NhanVien> mNhanViens;
    private int layout;

    public NhanVienAdapter(MainActivity mContext, List<NhanVien> mNhanViens, int layout) {
        this.mContext = mContext;
        this.mNhanViens = mNhanViens;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return mNhanViens.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View  convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        ImageView imageHinh = (ImageView) convertView.findViewById(R.id.img_hinh);
        TextView tv_Name = (TextView) convertView.findViewById(R.id.tv_Name);
        TextView tv_Birthday = (TextView) convertView.findViewById(R.id.tv_Birthdate);
        TextView tv_Sex = (TextView) convertView.findViewById(R.id.tv_Sex);
        ImageButton Img_Sua = (ImageButton) convertView.findViewById(R.id.img_Sua);
        ImageButton Img_Xoa = (ImageButton) convertView.findViewById(R.id.img_Xoa);


        NhanVien nhanVien = mNhanViens.get(i);
        tv_Name.setText(nhanVien.getName());
        tv_Birthday.setText(nhanVien.getBirthday());
        tv_Sex.setText(nhanVien.getSex());
        imageHinh.setImageResource(nhanVien.getHinhanh());

        Img_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.Sua(i);
            }
        });

        Img_Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.Xoa(i);
            }
        });
        return convertView;
    }
}
