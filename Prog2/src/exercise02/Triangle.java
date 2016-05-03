package exercise02;

/**
 * 
 * @author Patrick Budig 5115455
 *
 */
public class Triangle implements Polygon {

	private Point p1;
	private Point p2;
	private Point p3;

	public Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	@Override
	public Point[] allVertexes() {
		return new Point[] { p1, p2, p3 };
	}

	@Override
	public double perimeter() {
		double distance = 0.0;
		double distanceP1P2 = p1.distance(p2);
		double distanceP2P3 = p2.distance(p3);
		double distanceP3P1 = p3.distance(p1);
		distance = distanceP1P2 + distanceP2P3 + distanceP3P1;
		return distance;
	}

	@Override
	public double area() {
		double area = 0.0;
		double s = perimeter() / 2;
		double a = p1.distance(p2);
		double b = p2.distance(p3);
		double c = p3.distance(p1);
		area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return area;
	}

	@Override
	public void move(double dx, double dy) {
		p1 = p1.moved(dx, dy);
		p2 = p2.moved(dx, dy);
		p3 = p3.moved(dx, dy);

	}

	public static void main(String[] args) {

		Point p1 = new Point(0.0, 0.0);
		Point p2 = new Point(1.0, 0.0);
		Point p3 = new Point(0.0, 1.0);
		Triangle t = new Triangle(p1, p2, p3);
		Point[] vertexesT = t.allVertexes();
		double areaT = t.area();
		double perimeterT = t.perimeter();

		double dx = 2.0;
		double dy = -2.0;
		Point p1Moved = p1.moved(dx, dy);
		Point p2Moved = p2.moved(dx, dy);
		Point p3Moved = p3.moved(dx, dy);
		Triangle tMoved = t;
		tMoved.move(dx, dy);
		Point[] vertexesTM = tMoved.allVertexes();
		double areaTM = tMoved.area();
		double perimeterTM = tMoved.perimeter();

		System.out.println("Abfrage   Erwartet   Wert");
		System.out.println("Punkt1: " + p1.toString() + "  " + vertexesT[0].toString());
		System.out.println("Punkt2: " + p2.toString() + "  " + vertexesT[1].toString());
		System.out.println("Punkt3: " + p3.toString() + "  " + vertexesT[2].toString());
		System.out.println("Umfang: 3.4142...  " + perimeterT);
		System.out.println("Flaeche: 0.4999...  " + areaT);
		System.out.println("Verschiebe das Dreieck um: " + dx + ", " + dy);
		System.out.println("Punkt1: " + p1Moved.toString() + "  " + vertexesTM[0].toString());
		System.out.println("Punkt2: " + p2Moved.toString() + "  " + vertexesTM[1].toString());
		System.out.println("Punkt3: " + p3Moved.toString() + "  " + vertexesTM[2].toString());
		System.out.println("Umfang: " + perimeterT + "  " + perimeterTM);
		System.out.println("Flaeche: " + areaT + "  " + areaTM);
	}

}
