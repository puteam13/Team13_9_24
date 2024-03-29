import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainFrame extends JPanel implements ActionListener, KeyListener, MouseListener {

	JFrame f;
	JMenu menuRestart;

	JMenu menuBack;
	JMenu menuScore;
	JMenu menuExit;
	JMenu menuLife;
	JMenu menuScore1;
	JMenuBar Menub;
	Timer t;
	ImageIcon BackImg;
	Image wall_image;
	Image road_image;
	Image start_image;
	Image exit_image;
	Image octopus_image;

	// int Global.difficulty;
	Enemy E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, E11, E12, E13, E14, E15, E16, E17, E18, E19, E20, E21, E22, E23, E24, E25, E26, E27, E28, E29, E30, E31, E32, E33, E34, E35, E36, E37, E38;
	Charactermodel Hero;
	//int velx = 1, vely = 1;
	User user;
	Treasure Cash, Cash2, Cash3, Cash4, Cash5, Cash6, Cash7, Cash8, Cash9, Cash10;
	JFrame frame;
	// int Hero.x = 20, Hero.y = 100;

	public MainFrame(User User,JFrame frame ) {
		this.user=User;
		this.frame=frame;
		
		
		frameLayout();

		  E1 = new Enemy(60, 120); //level 1, up-down
		  E2 = new Enemy(180, 120); //level 1, up-down
		  E3 = new Enemy(140, 60); //level 2, left-right
		  E4 = new Enemy(180, 100); //level 2, left-right
		  E5 = new Enemy(120, 140); //level 2, left-right
		  E6 = new Enemy(60, 180); //level 3, up-down
		  E7 = new Enemy(200, 120); //level 3, up-down
		  E8 = new Enemy(120, 60); //level 3, left-right
		  E9 = new Enemy(100, 100); //level 4, left-right
		  E10 = new Enemy(140, 140); //level 4, left-right
		  E11 = new Enemy(240, 220); //level 4, up-down
		  E12 = new Enemy(60, 160); //level 5, up-down
		  E13 = new Enemy(100, 160); //level 5, up-down
		  E14 = new Enemy(160, 60); //level 5, left-right
		  E15 = new Enemy(160, 100); //level 5, left-right
		  E16 = new Enemy(160, 220); //level 5, left-right
		  E17 = new Enemy(100, 100); //level 6, left-right
		  E18 = new Enemy(60, 240); //level 6, left-right
		  E19 = new Enemy(280, 240); //level 6, up-down
		  E20 = new Enemy(160, 280); //level 6, left-right
		  E21 = new Enemy(60, 140); //level 7, up-down
		  E22 = new Enemy(260, 120); //level 7, left-right 
		  E23 = new Enemy(80, 240); //level 7, left-right
		  E24 = new Enemy(240, 220); //level 7, up-down
		  E25 = new Enemy(60, 160); //level 8, up-down 
		  E26 = new Enemy(120, 240); //level 8, up-down 
		  E27 = new Enemy(160, 200); //level 8, up-down 
		  E28 = new Enemy(320, 240); //level 8, up-down 
		  E29 = new Enemy(320, 80); //level 8, up-down 
		  E30 = new Enemy(200, 20); //level 9, left-right 
		  E31 = new Enemy(180, 160); //level 9, left-right
		  E32 = new Enemy(60, 320); //level 9, left-right
		  E33 = new Enemy(200, 280); //level 9, up-down
		  E34 = new Enemy(360, 240); //level 9, up-down
		  E35 = new Enemy(20, 160); //level 10, up-down
		  E36 = new Enemy(160, 120); //level 10, left-right
		  E37 = new Enemy(200, 340); //level 10, left-right
		  E38 = new Enemy(300, 140); //level 10, up-down
		
		
		
		  Cash = new Treasure(140, 180);
		  Cash2 = new Treasure(60, 180);
		  Cash3 = new Treasure(140, 140);
		  Cash4 = new Treasure(100, 120);
		  Cash5 = new Treasure(160, 160);
		  Cash6 = new Treasure(60, 280);
		  Cash7 = new Treasure(140, 320);
		  Cash8 = new Treasure(160, 300);
		  Cash9 = new Treasure(120, 360);
		  Cash10 = new Treasure(240, 160);
	//	setEnemy(E1,60, 120);
		
		
		
		// System.out.println("mmmm");
		Hero = new Charactermodel();
	
		// Global.difficulty = 10;
		Global.LEVEL = 6;
		t = new Timer(Global.difficulty+5, this);
		t.start();
	}

	public void frameLayout() {
		f = new JFrame("Title");
		menuRestart = new JMenu("Restart");

		menuBack = new JMenu("Back");
		menuScore = new JMenu("Score");
		menuExit = new JMenu("Exit");
		menuLife = new JMenu("Life: 3");
		menuScore1 = new JMenu("Score: 0");
		Menub = new JMenuBar();
		
		Menub.add(menuRestart);
		Menub.add(menuBack);
		Menub.add(menuScore1);
		Menub.add(menuExit);
		Menub.add(menuLife);
		Menub.add(menuScore1);
		menuRestart.addMouseListener(this);
		menuBack.addMouseListener(this);
		menuScore.addMouseListener(this);
		menuExit.addMouseListener(this);
		menuLife.setEnabled(false);
		menuScore1.setEnabled(false);
			
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 600);
		f.setJMenuBar(Menub);
	
		f.add(this);

		f.setVisible(true);
		f.addKeyListener(this);

		//f.setSize(400, 400);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.GRAY);
		// g.setColor(Color.green);
		g.drawOval(0, 0, 20, 20);
		drawmap(g);
		drawstart(g);
		drawexit(g);

		
		if (Global.LEVEL == 1) {

			   drawenemy(g, E1);
			   drawenemy(g, E2);
			   enemymovelogic(E1);
			   enemymovelogic( E2);
			 //  System.out.println(E2.y);
			   
			   if(Global.picked==0){
				   PickCash(Cash, Hero) ;
			   drawTreasure(g, Cash, 160, 200);// this is to set treasure place.    
			   }//   enemymovelogic(E1.x, E1.y);
			   collision(E2, Hero);
			   collision(E1, Hero);
			  // System.out.println("mmm");
			  } else if(Global.LEVEL==2){
			   drawenemy(g, E3);
			   drawenemy(g, E4);
			   drawenemy(g, E5);
			   enemymovelogic(E3);
			      enemymovelogic(E4);
			      enemymovelogic(E5);
			  
			      collision(E3, Hero);
			      collision(E4, Hero);
			      collision(E5, Hero);
			   //collision(E3, Hero);
			   if(Global.picked==0){
				   PickCash(Cash2, Hero) ;
			   drawTreasure(g, Cash2, 80, 200);
			   }
			  }else if(Global.LEVEL==3){
			   drawenemy(g, E6);
			   drawenemy(g, E7);
			   drawenemy(g, E8);
			   enemymovelogic(E6);
			      enemymovelogic(E7);
			      enemymovelogic(E8);
			  
			      collision(E6, Hero);
			      collision(E7, Hero);
			      collision(E8, Hero);
			   if(Global.picked==0){
				   PickCash(Cash3, Hero) ;
			   drawTreasure(g, Cash3, 140, 140);
			   }
			  }else if(Global.LEVEL==4){
			   drawenemy(g, E9);
			   drawenemy(g, E10);
			   drawenemy(g, E11);
			   enemymovelogic(E9);
			      enemymovelogic(E10);
			      enemymovelogic(E11);
			  
			      collision(E9, Hero);
			      collision(E10, Hero);
			      collision(E11, Hero);
			   if(Global.picked==0){
				   PickCash(Cash4, Hero) ;
			   drawTreasure(g, Cash4, 100, 120);
			   }
			  }else if(Global.LEVEL==5){
			   drawenemy(g, E12);
			   drawenemy(g, E13);
			   drawenemy(g, E14);
			   drawenemy(g, E15);
			   drawenemy(g, E16);
			   enemymovelogic(E12);
			      enemymovelogic(E13);
			      enemymovelogic(E14);
			      enemymovelogic(E15);
			      enemymovelogic(E16); 
			      
			      collision(E12, Hero);
			      collision(E13, Hero);
			      collision(E14, Hero);
			      collision(E15, Hero);
			      collision(E16, Hero);
			   if(Global.picked==0){
				   PickCash(Cash5, Hero) ;
			   drawTreasure(g, Cash5, 160, 160);
			   }
			  }else if(Global.LEVEL==6){
			   drawenemy(g, E17);
			   drawenemy(g, E18);
			   drawenemy(g, E19);
			   drawenemy(g, E20);
			   enemymovelogic(E17);
			      enemymovelogic(E18);
			      enemymovelogic(E19);
			      enemymovelogic(E20); 
			      
			      collision(E17, Hero);
			      collision(E18, Hero);
			      collision(E19, Hero);
			      collision(E20, Hero);
			   if(Global.picked==0){
				   PickCash(Cash6, Hero) ;
			   drawTreasure(g, Cash6, 60, 280);
			   }
			  }else if(Global.LEVEL==7){
			   drawenemy(g, E21);
			   drawenemy(g, E22);
			   drawenemy(g, E23);
			   drawenemy(g, E24);
			   enemymovelogic(E21);
			      enemymovelogic(E22);
			      enemymovelogic(E23);
			      enemymovelogic(E24); 
			      
			      collision(E21, Hero);
			      collision(E22, Hero);
			      collision(E23, Hero);
			      collision(E24, Hero);
			   if(Global.picked==0){
				   PickCash(Cash7, Hero) ;
			   drawTreasure(g, Cash7, 140, 320);
			   }
			  }else if(Global.LEVEL==8){
			   drawenemy(g, E25);
			   drawenemy(g, E26);
			   drawenemy(g, E27);
			   drawenemy(g, E28);
			   drawenemy(g, E29);
			   enemymovelogic(E25);
			      enemymovelogic(E26);
			      enemymovelogic(E27);
			      enemymovelogic(E28);
			      enemymovelogic(E29); 
			      
			      collision(E25, Hero);
			      collision(E26, Hero);
			      collision(E27, Hero);
			      collision(E28, Hero);
			      collision(E29, Hero);
			   if(Global.picked==0){
				   PickCash(Cash8, Hero) ;
			   drawTreasure(g, Cash8, 160, 320);
			   }
			  }else if(Global.LEVEL==9){
			   drawenemy(g, E30);
			   drawenemy(g, E31);
			   drawenemy(g, E32);
			  // drawenemy(g, E33);
			   drawenemy(g, E34);
			   enemymovelogic(E30);
			      enemymovelogic(E31);
			      enemymovelogic(E32);
			      enemymovelogic(E33);
			      enemymovelogic(E34); 
			      
			      collision(E30, Hero);
			      collision(E31, Hero);
			      collision(E32, Hero);
			      collision(E33, Hero);
			      collision(E34, Hero);
			   
			   if(Global.picked==0){
				   PickCash(Cash9, Hero) ;
			   drawTreasure(g, Cash9, 120, 360);
			   }
			  }else if(Global.LEVEL==10){
			   drawenemy(g, E35);
			   drawenemy(g, E36);
			   drawenemy(g, E37);
			   drawenemy(g, E38);
			   enemymovelogic(E35);
			      enemymovelogic(E36);
			      enemymovelogic(E37);
			      enemymovelogic(E38); 
			      
			      collision(E35, Hero);
			      collision(E36, Hero);
			      collision(E37, Hero);
			      collision(E38, Hero);
			   if(Global.picked==0){
				   PickCash(Cash10, Hero) ;
			   drawTreasure(g, Cash10, 240, 160);
			   }
			  }


		//drawenemy(g, E1);
		
		drawcharacter(g);
	
	}

	public void drawstart(Graphics g) {
		ImageIcon start_ImageIcon = new ImageIcon("images/Exit.png");
		start_image = start_ImageIcon.getImage();
		g.drawImage(start_image, 0, 20, null);

	}

	public void drawexit(Graphics g) {
		ImageIcon exit_ImageIcon = new ImageIcon("images/Exit.png");
		exit_image = exit_ImageIcon.getImage();
		g.drawImage(exit_image, (Global.level_size - 1) * 20,
				(Global.level_size - 2) * 20, null);
		Global.grid[Global.level_size - 1][Global.level_size - 2] = Global.EXIT;

	}

	public void ChooseLevel() {
		if (Global.LEVEL == 1) {
			new Buildwallroom1();
		} else if (Global.LEVEL == 2) {
			new Buildwallroom2();
		} else if (Global.LEVEL == 3) {
			new Buildwallroom3();
		} else if (Global.LEVEL == 4) {
			new Buildwallroom4();
		} else if (Global.LEVEL == 5) {
			new Buildwallroom5();
		} else if (Global.LEVEL == 6) {
			new Buildwallroom6();
		} else if (Global.LEVEL == 7) {
			new Buildwallroom7();
		} else if (Global.LEVEL == 8) {
			new Buildwallroom8();
		} else if (Global.LEVEL == 9) {
			new Buildwallroom9();
		} else if (Global.LEVEL == 10) {
			new Buildwallroom10();
		}

	}

	public void drawmap(Graphics g) {

		ImageIcon wall_ImageIcon = new ImageIcon("images/wall24.png");
		ImageIcon road_ImageIcon = new ImageIcon("images/road24.png");
		wall_image = wall_ImageIcon.getImage();
		road_image = road_ImageIcon.getImage();

		ChooseLevel();

		for (int i = 0; i < Global.level_size; i++) {
			for (int j = 0; j < Global.level_size; j++) {
				if (Global.grid[i][j] == Global.WALL) {
					// g.drawRect(20, 20, 20, 20);
					g.drawImage(wall_image, i * 20, j * 20, null);

				} else if (Global.grid[i][j] == Global.ROAD) {

					g.drawImage(road_image, i * 20, j * 20, null);

				}

			}

		}

	}
