
public class Point2D {

	private final double x;    // x coordinate
	private final double y;    // y coordinate

	// Constructor: initialize the (x,y) members of a new point
	public Point2D(final double x, final double y) {
		this.x = x;
		this.y = y;
	}

	public double x() { return x; }
	public double y() { return y; }

	public double distanceTo(final Point2D that) {
		final double dx = this.x - that.x;
		final double dy = this.y - that.y;
		return Math.sqrt(dx*dx + dy*dy);
	}

	public boolean equals(final Object other) {
		if (other == this) return true;
		if (other instanceof Point2D) {
		  Point2D that = (Point2D) other;
		  return this.x == that.x && this.y == that.y;
		} else {
		  return false;
		}
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	// plot using StdDraw
	public void draw() {
		StdDraw.point(x, y);
	}

	// draw line from this point p to q using StdDraw
	public void drawTo(final Point2D that) {
		StdDraw.line(this.x, this.y, that.x, that.y);
	}
}
