package com.example.atest;

import com.example.atest.R.id;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private Button btnButton ,bt1;
	private ViewStub vs;
	boolean flag = true;
	private Button button_image;
	private Button button_place;
	private Button button4;
	private Button single_dialog;
	private Button alert_dialog;
	private Button multi_dialog;
	private String[] multi_items={"篮球","足球","羽毛球","乒乓球","其他"};
	private String[] items = {"男","女","其他"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.include_main);
		tv1=(TextView) findViewById(R.id.tv1);
		tv2=(TextView) findViewById(R.id.tv2);
		tv3=(TextView) findViewById(R.id.tv3);
		btnButton = (Button) findViewById(R.id.btn);
		bt1=(Button) findViewById(R.id.button1);
		vs = (ViewStub) findViewById(R.id.viewstub);
		 button_image = (Button) findViewById(R.id.button_image);
		 button_place = (Button) findViewById(R.id.button_place);
		 button4 = (Button) findViewById(R.id.button4);
		 single_dialog = (Button) findViewById(R.id.single_dialog);
	//	vs.inflate();
		btnButton.setOnClickListener(this);
		alert_dialog = (Button) findViewById(R.id.alert_dialog);
		button_image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Toast toast =Toast.makeText(MainActivity.this,"带图的Toast", Toast.LENGTH_LONG);
				LinearLayout toast_liLayout = (LinearLayout) toast.getView();
				ImageView imageView = new ImageView(MainActivity.this);
				imageView.setImageResource(R.drawable.ic_launcher);
				toast_liLayout.addView(imageView,0);
				toast.show();
			}
		});
	//	vs.setVisibility(View.GONE);
		button_place.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Toast toast2 = Toast.makeText(MainActivity.this, "11111", Toast.LENGTH_LONG);
				toast2.setGravity(Gravity.CENTER, 0, 0);
				toast2.show();
			}
		});
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
				View toast_view = inflater.inflate(R.layout.toast_main,null);
				Toast toast = new Toast(MainActivity.this);
				toast.setView(toast_view);
				toast.show();
			}
		});
		alert_dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
					diaglogshow();
			}
			private void diaglogshow() {
				// TODO 自动生成的方法存根
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("确认对话框");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setMessage("这是一个确认对话框！");
				
				builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 自动生成的方法存根
						Toast toast = Toast.makeText(MainActivity.this, "按到了取消按钮",Toast.LENGTH_SHORT);
						toast.show();
					}
				});
				builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 自动生成的方法存根
						Toast toast = Toast.makeText(MainActivity.this, "按到了确认按钮",Toast.LENGTH_SHORT);
						toast.show();
					}
				});
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		single_dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("单选框！");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setSingleChoiceItems(items, 0,new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 自动生成的方法存根
						Toast.makeText(MainActivity.this, "选到的是"+items[which], Toast.LENGTH_SHORT).show();
					}
				});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		multi_dialog = (Button) findViewById(R.id.multi_dialog);
		multi_dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("请选择你的兴趣爱好：");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setMultiChoiceItems(multi_items, null, new DialogInterface.OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						// TODO 自动生成的方法存根
						if(isChecked)
							Toast.makeText(MainActivity.this,"我喜欢"+multi_items[which], Toast.LENGTH_SHORT).show();
						else 
							Toast.makeText(MainActivity.this, "我不喜欢"+multi_items[which],Toast.LENGTH_SHORT).show();
					}
				});
				builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 自动生成的方法存根
						dialog.dismiss();
					}
				});
				AlertDialog dialog = builder.create();
				dialog.show();
				
			}
		});
	}
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		if(flag==true){
			vs.setVisibility(View.VISIBLE);
			flag=false;
			}else{
				vs.setVisibility(View.GONE);
				flag=true;
			}
		
	}
}
