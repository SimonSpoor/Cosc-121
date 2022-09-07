package A2;
public class Rectangle extends Shape {
	private String color;
	private boolean filled;
	private double area;
	private double perimeter;
	private double xLength;
	private double yLength;

	protected Rectangle(String color, boolean filled, double xLength, double yLength){
		setColor(color);
		setFilled(filled);
		setxLength(xLength);
		setyLength(yLength);
		setPerimeter(xLength, yLength);
		setArea(yLength, yLength);
	}

	//methods
	public void setColor(String color) {
		this.color = color;
	}
	public void setFilled(boolean f) {
		this.filled = f;
	}
	public void setxLength(double x){
		this.xLength = x;
	}
	public void setyLength(double yLength) {
		this.yLength = yLength;
	}
	public void setPerimeter(double x, double y) {
		this.perimeter = 2*x + 2*y;
	}
	public void setArea(double x, double y) {
		this.area = x*y;
	}

	public double getArea(){
		return area;
	}

	public String getColor() {
		return color;
	}

	public boolean getFilled() {
		return filled;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public double getxLength() {
		return xLength;
	}

	public double getyLength() {
		return yLength;
	}

	
	public String toString() {
		return "Color: " + this.getColor() + ". " + (this.getFilled() ? "Filled. " : "Not filled. ") + " Perimeter: " + this.getPerimeter() + " Area: " + this.getArea();
	}
}