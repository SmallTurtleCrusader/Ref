package dev.megyesi.tilegame.tiles;

import dev.megyesi.tilegame.gfx.Assets;

public class NothingTile extends Tile{

	public NothingTile(int id) {
		super(Assets.nothing, id);
	}
	

	@Override
	public boolean isSolid() {
		return true;
	}
	
}
