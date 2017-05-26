package ridickle.co.kr.tabviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Sub1Fragment extends Fragment {

    private static Sub1Fragment instance;

    public Sub1Fragment() {
        // Required empty public constructor
    }

    public static synchronized Sub1Fragment newInstance(){
        if(instance == null)
            instance = new Sub1Fragment();
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sub1, container, false);
        return v;
    }

}
