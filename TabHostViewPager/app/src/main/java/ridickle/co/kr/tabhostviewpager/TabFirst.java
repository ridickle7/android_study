package ridickle.co.kr.tabhostviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class TabFirst extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter vpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_frist);

        // 탭 레이아웃 설정
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("My Story"));
        tabLayout.addTab(tabLayout.newTab().setText("Our Story"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(vpa);

        // 탭 레이아웃 + ViewPager 연결
        tabLayout.setupWithViewPager(viewPager);
    }
}
