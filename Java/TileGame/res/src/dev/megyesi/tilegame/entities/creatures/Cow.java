package dev.megyesi.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.megyesi.tilegame.Handler;
import dev.megyesi.tilegame.gfx.Animation;
import dev.megyesi.tilegame.gfx.Assets;

public class Cow extends Creature{

	int max = 120;
	int count = 0; 
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	public Cow(Handler handler, float x, float y) {
		super(handler, x, y, (int) (Creature.DEFAULT_CREATURE_WIDTH * 1.5),(int) (Creature.DEFAULT_CREATURE_HEIGHT * 1.5));
		
		DEFAULT_SPEED = 10.0f;
		
		animDown = new Animation(500, Assets.cow_down);
		animUp = new Animation(500, Assets.cow_down);
		animLeft = new Animation(500, Assets.cow_left);
		animRight = new Animation(500, Assets.cow_right);
	}

	@Override
	public void tick() {
		//Animation
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		//Movement
		getInput();
		move();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		}else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}else if(yMove < 0) {
			return animUp.getCurrentFrame();
		}else {
			return animDown.getCurrentFrame();
		}
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if (handler.getKeyManager().up) 
			yMove = -speed;		
		if (handler.getKeyManager().down) 
			yMove = speed;		
		if (handler.getKeyManager().left) 
			xMove = -speed;		
		if (handler.getKeyManager().right) 
			xMove = speed;		
	}

}
