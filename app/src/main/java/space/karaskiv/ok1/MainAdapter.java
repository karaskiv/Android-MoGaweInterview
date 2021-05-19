package space.karaskiv.ok1;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public MainAdapter(FragmentManager fm, Context context, int totalTabs){
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position){
        switch (position) {
            case 0:
                MainTabFragment1 MainTabFragment1 = new MainTabFragment1();
                return MainTabFragment1;
            default:
                return null;
        }
    }
}
