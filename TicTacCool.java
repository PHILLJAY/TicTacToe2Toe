import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class TicTacCool {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacCool window = new TicTacCool();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacCool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 696, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(111, 151, 97, 25);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("4");
		button_1.setBounds(111, 189, 97, 25);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(111, 227, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton button_2 = new JButton("2");
		button_2.setBounds(220, 151, 97, 25);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.setBounds(220, 189, 97, 25);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("3");
		button_4.setBounds(329, 151, 97, 25);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBounds(329, 189, 97, 25);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.setBounds(220, 227, 97, 25);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.setBounds(329, 227, 97, 25);
		frame.getContentPane().add(button_7);
	}
}
