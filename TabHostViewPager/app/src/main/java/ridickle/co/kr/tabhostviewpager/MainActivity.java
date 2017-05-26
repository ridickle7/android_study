package ridickle.co.kr.tabhostviewpager;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    LocalActivityManager mLocalActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocalActivityManager = new LocalActivityManager(this, false);
        mLocalActivityManager.dispatchCreate(savedInstanceState);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHostTop);
        tabHost.setup(mLocalActivityManager);

        // 탭 추가
        tabHost.addTab(tabHost.newTabSpec("Tab01")
                .setIndicator("First", getResources().getDrawable(R.mipmap.ic_launcher))
                .setContent(new Intent(this, TabFirst.class)));

        tabHost.addTab(tabHost.newTabSpec("Tab02")
                .setIndicator("Second", getResources().getDrawable(R.mipmap.ic_launcher))
                .setContent(new Intent(this, TabSecond.class)));

        tabHost.addTab(tabHost.newTabSpec("Tab03")
                .setIndicator("Third", getResources().getDrawable(R.mipmap.ic_launcher))
                .setContent(new Intent(this, TabThird.class)));

        tabHost.setCurrentTab(0);
    }

    // 추가하래서 추가함1
    @Override
    protected void onResume() {
        super.onResume();
        mLocalActivityManager.dispatchResume();
    }

    // 추가하래서 추가함2
    @Override
    protected void onPause() {
        super.onPause();
        mLocalActivityManager.dispatchPause(isFinishing());
    }
}
