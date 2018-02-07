package com.example.ravi.onboardingscreen;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ravi on 2/7/18.
 */

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slideImages = {
      R.drawable.icon_eat,
      R.drawable.icon_sleep,
            R.drawable.icon_code
    };

    public String[] slideHeadings ={
      "Eat",
            "Sleep",
            "Code"
    };

    public String[] slideDescriptions ={
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh justo, lobortis vitae lacinia et, scelerisque eu mauris. Morbi euismod scelerisque orci sit amet iaculis.",
            "Fusce mollis turpis at aliquam dapibus. In convallis malesuada arcu non consequat. Proin mattis luctus arcu, et vulputate orci lobortis sed.",
            "In hac habitasse platea dictumst. Duis laoreet metus et dui iaculis aliquam. Vestibulum sit amet lorem eget turpis sollicitudin volutpat."
    };


    @Override
    public int getCount() {
        return slideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (ConstraintLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.iv_image_icon);
        TextView slideHeading = (TextView) view.findViewById(R.id.tv_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.tv_description);

        slideImageView.setImageResource(slideImages[position]);
        slideHeading.setText(slideHeadings[position]);
        slideDescription.setText(slideDescriptions[position]);

        container.addView(view);

        return view;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);  //todo: RelativeLayout??
    }
}
