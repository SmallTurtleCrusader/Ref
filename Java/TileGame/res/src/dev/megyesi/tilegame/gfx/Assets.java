package dev.megyesi.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, grass, stone, tree, nothing;
	public static BufferedImage stick, chest;
	public static BufferedImage[] cow_down, cow_up, cow_left, cow_right;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_still;
	public static BufferedImage[] btn_start;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/sheet3.png"));
		
		stick = sheet.crop(0, 0, width, height);
		chest = sheet.crop(0, height * 4, width * 10, height * 8);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 4, 0, width * 2, height);
		btn_start[1] = sheet.crop(width * 6, 0, width * 2, height);
		
		//Player Images
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_still = new BufferedImage[1];
		
		player_down[0] = sheet.crop(0, height * 2, width, height);
		player_down[1] = sheet.crop(width, height * 2, width, height);
		
		player_up[0] = sheet.crop(width * 2, height * 2, width, height);
		player_up[1] = sheet.crop(width * 3, height * 2, width, height);
		
		player_left[0] = sheet.crop(width * 2, height * 3, width, height);
		player_left[1] = sheet.crop(width * 3, height * 3, width, height);
		
		player_right[0] = sheet.crop(0, height * 3, width, height);
		player_right[1] = sheet.crop(width, height * 3, width, height);
		
		player_still[0] = sheet.crop(width, height, width, height);
		
		//Creatures
		
		cow_down = new BufferedImage[4];
		cow_up = new BufferedImage[4];
		cow_left = new BufferedImage[4];
		cow_right = new BufferedImage[4];
		
		cow_up[0] = sheet.crop(0, height * 12, width * 4, height * 3);
		cow_up[1] = sheet.crop(width * 4, height * 12, width * 4, height * 3);
		cow_up[2] = sheet.crop(width * 8, height * 12, width * 4, height * 3);
		cow_up[3] = sheet.crop(width * 12, height * 12, width * 4, height * 3);
		
		cow_down[0] = sheet.crop(0, height * 20, width * 3, height * 3);
		cow_down[1] = sheet.crop(width * 4, height * 20, width * 3, height * 3);
		cow_down[2] = sheet.crop(width * 8, height * 20, width * 3, height * 3);
		cow_down[3] = sheet.crop(width * 12, height * 20, width * 3, height * 3);
		
		cow_left[0] = sheet.crop(0, height * 16, width * 3, height * 2);
		cow_left[1] = sheet.crop(width * 3, height * 16, width * 3, height * 2);
		cow_left[2] = sheet.crop(width * 7, height * 16, width * 3, height * 2);
		cow_left[3] = sheet.crop(width * 11, height * 16, width * 3, height * 2);	
		
		cow_right[0] = sheet.crop(0, height * 24, width * 3, height * 2);
		cow_right[1] = sheet.crop(width * 4, height * 24, width * 3, height * 2);
		cow_right[2] = sheet.crop(width * 8, height * 24, width * 3, height * 2);
		cow_right[3] = sheet.crop(width * 12, height * 24, width * 3, height * 2);
		
		//Tiles
		
		nothing = sheet.crop(width, height, width, height);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, height, width, height);
	}
	
}
