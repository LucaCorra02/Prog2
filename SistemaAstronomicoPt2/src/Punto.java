import java.util.Objects;

public class Punto {

    private final int x;
    private final int y;
    private final int z;

    public Punto(int a,int b, int c){
        x=a;
        y=b;
        z=c;
    }

    public Punto sottrai(Punto q){
        if (q ==null) throw new NullPointerException("q non può essere un riferimento a null");
        int v1 = x-q.getX();
        int v2 = y-q.getY();
        int v3 = z-q.getZ();

        //asert RepOk();
        return new Punto(v1,v2,v3);
    }

    public Punto somma(Punto q){
        if (q ==null) throw new NullPointerException("q non può essere un riferimento a null");
        int v1 = x+q.getX();
        int v2 = y+q.getY();
        int v3 = z+q.getZ();

        //asert RepOk();
        return new Punto(v1,v2,v3);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int norma(){
        return Math.abs(x)+Math.abs(y)+Math.abs(z);
    }

    @Override
    public String toString() {
        return "("+x+", "+y+", "+z+")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Punto)) return false;
        Punto tmp=(Punto) obj;
        return this.x==tmp.getX() && this.y==tmp.getY() && this.z==tmp.getZ();
    }

    @Override
    public int hashCode() {
        return 31*Objects.hashCode(this.x)+Objects.hashCode(this.y)+Objects.hashCode(this.z);
    }
}
