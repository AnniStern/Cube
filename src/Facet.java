
import java.awt.*;
import java.awt.geom.Path2D;


public class Facet {
    private R3Vector[] vertex;
    Color color;
    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4,Color color){
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
        this.color = color;
    }
    public void out(){
        for(int i = 0; i<vertex.length; i++) {
            vertex[i].out();
            System.out.print(" - ");
            if(i==3){
                vertex[0].out();
            }else{
                vertex[i + 1].out();
            }
            System.out.print("\n");
        }
    }
    public void rotate(double ux, double uy, double uz){
        for(int i = 0; i < vertex.length; i++){
            vertex[i].rotate(ux,uy,uz);
        }
    }
    public void scale(double k){
        for(int i = 0; i < vertex.length; i++){
            vertex[i].scale(k);
        }
    }
    public void translate(double dx, double dy, double dz){
        for(int i = 0; i < vertex.length; i++){
            vertex[i].translate(dx,dy,dz);
        }
    }
    public void draw(Graphics2D g){
        Path2D p = new Path2D.Double();
        p.moveTo(vertex[0].getX(), vertex[0].getY());
        p.lineTo(vertex[1].getX(), vertex[1].getY());
        p.lineTo(vertex[2].getX(), vertex[2].getY());
        p.lineTo(vertex[3].getX(), vertex[3].getY());
        p.lineTo(vertex[0].getX(), vertex[0].getY());
        p.closePath();
        if (normalin()) {
            g.setColor(color);
            g.fill(p);
        }

    }
    double[] t = new double[4];
    public void perspdraw(Graphics2D g, double f){
        Path2D path = new Path2D.Double();

        t[0] = -f / (vertex[0].getZ() - f);
        t[1] = -f / (vertex[1].getZ() - f);
        t[2] = -f / (vertex[2].getZ() - f);
        t[3] = -f / (vertex[3].getZ() - f);
        path.moveTo(vertex[0].getX() * t[0], vertex[0].getY() * t[0]);
        path.lineTo(vertex[1].getX() * t[1], vertex[1].getY() * t[1]);
        path.lineTo(vertex[2].getX() * t[2], vertex[2].getY() * t[2]);
        path.lineTo(vertex[3].getX() * t[3], vertex[3].getY() * t[3]);
        path.lineTo(vertex[0].getX() * t[0], vertex[0].getY() * t[0]);
        path.closePath();
        if (normalin2()) {
            g.setColor(this.color);
            //g.draw(path);
            g.fill(path);
       }
    }

    //78, 67, 29
    public boolean normalin2(){
        double[] t = new double[4];
        if(R3Vector.normal2(R3Vector.diagonals(vertex[1], vertex[3]),R3Vector.diagonals(vertex[0], vertex[1])).getZ()>0)
        { return true; }
        else{return false;}
    }

    public boolean normalin(){
        if(R3Vector.normal(R3Vector.diagonals(vertex[0], vertex[1]),R3Vector.diagonals(vertex[0], vertex[3])).getZ()>0)
        { return true; }
        else{return false;}
    }
}