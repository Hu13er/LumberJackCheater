import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Main {
  public static void main(String[] argv) throws Exception {
	  Scanner scanner = new Scanner(System.in);
	  
	  int skip = scanner.nextInt();
	  
	  int firstLineX = 750, secondLineX = 920;
	  int r = 108, g = 161, b = 62;
	  int maxY = 238;
	  
	  if(skip > 0) {
		  System.out.println("Enter first line x");
		  firstLineX = scanner.nextInt();
		  System.out.println("Enter second line x");
		  secondLineX = scanner.nextInt();
		  
		  System.out.println("Enter R G B:");
		  r = scanner.nextInt();
		  g = scanner.nextInt();
		  b = scanner.nextInt();
		  
		  System.out.println("Enter maxY:");
		  maxY = scanner.nextInt();
	  }
	  
	  env e = new env(firstLineX, secondLineX, maxY, new Color(r, g, b));
	  for(int i = 0; i < 3; i++) {
		  System.out.println(i);
		  Thread.sleep(1000);
	  }
	  System.out.println("BOOM");
	  
	  while(true) {
		  int status = e.getStatus();
		  System.out.println("Status: " + status);
		  if(status > 0)
			  e.LeftPress();
		  else if(status < 0)
			  e.RightPress();
		  else if(status == 0)
			  e.RightPress();
		  Thread.sleep(36);
		  
	  }

  }
}
