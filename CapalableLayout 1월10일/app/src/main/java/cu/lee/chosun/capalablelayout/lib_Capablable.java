package cu.lee.chosun.capalablelayout;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Lee on 2018-01-10.
 */

public class lib_Capablable extends FrameLayout {
    //변수값 초기설정
    private static final float Default_Scale_Base_Width = 100f;
    private static final float Default_Scale_Base_Height = 100f;

    // 초기화
    private static final float Default_Scale_Left = 0f;
    private static final int Default_Scale_Left_BasePosition = 0;
    private static final float Default_Scale_Top = 0f;
    private static final int Default_Scale_Top_BasePosition = 0;
    private static final float Default_Scale_Width = 100f;
    private static final float Default_Scale_Height = 100f;
    private static final float Default_TextView_WrapContent_Scale_MaxWidth = -1f;

    private static final float Default_Scale_TextSize = 100f;

    private float mScale_Root_Width 	= Default_Scale_Base_Width;
    private float mScale_Root_Height 	= Default_Scale_Base_Height;
    private float mRatioOfWidthHeight 	= mScale_Root_Height / mScale_Root_Width;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            requestLayout();
            forceLayout();
        }
    };
    private long mLastRequestPostTime = 0;
    private void postDelayedRequestLayout() {
        if(isInEditMode()) {
            return;
        }

        long now = System.currentTimeMillis();
        if(mLastRequestPostTime < now - 50 || now < mLastRequestPostTime) {
            mLastRequestPostTime = now;
            postDelayed(mRunnable, 10);
        }
    }

    /**
     * Simple constructor to use when creating a view from code.
     * Scale_Width, Scale_Height uses a default value of 100.
     * <p>
     * code에서 lib_Capablable 생성할 때 사용하는 constructor.
     * Scale_Width, Scale_Height를 기본값인 100으로 세팅함.
     *
     */
    public lib_Capablable(Context pContext) {
        this(pContext, Default_Scale_Base_Width, Default_Scale_Base_Height);
    }

    public lib_Capablable(Context pContext, float pScale_Width, float pScale_Height) {
        this(pContext, null, pScale_Width, pScale_Height);
    }
//    public lib_Capablable(Context pContext, float pScale_Width, float pScale_Height, int pScale_BasePosition) {
//        this(pContext, null, pScale_Width, pScale_Height, pScale_BasePosition);
//    }

    /*
    *레이아웃 에러메세지 출력
    *  레이아웃을 상속받지않으면 메세지 출력.
     */

public lib_Capablable.LayoutParams getChildLayoutParams(View pChild) {
    ViewGroup.LayoutParams lp = pChild.getLayoutParams();
    if(lp == null) { //자식 파라매터 설정
        lp = generateDefaultLayoutParams();
        pChild.setLayoutParams(lp);
    }

    /*
     * View 설정 함수 1/10 정의
     *
     */
    if(lp instanceof lib_Capablable.LayoutParams == false) {
        throw new IllegalArgumentException("pChild has not lib_Capablable.LayoutParams "+pChild.getLayoutParams());
    }
    return (lib_Capablable.LayoutParams) pChild.getLayoutParams();
}

    public void setTextView_WrapContent(TextView pTextView, TextView_WrapContent_Direction pDirection, boolean pRescaleSurrounded) {
 // TextView Content 설정
    }
    public void setTextView_WrapContent(TextView pTextView, TextView_WrapContent_Direction pDirection, boolean pRescaleSurrounded, boolean pMoveSibligs) {
        // TextView Content 설정
    }
    private TextWatcher mTextWatcher = new TextWatcher() {
        // TextView Content 설정 (Widget)
        @Override
        public void onTextChanged(CharSequence pS, int pStart, int pBefore, int pCount) {
            postDelayedRequestLayout();
        }
        @Override
        public void beforeTextChanged(CharSequence pS, int pStart, int pCount, int pAfter) { }
        @Override
        public void afterTextChanged(Editable pS) {
            postDelayedRequestLayout();
        }
    };


    private void refreshTextChangedListener(TextView pTextView) {

    }



// -----------------------------------------------------------------------------
}

