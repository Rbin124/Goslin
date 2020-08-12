package com.example.message.router;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.router.MessageProvider;
import com.example.commonlibrary.router.RouterPath;
import com.example.message.fragment.MessageFragment;


/**
 * Created by ${xinGen} on 2018/5/4 0004.
 * 博客：https://blog.csdn.net/hexingen
 */
@Route(path = RouterPath.PATH_FRAGMENT_MESSAGE)
public class MessageProviderImpl implements MessageProvider {

    @Override
    public Fragment createFragment() {
        return MessageFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