public void setEnemy(Enemy e,int x, int y){
	e.x=x;
	e.y=y;
}
	public void drawenemy(Graphics g, Enemy E) {

		g.drawImage(E.poop_image, E.x, E.y, null);
	}
	public void drawTreasure(Graphics g, Treasure t, int x, int y) {
		t.x=x;
		t.y=y;
		
		g.drawImage(t.Treasure_image, x, y, null);
	}

	public void drawcharacter(Graphics g) {
		g.drawImage(Hero.octopus_image, Hero.x, Hero.y, null);

	}

	public void draw_wall(Graphics g, int x, int y) {
		g.drawImage(wall_image, x, y, null);

	}

	private JMenuItem makeMenuItem(String name) {

		JMenuItem m = new JMenuItem(name);
		m.addActionListener(this);
		return m;
	}
	public void PickCash(Treasure E, Charactermodel H) {
		if (Math.abs(H.x - E.x) < 18 && Math.abs(H.y - E.y) < 18) {
			
			//System.out.println("~~~");
			Global.Score=Global.Score+Global.cash;
		//	E=null;
			menuScore1.setText("Score: "+Global.Score);
			Global.picked=1;
		//	System.out.println("Collision");

		}
	}

	public void collision(Enemy E, Charactermodel H) {
		if (Math.abs(H.x - E.x) < 18 && Math.abs(H.y - E.y) < 18) {
		if(Global.Life>0){
			Global.Life--;
			menuLife.setText("Life: " + Global.Life);
		
		
			if (Global.Life <= 0) {
				System.out.println("Game Over");
				
				
				user.currScore=Global.Score;
				user.saveScoreToDatabase();
			}
			else {				
				Hero.setPosition();// Go back to initialized position.
			}
		}
			
			System.out.println("Collision");

		}
	}

	public void enemymovelogic( Enemy E) {
		if (E.x < 0 || E.x > (Global.level_size-2)*20) {
			E.velx = -E.velx;

		}
		if (E.y < 0 || E.y > (Global.level_size-1)*20) {
			E.vely = -E.vely;
		}
		if (E.velx > 0
				&& Global.grid[(E.x + 20) / 20][E.y / 20] == Global.WALL) {
			/* It will turn back if collide with right wall. */
			E.velx = -E.velx;
			return;

		}
		if (E.velx < 0
				&& Global.grid[(E.x - 1) / 20][E.y / 20] == Global.WALL) {
			/* It will turn back if collide with left wall. */
			E.velx = -E.velx;
		//	System.out.println("@@@@"+E.x);
			return;
		}
		if (E.vely > 0
				&& Global.grid[E.x / 20][(E.y + 20) / 20] == Global.WALL) {
			//System.out.println("mmm");
			/* It will turn back if collide with right wall. */
			E.vely = -E.vely;
			return;
		}
		//
		if (E.vely < 0 &&( Global.grid[E.x / 20][(E.y-1) / 20] == Global.WALL) ){
			/* It will turn back if collide with up wall. */
			//System.out.println("sss"+E.y);
		//	System.out.println("mmmnnn"+E.x / 20+"ffff"+(E.y - 2) / 20);
			E.vely = -E.vely;
			return;
		}

	}

	public void actionPerformed(ActionEvent e) {
	
		
		if (Global.LEVEL == 1) {
            E1.y = E1.y + E1.vely;
            E2.y = E2.y + E2.vely;
    //        System.out.println("mmm");
    } else if(Global.LEVEL==2){
            E3.x = E3.x + E3.velx;
            E4.x = E4.x + E4.velx;
            E5.x = E5.x + E5.velx;
            
    }else if(Global.LEVEL==3){
            E6.y = E6.y + E6.vely;
            E7.y = E7.y + E7.vely;
            E8.x = E8.x + E8.velx;
            
    }else if(Global.LEVEL==4){
            E9.x = E9.x + E9.velx;
            E10.x = E10.x + E10.velx;
            E11.y = E11.y + E11.vely;
            
            
    }else if(Global.LEVEL==5){
            E12.y = E12.y +E12. vely;
            E13.y = E13.y + E13.vely;
            E14.x = E14.x + E14.velx;
            E15.x = E15.x + E15.velx;
            E16.x = E16.x + E16.velx;
            
    }else if(Global.LEVEL==6){
            E17.x = E17.x + E17.velx;
            E18.y = E18.y + E18.vely;
            E19.y = E19.y + E19.vely;
            E20.x = E20.x + E20.velx;
            
    }else if(Global.LEVEL==7){
            E21.y = E21.y + E21.vely;
            E22.x = E22.x + E22.velx;
            E23.x = E23.x + E23.velx;
            E24.y = E24.y + E24.vely;
            
            
    }else if(Global.LEVEL==8){
            E25.y = E25.y + E25.vely;
            E26.y = E26.y + E26.vely;
            E27.y = E27.y + E27.vely;
            E28.y = E28.y + E28. vely;
            E29.y = E29.y + E29.vely;
            
    }else if(Global.LEVEL==9){
            E30.x = E30.x + E30.velx;
            E31.x = E31.x + E31.velx;
            E32.x = E32.x + E32.velx;
            E33.y = E33.y + E33.vely;
            E34.y = E34.y + E34.vely;
            
            
    }else if(Global.LEVEL==10){
            E35.y = E35.y + E35. vely;
            E36.x = E36.x + E36.velx;
            E37.x = E37.x + E37.velx;
            E38.y = E38.y + E38.vely;                
            
    }

		//
		repaint();
	}

	public void start() {

	}

	public void stop() {

	}

	public void run() {
		// do stuff here
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		// e.getk
		if (Hero.x < 0) {
			Hero.x = 0;
		}
		if (Hero.y < 0) {
			Hero.y = 0;
		}
		// if (Hero.x > 400 || Hero.x < 0 || Hero.y > 400 || Hero.y < 0) {
		// return;
		// }
		if (c == KeyEvent.VK_LEFT) {
			if (Global.grid[(Hero.x - 1) / 20][(Hero.y + 8) / 20] != Global.WALL
					&& Global.grid[(Hero.x - 1) / 20][(Hero.y + 12) / 20] != Global.WALL)

			{
				Hero.y = ((Hero.y + 8) / 20) * 20;
				// System.out.println(Hero.y);

				Hero.goleft();
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.WALL)
					Hero.x = Hero.x - Global.movex;

			}

		}
		if (c == KeyEvent.VK_UP) {
			if (Global.grid[(Hero.x + 6) / 20][(Hero.y - 1) / 20] != Global.WALL
					&& Global.grid[(Hero.x + 14) / 20][(Hero.y - 1) / 20] != Global.WALL) {
				// if(!(octopus % 20==0) )

				Hero.x = ((Hero.x + 6) / 20) * 20;

				Hero.goup();
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.WALL)
					// Hero.x = Hero.x + Global.Global.movex;
					Hero.y = Hero.y - Global.movey;
			}

		}
		if (c == KeyEvent.VK_RIGHT) {

			// System.out.println(Hero.x+" ssssssss  "+Hero.y);
			if (Global.grid[(Hero.x) / 20 + 1][(Hero.y + 6) / 20] != Global.WALL
					&& Global.grid[Hero.x / 20 + 1][(Hero.y + 14) / 20] != Global.WALL) {
				Hero.y = ((Hero.y + 6) / 20) * 20;
				// System.out.println(Hero.y);

				Hero.goright();
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.WALL)
					Hero.x = Hero.x - Global.movex;
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.EXIT) {
					Global.LEVEL++;
					Global.picked=0;
					Hero.setPosition();
					Global.Score=Global.Score+25-Global.difficulty;
					menuScore1.setText("Score: "+Global.Score);
					
					
					
					if (Global.LEVEL > 10) {
						System.out.println("Game Over");
						JOptionPane.showMessageDialog(null,"Congratulations!Your final score is "+Global.Score,"You Win!",JOptionPane.INFORMATION_MESSAGE); 
						Global.LEVEL=0;
					
						user.currScore=Global.Score;
						user.saveScoreToDatabase();
						
						f.dispose();
						frame.setVisible(true);
						Global.Score=0;
					}
				}

			}
		}
		if (c == KeyEvent.VK_DOWN) {
			if (Global.grid[(Hero.x + 6) / 20][(Hero.y) / 20 + 1] != Global.WALL
					&& Global.grid[(Hero.x + 14) / 20][Hero.y / 20 + 1] != Global.WALL)

			{

				Hero.x = ((Hero.x + 6) / 20) * 20;
				// System.out.println(Hero.y);

				Hero.godown();
				if (Global.grid[Hero.x / 20][Hero.y / 20] == Global.WALL)
					Hero.x = Hero.x - Global.movex;

			}
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		// Global.Global.movex = 0;
		// Global.movey = 0;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] agrs) {
		User User = null;
		JFrame F = null;
		MainFrame f = new MainFrame(User ,  F);

	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == menuBack)
		{
			//System.out.println("menuBack");
			frame.setVisible(true);
			user.currScore=Global.Score;
			user.saveScoreToDatabase();
			
			f.dispose();
			Global.Score=0;
			
			
		}else if(arg0.getSource() == menuScore){
			
			System.out.println("menuScore");
			
		}else if(arg0.getSource() == menuExit){
			
			System.out.println("menuExit");
			String message = " Really Quit ? ";
            String title = "Quit";
            
            int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
            	
            	user.currScore=Global.Score;
				user.saveScoreToDatabase();
                System.exit(0);
            }
			
		}else if(arg0.getSource() == menuRestart){
			Hero.setPosition();
			System.out.println("menuRestart");
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}