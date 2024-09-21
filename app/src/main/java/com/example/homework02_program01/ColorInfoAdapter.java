package com.example.homework02_program01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorInfoAdapter extends BaseAdapter {
    MainActivity m = new MainActivity();
    Context context;
    ArrayList<ColorInfo> listOfColors;
    public ColorInfoAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }
    @Override
    public int getCount() {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }
        //Establishing the GUI elements from the custom cell
        TextView cCredWord, cCredNum, cCgreenWord, cCgreenNum, cCblueWord, cCblueNum;
        TextView cChexWord, cChexVal;
        cCredWord = view.findViewById(R.id.tv_custom_redWord);
        cCredNum = view.findViewById(R.id.tv_customCell_redNum);
        cCgreenWord = view.findViewById(R.id.tv_customCell_greenWord);
        cCgreenNum = view.findViewById(R.id.tv_customCell_greenNum);
        cCblueWord = view.findViewById(R.id.tv_customCell_blueWord);
        cCblueNum = view.findViewById(R.id.tv_customCell_blueNum);
        cChexWord = view.findViewById(R.id.tv_customCell_hexWord);
        cChexVal = view.findViewById(R.id.tv_customCell_hexValue);
        return null;
    }
}
