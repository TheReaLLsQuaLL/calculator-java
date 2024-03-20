package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField display;
	private String operatorFirst;
	private String operator;
	private String operatorLast;
	private double result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		display = new JTextField();
		display.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
						.addComponent(display, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(display, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		buttonPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
				}
		});
		buttonPanel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
			}
		});
		buttonPanel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
			}
		});
		buttonPanel.add(btn9);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperator(e.getActionCommand());
			}
		});
		buttonPanel.add(btnDiv);
		
		JButton btnErase = new JButton("DEL");
		buttonPanel.add(btnErase);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
			}
		});
		buttonPanel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
			}
		});
		buttonPanel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
			}
		});
		buttonPanel.add(btn6);
		
		JButton btnMul = new JButton("x");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperator(e.getActionCommand());
			}
		});
		buttonPanel.add(btnMul);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear(e.getActionCommand());
			}
		});
		buttonPanel.add(btnClear);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
			}
		});
		buttonPanel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
			}
		});
		buttonPanel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
			}
			
		});
		buttonPanel.add(btn3);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperator(e.getActionCommand());
			}
		});
		buttonPanel.add(btnPlus);
		
		JButton btnEqUp = new JButton("");
		buttonPanel.add(btnEqUp);
		
		JButton btnPlusMin = new JButton("+/-");
		btnPlusMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = display.getText();
				char first = temp.charAt(0);
				temp.substring(1, temp.length());
				display.setText("-" + temp);
			}
		});
		buttonPanel.add(btnPlusMin);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processDigit(e.getActionCommand() );
			}
		});
		buttonPanel.add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = display.getText();
				if(n.contains(".")) return;
				processDigit(e.getActionCommand() );
			}
		});
		buttonPanel.add(btnDot);
		
		JButton btnMin = new JButton("-");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperator(e.getActionCommand());
			}
		});
		buttonPanel.add(btnMin);
		
		JButton btnEqDown = new JButton("=");
		btnEqDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorLast = display.getText();
				double oF = Double.parseDouble(operatorFirst);
				double oL = Double.parseDouble(operatorLast);
				if(operator == "+") {
					result = oF + oL;
					display.setText("" + result);
				}else if(operator == "-") {
					result = oF - oL;
					display.setText("" + result);
				}else if(operator == "x") {
					result = oF * oL;
					display.setText("" + result);
				} else if(operator == "/") {
					result = oF  / oL;
					display.setText("" + result);
				} else {
					display.setText("Unidentified!");
				}
				operatorFirst = "";
				operator = "";
				operatorLast = "";
			}
		});
		buttonPanel.add(btnEqDown);
		contentPane.setLayout(gl_contentPane);
	}

	protected void clear(String actionCommand) {
		String temp = display.getText();
		if(temp.length() > 1) {
			display.setText(temp.substring(0,temp.length()-1));
		}else {
			display.setText("");
		}
	}

	protected void setOperator(String actionCommand) {
		operatorFirst = display.getText();
		operator = actionCommand;
		display.setText("");
		
	}

	protected void processDigit(String actionCommand) {
		display.setText( display.getText() + actionCommand);
	}
}
