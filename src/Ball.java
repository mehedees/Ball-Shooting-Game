import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private int x;
	private int y;
	private double dy = 3;
	private int radius = 40;
	boolean as=true;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void update(Start s){
		if(y + dy > s.getHeight() - radius - 1){
			y -= dy;
			dy = -dy;
			as=true;
		}else if(y + dy < radius){
			y = radius;
			dy = -dy;
			as=true;
		}else{
			y += dy;
		}
	}
	public void paint(Graphics g){	
		if(as){
			g.setColor(Color.RED);
		}
		else{
			g.setColor(new Color(135, 206, 250));
		}
		g.fillOval(x - radius, y - radius, radius, radius);
	}
}
