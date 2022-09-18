package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
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
	
	public final int maxWorldCol = 200;
	public final int maxWorldRow = 120;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	int FPS = 60;

	public TileManager tileManager = new TileManager(this);
	KeyManager keyManager = new KeyManager(this);
	Sound sound = new Sound();
	Sound soundEffect = new Sound();
	public CollisionChecker colCheck = new CollisionChecker(this);
	public ObjectManager om = new ObjectManager(this);
	public UserInterface ui = new UserInterface(this);
	Thread gameThread;
	
	public Player player = new Player(this, keyManager);
	public SuperObject obj[] = new SuperObject[10];
	public Entity npc[] = new Entity[10];
	
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyManager);
		this.setFocusable(true);
	}

	
	public void setUpGame() {
		om.setObjects();
		om.setNPCs();
		playMusic(2);
		gameState = playState;
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
		if(gameState == playState) {
			player.update();
			for(int i = 0; i<npc.length; i++) {
				if(npc[i] != null) {
					npc[i].update();
				}
			}
		} else if(gameState == pauseState) {
			//not updating since the game is paused
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		long startOfDrawing = System.nanoTime();
		
		tileManager.draw(g2);
		
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		for(int i = 0; i < npc.length; i++) {
			if(npc[i] != null) {
				npc[i].draw(g2);
			}
		}
		
		player.draw(g2);
		
		ui.draw(g2);
		
		long endOfDrawing = System.nanoTime();
		long timeItTookToDraw = endOfDrawing - startOfDrawing;
		if(keyManager.checkDrawingTime) {
			System.out.println("Time it took to draw: " + timeItTookToDraw);
		}
		
		g2.dispose();
		
	}
	
	public void playMusic(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	
	public void stopMusic() {
		sound.stop();
	}
	
	public void playSoundEffect(int i) {
		soundEffect.setFile(i);
		soundEffect.play();
	}
	
}
