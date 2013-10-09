package com.manishkpr.viewpagerimagegallery;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {
	
	static Product aquaphor=new Product("aquaphor", 12);
	static Product aveeno=new Product("aveeno", 12);
	static Product billyboy=new Product("billyboy", 12);
	
	static Product[] productArray=new Product[]{
			aquaphor,
			billyboy,
			aveeno,
			
	};

	Context context;
    public static  int[] GalImages = new int[] {
        aquaphor.imageId,
        aveeno.imageId,
        billyboy.imageId
        //R.drawable.aquaphor,
        //R.drawable.billyboy,
        //R.drawable.aveeno
    };
    ImageAdapter(Context context){
    	this.context=context;
    }
    @Override
    public int getCount() {
      return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
      return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      ImageView imageView = new ImageView(context);
      int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
      imageView.setPadding(padding, padding, padding, padding);
      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      imageView.setImageResource(GalImages[position]);
      ((ViewPager) container).addView(imageView, 0);
      return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      ((ViewPager) container).removeView((ImageView) object);
    }
  }
