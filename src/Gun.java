import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gun implements KeyListener{

	
	int x, y, width, height, dy;
	
	public Gun(){
		dy = 5;
		x = 100;
		y = 600;
		width = 120;
		height = 15;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
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

	public void update(Start s){
		if(y + dy > s.getHeight() - 100){
			y -= dy;
			dy = -dy;
		}else if(y + dy < 50){
			y = 50;
			dy = -dy;
		}else{
			y += dy;
		}
	}
    public void paint(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
