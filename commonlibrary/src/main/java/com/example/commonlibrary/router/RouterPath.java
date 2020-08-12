package com.example.commonlibrary.router;

/**
 * Created by ${xinGen} on 2018/5/3 0003.
 * 博客：https://blog.csdn.net/hexingen
 *
 * 注意点：不同module下的"/xxx1/xxx2"中，xxx1不能一样。每一个组件xxx1是不能相同的
 */

public final class RouterPath {
    /**
     * 首页的路径
     */
    public static final String PATH_FRAGMENT_HOME="/HomeService/fragment_home";
    /**
     * 直播的路径
     */
  public static final String PATH_FRAGMENT_LIVE="/LiveService/fragment_live";
    /**
     * 我的消息
     */
    public static final String PATH_FRAGMENT_MESSAGE="/MessageService/fragment_message";
    /**
     * 我的的路径
     */
   public static final String PATH_FRAGMENT_MINE="/MineService/fragment_mine";
}
