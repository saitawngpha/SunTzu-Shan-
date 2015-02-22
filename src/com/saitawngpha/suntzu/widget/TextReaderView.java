package com.saitawngpha.suntzu.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: FUWEN MO
 * Date: 2014/05/20
 * Description: A TextView with paging.
 */
public class TextReaderView extends TextView {

    private static final String TAG = "TextReaderView";

    private CharSequence mText;
    private List<Integer> mCharNumEachPage;
    private int mCurrPage;
    private boolean mIsIniting;
    private boolean mIsInited;
    private OnPagingListener mOnPagingListener;

    public TextReaderView(Context context) {
        this(context, null);
    }

    public TextReaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextReaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mIsInited = false;
    }

    public void setOnpagingListener(OnPagingListener listener) {
        mOnPagingListener = listener;
    }

    public int getCurrPageTextOffset() {
        Layout layout = getLayout();
        if (layout != null) {
            return layout.getLineEnd(getLastLineNum());
        }
        return -1;
    }

    public void nextPage() {
        if (mCurrPage != mCharNumEachPage.size() - 1) {
            int start = mCharNumEachPage.get(mCurrPage);
            int end = mCharNumEachPage.get(mCurrPage + 1);
            mCurrPage++;
            setText(mText.toString().substring(start, end));
        }
    }

    public void prevPage() {
        if (mCurrPage != 1) {
            mCurrPage--;
            int start = mCharNumEachPage.get(mCurrPage - 1);
            int end = mCharNumEachPage.get(mCurrPage);
            setText(mText.toString().substring(start, end));
        }
    }

    public int getCurrPage() {
        return mCurrPage;
    }

    public int getTotalPage() {
        if (mCharNumEachPage != null) {
            return mCharNumEachPage.size() - 1;
        }
        return 0;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (!mIsIniting && !mIsInited) {
            initPaging();
        }
    }

    private int getLastLineNum() {
        Layout layout = getLayout();
        if (layout != null) {
            return layout.getLineForVertical(getHeight() - getPaddingTop() - getPaddingBottom() - getLineHeight());
        }
        return -1;
    }

    private void initPaging() {
        mIsIniting = true;
        mCharNumEachPage = new ArrayList<Integer>();
        mText = getText();
        String text;
        int currPageCharNum;
        if (mText != null) {
            mCharNumEachPage.add(0);
            while ((text = getText().toString()) != null && !"".equals(text)) {
                currPageCharNum = getCurrPageTextOffset();
                mCharNumEachPage.add(mCharNumEachPage.get(mCharNumEachPage.size() - 1) + currPageCharNum);
                setText(text.substring(currPageCharNum));
            }
            mIsInited = true;
            mCurrPage = 1;
            if (mCharNumEachPage.size() > 1) {
                setText(mText.subSequence(0, mCharNumEachPage.get(1)));
            }
            if (mOnPagingListener != null) {
                mOnPagingListener.onComplete(getCurrPage(), getTotalPage());
            }
            mIsIniting = false;
        }
    }

    public interface OnPagingListener {
        public void onComplete(int curr, int total);
    }

}
