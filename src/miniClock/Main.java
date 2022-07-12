package miniClock;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;


public class Main extends JFrame{
	private MouseHandler mouseHandler = new MouseHandler();
	private static final long serialVersionUID = 1L;
	public Main() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new Time());
		this.setUndecorated(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
	}
	public static void main(String[] args) {new Main();}
	private class MouseHandler implements MouseListener, MouseMotionListener {
		int x0, y0, x1, y1;
		public void mouseDragged(MouseEvent e) {
			x1=e.getXOnScreen();
			y1=e.getYOnScreen();
			x1=x1-x0;
			y1=y1-y0;
			setLocation(x1, y1);
		}
		public void mousePressed(MouseEvent e) {x0=e.getX(); y0=e.getY();}
		public void mouseClicked(MouseEvent e) {if(e.getButton()==3) {System.exit(0);};}
		public void mouseMoved(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
}
