package com.njucs.card.main;

import com.njucs.card.R;
import com.njucs.card.initializtion.GetRecentCard;
import com.njucs.card.recognition.Recognition;
import com.njucs.card.tools.BaseActivity;
import com.njucs.card.tools.Contacts;
import com.njucs.card.user.User;

import java.io.*;
import android.widget.*;
import android.graphics.*;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

/*
 * 主界面：包括最近扫描结果组成的一个列表ListView::recent和下方四个ImageButton
 * 分别是：名片夹（没什么用），相册，照相，用户
 * 相册和照相的响应函数以完成，会在onActivityResult()里得到一个图片的Uri进而处理得到Bitmap传入识别模块
 * 
 * 对于最近处理列表还需要对每一项添加响应函数，点击后跳转到我们自定义的一个联系人界面（未设计）进行浏览
 * 2016-11-02
 
 */
public class MainActivity extends BaseActivity implements OnTouchListener{
	public static final int GET_PICTURE=1;
	
	private ImageButton album, camera, user;
	private ListView recent;
	private Uri imageUri;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		album=(ImageButton)findViewById(R.id.btn_album);
		camera=(ImageButton)findViewById(R.id.btn_camera);
		user=(ImageButton)findViewById(R.id.btn_user);
		
		album.setOnTouchListener(this);
		camera.setOnTouchListener(this);
		user.setOnTouchListener(this);
		
		album.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();  
				intent.setAction(Intent.ACTION_GET_CONTENT); 
				intent.setType("image/*");
				startActivityForResult(intent, GET_PICTURE);     
			}
		});
		
		camera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				startActivityForResult(intent, GET_PICTURE);
			}
		});

		user.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("Main", "Click User");
				Intent intent = new Intent(MainActivity.this, User.class);
				startActivity(intent);
			}
		});
		
		recent = (ListView) findViewById(R.id.list_recent);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, GetRecentCard.getData());
		recent.setAdapter(adapter);

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case GET_PICTURE:
			if(resultCode==RESULT_OK){
				imageUri=data.getData();
				Log.i("Uri", imageUri.toString());
				try {
					Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
//					picture.setImageBitmap(bitmap);
					Recognition.Handle(bitmap);
					/*Log.i("String", "Outside!");
					Contacts c=new Contacts("");
					c.action(MainActivity.this);*/
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch(v.getId()){
		case R.id.btn_album:
			if(event.getAction() == MotionEvent.ACTION_DOWN)
				album.setImageDrawable(getResources().getDrawable(R.drawable.album_press));		
			if(event.getAction() == MotionEvent.ACTION_UP)
				album.setImageDrawable(getResources().getDrawable(R.drawable.album));		
			break;
		case R.id.btn_camera:
			if(event.getAction() == MotionEvent.ACTION_DOWN)
				camera.setImageDrawable(getResources().getDrawable(R.drawable.camera_press));		
			if(event.getAction() == MotionEvent.ACTION_UP)
				camera.setImageDrawable(getResources().getDrawable(R.drawable.camera));	
			break;
		case R.id.btn_user:
			if(event.getAction() == MotionEvent.ACTION_DOWN)
				user.setImageDrawable(getResources().getDrawable(R.drawable.user_press));		
			if(event.getAction() == MotionEvent.ACTION_UP)
				user.setImageDrawable(getResources().getDrawable(R.drawable.user));	
			break;
		default:
			break;
		}
		return false;
	}

}
