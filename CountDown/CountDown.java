import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.io.File;
import java.io.IOException;

public class CountDown {
	static int width = 150, height = 100;
	static int max = 10;	
	JFrame frame = null;
	NumberCanvas canvas = null;
	JPanel pane = null;

	Tick t = null;

	CountDown(int max) {
		this.max = max;
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			max = Integer.valueOf(args[0]);
		} 

		CountDown cd = new CountDown(max);
		cd.run();
	}

	public void run() {
		start();

		try {
			Thread.sleep(3000);
		} catch(InterruptedException ie){}

		tick();

		//beep();

	}

	public void start() {

		/*
		* Prepare for the GUI frame
		*/ 

		frame = new JFrame("CountDown Timer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width,height);
		frame.setLocationRelativeTo(null);

		canvas = new NumberCanvas("CountDown");
		canvas.setPreferredSize(new Dimension(width, height));

		pane = new JPanel();

		frame.getContentPane().add(pane);



		pane.add(canvas);

		/*
		* set the maximum value for the countdown.
		*/
		canvas.setValue(max);		

		frame.setVisible(true);


	}

	public void tick() {

		this.t = new Tick(this, canvas, max);
		t.start();

	}

	public void beep() {
		/*
		* for the beep sound
		*/
		Toolkit.getDefaultToolkit().beep();
	}


	class Tick extends Thread {
		private boolean isActive = true;
		private int max = 10;
		NumberCanvas canvas = null;
		CountDown cd = null;

		Tick(CountDown cd, NumberCanvas c, int max) {
			this.canvas = c;
			this.max = max;
			this.cd = cd;
		}
		public void run () {
			for(int i=max; i > 0; i--) {

				try{
					Thread.sleep(1000);	
					this.canvas.decrementValue();
				} catch(InterruptedException e) {}

			}
			cd.beep();
		}
	}

}
