//=====================================
//Author:       Cecil
//Date:         September 11th, 2024
//Description:  The user may adjust any of the three sliders. This changes the numbers displayed, the hexadecimal value displayed,
//              the background color, and, if the background color is sufficiently dark, the color of the text displayed. If the
//              background color is sufficiently light, the text changes back to black. The user can also save a background color
//              to an array. By clicking that color in the list view, the user can change the app's background color back to that.
//=====================================
package com.example.homework02_program01;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //Declare the changeable text boxes, the setbars, the button, and the list view. GUI elements are declared here from top to bottom.
    TextView et_j_redWord;
    TextView et_j_redNum;
    SeekBar sb_j_redBar;

    TextView et_j_greenWord;
    TextView et_j_greenNum;
    SeekBar sb_j_greenBar;

    TextView et_j_blueWord;
    TextView et_j_blueNum;
    SeekBar sb_j_blueBar;

    TextView et_j_hexWord;
    TextView et_j_hexValue;

    Button btn_j_saveColor;

    ListView lv_j_colorList;

    ConstraintLayout mainBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Connect GUI with code
        et_j_redWord    = findViewById(R.id.tv_main_redWord);
        et_j_redNum     = findViewById(R.id.tv_main_redNum);
        sb_j_redBar     = findViewById(R.id.sb_main_redBar);

        et_j_greenWord  = findViewById(R.id.tv_main_greenWord);
        et_j_greenNum   = findViewById(R.id.tv_main_greenNum);
        sb_j_greenBar   = findViewById(R.id.sb_main_greenBar);

        et_j_blueWord   = findViewById(R.id.tv_main_blueWord);
        et_j_blueNum    = findViewById(R.id.tv_main_blueNum);
        sb_j_blueBar    = findViewById(R.id.sb_main_blueBar);

        et_j_hexWord    = findViewById(R.id.tv_main_hexWords);
        et_j_hexValue   = findViewById(R.id.tv_main_hexValue);

        btn_j_saveColor = findViewById(R.id.btn_main_saveColor);

        lv_j_colorList = findViewById(R.id.lv_main_colorList);

        mainBackground = findViewById(R.id.main);

        //onSeekBarChangeListeners to update seek bars in real time
        redBarListener();
        greenBarListener();
        blueBarListener();

        //Note to self: don't forget about the listView!
        //Need to save hexcode (primary key), red progress, green progress, and blue progress
        //(don't need to save background color because the progress bar listeners will change the
        //color automatically)
    }

    private void redBarListener() {
        sb_j_redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int redProgress = sb_j_redBar.getProgress();
                et_j_redNum.setText(String.valueOf(redProgress));
                changeHex();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void greenBarListener() {
        sb_j_greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int greenProgress = sb_j_greenBar.getProgress();
                et_j_greenNum.setText(String.valueOf(greenProgress));
                changeHex();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void blueBarListener() {
        sb_j_blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int blueProgress = sb_j_blueBar.getProgress();
                et_j_blueNum.setText(String.valueOf(blueProgress));
                changeHex();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void changeHex() {
        //Retrieve progress from each bar.
        int redProgress = sb_j_redBar.getProgress();
        int greenProgress = sb_j_greenBar.getProgress();
        int blueProgress = sb_j_blueBar.getProgress();
        //Determine first char of red section of hex code
        String redProgHex;
        if (redProgress / 16 == 15) {
            redProgHex = "F";
            redProgress = redProgress - 240;
        }
        else if (redProgress / 16 == 14) {
            redProgHex = "E";
            redProgress = redProgress - 224;
        }
        else if (redProgress / 16 == 13) {
            redProgHex = "D";
            redProgress = redProgress - 208;
        }
        else if (redProgress / 16 == 12) {
            redProgHex = "C";
            redProgress = redProgress - 192;
        }
        else if (redProgress / 16 == 11) {
            redProgHex = "B";
            redProgress = redProgress - 176;
        }
        else if (redProgress / 16 == 10) {
            redProgHex = "A";
            redProgress = redProgress - 160;
        }
        else if (redProgress / 16 == 9) {
            redProgHex = "9";
            redProgress = redProgress - 144;
        }
        else if (redProgress / 16 == 8) {
            redProgHex = "8";
            redProgress = redProgress - 128;
        }
        else if (redProgress / 16 == 7) {
            redProgHex = "7";
            redProgress = redProgress - 112;
        }
        else if (redProgress / 16 == 6) {
            redProgHex = "6";
            redProgress = redProgress - 96;
        }
        else if (redProgress / 16 == 5) {
            redProgHex = "5";
            redProgress = redProgress - 80;
        }
        else if (redProgress / 16 == 4) {
            redProgHex = "4";
            redProgress = redProgress - 64;
        }
        else if (redProgress / 16 == 3) {
            redProgHex = "3";
            redProgress = redProgress - 48;
        }
        else if (redProgress / 16 == 2) {
            redProgHex = "2";
            redProgress = redProgress - 32;
        }
        else if (redProgress / 16 == 1) {
            redProgHex = "1";
            redProgress = redProgress - 16;
        }
        else {
            redProgHex = "0";
        }
        //Determine second char of red hex portion
        if (redProgress - 15 == 0) {
            redProgHex = redProgHex + "F";
        }
        else if (redProgress - 14 == 0) {
            redProgHex = redProgHex + "E";
        }
        else if (redProgress - 13 == 0) {
            redProgHex = redProgHex + "D";
        }
        else if (redProgress - 12 == 0) {
            redProgHex = redProgHex + "C";
        }
        else if (redProgress - 11 == 0) {
            redProgHex = redProgHex + "B";
        }
        else if (redProgress - 10 == 0) {
            redProgHex = redProgHex + "A";
        }
        else if (redProgress - 9 == 0) {
            redProgHex = redProgHex + "9";
        }
        else if (redProgress - 8 == 0) {
            redProgHex = redProgHex + "8";
        }
        else if (redProgress - 7 == 0) {
            redProgHex = redProgHex + "7";
        }
        else if (redProgress - 6 == 0) {
            redProgHex = redProgHex + "6";
        }
        else if (redProgress - 5 == 0) {
            redProgHex = redProgHex + "5";
        }
        else if (redProgress - 4 == 0) {
            redProgHex = redProgHex + "4";
        }
        else if (redProgress - 3 == 0) {
            redProgHex = redProgHex + "3";
        }
        else if (redProgress - 2 == 0) {
            redProgHex = redProgHex + "2";
        }
        else if (redProgress - 1 == 0) {
            redProgHex = redProgHex + "1";
        }
        else {
            redProgHex = redProgHex + "0";
        }
        //Repeat process for green bar
        String greenProgHex;
        if (greenProgress / 16 == 15) {
            greenProgHex = "F";
            greenProgress = greenProgress - 240;
        }
        else if (greenProgress / 16 == 14) {
            greenProgHex = "E";
            greenProgress = greenProgress - 224;
        }
        else if (greenProgress / 16 == 13) {
            greenProgHex = "D";
            greenProgress = greenProgress - 208;
        }
        else if (greenProgress / 16 == 12) {
            greenProgHex = "C";
            greenProgress = greenProgress - 192;
        }
        else if (greenProgress / 16 == 11) {
            greenProgHex = "B";
            greenProgress = greenProgress - 176;
        }
        else if (greenProgress / 16 == 10) {
            greenProgHex = "A";
            greenProgress = greenProgress - 160;
        }
        else if (greenProgress / 16 == 9) {
            greenProgHex = "9";
            greenProgress = greenProgress - 144;
        }
        else if (greenProgress / 16 == 8) {
            greenProgHex = "8";
            greenProgress = greenProgress - 128;
        }
        else if (greenProgress / 16 == 7) {
            greenProgHex = "7";
            greenProgress = greenProgress - 112;
        }
        else if (greenProgress / 16 == 6) {
            greenProgHex = "6";
            greenProgress = greenProgress - 96;
        }
        else if (greenProgress / 16 == 5) {
            greenProgHex = "5";
            greenProgress = greenProgress - 80;
        }
        else if (greenProgress / 16 == 4) {
            greenProgHex = "4";
            greenProgress = greenProgress - 64;
        }
        else if (greenProgress / 16 == 3) {
            greenProgHex = "3";
            greenProgress = greenProgress - 48;
        }
        else if (greenProgress / 16 == 2) {
            greenProgHex = "2";
            greenProgress = greenProgress - 32;
        }
        else if (greenProgress / 16 == 1) {
            greenProgHex = "1";
            greenProgress = greenProgress - 16;
        }
        else {
            greenProgHex = "0";
        }
        //Determine second char of green hex portion
        if (greenProgress - 15 == 0) {
            greenProgHex = greenProgHex + "F";
        }
        else if (greenProgress - 14 == 0) {
            greenProgHex = greenProgHex + "E";
        }
        else if (greenProgress - 13 == 0) {
            greenProgHex = greenProgHex + "D";
        }
        else if (greenProgress - 12 == 0) {
            greenProgHex = greenProgHex + "C";
        }
        else if (greenProgress - 11 == 0) {
            greenProgHex = greenProgHex + "B";
        }
        else if (greenProgress - 10 == 0) {
            greenProgHex = greenProgHex + "A";
        }
        else if (greenProgress - 9 == 0) {
            greenProgHex = greenProgHex + "9";
        }
        else if (greenProgress - 8 == 0) {
            greenProgHex = greenProgHex + "8";
        }
        else if (greenProgress - 7 == 0) {
            greenProgHex = greenProgHex + "7";
        }
        else if (greenProgress - 6 == 0) {
            greenProgHex = greenProgHex + "6";
        }
        else if (greenProgress - 5 == 0) {
            greenProgHex = greenProgHex + "5";
        }
        else if (greenProgress - 4 == 0) {
            greenProgHex = greenProgHex + "4";
        }
        else if (greenProgress - 3 == 0) {
            greenProgHex = greenProgHex + "3";
        }
        else if (greenProgress - 2 == 0) {
            greenProgHex = greenProgHex + "2";
        }
        else if (greenProgress - 1 == 0) {
            greenProgHex = greenProgHex + "1";
        }
        else {
            greenProgHex = greenProgHex + "0";
        }
        //Repeat process for blue bar
        String blueProgHex;
        if (blueProgress / 16 == 15) {
            blueProgHex = "F";
            blueProgress = blueProgress - 240;
        }
        else if (blueProgress / 16 == 14) {
            blueProgHex = "E";
            blueProgress = blueProgress - 224;
        }
        else if (blueProgress / 16 == 13) {
            blueProgHex = "D";
            blueProgress = blueProgress - 208;
        }
        else if (blueProgress / 16 == 12) {
            blueProgHex = "C";
            blueProgress = blueProgress - 192;
        }
        else if (blueProgress / 16 == 11) {
            blueProgHex = "B";
            blueProgress = blueProgress - 176;
        }
        else if (blueProgress / 16 == 10) {
            blueProgHex = "A";
            blueProgress = blueProgress - 160;
        }
        else if (blueProgress / 16 == 9) {
            blueProgHex = "9";
            blueProgress = blueProgress - 144;
        }
        else if (blueProgress / 16 == 8) {
            blueProgHex = "8";
            blueProgress = blueProgress - 128;
        }
        else if (blueProgress / 16 == 7) {
            blueProgHex = "7";
            blueProgress = blueProgress - 112;
        }
        else if (blueProgress / 16 == 6) {
            blueProgHex = "6";
            blueProgress = blueProgress - 96;
        }
        else if (blueProgress / 16 == 5) {
            blueProgHex = "5";
            blueProgress = blueProgress - 80;
        }
        else if (blueProgress / 16 == 4) {
            blueProgHex = "4";
            blueProgress = blueProgress - 64;
        }
        else if (blueProgress / 16 == 3) {
            blueProgHex = "3";
            blueProgress = blueProgress - 48;
        }
        else if (blueProgress / 16 == 2) {
            blueProgHex = "2";
            blueProgress = blueProgress - 32;
        }
        else if (blueProgress / 16 == 1) {
            blueProgHex = "1";
            blueProgress = blueProgress - 16;
        }
        else {
            blueProgHex = "0";
        }
        //Determine second char of blue hex portion
        if (blueProgress == 15) {
            blueProgHex = blueProgHex + "F";
        }
        else if (blueProgress == 14) {
            blueProgHex = blueProgHex + "E";
        }
        else if (blueProgress == 13) {
            blueProgHex = blueProgHex + "D";
        }
        else if (blueProgress == 12) {
            blueProgHex = blueProgHex + "C";
        }
        else if (blueProgress == 11) {
            blueProgHex = blueProgHex + "B";
        }
        else if (blueProgress == 10) {
            blueProgHex = blueProgHex + "A";
        }
        else if (blueProgress == 9) {
            blueProgHex = blueProgHex + "9";
        }
        else if (blueProgress == 8) {
            blueProgHex = blueProgHex + "8";
        }
        else if (blueProgress == 7) {
            blueProgHex = blueProgHex + "7";
        }
        else if (blueProgress == 6) {
            blueProgHex = blueProgHex + "6";
        }
        else if (blueProgress == 5) {
            blueProgHex = blueProgHex + "5";
        }
        else if (blueProgress == 4) {
            blueProgHex = blueProgHex + "4";
        }
        else if (blueProgress == 3) {
            blueProgHex = blueProgHex + "3";
        }
        else if (blueProgress == 2) {
            blueProgHex = blueProgHex + "2";
        }
        else if (blueProgress == 1) {
            blueProgHex = blueProgHex + "1";
        }
        else {
            blueProgHex = blueProgHex + "0";
        }
        String hexaText = redProgHex + greenProgHex + blueProgHex;
        redProgress = sb_j_redBar.getProgress();
        greenProgress = sb_j_greenBar.getProgress();
        blueProgress = sb_j_blueBar.getProgress();
        et_j_hexValue.setText(hexaText);
        //Changes the background color
        mainBackground.setBackgroundColor(Color.rgb(redProgress, greenProgress, blueProgress));
        //Change the color of all the text boxes depending on brightness of any of the RGB values
        //Change the color to white if any of the progress values are less than 86
        if (redProgress < 86) {
            et_j_redWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_redNum.setTextColor(Color.rgb(255, 255, 255));
            et_j_greenWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_greenNum.setTextColor(Color.rgb(255, 255, 255));
            et_j_blueWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_blueNum.setTextColor(Color.rgb(255, 255, 255));
            et_j_hexWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_hexValue.setTextColor(Color.rgb(255, 255, 255));
        }
        else if (greenProgress < 86) {
            et_j_redWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_redNum.setTextColor(Color.rgb(255, 255, 255));
            et_j_greenWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_greenNum.setTextColor(Color.rgb(255, 255, 255));
            et_j_blueWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_blueNum.setTextColor(Color.rgb(255, 255, 255));
            et_j_hexWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_hexValue.setTextColor(Color.rgb(255, 255, 255));
        }
        else if (blueProgress < 86) {
            et_j_redWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_redNum.setTextColor(Color.rgb(255, 255, 255));
            et_j_greenWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_greenNum.setTextColor(Color.rgb(255, 255, 255));
            et_j_blueWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_blueNum.setTextColor(Color.rgb(255, 255, 255));
            et_j_hexWord.setTextColor(Color.rgb(255, 255, 255));
            et_j_hexValue.setTextColor(Color.rgb(255, 255, 255));
        }
        //Make all the text black if all of the progress values are less than 86.
        else {
            et_j_redWord.setTextColor(Color.rgb(0, 0, 0));
            et_j_redNum.setTextColor(Color.rgb(0, 0, 0));
            et_j_greenWord.setTextColor(Color.rgb(0, 0, 0));
            et_j_greenNum.setTextColor(Color.rgb(0, 0, 0));
            et_j_blueWord.setTextColor(Color.rgb(0, 0, 0));
            et_j_blueNum.setTextColor(Color.rgb(0, 0, 0));
            et_j_hexWord.setTextColor(Color.rgb(0, 0, 0));
            et_j_hexValue.setTextColor(Color.rgb(0, 0, 0));
        }
    }
}