package debug;

import android.util.Log;

import com.example.commonlibrary.base.BaseApplication;


public class HomeApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("--LiveApplication--","LiveApplication");
    }
}
