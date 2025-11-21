package com.designer.statemachine.example2;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/4/8 17:23
 */
public class VideoContext {
    /**
     * 当前的状态
     */
    private VideoState mVideoState;
    public final static PlayState PLAY_STATE = new PlayState();
    public final static PauseState PAUSE_STATE = new PauseState();
    public final static SpeedState SPEED_STATE = new SpeedState();
    public final static StopState STOP_STATE = new StopState();

    public VideoState getVideoState() {
        return mVideoState;
    }

    /**
     * 将传入的 VideoState , 赋值给当前的 VideoState mVideoState 成员
     *      除此之外 , 还要设置 VideoState 的上下文 , 即该类本身
     *      将当前的环境 VideoContext , 通知到各个状态实现类
     * @param mVideoState
     */
    public void setVideoState(VideoState mVideoState) {
        this.mVideoState = mVideoState;
        this.mVideoState.setVideoContext(this);
    }

    public void play() {
        this.mVideoState.play();
    }

    public void pause() {
        this.mVideoState.pause();
    }

    public void speed() {
        this.mVideoState.speed();
    }

    public void stop() {
        this.mVideoState.stop();
    }
}
