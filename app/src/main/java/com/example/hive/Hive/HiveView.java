package com.example.hive.Hive;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceView;

import com.example.hive.R;

public class HiveView extends SurfaceView {

    protected HiveGameState state = new HiveGameState();
//    private HiveGameState.piece piece;

    Paint wBee = new Paint();
    Paint wBeetle = new Paint();
    Paint wSpider = new Paint();
    Paint wAnt = new Paint();
    Paint wGrasshopper = new Paint();

    Paint hexagonalPaint = new Paint();
    Paint hexagonalTargetPaint = new Paint();
    Paint HexagonalPaintOutline = new Paint();

    Path Hexagon = new Path();
    Point point1 = new Point();
    Point point2 = new Point();
    Point point3 = new Point();
    Point point4 = new Point();
    Point point5 = new Point();
    Point point6 = new Point();

    public HiveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        hexagonalPaint.setColor(Color.WHITE);
        hexagonalPaint.setStyle(Paint.Style.FILL);

        hexagonalTargetPaint.setColor(Color.RED);
        HexagonalPaintOutline.setColor(Color.BLACK);

        wBee.setColor(Color.RED);

        hexagonalTargetPaint.setStyle(Paint.Style.STROKE);
        HexagonalPaintOutline.setStyle(Paint.Style.STROKE);

        Hexagon.setFillType(Path.FillType.EVEN_ODD);


    }

    public void setState(HiveGameState state) {
        this.state = state;
    }

    public void onDraw(Canvas canvas) {
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 12; x++) {
                if (y % 2 == 0) {

                    /*drawHexagon(canvas, x, y);*/
                    if (state.getPiece(x,y) == HiveGameState.piece.EMPTY) {
                        drawHexagon(canvas, x * 100, y * 66);
                    } else if (state.getPiece(x, y) == HiveGameState.piece.WBEE) {
                        drawWBee(canvas, x*100, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.WBEETLE) {
                        drawWBeetle(canvas, x*100, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.WGHOPPER) {
                        drawWGhopper(canvas, x*100, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.WSPIDER) {
                        drawWSpider(canvas, x*100, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.WANT) {
                        drawWAnt(canvas, x*100, y*66);
                    }
                    if (state.getPiece(x, y) == HiveGameState.piece.BBEE) {
                        drawBBee(canvas, x*100, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.BBEETLE) {
                        drawBBeetle(canvas, x*100, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.BGHOPPER) {
                        drawBGhopper(canvas, x*100, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.BSPIDER) {
                        drawBSpider(canvas, x*100, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.BANT) {
                        drawBAnt(canvas, x*100, y*66);
                    }
                } else {
                    if (state.board[x][y] == HiveGameState.piece.EMPTY) {
                        drawHexagon(canvas, x * 100 + 50, y * 66);
                    } else if (state.getPiece(x, y) == HiveGameState.piece.WBEE) {
                        drawWBee(canvas, x*100 + 50, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.WBEETLE) {
                        drawWBeetle(canvas, x*100 + 50, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.WGHOPPER) {
                        drawWGhopper(canvas, x*100 + 50, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.WSPIDER) {
                        drawWSpider(canvas, x*100 + 50, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.WANT) {
                        drawWAnt(canvas, x*100 + 50, y*66);
                    }
                    if (state.getPiece(x, y) == HiveGameState.piece.BBEE) {
                        drawBBee(canvas, x*100 + 50, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.BBEETLE) {
                        drawBBeetle(canvas, x*100 + 50, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.BGHOPPER) {
                        drawBGhopper(canvas, x*100 + 50, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.BSPIDER) {
                        drawBSpider(canvas, x*100 + 50, y*66);
                    } else if (state.getPiece(x,y) == HiveGameState.piece.BANT) {
                        drawBAnt(canvas, x*100 + 50, y*66);
                    }
                }
            }
        }
    }

    public void drawHexagon(Canvas canvas, int x, int y) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(x, y), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(x, y), HexagonalPaintOutline);

    }

    public void drawWBee(Canvas canvas, int startX, int startY) {

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.wbee);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(b, 75, 80, false);

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);

        canvas.drawBitmap(resizedBitmap, startX+13, startY+12, wBee);
    }

    public void drawWBeetle(Canvas canvas, int startX, int startY) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.wbeetle);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(
                b, 100, 66, false);
        wBeetle.setColor(Color.RED);
        canvas.drawBitmap(resizedBitmap, startX, startY, wBeetle);


    }

    public void drawWSpider(Canvas canvas, int startX, int startY) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.wspider);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(
                b, 100, 66, false);
        wSpider.setColor(Color.RED);
        canvas.drawBitmap(resizedBitmap, startX, startY, wBeetle);
    }

    public void drawWAnt(Canvas canvas, int startX, int startY) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.want);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(
                b, 100, 66, false);
        wAnt.setColor(Color.RED);
        canvas.drawBitmap(resizedBitmap, startX, startY, wAnt);
    }

    public void drawWGhopper(Canvas canvas, int startX, int startY) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.wgrasshopper);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(
                b, 100, 66, false);
        wGrasshopper.setColor(Color.RED);
        canvas.drawBitmap(resizedBitmap, startX, startY, wGrasshopper);

    }

    public void drawBBee(Canvas canvas, int startX, int startY) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);


    }

    public void drawBBeetle(Canvas canvas, int startX, int startY) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);


    }

    public void drawBSpider(Canvas canvas, int startX, int startY) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);


    }

    public void drawBAnt(Canvas canvas, int startX, int startY) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);


    }

    public void drawBGhopper(Canvas canvas, int startX, int startY) {

        //draw filled hexagon
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);


    }

    public void drawTargetHexagon(Canvas canvas, int startX, int startY) {

        //draw red outlines
        canvas.drawPath(drawHexagonLines(startX, startY), hexagonalTargetPaint);

        //draw black outlines
        canvas.drawPath(drawHexagonLines(startX, startY), HexagonalPaintOutline);
    }

    /**
     * Modifies the path object by setting six points around target point and connects each point with a line.
     *
     * @param x x coordinate of hexagon origin
     * @param y y coordinate of hexagon origin
     * @return Hexagon  modified path class in the shape of a hexagon
     * <p>
     * *note* this method only draws lines, filling is done by paint
     */
    private Path drawHexagonLines(int x, int y) {
        point1.set(x, y + 33);
        point2.set(x + 50, y);
        point3.set(x + 100, y + 33);
        point4.set(x + 100, y + 66);
        point5.set(x + 50, y + 100);
        point6.set(x, y + 66);

        /*          point2
         *            / \
         *          /     \
         *  point6 /       \  point 4
         *        |         |
         *        |         |
         *        |         | point 3
         *  point1 \       /
         *          \     /
         *            \ /
         *          point5
         */

        Hexagon.moveTo(point1.x, point1.y);
        Hexagon.lineTo(point2.x, point2.y);
        Hexagon.lineTo(point3.x, point3.y);
        Hexagon.lineTo(point4.x, point4.y);
        Hexagon.lineTo(point5.x, point5.y);
        Hexagon.lineTo(point6.x, point6.y);
        Hexagon.close();

        return Hexagon;
    }
}

