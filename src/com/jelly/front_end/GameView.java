package com.jelly.front_end;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class GameView extends View implements Runnable {

	Bitmap mBitQQ = null;
	int bitQQWidth = 0;
	int bitQQHeight = 0;
	float angle = 0.0f;
	Matrix mMatrix = new Matrix();
	public GameView(Context context) {
		super(context);
		// 加载资源
		mBitQQ = ((BitmapDrawable)getResources().getDrawable(R.drawable.lihengjia)).getBitmap();
		bitQQHeight = mBitQQ.getHeight();
		bitQQWidth = mBitQQ.getWidth();
		new Thread(this).start();
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mMatrix.reset();
		mMatrix.setRotate(angle);
		Bitmap mBitmap2 = Bitmap.createBitmap(mBitQQ,0,0,
				bitQQWidth,bitQQHeight,mMatrix,true);
		GameView.drawImage(canvas,mBitmap2,(320-bitQQWidth)/2,10);
	}

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			try {
				Thread.sleep(100);
				angle++;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			postInvalidate();
		}

	}
	/**
	 * 
	 * @param canvas 画布
	 * @param bitmap 图片
	 * @param x      屏幕上x坐标
	 * @param y      屏幕上y坐标
	 */
	public static void drawImage(Canvas canvas,Bitmap bitmap,int x,int y){
		canvas.drawBitmap(bitmap, x, y,null);
	}

}
