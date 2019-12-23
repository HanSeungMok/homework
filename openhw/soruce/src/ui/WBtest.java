package ui;
/**
 * 
 */

import java.awt.EventQueue;

/**
 * @author uniha
 *
 */
public class WBtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new MainJFrame();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
