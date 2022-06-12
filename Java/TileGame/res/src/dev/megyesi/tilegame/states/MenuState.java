package dev.megyesi.tilegame.states;

import java.awt.Graphics;

import dev.megyesi.tilegame.Handler;
import dev.megyesi.tilegame.gfx.Assets;
import dev.megyesi.tilegame.ui.ClickListener;
import dev.megyesi.tilegame.ui.UIImageButton;
import dev.megyesi.tilegame.ui.UIManager;

public class MenuState extends State{
	
	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObejct(new UIImageButton(260, 140, 128, 64, Assets.btn_start, new ClickListener() {
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);				
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}
}
