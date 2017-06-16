package com.bawei.lvwenjing.spannablestringdome;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static int[] resIDs = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    public static String[] smileArray = {"[干嘛]", "[鼓掌]", "[握手]", "[发疯]"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tv);
        // String content = "吕文静，吕文博，纪仔涛，关孬货";
        String contents = "你好，[干嘛]吃饭了吗[握手][握手][握手][握手][握手][握手]";
        final SpannableString spannableString = new SpannableString(contents);
        tv.setText(toImageSpan(this, contents, resIDs, smileArray));
/*     //背景颜色
        spannableString.setSpan(new BackgroundColorSpan(Color.BLUE), 4, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //下划线
        spannableString.setSpan(new UnderlineSpan(), 7, 10, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
       //前景颜色也就是字体颜色
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 4, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/

   /*     //设置图片注意 设图片的大小
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0, 0, 50, 50);
        spannableString.setSpan(new ImageSpan(drawable), 5, 6, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        */
  /*      //加粗
        spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 4, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //下标
        spannableString.setSpan(new SubscriptSpan(), 5, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //上标
        spannableString.setSpan(new SuperscriptSpan(), 6, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //加超链接 注意加点击事件 tv.setMovementMethod(new LinkMovementMethod());
        spannableString.setSpan(new URLSpan("http://www.baidu.com"), 8, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/
//        ClickableSpan clickableSpan = new ClickableSpan() {     @Override     public void onClick(View widget) { 
//             
//            System.out.println("widget = " + widget);     } 
//                 
//            @Override     public void updateDrawState(TextPaint ds) {         super.updateDrawState(ds);         ds.setColor(Color.RED);         ds.setUnderlineText(true); 
//                 
//            }  } ; 
//         
//        spannableString.setSpan(clickableSpan,3,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE); 

        //点击事件设置同时别忘了点击事件的设置        tv.setMovementMethod(new LinkMovementMethod());
    /*    ClickableSpan click = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //吐司位置的设置
                Toast toast = Toast.makeText(getApplicationContext(),
                        "你好啊", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK, 0, 0);
                toast.show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                //修改字体颜色
                ds.setColor(Color.LTGRAY);
            }
        };
        spannableString.setSpan(click, 6, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(spannableString);
        tv.setMovementMethod(new LinkMovementMethod());*/


    }

    //图文混聊
    public static SpannableString toImageSpan(Context context, String contents, int[] emoImg, String[] emoText) {
        SpannableString ss = new SpannableString(contents);
        for (int i = 0; i < emoText.length; i++) {
            int startPos = 0;
            String rep = emoText[i];
            int fromPos = 0;
            while ((startPos = contents.indexOf(rep, fromPos)) != -1) {
                fromPos = startPos + rep.length();
                Bitmap bit = BitmapFactory.decodeResource(context.getResources(), emoImg[i]);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bit);
                bitmapDrawable.setBounds(0, 0, 50, 50);
                ImageSpan span = new ImageSpan(bitmapDrawable);
                ss.setSpan(span, startPos, fromPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return ss;
    }

}
