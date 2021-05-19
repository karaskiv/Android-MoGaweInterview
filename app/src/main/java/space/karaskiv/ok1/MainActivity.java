package space.karaskiv.ok1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fb,google,twitter;
    TextView txtMenu1,txtMenu2,menuBar,footTxt1,footTxt2;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        fb = findViewById(R.id.fab_fb);
        google = findViewById(R.id.fab_google);
        twitter = findViewById(R.id.fab_twitter);
        txtMenu1 = findViewById(R.id.txtMenu1);
        txtMenu2 = findViewById(R.id.txtMenu2);
        menuBar = findViewById(R.id.menuBar);
        footTxt1 = findViewById(R.id.footTxt1);
        footTxt2 = findViewById(R.id.footTxt2);


        tabLayout.addTab(tabLayout.newTab().setText("Main"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MainAdapter adapter = new MainAdapter(getSupportFragmentManager(), this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        fb.setTranslationY(300);
        google.setTranslationY(300);
        twitter.setTranslationY(300);
        tabLayout.setTranslationY(300);
        txtMenu1.setTranslationX(300);
        txtMenu2.setTranslationX(300);
        menuBar.setTranslationX(300);
        footTxt1.setTranslationY(300);
        footTxt2.setTranslationY(300);


        fb.setAlpha(v);
        google.setAlpha(v);
        twitter.setAlpha(v);
        tabLayout.setAlpha(v);
        txtMenu1.setAlpha(v);
        txtMenu2.setAlpha(v);
        menuBar.setAlpha(v);
        footTxt1.setAlpha(v);
        footTxt2.setAlpha(v);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        txtMenu1.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(400).start();
        txtMenu2.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(400).start();
        menuBar.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(400).start();
        footTxt1.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        footTxt2.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(850).start();



    }
}