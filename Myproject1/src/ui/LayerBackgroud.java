package ui;

import java.awt.Graphics;
import java.awt.Image;


public class LayerBackgroud extends Layer {

	
    //TODO temporary background
	
	public LayerBackgroud(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		int bgIdx = this.dto.getNowlevel() % Img.BG_LIST.size();
		Image imgIn = Img.BG_LIST.get(bgIdx);
		g.drawImage(imgIn, 0, 0, imgIn.getWidth(null), imgIn.getHeight(null), null);

	}

}
