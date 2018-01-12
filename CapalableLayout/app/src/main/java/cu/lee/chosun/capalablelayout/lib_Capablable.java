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

    /*
     * Measure 함수
     * 레이아웃 크기 설정
     */
    @Override
    protected void onMeasure(int pWidthMeasureSpec, int pHeightMeasureSpec) {
//		log("onMeasure ================ Start "+this.toString());

//		float 	lRoot_Width 					= 0;
        float 	lRoot_Width_Max 				= 0;
        int 	lRoot_MeasureSpec_WidthMode 	= MeasureSpec.getMode(pWidthMeasureSpec);

//		float 	lRoot_Height 					= 0;
        float 	lRoot_Height_Max 				= 0;
        int 	lRoot_MeasureSpec_HeightMode 	= MeasureSpec.getMode(pHeightMeasureSpec);

        // get condition of CapableLayout
        // CapableLayout이 지켜야 되는 조건들을 확인함
        {
            int lRoot_MeasureSpec_Width 	= MeasureSpec.getSize(pWidthMeasureSpec);
            int lRoot_MeasureSpec_Height 	= MeasureSpec.getSize(pHeightMeasureSpec);
            switch (lRoot_MeasureSpec_WidthMode) {
                case MeasureSpec.EXACTLY: {
//				log("  onMeasure Width  Exactly "+lRoot_Width+" = min("+mScale_Root_Width+", "+lRoot_MeasureSpec_Width+")");
                    lRoot_Width_Max = lRoot_MeasureSpec_Width;
//				log("  onMeasure Width  Exactly = "+lRoot_Width_Max);
//				lRoot_Width 		= lRoot_MeasureSpec_Width;
                } break;
                case MeasureSpec.AT_MOST: {
                    if (lRoot_MeasureSpec_HeightMode == MeasureSpec.EXACTLY) {
//					lRoot_Width_Max 	= lRoot_MeasureSpec_Width;
                        lRoot_Width_Max = Float.MAX_VALUE;
                    } else {
                        lRoot_Width_Max = lRoot_MeasureSpec_Width;
                    }
//				lRoot_Width 		= lRoot_MeasureSpec_Width;
//				log("  onMeasure Width  AtMost  = "+lRoot_Width_Max);
                } break;
                default: {
//				log("  onMeasure Width  Unspecified "+lRoot_Width_Max+" = "+mScale_Root_Width);
//				lRoot_Width 		= mScale_Root_Width;
//				lRoot_Width_Max 	= Float.MAX_VALUE;
//				lRoot_Width 		= lRoot_WidthSize;
//				lRoot_Width_Max 	= lRoot_WidthSize;
//				break;
//				throw new IllegalArgumentException(String.format("  onMeasure Width  Unspecified %08X", lRoot_MeasureSpec_Width));
                    lRoot_Width_Max = Float.MAX_VALUE;
//				throw new IllegalArgumentException(String.format("  onMeasure Width Unspecified %08X lRoot_MeasureSpec_WidthMode:%d lRoot_MeasureSpec_Width:%d",
//					lRoot_MeasureSpec_Width, lRoot_MeasureSpec_WidthMode, lRoot_MeasureSpec_Width));
                }
            }

            switch (lRoot_MeasureSpec_HeightMode) {
                case MeasureSpec.EXACTLY: {
                    lRoot_Height_Max = lRoot_MeasureSpec_Height;
//				log("  onMeasure Height Exactly = "+lRoot_Height_Max);
                } break;
                case MeasureSpec.AT_MOST: {
                    if (lRoot_MeasureSpec_WidthMode == MeasureSpec.EXACTLY) {
//					lRoot_Height_Max 	= lRoot_MeasureSpec_Height;
                        lRoot_Height_Max = Float.MAX_VALUE;
                    } else {
                        lRoot_Height_Max = lRoot_MeasureSpec_Height;
                    }
//				log("  onMeasure Height AtMost  = "+lRoot_Height_Max);
                } break;
                default: {
//				lRoot_Height = lRoot_Width * mRatioOfWidthHeight;
////			log("  onMeasure Height Unspecified "+lRootHeight+" = "+lRootWidth+"*"+mRatioOfWidthHeight);
//				break;
                    lRoot_Height_Max = Float.MAX_VALUE;
//				throw new IllegalArgumentException(String.format("  onMeasure Height Unspecified %08X lRoot_MeasureSpec_HeightMode:%d lRoot_MeasureSpec_Height:%d",
//					lRoot_MeasureSpec_Height, lRoot_MeasureSpec_HeightMode, lRoot_MeasureSpec_Height));
                }
            }
        }

//		log(String.format("onMeasure 1 lScale:%5.3f ChildCount:%d Root:(%5.3f, %5.3f)", (lRootWidth/mScale_Full_Width), getChildCount(), lRootWidth, lRootHeight));
//		log(String.format("onMeasure 1 lScale:%5.3f ChildCount:%d", (lRootWidth/mScale_Full_Width), getChildCount()));

        float 	lRoot_Width 					= 0;
        float 	lRoot_Height 					= 0;
        for(int tryi = 0 ; tryi < 3 ; tryi++) {
            float lScale_Ratio_Pre = Math.min(lRoot_Width_Max / mScale_Root_Width, lRoot_Height_Max / mScale_Root_Height);
//			log(String.format("onMeasure 1 lScale_Ratio:%5.3f Scale_Ratio:(%5.3f, %5.3f) Scale:(%5.3f, %5.3f)",
//				lScale_Ratio_Pre, (lRoot_Width_Max/mScale_Root_Width), (lRoot_Height_Max / mScale_Root_Height), mScale_Root_Width, mScale_Root_Height));

            //////////////////////// Text Measure
            // TODO english
            // CapableLayout의 TextView중에 TextView_WrapContent_Direction 세팅되어 있을 경우 CapableLayout의 Scale Size와 이웃한 View들의 CapableLayout의 LayoutParams를 재계산
            for (int i=0;i<getChildCount();i++) {
                View lView = getChildAt(i);

                if(lView instanceof TextView) {
                    updateTextViewSize((TextView)lView, lScale_Ratio_Pre);
                }
            }

            // calculate final size of CapableLayout의
            // CapableLayout의 최종적인 크기를 결정지음
            float lScale_Ratio_Post = Math.min(lRoot_Width_Max / mScale_Root_Width, lRoot_Height_Max / mScale_Root_Height);

            {
                lRoot_Width 	= mScale_Root_Width * lScale_Ratio_Post;
                lRoot_Height 	= mScale_Root_Height * lScale_Ratio_Post;
            }

            {
                // 최종적으로 배치 위치를 세팅하기 위해 각 자식 뷰들의 layoutparams를 업데이트함
                // update layoutparams of each child view to arrange finally

//				log("  onMeasure ("+lRoot_Width+","+lRoot_Height+") Ratio:"+mRatioOfWidthHeight+" lScale_TextViewMeasure_Post:"+lScale_Ratio_Post+" lTopMarginFromWeight:"+lTopMarginFromWeight);
                for (int i=0;i<getChildCount();i++) {
                    View lView = getChildAt(i);

                    CapableLayout.LayoutParams lParams = getChildLayoutParams(lView);

                    boolean dif = false;

                    int lParams_Left = Math.round(lScale_Ratio_Post * lParams.getScale_Left());
                    if(lParams.leftMargin != lParams_Left)
                        dif = true;
                    lParams.leftMargin = lParams_Left;

                    int lParams_Width = Math.round(lScale_Ratio_Post * lParams.getScale_Width());
                    if(lParams.width != lParams_Width)
                        dif = true;
                    lParams.width = lParams_Width;
                    switch (lParams.mScale_Left_BasePosition) {
                        case 0: { // left
                        } break;
                        case 1: { // center
                            lParams.leftMargin -= lParams.width / 2;
                        } break;
                        case 2: { // right
                            lParams.leftMargin -= lParams.width;
                        } break;
                    }


//                    log(" lTopMarginFromWeight:"+lTopMarginFromWeight);
//                    int lParams_Top = Math.round(lScale_Ratio_Post * lParams.mScale_Top + lTopMarginFromWeight);
                    int lParams_Top = Math.round(lScale_Ratio_Post * lParams.getScale_Top());
                    if(lParams.topMargin != lParams_Top)
                        dif = true;
                    lParams.topMargin = lParams_Top;

                    int lParams_Height = Math.round(lScale_Ratio_Post * lParams.getScale_Height());
//                    log("lParams_Height "+lParams_Height+" "+lScale_Ratio_Post+" "+lParams_Height);
                    if(lParams.height != lParams_Height)
                        dif = true;
//                    lParams.height = lParams_Height;
                    lParams.height = lParams_Height;
                    switch (lParams.mScale_Top_BasePosition) {
                        case 0: { // left
                        } break;
                        case 1: { // center
                            lParams.topMargin -= lParams.height / 2;
                        } break;
                        case 2: { // right
                            lParams.topMargin -= lParams.height;
                        } break;
                    }

                    if(lParams.mScale_TextSize != -1) {
                        if(lView instanceof TextView) {
                            TextView v = (TextView) lView;
                            if(isDifferentSufficiently(lParams.mScale_TextSize * lScale_Ratio_Post, v.getTextSize())) {
                                v.setTextSize(TypedValue.COMPLEX_UNIT_PX, lParams.mScale_TextSize * lScale_Ratio_Post);
                            }
                        }
                    }

                    if(dif) {
                        lView.setLayoutParams(lParams);
                    }
                }
            }
            if(isDifferentSufficiently(lScale_Ratio_Post, lScale_Ratio_Pre, 1.01f) == false) {
                break;
            }
        }
// -----------------------------------------------------------------------------
}

