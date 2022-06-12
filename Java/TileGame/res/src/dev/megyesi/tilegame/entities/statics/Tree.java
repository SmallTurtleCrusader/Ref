package dev.megyesi.tilegame.entities.statics;

import java.awt.Graphics;

import dev.megyesi.tilegame.Handler;
import dev.megyesi.tilegame.gfx.Assets;
import dev.megyesi.tilegame.items.Item;
import dev.megyesi.tilegame.tiles.Tile;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		
		bounds.x = 20;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 40;
		bounds.height = (int) (height - height / 1.5f - 10);
	}

	@Override
	public void tick() {
		
		
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem01.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree,(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

}
