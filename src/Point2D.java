public class Point2D {
    private int curX;
    private int curY;

    private int width;
    private int height;

    public Point2D(int x, int y)
    {
        curX = x;
        curY = y;
        width = 10;
        height = 10;
    }

    public boolean isMove(int x, int y)
    {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void moveT0(int dx, int dy)
    {
        if (isMove(curX+dx, curY+dy))
        {
            curX += dx;
            curY += dy;
        }
    }
}
