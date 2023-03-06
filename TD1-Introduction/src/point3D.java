public class point3D extends point2D{

    private int z;

    point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "["+x+","+y+","+z+"]";
    }

    public double calculerDistance(point3D p) {
        return Math.sqrt(Math.pow(p.getX()-this.x,2)+Math.pow(p.getY()-this.y,2)+Math.pow(p.getZ()-this.z,2));
    }
}
