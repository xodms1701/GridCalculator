package org.techtown.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button[] butOps=new Button[4];
    Button[] butNums=new Button[10];
    public static final int SELECT_EDIT1=0;
    public static final int SELECT_EDIT2=1;
    int selectEdit=SELECT_EDIT1;
    String numStr="";
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText)findViewById(R.id.edit_x);
        edit2= (EditText)findViewById(R.id.edit_y);
        edit1.setOnTouchListener(editHandler);
        edit2.setOnTouchListener(editHandler);
        textResult=(TextView)findViewById(R.id.text_result);

        for (int i = 0; i < butNums.length; i++) {
            butNums[i] = (Button) findViewById(R.id.but_0 + i);
            butNums[i].setOnClickListener(butNumHandler);
        }
        for (int i = 0; i < butOps.length; i++) {
            butOps[i] = (Button) findViewById(R.id.Ops1 + i);
            butOps[i].setOnClickListener(butOpHandler);
        }
    }
    View.OnClickListener butNumHandler=new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Button but=(Button)view;
            numStr+=but.getText();
            switch (selectEdit){
                case SELECT_EDIT1:
                    edit1.setText(numStr);
                    break;
                case SELECT_EDIT2:
                    edit2.setText(numStr);
                    break;
            }
        }
    };
    View.OnClickListener butOpHandler=new View.OnClickListener(){
        @Override
        public void onClick(View view){
            int num1=Integer.parseInt(edit1.getText().toString());
            int num2=Integer.parseInt(edit2.getText().toString());
            double result=0;
            switch (view.getId()){
                case R.id.Ops1:
                    result = num1+num2;
                    break;
                case R.id.Ops2:
                    result = num1-num2;
                    break;
                case R.id.Ops3:
                    result = num1*num2;
                    break;
                case R.id.Ops4:
                    result = (double)num1/num2;
                    break;
            }
            textResult.setText("계산결과 : "+result);
        }
    };
    View.OnTouchListener editHandler=new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            numStr="";
            switch (v.getId()){
                case R.id.edit_x:
                    selectEdit=SELECT_EDIT1;
                    break;
                case R.id.edit_y:
                    selectEdit=SELECT_EDIT2;
                    break;
            }
            return true;
        }
    };
}
