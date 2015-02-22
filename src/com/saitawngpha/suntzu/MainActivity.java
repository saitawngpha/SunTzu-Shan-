package com.saitawngpha.suntzu;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import com.saitawngpha.suntzu.R;
import com.saitawngpha.suntzu.widget.TextReaderView;

import org.apache.http.util.EncodingUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {

    private TextView mTextTitle;
    private TextView mTextNav;
    private TextReaderView mTextHolder;
    Typeface Padauk;
    Typeface PangLong;

    private int downX;
    private int downY;
    private int moveX;
    private int moveY;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // test
        mTextTitle = (TextView) findViewById(R.id.text1);
        mTextNav = (TextView) findViewById(R.id.text_nav);
        mTextHolder = (TextReaderView) findViewById(R.id.text_holder);
        
        this.PangLong = Typeface.createFromAsset(getAssets(), "fonts/PangLong.ttf");
        this.mTextTitle = ((TextView)findViewById(R.id.text1));
        this.mTextTitle.setTypeface(this.PangLong);
        this.PangLong = Typeface.createFromAsset(getAssets(), "fonts/PangLong.ttf");
        this.mTextNav = ((TextView)findViewById(R.id.text_nav));
        this.mTextNav.setTypeface(this.PangLong);
        this.PangLong = Typeface.createFromAsset(getAssets(), "fonts/PangLong.ttf");
        this.mTextHolder = ((TextReaderView)findViewById(R.id.text_holder));
        this.mTextHolder.setTypeface(this.PangLong);
              

        try {
            InputStream in = getAssets().open("test-content_intro.json");
            int length = in.available();
            byte[] buffer = new byte[length];
            in.read(buffer);
            in.close();
            JSONObject testObj = new JSONObject(EncodingUtils.getString(buffer, "UTF-8"));
            mTextTitle.setText(testObj.getString("title"));
            mTextHolder.setText(testObj.getString("content"));
            mTextHolder.setOnpagingListener(new TextReaderView.OnPagingListener() {
                @Override
                public void onComplete(int curr, int total) {
                    mTextNav.setText(curr + "/" + total);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getRawX();
                downY = (int) event.getRawY();
                moveX = 0;
                moveY = 0;
                return true;
            case MotionEvent.ACTION_MOVE:
                moveX = (int) event.getRawX() - downX;
                moveY = (int) event.getRawY() - downY;
                return true;
            case MotionEvent.ACTION_UP:
                if (Math.abs(moveX) < 10 && Math.abs(moveY) < 10) {
                    // click event
                } else if (moveX > 50 && Math.abs(moveY) < 200) {
                    // right
                    mTextHolder.prevPage();
                    mTextNav.setText(mTextHolder.getCurrPage() + "/" + mTextHolder.getTotalPage());
                } else if (moveX < -50 && Math.abs(moveY) < 200) {
                    // left
                    mTextHolder.nextPage();
                    mTextNav.setText(mTextHolder.getCurrPage() + "/" + mTextHolder.getTotalPage());
                }
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

}
