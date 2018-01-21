package cu.lee.chosun.capalablelayout;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
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

        public lib_Capablable(Context pContext, float pScale_Width, float pScale_Height) {
            this(pContext, null, pScale_Width, pScale_Height);
        }

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

        /*
         * Measure 함수
         * 레이아웃 크기 설정
         */
        @Override
        protected void onMeasure(int pWidthMeasureSpec, int pHeightMeasureSpec) { // 가로 세로 높이 측정

            float lRoot_Width_Max = 0; // 초기화
            int lRoot_MeasureSpec_WidthMode = MeasureSpec.getMode(pWidthMeasureSpec); //MeasureSpec 클래스 크기 설정


            float lRoot_Height_Max = 0; // 초기화
            int lRoot_MeasureSpec_HeightMode = MeasureSpec.getMode(pHeightMeasureSpec); //MeasureSpec 클래스 크기 설정


            {
                int lRoot_MeasureSpec_Width = MeasureSpec.getSize(pWidthMeasureSpec); //MeasureSpec 클래스 크기 설정한값을 부여
                int lRoot_MeasureSpec_Height = MeasureSpec.getSize(pHeightMeasureSpec);//MeasureSpec 클래스 크기 설정한 값을 부여
                switch (lRoot_MeasureSpec_WidthMode) {
                    case MeasureSpec.EXACTLY: { //부모레이아웃 크기 설정후  capable 레이아웃에 경계를 부여

                        lRoot_Width_Max = lRoot_MeasureSpec_Width;

                    }
                    break;
                    case MeasureSpec.AT_MOST: { // caplable 레이아웃 크기 설정
                        if (lRoot_MeasureSpec_HeightMode == MeasureSpec.EXACTLY) {

                            lRoot_Width_Max = Float.MAX_VALUE; // 가로 최대값 설정
                        } else {
                            lRoot_Width_Max = lRoot_MeasureSpec_Width;
                        }

                    }
                    break;
                    default: {

                        lRoot_Width_Max = Float.MAX_VALUE; // 최대값 설정
                        public String toString() {
                            return String.format("%08x (%6.3f, %6.3f) (%6.3f, %6.3f)", hashCode(), getScale_Left(), getScale_Top(), getScale_Right(), getScale_Bottom());
                        }
                        private float mScale_Left = Default_Scale_Left;
                        public float getScale_Left() { return mScale_Left; }
                        public void setScale_Left(float pScale_Left) { mScale_Left = pScale_Left; }
                        public float getScale_Right() { return getScale_Left()+getScale_Width(); }
                        private int mScale_Left_BasePosition;
                        public int getScale_Left_BasePosition() { return mScale_Left_BasePosition; }
                        public void setScale_Left_BasePosition(int pScale_Left_BasePosition) { mScale_Left_BasePosition = pScale_Left_BasePosition; }

                        private float mScale_Top = Default_Scale_Top;
                        public float getScale_Top() { return mScale_Top; }
                        public void setScale_Top(float pScale_Top) { mScale_Top = pScale_Top; }
                        public float getScale_Bottom() { return getScale_Top()+getScale_Height(); }
                        private int mScale_Top_BasePosition;
                        public int getScale_Top_BasePosition() { return mScale_Top_BasePosition; }
                        public void setScale_Top_BasePosition(int pScale_Top_BasePosition) { mScale_Top_BasePosition = pScale_Top_BasePosition; }

                        private float mScale_Width = Default_Scale_Width;
                        public float getScale_Width() { return mScale_Width; }
                        public void setScale_Width(float pScale_Width) { mScale_Width = pScale_Width; }
                        private float mScale_Height = Default_Scale_Height;
                        public float getScale_Height() { return mScale_Height; }
                        public void setScale_Height(float pScale_Height) { mScale_Height = pScale_Height; }
                    }
                }
            }
        }