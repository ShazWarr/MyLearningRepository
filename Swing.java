import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
*	Exam 1 CSIS-225 
*
*	@author Ira Goldstein
*	@version Spring 2023  
*/

public class Swing implements Runnable,ActionListener {


	//When creating GUI's all your variables should be instance, we can reference and use these variables
	//within our run () method, but they must be declare/initialized here first. 

	public JFrame frame;
	public JPanel panel;
	public JPanel tallyPanel;
	public JLabel tallyLabel;
	public Font currFont;
	public Font newFont;
	public JPanel buttonPanel;
	public JButton oneButton;
	public JButton fiveButton;
	public JButton tenButton;
	public JButton clearButton;
	public int tally;


	@Override
	public void run() {



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//Created my main frame, gave it text "add it"
		//Set preffered size "300 x 200"
		//"setDefaultCloseOperation" will close the frame when the x symbol is clicked. 
		JFrame frame = new JFrame("Add It!");
		frame.setPreferredSize(new Dimension(300, 200));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//Main panel
		JPanel panel = new JPanel(new BorderLayout());

		//We will add our main panel to our main frame.
		frame.add(panel);


		//Talley panel should not be declared here but it will not hurt the program
		//We create the panel with a "Flowlayout"
		//We add this panel to out main panel.
		JPanel tallyPanel = new JPanel(new FlowLayout());
		panel.add(tallyPanel, BorderLayout.CENTER);
		
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//We initizalize our instance variable "tally" with 0.
		//We create a label to add to tallyLabel, which is already created, we
		//are just adding text to our created label.
		tally=0;
		tallyLabel = new JLabel("Tally: " + tally);

		//We add our panel to our main panel.
		tallyPanel.add(tallyLabel);



		//Dont care too much about this block, font currFont and newFont should not be delcared again,
		//as they are declared as instance variables
		Font currFont = tallyLabel.getFont();
		Font newFont = new Font(currFont.getFontName(), currFont.getStyle(), 24);
		tallyLabel.setFont(newFont);


		//Should not declare buttonPanel here, it should be a class instance, but doesnt hurt
		//program. this panel is addded to the main panel.
		JPanel buttonPanel = new JPanel(new FlowLayout());
		panel.add(buttonPanel, BorderLayout.SOUTH);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Buttons are not declared again but rahter are assigned text. 
		//Buttons need an actionListener, the parameter always defaults to "this".
		//Make sure to import actionEvent, and actionListener.
		oneButton = new JButton("One");
		oneButton.addActionListener(this);
		//We add this button to the buttonPanel, we already added the buttonPanel to the main panel
		buttonPanel.add(oneButton);

		//Same thing as we did for buttonOne.
		fiveButton = new JButton("Five");
		fiveButton.addActionListener(this);
		buttonPanel.add(fiveButton);
		tenButton = new JButton("Ten");
		tenButton.addActionListener(this);
		buttonPanel.add(tenButton);
		
		clearButton = new JButton("Clear");
		
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);		

		frame.pack();
		frame.setVisible(true);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Since we implement the actionListener interface we must implement that interface's methods.
	
	public void actionPerformed(ActionEvent e) {

		//based on the button pressed an if-statement wille execute.
        if (e.getSource() == oneButton) {
        tally++;

		//updates our original JLabel "tallyLabel" with the updated text
        tallyLabel.setText("Tally: " + tally);
    } else if (e.getSource() == fiveButton) {
        tally += 5;
        tallyLabel.setText("Tally: " + tally);
    } else if (e.getSource() == tenButton) {
        tally += 10;
        tallyLabel.setText("Tally: " + tally);
    } else if (e.getSource() == clearButton) {
        tally = 0;
        tallyLabel.setText("Tally: " + tally);
    }
    }

	public static void main(String args[]) {

		javax.swing.SwingUtilities.invokeLater(new Swing());
	}
}
