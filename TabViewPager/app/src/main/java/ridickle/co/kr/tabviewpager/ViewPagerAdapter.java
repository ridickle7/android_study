package ridickle.co.kr.tabviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ridickle on 2017. 4. 5..
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    Fragment[] arrFragment;
    String[] tabTitle;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        arrFragment = new Fragment[3];
        tabTitle = new String[]{"tab1", "tab2", "tab3"};

        arrFragment[0] = new BlueFragment();
        arrFragment[1] = new YellowFragment();
        arrFragment[2] = new GreenFragment();
    }

    @Override
    public Fragment getItem(int position) {
        return arrFragment[position];
    }

    @Override
    public int getCount() {
        return arrFragment.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
