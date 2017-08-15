package com.snake.arif.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Arif on 8/15/2017.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    public GameThread gameThread;
    public SceneManager manager;
    public GamePanel(Context context)
    {
        super(context);
        getHolder().addCallback(this);
        Constants.CURRENT_CONTEXT = context;
        gameThread = new GameThread(getHolder(), this);
        manager = new SceneManager();
        setFocusable(true);

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        gameThread = new GameThread(getHolder(), this);
        Constants.INIT_TIME = System.currentTimeMillis();
        gameThread.setRunning(true);
        gameThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry)
        {
            try {
                gameThread.setRunning(false);
                gameThread.join();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            manager.recieveTouch(event);
            return true;
        }
        return false;
    }



    public void update()
    {
        manager.update();
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        manager.draw(canvas);
    }
}
