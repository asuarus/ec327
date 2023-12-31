package com.example.screamybird;

import static com.example.screamybird.GameView.screenRatioX;
import static com.example.screamybird.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

/*
This is the snake class that creates the snake and animates it
 */
public class Snake {
    public int speed = 20;
    int x,y, width, height, snakeCounter=1;
    Bitmap snake1, snake2, snake3;

    Snake(Resources res){   //creates the snake
        snake1 = BitmapFactory.decodeResource(res, R.drawable.snake1);
        snake2 = BitmapFactory.decodeResource(res, R.drawable.snake2);
        snake3 = BitmapFactory.decodeResource(res, R.drawable.snake3);

        width = snake1.getWidth();
        height = snake1.getHeight();

        width /= 7;
        height /= 7;

        width *= (int) (width * screenRatioX);
        height *= (int) (height * screenRatioY);

        snake1 = Bitmap.createScaledBitmap(snake1, width, height, false);
        snake2 = Bitmap.createScaledBitmap(snake2, width, height, false);
        snake3 = Bitmap.createScaledBitmap(snake3, width, height, false);

        y =  -height;
    }

    Bitmap getSnake(){  //this animates the snake with three different images
        if (snakeCounter == 1) {
            snakeCounter++;
            return snake1;
        }
        if (snakeCounter == 2) {
            snakeCounter++;
            return snake2;
        }
        if (snakeCounter == 3) {
            snakeCounter++;
            return snake3;
        }
        snakeCounter = 1;
        return snake1;
    }

    Rect GetCollisionShape () { //this creates the collision shape for the snake
        return new Rect(x, y, (int) (x + width*.6), (int) (y + height*.75));
    }
}
