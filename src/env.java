import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class env {
	
	private int firstLine;
	private int secondLine;
	private int maxY;
	private BufferedImage img;
	private Robot robot;
	private Color color;
	
	env(int firstLine, int secondLine, int maxY, Color color) throws AWTException {
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.maxY = maxY;
		this.robot = new Robot();
		this.color = color;
	}
	
	public int getStatus() {
		updatePic();
		int f = getLastPixel(firstLine);
		int s = getLastPixel(secondLine); 
		if(f > this.maxY)
			return -1;
		if(s > this.maxY)
			return 1;
		if(f > s)
			return -1;
		if(s > f)
			return 1;
		return 0;
	}
	
	public void RightPress() {
		this.robot.keyPress(KeyEvent.VK_RIGHT);
	}
	
	public void LeftPress() {
		this.robot.keyPress(KeyEvent.VK_LEFT);
	}
	
	private void updatePic() {
		  Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		  this.img = robot.createScreenCapture(area);
	}
	
	private int getLastPixel(int x) {
		int last = 0;
		int height = img.getHeight();
		for(int y = 1; y < height ; y++) {
			Color c = new Color(img.getRGB(x, y));
			if(c.equals(this.color))
				last = y;
		}
		return last;
	}
	
}
