import java.awt.*;

public class Cube {
    private Facet[] facets;
    public Cube(){
        facets = new Facet[6];
        facets[0] = new Facet(new R3Vector(0,0,0),
                new R3Vector(1,0,0),
                new R3Vector(1,1,0),
                new R3Vector(0,1,0), Color.RED);
        facets[1] = new Facet(new R3Vector(1,0,1),
                new R3Vector(1,1,1),
                new R3Vector(1,1,0),
                new R3Vector(1,0,0), Color.CYAN);
        facets[2] = new Facet(new R3Vector(0,0,0),
                new R3Vector(0,1,0),
                new R3Vector(0,1,1),
                new R3Vector(0,0,1), Color.magenta);
        facets[3] = new Facet(new R3Vector(0,0,0),
                new R3Vector(0,0,1),
                new R3Vector(1,0,1),
                new R3Vector(1,0,0), Color.orange);
        facets[4] = new Facet(new R3Vector(0,1,0),
                new R3Vector(1,1,0),
                new R3Vector(1,1,1),
                new R3Vector(0,1,1), Color.green);
        facets[5] = new Facet(new R3Vector(0,0,1),
                new R3Vector(0,1,1),
                new R3Vector(1,1,1),
                new R3Vector(1,0,1), Color.gray);
    }
    public void scale(double k){
        for(int i = 0; i < facets.length; i++){
            facets[i].scale(k);
        }
    }
    public void translate(double dx, double dy, double dz){
        for(int i = 0; i < facets.length; i++){
            facets[i].translate(dx,dy,dz);
        }
    }
    public void rotate(double ux, double uy, double uz){
        for(int i = 0; i < facets.length; i++){
            facets[i].rotate(ux,uy,uz);
        }
    }
    public void draw(Graphics2D g){
        for(int i = 0; i < facets.length; i++){
            facets[i].draw(g);
        }
    }
    public void perspdraw(Graphics2D g, double f){
        //Double t=(vertex[0].getZ()+100)/100;
        for(int i = 0; i < facets.length; i++){
            facets[i].perspdraw(g, f);
        }
    }

}