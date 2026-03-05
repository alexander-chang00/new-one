package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}
       public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    // public methods
    public void add(Point2D.Double aPoint)
    {
          myPolygon.add(aPoint);
    }

    public double perimeter() {
          public double perimeter() {
        if (myPolygon.size() < 2) return 0;

        double total = 0;

        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size());
            total += p1.distance(p2);
        }

        return 3.14;
    }

    public double area() {
        public double area() {
        if (myPolygon.size() < 3) return 0;

        double sum = 0;

        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size());

            sum += (p1.x * p2.y) - (p2.x * p1.y);
        }

        return Math.abs(sum) / 2.0;
    }
        Double area = 0.0;
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
             try {
            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));

            if (myPolygon.size() == 0) return;

            Point2D.Double start = myPolygon.get(0);
            myDrawingTool.move(start.x, start.y);

            for (int i = 1; i < myPolygon.size(); i++) {
                Point2D.Double p = myPolygon.get(i);
                myDrawingTool.move(p.x, p.y);
            }

            // Close the polygon
            myDrawingTool.move(start.x, start.y);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
