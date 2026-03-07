package polygon;

import java.awt.geom.Point2D;

public class Main {
    public static void main(String [] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();
          myPolygon.add(new Point2D.Double(50, 50));
        myPolygon.add(new Point2D.Double(150, 50));
        myPolygon.add(new Point2D.Double(120, 120));
        myPolygon.add(new Point2D.Double(60, 150));

        myPolygon.draw();

        TestSuite.run();
    }
    
}
