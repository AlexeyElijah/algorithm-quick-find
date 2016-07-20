package com.algorithm.alexey.algorithm_quick_find;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 这是一个动态联通性的最简单的算法
 * Alexey
 */
public class MainActivity extends AppCompatActivity {
    private int[] id;
    private EditText etFirstNum;
    private EditText etSecondNum;
    private Button btUnionNum;
    private Button btCheckUnion;
    private TextView tvAllNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initID();
        initView();

        setClickLisen();
        showAllNum();
    }

    private void setClickLisen() {
        btUnionNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int firstNum = id[Integer.parseInt(etFirstNum.getText().toString().trim())];
                    int secNum = id[Integer.parseInt(etSecondNum.getText().toString().trim())];


                    unionTwoNum(firstNum, secNum);
                    showAllNum();
                    etSecondNum.setText("");
                    etFirstNum.setText("");
                } catch (Exception e) {
                    return;
                }

            }


        });
        btCheckUnion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int firstNum = id[Integer.parseInt(etFirstNum.getText().toString().trim())];
                    int secNum = id[Integer.parseInt(etSecondNum.getText().toString().trim())];

                    String result;
                    result = firstNum == secNum ? "联通" : "不联通";
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    return;
                }
            }
        });
    }

    private void unionTwoNum(int firstNum, int secNum) {
        int num = firstNum;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == num) id[i] = id[secNum];
        }
    }

    private void initView() {
        etFirstNum = (EditText) findViewById(R.id.et_first_num);
        etSecondNum = (EditText) findViewById(R.id.et_secend_num);
        btUnionNum = (Button) findViewById(R.id.bt_union_num);
        btCheckUnion = (Button) findViewById(R.id.bt_chech_union);
        tvAllNum = (TextView) findViewById(R.id.tv_all_num);
    }

    private void initID() {
        id = new int[50];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private void showAllNum() {
        String st = "";
        for (int i = 0; i < id.length; i++) {
            st += id[i] + " , ";
        }
        tvAllNum.setText(st);
    }
}
