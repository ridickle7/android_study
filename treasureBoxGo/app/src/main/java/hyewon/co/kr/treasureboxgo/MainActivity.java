package hyewon.co.kr.treasureboxgo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        if(LoginActivity.loginActivity != null)
            LoginActivity.loginActivity.finish();
        if(SignInActivity.signInActivity != null)
            SignInActivity.signInActivity.finish();
        if(CharacterActivity.characterActivity != null)
            CharacterActivity.characterActivity.finish();
    }
}
