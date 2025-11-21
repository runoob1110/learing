package com.designer.statemachine.example2;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/4/8 17:22
 */
public class StopState extends VideoState {
    /**
     * 播放时 , 只需要调用 PlayState 父类 VedioState 的上下文 VedioContext
     *      将上下文 VedioContext 中的状态 , 设置为 播放 的状态即可
     */
    @Override
    public void play() {
        super.videoContext.setVideoState(VideoContext.PLAY_STATE);
    }

    /**
     * 不能暂停
     */
    @Override
    public void pause() {
        System.out.println("停止状态不能暂停");
    }

    /**
     * 不能快进
     */
    @Override
    public void speed() {
        System.out.println("停止状态不能快进");
    }

    /**
     * 停止时 , 只需要调用 PlayState 父类 VedioState 的上下文 VedioContext
     *      将上下文 VedioContext 中的状态 , 设置为 停止 的状态即可
     */
    @Override
    public void stop() {
        System.out.println("停止播放视频");
    }
}
