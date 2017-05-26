package hyewon.co.kr.treasureboxgo;

import java.util.ArrayList;

/**
 * Created by ridickle on 2016. 12. 14..
 */

public class TestMain {



    public static void main(){

        ArrayList<String> list = new ArrayList<String>();

        for(int i = 0 ; i < 30; i++){

            list.add("test"+i);
        }

        list.stream().forEach(System.out::println);
    }
}
