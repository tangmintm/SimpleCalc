package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	private Button mLoginButton;
    private EditText mPasswordEditText;
    private EditText mNameEditText;
    private CheckBox switchCheck;
    private ListView lv;
    private boolean isHidden = true;
    private static String[] array = new String[]{"Spring","Summer","Fall","Winter"};
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setContentView(R.layout.abc);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mPasswordEditText = (EditText) findViewById(R.id.passwd);
		mNameEditText = (EditText) findViewById(R.id.username);
		mLoginButton = (Button) findViewById(R.id.button);
		switchCheck = (CheckBox) findViewById(R.id.checkHidden);
		lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, array));
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		mLoginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
		        intent.putExtra("name","Lily");    
		        /* 指定intent要启动的类 */
		        intent.setClass(MainActivity.this, CalcActivity.class);
		        /* 启动一个新的Activity */
		        MainActivity.this.startActivity(intent);
		        /* 关闭当前的Activity */
		        //MainActivity.this.finish();
			}
		});
		
		lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //点击后在标题上显示点击了第几行
                setTitle("你点击了第"+(arg2+1)+"行");
            }
        });
		
		if(switchCheck.isChecked()){
			mPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
		}else{
			mPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
		}
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("on start...");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		System.out.println("on restart...");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("on resume...");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		System.out.println("on pause...");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
