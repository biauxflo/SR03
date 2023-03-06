public class point2D {
    protected int x;
    protected int y;

    point2D(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double calculerDistance(point2D p){
        return Math.sqrt(Math.pow(p.getX()-this.x,2)+Math.pow(p.getY()-this.y,2));
    }

    @Override
    public String toString() {
        return "["+x+","+y+"]";
    }
}
