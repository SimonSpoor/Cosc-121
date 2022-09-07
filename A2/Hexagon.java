package A2;
public class Hexagon extends Shape {
	private double sideLength; 
	private String color;
	private boolean filled;
	private double area;
	private double perimeter;

	protected Hexagon(String color, boolean filled, double sideLength){
		setColor(color);
		setFilled(filled);
		setSideLength(sideLength);
		setPerimeter(sideLength);
		setArea(sideLength);
	}

	//methods
	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setFilled(boolean f) {
		this.filled = f;
	}
	public void setArea(double sideLength) {
		area = (3*Math.sqrt(3)/2)*sideLength;
	}
	public void setPerimeter(double sideLength){
		perimeter = sideLength*5;
	}
	public double getArea() {
		return area;
	}
	public double getPerimeter() {
		return perimeter;
	}
	public String getColor() {
		return color;
	}
	public double getSideLength() {
		return sideLength;
	}
	public Boolean getFilled(){
		return filled;
	}

	public String toString() {
		return "Color: " + this.getColor() + ". " + (this.getFilled() ? "Filled. " : "Not filled. ") + " Perimeter: " + this.getPerimeter() + " Area: " + this.getArea();
	}




}