package com.snake.arif.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * Created by Arif on 8/15/2017.
 */

public class SceneManager implements IScene {

    private Player player;
    private Point playerPoint;
    //private ObstacleManager obstacleManager;
    private boolean gameOver = false;
    private boolean movingPlayer = false;
    private long gameOverTime;
    private Rect r = new Rect();
    eDirection direction = eDirection.Down;
    //private OrientationData orientationData;
    private float x1,x2;
    private long startClickTime;
    static final int MIN_DISTANCE = 150;
    static final int MAX_SWIPE_TIME = 200;
    private long frameTime;

    public SceneManager()
    {
        player = new Player(new Rect(500,500,600,600), Color.rgb(255,0,0));
        playerPoint = new Point(Constants.SCREEN_WIDTH/2,3*Constants.SCREEN_HEIGHT/4);
        player.update(direction);
        frameTime = System.currentTimeMillis();
    }


    @Override
    public void update() {
        player.update(direction);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        player.draw(canvas);
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        if(direction == eDirection.Up || direction == eDirection.Down) {
            if (event.getX() > player.right)
                direction = eDirection.Right;
            if (event.getX() < player.left)
                direction = eDirection.Left;
        }
        else {
            if (event.getY() > player.bottom)
                direction = eDirection.Down;
            if (event.getY() < player.top)
                direction = eDirection.Up;
        }
    }

    public enum eDirection
    {
        Up,
        Down,
        Left,
        Right
    }
}
