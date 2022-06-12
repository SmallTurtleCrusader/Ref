package dev.megyesi.tilegame.worlds;

import java.awt.Graphics;

import dev.megyesi.tilegame.Handler;
import dev.megyesi.tilegame.entities.EntityManager;
import dev.megyesi.tilegame.entities.creatures.Cow;
import dev.megyesi.tilegame.entities.creatures.Player;
import dev.megyesi.tilegame.entities.statics.LargeChest;
import dev.megyesi.tilegame.entities.statics.Tree;
import dev.megyesi.tilegame.items.ItemManager;
import dev.megyesi.tilegame.tiles.Tile;
import dev.megyesi.tilegame.utils.Utils;

public class World {

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entities;
	private EntityManager entityManager;
	//Items
	private ItemManager itemManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		
		entityManager.addEntity(new Tree(handler, 100, 250));
		entityManager.addEntity(new Tree(handler, 100, 350));
		entityManager.addEntity(new Tree(handler, 100, 450));
		entityManager.addEntity(new Tree(handler, 100, 550));
		entityManager.addEntity(new Cow(handler, 400, 500));
		
		entityManager.addEntity(new LargeChest(handler, 500, 500));
		itemManager = new ItemManager(handler);
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) 
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}
