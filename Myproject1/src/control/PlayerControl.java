package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/*
 * 注意可以改成extends KeyAdaptor,可以省下两个不需要的方法KeyReleased和KeyTyped
 */
public class PlayerControl implements KeyListener {

	private GameControl gameControl;
	
	public PlayerControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	/*
	 * 键盘按下事件
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		//TODO
		switch (e.getKeyCode()) {
		
		case KeyEvent.VK_UP:
		    this.gameControl.keyUp();
		break;
		
	    case KeyEvent.VK_DOWN:
			this.gameControl.keyDown();
		break;
		
	    case KeyEvent.VK_RIGHT:
	 	    this.gameControl.keyRight();
		break;
		
	    case KeyEvent.VK_LEFT:
	    	this.gameControl.keyLeft();
		break;
	    case KeyEvent.VK_W:
	    	this.gameControl.testLevelUp();
	    	break;
	   	default:
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
