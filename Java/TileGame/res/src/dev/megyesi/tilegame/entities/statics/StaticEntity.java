package dev.megyesi.tilegame.entities.statics;

import dev.megyesi.tilegame.Handler;
import dev.megyesi.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
	
}
