package com.example.commonlibrary.weight;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author : Chengxiaolin
 * e-mail : robin125@sina.cn
 * date   : 2019/11/18  21:00
 * desc   :
 * version: 1.0
 */
public class WallpaperPaperAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;

    public WallpaperPaperAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }
}
