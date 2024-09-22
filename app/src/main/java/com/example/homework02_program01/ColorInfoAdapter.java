package com.example.homework02_program01;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ColorInfoAdapter extends BaseAdapter {
    Context context;
    ArrayList<ColorInfo> listOfColors;
    public ColorInfoAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context         = c;
        listOfColors    = ls;
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
            LayoutInflater mInflater    = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view                        = mInflater.inflate(R.layout.custom_cell, null);
        }
        //Establishing the GUI elements from the custom cell
        TextView cCredWord, cCredNum, cCgreenWord, cCgreenNum, cCblueWord, cCblueNum;
        TextView cChexWord, cChexVal;
        ConstraintLayout customCellBackground;

        cCredWord               = view.findViewById(R.id.tv_custom_redWord);
        cCredNum                = view.findViewById(R.id.tv_customCell_redNum);
        cCgreenWord             = view.findViewById(R.id.tv_customCell_greenWord);
        cCgreenNum              = view.findViewById(R.id.tv_customCell_greenNum);
        cCblueWord              = view.findViewById(R.id.tv_customCell_blueWord);
        cCblueNum               = view.findViewById(R.id.tv_customCell_blueNum);
        cChexWord               = view.findViewById(R.id.tv_customCell_hexWord);
        cChexVal                = view.findViewById(R.id.tv_customCell_hexValue);
        customCellBackground    = view.findViewById(R.id.customCellBG);
        ColorInfo col           = listOfColors.get(i);

        //Set the GUI
        cCredNum.setText(String.valueOf(col.getRedProgress()));
        cCgreenNum.setText(String.valueOf(col.getGreenProgress()));
        cCblueNum.setText(String.valueOf(col.getBlueProgress()));
        cChexVal.setText(col.getHexaText());
        //Set background color
        customCellBackground.setBackgroundColor(Color.rgb(col.getRedProgress(), col.getGreenProgress(), col.getBlueProgress()));
        if (col.getRedProgress() < 86) {
            cCredWord.setTextColor(Color.rgb(255, 255, 255));
            cCredNum.setTextColor(Color.rgb(255, 255, 255));
            cCgreenWord.setTextColor(Color.rgb(255, 255, 255));
            cCgreenNum.setTextColor(Color.rgb(255, 255, 255));
            cCblueWord.setTextColor(Color.rgb(255, 255, 255));
            cCblueNum.setTextColor(Color.rgb(255, 255, 255));
            cChexWord.setTextColor(Color.rgb(255, 255, 255));
            cChexVal.setTextColor(Color.rgb(255, 255, 255));
        }
        else if (col.getGreenProgress() < 86) {
            cCredWord.setTextColor(Color.rgb(255, 255, 255));
            cCredNum.setTextColor(Color.rgb(255, 255, 255));
            cCgreenWord.setTextColor(Color.rgb(255, 255, 255));
            cCgreenNum.setTextColor(Color.rgb(255, 255, 255));
            cCblueWord.setTextColor(Color.rgb(255, 255, 255));
            cCblueNum.setTextColor(Color.rgb(255, 255, 255));
            cChexWord.setTextColor(Color.rgb(255, 255, 255));
            cChexVal.setTextColor(Color.rgb(255, 255, 255));
        }
        else if (col.getBlueProgress() < 86) {
            cCredWord.setTextColor(Color.rgb(255, 255, 255));
            cCredNum.setTextColor(Color.rgb(255, 255, 255));
            cCgreenWord.setTextColor(Color.rgb(255, 255, 255));
            cCgreenNum.setTextColor(Color.rgb(255, 255, 255));
            cCblueWord.setTextColor(Color.rgb(255, 255, 255));
            cCblueNum.setTextColor(Color.rgb(255, 255, 255));
            cChexWord.setTextColor(Color.rgb(255, 255, 255));
            cChexVal.setTextColor(Color.rgb(255, 255, 255));
        }
        else {
            cCredWord.setTextColor(Color.rgb(0, 0, 0));
            cCredNum.setTextColor(Color.rgb(0, 0, 0));
            cCgreenWord.setTextColor(Color.rgb(0, 0, 0));
            cCgreenNum.setTextColor(Color.rgb(0, 0, 0));
            cCblueWord.setTextColor(Color.rgb(0, 0, 0));
            cCblueNum.setTextColor(Color.rgb(0, 0, 0));
            cChexWord.setTextColor(Color.rgb(0, 0, 0));
            cChexVal.setTextColor(Color.rgb(0, 0, 0));
        }
        return view;
    }
}
