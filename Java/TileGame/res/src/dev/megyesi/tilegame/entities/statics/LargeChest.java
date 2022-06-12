package dev.megyesi.tilegame.entities.statics;

import java.awt.Graphics;

import dev.megyesi.tilegame.Handler;
import dev.megyesi.tilegame.gfx.Assets;
import dev.megyesi.tilegame.tiles.Tile;

public class LargeChest extends StaticEntity{

	public LargeChest(Handler handler, float x, float y) {
		super(handler, x, y, (int) (Tile.TILEWIDTH * 1.25), Tile.TILEHEIGHT);
		
		DEFAULT_HEALTH = 20;
		
		bounds.x = 20;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 40;
		bounds.height = (int) (height - height / 1.5f - 10);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.chest,(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		System.out.println("Chest has been opened");
	}

}
