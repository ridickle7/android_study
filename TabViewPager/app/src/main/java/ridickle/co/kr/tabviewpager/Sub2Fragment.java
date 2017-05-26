package ridickle.co.kr.tabviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Sub2Fragment extends Fragment {

    static Sub2Fragment instance;

    public Sub2Fragment() {
        // Required empty public constructor
    }

    public static synchronized Sub2Fragment newInstance(){
        if(instance == null)
            instance = new Sub2Fragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sub2, container, false);
        return v;
    }

}
