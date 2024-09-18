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

        //Next step: convert progress to hexadecimal code
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
        if (redProgress / 16 == 15) {
            redProgHex = redProgHex + "F";
        }
        else if (redProgress / 16 == 14) {
            redProgHex = redProgHex + "E";
        }
        else if (redProgress / 16 == 13) {
            redProgHex = redProgHex + "D";
        }
        else if (redProgress / 16 == 12) {
            redProgHex = redProgHex + "C";
        }
        else if (redProgress / 16 == 11) {
            redProgHex = redProgHex + "B";
        }
        else if (redProgress / 16 == 10) {
            redProgHex = redProgHex + "A";
        }
        else if (redProgress / 16 == 9) {
            redProgHex = redProgHex + "9";
        }
        else if (redProgress / 16 == 8) {
            redProgHex = redProgHex + "8";
        }
        else if (redProgress / 16 == 7) {
            redProgHex = redProgHex + "7";
        }
        else if (redProgress / 16 == 6) {
            redProgHex = redProgHex + "6";
        }
        else if (redProgress / 16 == 5) {
            redProgHex = redProgHex + "5";
        }
        else if (redProgress / 16 == 4) {
            redProgHex = redProgHex + "4";
        }
        else if (redProgress / 16 == 3) {
            redProgHex = redProgHex + "3";
        }
        else if (redProgress / 16 == 2) {
            redProgHex = redProgHex + "2";
        }
        else if (redProgress / 16 == 1) {
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
        if (greenProgress / 16 == 15) {
            greenProgHex = greenProgHex + "F";
        }
        else if (greenProgress / 16 == 14) {
            greenProgHex = greenProgHex + "E";
        }
        else if (greenProgress / 16 == 13) {
            greenProgHex = greenProgHex + "D";
        }
        else if (greenProgress / 16 == 12) {
            greenProgHex = greenProgHex + "C";
        }
        else if (greenProgress / 16 == 11) {
            greenProgHex = greenProgHex + "B";
        }
        else if (greenProgress / 16 == 10) {
            greenProgHex = greenProgHex + "A";
        }
        else if (greenProgress / 16 == 9) {
            greenProgHex = greenProgHex + "9";
        }
        else if (greenProgress / 16 == 8) {
            greenProgHex = greenProgHex + "8";
        }
        else if (greenProgress / 16 == 7) {
            greenProgHex = greenProgHex + "7";
        }
        else if (greenProgress / 16 == 6) {
            greenProgHex = greenProgHex + "6";
        }
        else if (greenProgress / 16 == 5) {
            greenProgHex = greenProgHex + "5";
        }
        else if (greenProgress / 16 == 4) {
            greenProgHex = greenProgHex + "4";
        }
        else if (greenProgress / 16 == 3) {
            greenProgHex = greenProgHex + "3";
        }
        else if (greenProgress / 16 == 2) {
            greenProgHex = greenProgHex + "2";
        }
        else if (greenProgress / 16 == 1) {
            greenProgHex = greenProgHex + "1";
        }
        else {
            greenProgHex = greenProgHex + "0";
        }
    }
}