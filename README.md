# LoadingLayout

Above two maps are custom different Dialog. Loading as long as you have a wealth of imagination, you can define a more splendid load of animation。
######Gif Loading

![](https://github.com/songxiaoliang/loadinglayout/blob/master/app/demo/gif_demo.jpg "Gif图加载效果") 

######FrameAnimation Loading

![](https://github.com/songxiaoliang/loadinglayout/blob/master/app/demo/frameAnimation_demo.jpg "帧动画加载效果") 

## Development Help

####1.Dependence：

#####Android Studio：
#####Insert the following dependency to build.gradle file of your project:
    
     compile 'com.song:loadinglayout:1.0.1'
      
#####Eclipse：
#####Copy and layout LoadingLayout attrs file module under the values and res folder of your module layout_loading corresponding directory.
      
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

#####layout.xml:

#####The LoadingLayout layout as the root or the same size and layout of the outermost layer layout
	<co.songlcy.loadinglayout.view.LoadingLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:id="@+id/loadinglayout"
	    app:contentBg="#55000000"
	    app:strLoading="正在加载"
	    app:loadingTweenDrawable="@anim/tr"//使用补间动画>
	    
	    <TextView
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:text="Hello World!" />
	        
	</co.songlcy.loadinglayout.view.LoadingLayout>
	
#####Activity:

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
    
