package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalcActivity extends Activity{
	private EditText et;
	private Button buttonC;
	private Button buttonPlus;
	private Button buttonSub;
	private Button buttonMult;
	private Button buttonDiv;
	private Button buttonEq;
	private Button temp;
	private String str1;
	private int[] buttons;
	private int flag;
	private int result0 = 0;
	private int result1 = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calc);
		init();
	}

	private void init() {
		initButton();
    	// 清空按钮监听
		buttonC.setOnClickListener(new OnClickListener() {
		      public void onClick(View v) {
		           str1 = "";
		           et.setText(str1);
		           flag = 0;
		      }
	      });
	      
		//数字键监听
		for (int i = 0; i < buttons.length; i++) {
	          temp = (Button) findViewById(buttons[i]);
	          temp.setOnClickListener(
	          new OnClickListener() {
	               @Override
	               public void onClick(View v) {
	                    str1 = et.getText().toString().trim();
	                    if(flag == -1){
	                    	str1="";
	                    	flag = 0;
	                    }
	                    str1 = str1 + String.valueOf(((Button) v).getText());
	                    System.out.println("str1" + ":::" + str1);
	                    et.setText(str1);
	               }
	         });
		}
	      
	  // +-*/键的监听
      buttonListener(buttonPlus, 1);
      buttonListener(buttonSub, 2);
      buttonListener(buttonMult, 3);
      buttonListener(buttonDiv, 4);
      
      // 等号键监听
      buttonEq.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			String str = et.getText().toString().trim();
			if(str != null && !("").equals(str)){
				result1 = Integer.parseInt(str);
			}
            int ft = 0;
			switch (flag) {
				case 1://加
					ft = result0 + result1;
					et.setText(ft + "");
					break;
				case 2://减
					ft = result0 - result1;
					et.setText(ft + "");
					break;
				case 3://乘
					ft = result0 * result1;
					et.setText(ft + "");
					break;
				case 4://除
					ft = result0 / result1;
					et.setText(ft + "");
					break;
				default:
					et.setText(str);
					break;
			}
			result1 = 0;
			result0 = ft;
			flag = -1;
		}
      });
	}

	private void initButton() {
	    et = (EditText) this.findViewById(R.id.show);
	    str1 = String.valueOf(et.getText());
		 
		buttonC = (Button) this.findViewById(R.id.buttonDelete); 
		buttonPlus = (Button) this.findViewById(R.id.buttonPlus);
		buttonSub = (Button) this.findViewById(R.id.buttonSub);
		buttonMult = (Button) this.findViewById(R.id.buttonMult);
		buttonDiv = (Button) this.findViewById(R.id.buttonDiv);
		buttonEq = (Button) this.findViewById(R.id.buttonEq);
		 
		buttons = new int[] {
		     R.id.button0, R.id.button1, R.id.button2, R.id.button3,
		     R.id.button4, R.id.button5, R.id.button6, R.id.button7,
		     R.id.button8, R.id.button9 
	     };
	}
	
	// +-*/按钮监听
	public void buttonListener(Button button, final int id) {
	     button.setOnClickListener(new OnClickListener() {
	          @Override
	          public void onClick(View v) {
	               String str = et.getText().toString().trim();
	               if(str != null && !("").equals(str)){
	            	   result0 = Integer.parseInt(str);
	            	   et.setText("");
	            	   flag = id;
	               }
	          }
	    });
     }
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) { // 如果是手机上的返回键
			CalcActivity.this.finish();
		  }
		return super.onKeyDown(keyCode, event);
	}
}
