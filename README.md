# LoadingLayout
Above two maps are custom different Dialog. Loading as long as you have a wealth of imagination, you can define a more splendid load of animation。
## Development Help
####1.Insert the following dependency to build.gradle file of your project:
    
      compile 'com.song:loadinglayout:1.0.0'
      
####2.LoadingLayout support function：
      
    app:contentBg="@android:color/transparent" //遮罩层背景色
      
    app:loadingBg="@android:color/white" //Loading窗口背景色
      
    app:distance="5dp" //drawable和文字之间的间距
      
    app:gifViewWidth="30dp" //Gif图宽度
      
    app:gifViewHeight="30dp" //Gif图宽度
      
    app:imgLoadingWidth="30dp" //ImageView宽度
      
    app:imgLoadingHeight="30dp" //ImageView高度
      
    app:loadingWidth="200dp" //Loading窗口的宽度
      
    app:loadingHeight="100dp" //Loading窗口的高度
      
    app:strLoadingColor="@android:color/black" //Loading字体颜色
      
    app:strLoadingSize="16dp" //Loading字体大小
      
    app:strLoading="正在加载" //Loading文字提示
      
    app:loadingGif="@drawable/mygif" //Gif图
      
    app:loadingContentDrawable="@drawable/shape" //Loading窗口的自定义Drawable，例如圆角shape。
      
    app:loadingFrameDrawable="@drawable/anim_loadig" //Loading的帧动画
    
    app:loadingImage="@mipmap/ic_launcher" // 显示的图片，此属性要结合补间动画一起使用。
    
    app:loadingTweenDrawable="@anim/translate" //补间动画，此属性要结合app:loadingImage一起使用。
    
####3.Use code：
    mLoadingLayout = (LoadingLayout) findViewById(R.id.loadinglayout);
    
    mLoadingLayout.showLoading();//显示Loading
    
        new Handler().postDelayed(new Runnable() {
    
            @Override
	        public void run() {
                
		        //延迟5秒后隐藏Loading
		        mLoadingLayout.hideLoading();
            
	        }
        
	    },5000);
        
## My Blog
####[Click to view](http://blog.csdn.net/u013718120)
## Contact Me
####Email：563609104@qq.com
    