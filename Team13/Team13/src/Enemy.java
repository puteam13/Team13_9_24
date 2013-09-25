import java.awt.Image;

import javax.swing.ImageIcon;


public class Enemy {
	Image poop_image;
	ImageIcon poop_ImageIcon;
	int x;
	int y;
	int movepath;
	int velx;
	int vely;
	public Enemy(int x, int y){
		this.x=x;
		this.y=y;
		this.velx = 1;
		this.vely = 1;
		poop_ImageIcon = new ImageIcon("images/poop.png");
		poop_image = poop_ImageIcon.getImage();
		
	}
	
	
}
