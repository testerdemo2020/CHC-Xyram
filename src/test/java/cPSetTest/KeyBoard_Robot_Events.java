package cPSetTest;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.testng.annotations.Test;

import testScript.BaseClass;

 
public class KeyBoard_Robot_Events extends BaseClass{

@Test
public void test() throws AWTException {
	driver.get("https://www.stqatools.com");
 
// Create Robot class
Robot rb = new Robot();
 
// Press control keyboard key
rb.keyPress(KeyEvent.VK_CONTROL);
 
// Press A keyboard key
rb.keyPress(KeyEvent.VK_A);
 
}
 
}