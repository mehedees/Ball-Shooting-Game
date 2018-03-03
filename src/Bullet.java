import java.awt.Color;
import java.awt.Graphics;

public class Bullet{

	private int x;
	private int y;
	private double dx = 0;
	private double dy = 5;
	private int radius = 15;
	Start s;
	Gun gun;
	Boolean flag = false;
	int counter=0;
	static int score=0;
	Boolean end_game = false;
	
	public Bullet(Gun gun){
		this.x = gun.getX() + gun.getWidth()+radius-1;
		this.y = gun.getY() + gun.getHeight();
		this.gun = gun;
	}
	
	
	
	public void update(Start s, Ball b){
		this.s = s;
		checkForCollision(b);
		if(x+dx>s.getWidth()-radius-1){
			flag=false;
			this.x = gun.getX() + gun.getWidth()+radius-1;
			this.y = gun.getY() + gun.getHeight();
			dy=5;
			dx=0;
		}
		else{
			x += dx;
		}
	}
	private void checkForCollision(Ball b) {
		int ballX=b.getX();
		int ballY=b.getY();
		int ballRadius=b.getRadius();
		int p=x-ballX;
		int q=y-ballY;
		int collide= radius+ballRadius;
		double c=Math.sqrt((p*p)+(q*q));
		if(c<collide){
			collided(b);
			
		}
		
	}
	private void collided(Ball b){
		
		b.as=false;
		score+=50;
		
	}

	public void paint(Graphics g){	
		if(!flag){
			g.setColor(new Color(135, 206, 250));
		}else{
			g.setColor(Color.BLUE);
		}
		g.fillOval(x - radius, y - radius, radius, radius);
	}

	public void shoot() {
		if(counter<5){
			if(!flag){
				flag = true;
				dy = 0;
				dx = 20;
				y = gun.getY();
				counter++;
			}
			
			if(counter >= 5){
				end_game = true;
			}
		}
	}



	public boolean getGameOver() {
		return end_game;
		
	}
	
}
