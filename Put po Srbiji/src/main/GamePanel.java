package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final int originalTileSize = 16; //16x16 pixel tile
	public final int scale = 3;     //scaling (pixel is actually 3x3 pixels)
	public final int tileSize = originalTileSize * scale;
	
	public final int columns =  20;
	public final int rows = 12;
	
	public final int screenWidth = tileSize * columns;
	public final int screenHeight = tileSize * rows;
	
	int FPS = 60;

	TileManager tileManager = new TileManager(this);
	KeyManager keyManager = new KeyManager();
	Thread gameThread;
	Player player = new Player(this, keyManager);
	

	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyManager);
		this.setFocusable(true);
	}

	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	
	@Override
	public void run() {
		
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}
	
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		tileManager.draw(g2);
		player.draw(g2);
		
		g2.dispose();
		
	}
	
}
