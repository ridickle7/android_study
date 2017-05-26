package hyewon.co.kr.treasureboxgo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    public static SignInActivity signInActivity;
    private Button signInButton;
    private Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signInActivity = this;

        init();
    }

    public void init(){
        signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.signInButton){
            Intent intent = new Intent(ctx, CharacterActivity.class);
            startActivity(intent);
        }
    }
}
