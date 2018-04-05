/**
 * 
 */

/**
 * @author xwxg008
 *
 */

import javax.swing.JFrame;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Frame;

//stpe 4 leverage shapeslibrary
class OvalDraw extends Oval{
	private boolean drawOvalfilledred;
	public void setDrawOvalFilledRed() { drawOvalfilledred = true;}
	
	//Override default constructor
	public OvalDraw () {
		super(0,0,0,0);
		drawOvalfilledred =false;
		
	}
	
	public OvalDraw(int positionXIn, int positionYIn, int widthIn, int heightIn){
		super(positionXIn,positionYIn,widthIn,heightIn);
		drawOvalfilledred = false;
	}
	
	
//steop 5 draew itself
	public void paintComponent(Graphics g) {
		g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
		if (drawOvalfilledred) {
			g.setColor(Color.red);
			g.fillOval(getPositionX()+1, getPositionY()+1, getWidth()-2, getHeight()-2);
		}
		System.out.format("OvalDraw.paintComponent(x=%d,y=%d,w=%d,h=d)\n",
				getPositionX(), getPositionY(), getWidth(), getHeight());
	}
	
}
//step 8 create face w default constructor
class SadFace extends OvalDraw {
	private OvalDraw eye;

	public SadFace() {
		super(0,0,0,0);
		eye = new OvalDraw(0,0,0,0);

		
	}
	
	public SadFace(int positionXIn, int positionYIn, int widthIn, int heightIn){

		super(positionXIn,positionYIn,widthIn,heightIn);
		int eyeHeight = heightIn / 7;
		int eyeWidth = eyeHeight * 2;
		int eyePostionX = positionXIn + (widthIn / 2) - (eyeWidth / 2);
		int eyePositionY = positionYIn + (heightIn / 3) - (eyeHeight /2) ;



		eye = new OvalDraw(eyePostionX,eyePositionY,eyeWidth,eyeHeight);
		eye.setDrawOvalFilledRed();
	}
	
	//draw sad face itself
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		eye.paintComponent(g);
		g.setColor(Color.black);
		g.drawArc(getPositionX(),getPositionY()+(getHeight()/2), getWidth()-10, getHeight()-10, 45,90);
}
}
//stpe 2 implement jpanel and graphics then add panel to frame
class SadPanel extends JPanel{
	//steop 6 create 1 of them
	//create collectiomn of sadpanels
	private SadFace mySadFace;
	private SadFace mySadFace2;

	
	public SadPanel() {
		//constructor
		mySadFace = new SadFace(100,100,80,160);
		mySadFace2 = new SadFace(200,300,140,260);
		
	}
	public void paintComponent(Graphics g) {	
		super.paintComponent(g);
		//step 7 clean up
		//g.drawOval(100, 100, 80, 120);
		
		
		//step 6.1
		mySadFace.paintComponent(g);
		mySadFace2.paintComponent(g);
		
	}
}

public class FaceDrawLite {

	public static void main(String[] args) {
		System.out.println("face Draw Lite");
		
		//step 1 create jframe
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame myFrame = new JFrame("sad face draw");
		myFrame.setBounds(100, 100, 900, 900);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		
		//step3 add Panel to Frame
		SadPanel mySadPanel = new SadPanel();
		myFrame.add(mySadPanel);
		
	}

}
