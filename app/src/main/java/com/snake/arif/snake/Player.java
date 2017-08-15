package com.snake.arif.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by Arif on 8/15/2017.
 */

public class Player implements IGameObject{

    private int color;
    public int left, right, top, bottom;
    Rect rectangle;
    public Player(Rect rectangle, int color)
    {
        this.left = rectangle.left;
        this.right = rectangle.right;
        top = rectangle.top;
        bottom = rectangle.bottom;
        this.rectangle = rectangle;
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(this.rectangle,paint);
    }

    @Override
    public void update() {

    }

    public void update(SceneManager.eDirection direction)
    {
        switch (direction)
        {
            case Up:
                this.top--;
                this.bottom--;
                //Log.d("Up","TOP");
                rectangle.set(left, top, right, bottom);
                break;
            case Down:
                this.top++;
                this.bottom++;
                //Log.d("DOWN", "Bottom");
                rectangle.set(left, top, right, bottom);
                break;
            case Left:
                this.left--;
                this.right--;
                //Log.d("Up","TOP");
                rectangle.set(left, top, right, bottom);
                break;
            case Right:
                this.left++;
                this.right++;
                //Log.d("DOWN", "Bottom");
                rectangle.set(left, top, right, bottom);
                break;
        }
    }


}
