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
	private String[] multi_items={"����","����","��ë��","ƹ����","����"};
	private String[] items = {"��","Ů","����"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
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
				// TODO �Զ����ɵķ������
				Toast toast =Toast.makeText(MainActivity.this,"��ͼ��Toast", Toast.LENGTH_LONG);
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
				// TODO �Զ����ɵķ������
				Toast toast2 = Toast.makeText(MainActivity.this, "11111", Toast.LENGTH_LONG);
				toast2.setGravity(Gravity.CENTER, 0, 0);
				toast2.show();
			}
		});
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
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
				// TODO �Զ����ɵķ������
					diaglogshow();
			}
			private void diaglogshow() {
				// TODO �Զ����ɵķ������
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("ȷ�϶Ի���");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setMessage("����һ��ȷ�϶Ի���");
				
				builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO �Զ����ɵķ������
						Toast toast = Toast.makeText(MainActivity.this, "������ȡ����ť",Toast.LENGTH_SHORT);
						toast.show();
					}
				});
				builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO �Զ����ɵķ������
						Toast toast = Toast.makeText(MainActivity.this, "������ȷ�ϰ�ť",Toast.LENGTH_SHORT);
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
				// TODO �Զ����ɵķ������
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("��ѡ��");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setSingleChoiceItems(items, 0,new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO �Զ����ɵķ������
						Toast.makeText(MainActivity.this, "ѡ������"+items[which], Toast.LENGTH_SHORT).show();
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
				// TODO �Զ����ɵķ������
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("��ѡ�������Ȥ���ã�");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setMultiChoiceItems(multi_items, null, new DialogInterface.OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						// TODO �Զ����ɵķ������
						if(isChecked)
							Toast.makeText(MainActivity.this,"��ϲ��"+multi_items[which], Toast.LENGTH_SHORT).show();
						else 
							Toast.makeText(MainActivity.this, "�Ҳ�ϲ��"+multi_items[which],Toast.LENGTH_SHORT).show();
					}
				});
				builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		if(flag==true){
			vs.setVisibility(View.VISIBLE);
			flag=false;
			}else{
				vs.setVisibility(View.GONE);
				flag=true;
			}
		
	}
}
