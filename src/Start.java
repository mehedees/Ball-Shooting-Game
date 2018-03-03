import java.applet.Applet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Start extends Applet implements KeyListener, Runnable {

	private Image i;
	private Graphics gg;
	//public int score = 0;
	Ball b1 = new Ball(1100, 600);
	//Ball b2 = new Ball(1150, 0);
	Gun gun = new Gun();
	Bullet b = new Bullet(gun);
	Boolean endGame = false;
	
	public void init() {
		this.setSize(1280, 720);
		this.addKeyListener(this);
	}
	
	public void start() {
		Thread t = new Thread(this);
		t.start();
	}
	
	public Boolean getEndGame() {
		return endGame;
	}

	public void setEndGame(Boolean endGame) {
		this.endGame = endGame;
	}

	public void update(Graphics g) {
		if(i == null){
			i = createImage(this.getWidth(), this.getHeight());
			gg = i.getGraphics();
		}
		gg.setColor(getBackground());
		gg.fillRect(0, 0, this.getWidth(), this.getHeight());
		gg.setColor(getForeground());
		paint(gg);
		g.drawImage(i, 0, 0, this);
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(135, 206, 250));
		g.fillRect(0, 0, getWidth(), getHeight());
		b1.paint(g);
		//b2.paint(g);
		gun.paint(g);
		b.paint(g);
		String s = Integer.toString(Bullet.score);
		Font font = new Font("Serif", Font.BOLD, 35);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(s, getWidth() - 120, 30);
		if(endGame){
			g.setColor(Color.BLACK);
			g.drawString("Game Over", 300, 300);
		}
	}
	
	public void run() {
		while(true){
			endGame = b.getGameOver();
			b1.update(this);
			//b2.update(this);
			gun.update(this);
			b.update(this,b1);
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_SPACE:
			b.shoot();
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
