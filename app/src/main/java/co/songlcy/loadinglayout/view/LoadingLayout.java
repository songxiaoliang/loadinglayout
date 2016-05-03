package co.songlcy.loadinglayout.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import co.songlcy.loadinglayout.R;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Song on 2016/4/30.
 * Blog:http://blog.csdn.net/u013718120
 */
public class LoadingLayout extends RelativeLayout{


    private Context mContext;
    private View loadingView;
    private TextView tvLoading;
    private ImageView ivLoading;
    private LinearLayout llyContent;
    private LinearLayout llyLoading;
    private GifImageView gifImageView;
    private AnimationDrawable mAnimationDrawable;
    private int contentBg;//contentBg
    private int loadingBg;//loadingBg:default:white
    private int distance;//text and Drawable distance default:10dp
    private int gifViewWidth;//GifImage width default:30dp
    private int gifViewHeight;//GifImage height default:30dp
    private int imgLoadingWidth;//loadingImage width
    private int imgLoadingHeight;//loadingImage height
    private int loadingWidth;//loading width default:200dp
    private int loadingHeight;//loading height default:100dp
    private int strLoadingColor;//textColor：default: black
    private int strLoadingSize;//textSize  default:16dp
    private String strLoading;
    private Drawable loadingDrawable;//loading animation-list
    private Drawable loadingGif;//GifImage
    private Drawable loadingContentDrawable;//Loading style

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public LoadingLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        TypedArray typedArray = context.getTheme().
                obtainStyledAttributes(attrs, R.styleable.LoadingLayout, 0, 0);

        int attrNum = typedArray.getIndexCount();

