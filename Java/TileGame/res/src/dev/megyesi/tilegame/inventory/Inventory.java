package dev.megyesi.tilegame.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.megyesi.tilegame.Handler;
import dev.megyesi.tilegame.items.Item;

public class Inventory {

	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItem;
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItem = new ArrayList<Item>();
	}
	
	public void tick() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if (!active) {
			return;
		}
		
		System.out.println("INVENTORY: ");
		for (Item i : inventoryItem) {
			System.out.println(i.getName() + "  " + i.getCount());
		}
	}
	
	public void render(Graphics g) {
		if (!active) {
			return;
		}
	}
	
	//INVENTORY METHODS
	
	public void addItem(Item item) {
		for (Item i : inventoryItem) {
			if (i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItem.add(item);
	}

	//GETTERS AND SETTERS
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
}
