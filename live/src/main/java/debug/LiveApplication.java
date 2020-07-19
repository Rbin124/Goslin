package debug;

import android.util.Log;

import com.example.commonlibrary.base.BaseApplication;

public class LiveApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("--LiveApplication--","LiveApplication");
    }
}
