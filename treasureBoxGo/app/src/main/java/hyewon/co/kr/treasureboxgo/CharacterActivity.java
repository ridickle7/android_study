package hyewon.co.kr.treasureboxgo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class CharacterActivity extends AppCompatActivity implements View.OnClickListener {

    public static CharacterActivity characterActivity;
    private Button nameButton;
    private Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        characterActivity = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.action_characterTitle));
        toolbar.setSubtitle(getResources().getString(R.string.action_characterSubTitle));

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.white));

        setSupportActionBar(toolbar);

        init();
    }

    public void init(){
        nameButton = (Button) findViewById(R.id.nameButton);
        nameButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.nameButton){
            Intent intent = new Intent(ctx, MainActivity.class);
            intent.setFlags(FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }
}

