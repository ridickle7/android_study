package ridickle.co.kr.tabviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    Button topButton, bottomButton;
    Sub1Fragment fragment1;
    Sub2Fragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        topButton = (Button) findViewById(R.id.buttonTop);
        bottomButton = (Button) findViewById(R.id.buttonBottom);
        fragment1 = Sub1Fragment.newInstance();


        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment1 = Sub1Fragment.newInstance();
                fragment1.setArguments(getIntent().getExtras());

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_button, fragment1).commit();
            }
        });

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment2 = Sub2Fragment.newInstance();
                fragment2.setArguments(getIntent().getExtras());

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_button, fragment2).commit();
            }
        });


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_button, fragment1).commit();
    }
}
