package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;

import java.util.ArrayList;

/**
 * 整个页面的MainFragment,在这个上加其他的Fragment
 *
 * Created by dllo on 16/1/26.
 */
public class MainFragment extends BaseFragment {

    private ArrayList<Fragment> data;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MainActivity mainActivity;
    private MainFragmentPageAdapter adapter;

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initFindViewById(view);
        initTabLayout();
        return view;
    }

    public void initFindViewById(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);

        data = new ArrayList<>();
        data.add(MyFragment.newInstance());
        data.add(FindFragment.newInstance());
        data.add(RecommendFragment.newInstance());
        data.add(TestNetFragment.newInstance());

        /**
         * 传getChildFragmentManager()这个  不要传mainActivity.getSupportFragmentManager()
         * Fragment配合ViewPager使用时适配器要用getChildFragmentManager()这个参数
         */
        adapter = new MainFragmentPageAdapter(getChildFragmentManager(), data, mainActivity);
        viewPager.setAdapter(adapter);
    }

    public void initTabLayout() {
        // 设置选中前的颜色和不选中的颜色
        tabLayout.setTabTextColors(Color.rgb(180,182,188), Color.WHITE);
        tabLayout.setupWithViewPager(viewPager);
        //最下面选中的颜色      设置透明色
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
    }


    /**
     * MainFragmentPageAdapter是内部类适配器
     */
    public class MainFragmentPageAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> data;
        private Context context;
        private String[] title = {"我的", "发现", "咪咕推荐","热门歌曲"};   //"热门歌曲" -替换- "测试网络播放"

        public MainFragmentPageAdapter(FragmentManager fm, ArrayList<Fragment> data, Context context) {
            super(fm);
            this.data = data;
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