        for (int i = 0; i < attrNum; i++) {

            int attr = typedArray.getIndex(i);
            if(attr == R.styleable.LoadingLayout_contentBg) {
                contentBg = typedArray.getColor(attr,Color.parseColor("#55000000"));
            } else if(attr == R.styleable.LoadingLayout_loadingBg) {
                loadingBg = typedArray.getColor(attr,Color.WHITE);
            } else if(attr == R.styleable.LoadingLayout_loadingDrawable) {
                loadingDrawable = typedArray.getDrawable(attr);
            } else if(attr == R.styleable.LoadingLayout_loadingHeight) {
                loadingHeight = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics()));
            } else if(attr == R.styleable.LoadingLayout_loadingWidth) {
                loadingWidth = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics()));
            } else if(attr == R.styleable.LoadingLayout_strLoading) {
                strLoading = typedArray.getString(attr);
            } else if(attr == R.styleable.LoadingLayout_strLoadingColor) {
                strLoadingColor = typedArray.getColor(attr, Color.BLACK);
            } else if(attr ==  R.styleable.LoadingLayout_strLoadingSize) {
                strLoadingSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
            } else if(attr == R.styleable.LoadingLayout_imgLoadingHeight) {
                imgLoadingHeight = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics()));
            } else if(attr == R.styleable.LoadingLayout_imgLoadingWidth) {
                imgLoadingWidth = typedArray.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,30,getResources().getDisplayMetrics()));

            } else if(attr == R.styleable.LoadingLayout_gifViewHeight) {
                gifViewHeight = typedArray.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,30,getResources().getDisplayMetrics()));
            } else if(attr == R.styleable.LoadingLayout_gifViewWidth) {
                gifViewWidth = typedArray.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,30,getResources().getDisplayMetrics()));
            } else if(attr == R.styleable.LoadingLayout_distance) {
                distance = typedArray.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,10,getResources().getDisplayMetrics()));
            } else if(attr == R.styleable.LoadingLayout_loadingGif) {
                loadingGif = typedArray.getDrawable(attr);
            } else if(attr == R.styleable.LoadingLayout_loadingContentDrawable) {
                loadingContentDrawable = typedArray.getDrawable(attr);
            }
        }

        typedArray.recycle();
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void init() {

        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        loadingView = LayoutInflater.from(mContext).inflate(R.layout.layout_loading,null);
        post(new Runnable() {
            @Override
            public void run() {

                addView(loadingView, -1, new LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            }
        });

        initView();
        initViewAttrValue();
    }

    /**
     * find all views
     */
    private void initView() {

        tvLoading = (TextView) loadingView.findViewById(R.id.tv_loading);
        ivLoading = (ImageView) loadingView.findViewById(R.id.iv_loading);
        gifImageView = (GifImageView) loadingView.findViewById(R.id.gif_view);
        llyContent = (LinearLayout) loadingView.findViewById(R.id.lly_content);
        llyLoading = (LinearLayout) loadingView.findViewById(R.id.lly_loading);

    }

    /**
     * init views attribute value
     */
    private void initViewAttrValue() {

        if(null != strLoading) {
            tvLoading.setText(strLoading);
        }

        if(strLoadingSize != 0) {

            tvLoading.setTextSize(TypedValue.COMPLEX_UNIT_PX,strLoadingSize);
        }

        if(strLoadingColor != 0) {
            tvLoading.setTextColor(strLoadingColor);
        }

        if(distance != 0) {

           LinearLayout.LayoutParams tvLoadingLP = (LinearLayout.LayoutParams) tvLoading.getLayoutParams();
           tvLoadingLP.leftMargin = distance;
        }

        if(loadingHeight != 0 ) {

            LinearLayout.LayoutParams loadingLP = (LinearLayout.LayoutParams) llyLoading.getLayoutParams();
            loadingLP.height = loadingHeight;
        }

        if(loadingWidth != 0 ) {

            LinearLayout.LayoutParams loadingLP = (LinearLayout.LayoutParams) llyLoading.getLayoutParams();
            loadingLP.width = loadingWidth;
        }

        if(imgLoadingWidth != 0) {

            ViewGroup.LayoutParams ivLoadingLp = ivLoading.getLayoutParams();
            ivLoadingLp.width = imgLoadingWidth;
        }

        if(imgLoadingHeight != 0) {

            ViewGroup.LayoutParams ivLoadingLp = ivLoading.getLayoutParams();
            ivLoadingLp.height = imgLoadingHeight;
        }

        if(gifViewWidth != 0) {

            ViewGroup.LayoutParams gifLp = gifImageView.getLayoutParams();
            gifLp.width = gifViewWidth;
        }

        if(gifViewHeight != 0) {

            ViewGroup.LayoutParams gifLp = gifImageView.getLayoutParams();
            gifLp.height = gifViewHeight;

        }

        if(null != loadingDrawable && null != loadingGif) {

            ivLoading.setVisibility(View.VISIBLE);
            ivLoading.setBackground(ContextCompat.getDrawable(mContext, R.drawable.anim_loading));
        } else if(null != loadingDrawable) {

            ivLoading.setVisibility(View.VISIBLE);
            ivLoading.setBackground(loadingDrawable);
        } else if(null != loadingGif) {

            gifImageView.setVisibility(View.VISIBLE);
            gifImageView.setImageDrawable(loadingGif);
        } else {

            ivLoading.setVisibility(View.VISIBLE);
            ivLoading.setBackground(ContextCompat.getDrawable(mContext, R.drawable.anim_loading));
        }

        if(contentBg != 0) {

            llyContent.setBackgroundColor(contentBg);
        }

        if(loadingBg != 0) {

            llyLoading.setBackgroundColor(loadingBg);
        }

        if(loadingContentDrawable != null) {
            llyLoading.setBackground(loadingContentDrawable);
        }

        requestLayout();
    }

    /**
     * show loading
     */
    public void showLoading() {

        llyContent.setVisibility(View.VISIBLE);
        try {
            mAnimationDrawable = (AnimationDrawable)ivLoading.getBackground();
            mAnimationDrawable.start();
        } catch(Exception e) {
            ivLoading.setBackground(ContextCompat.getDrawable(mContext, R.drawable.anim_loading));
            mAnimationDrawable = (AnimationDrawable)ivLoading.getBackground();
            mAnimationDrawable.start();
        }
    }

    /**
     * hide Loading
     */
    public void hideLoading() {

        try {
            mAnimationDrawable.stop();
            llyContent.setVisibility(View.GONE);
        } catch(Exception e) {
            Log.e("co.song.loadinglayout","mAnimationDrawable is error");
        }
    }
}
