package com.designer.statemachine.example2;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/4/8 17:24
 */
public class Test {
    public static void main(String[] args) {
        VideoContext videoContext = new VideoContext();
        videoContext.setVideoState(VideoContext.PLAY_STATE);
        System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());

        videoContext.pause();
        System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());

        videoContext.speed();
        System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());

        videoContext.stop();
        System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());

        videoContext.speed();
        System.out.println("当前视频状态 : " + videoContext.getVideoState().getClass().getSimpleName());
    }
}
