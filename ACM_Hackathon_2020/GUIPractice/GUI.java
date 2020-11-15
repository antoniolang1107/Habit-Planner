import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener
{
    private JFrame frame = new JFrame();
    private JButton button1 = new JButton("List");
    private JButton button2 = new JButton("Add");
    private JButton button3 = new JButton("Modify");
    private JButton backButton = new JButton("Back");
    private JButton submit = new JButton("Enter");
    
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    
    private TextField tf1, tf2, tf3, tf4;
    private TextArea ta1;

    public GUI() {
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        backButton.addActionListener(this);
        submit.addActionListener(this);
        
        ta1 = new TextArea("The habits go here\n"); // can be console for bandage
        ta1.setEditable(false);
        
        JLabel tL1, tL2, tL3, tL4;
        
        tf1 = new TextField();
        tf1.setBounds(50, 50, 150, 20);
        tf2 = new TextField();
        tf2.setBounds(50, 50, 150, 20);
        tf3 = new TextField();
        tf3.setBounds(50, 50, 50, 20);
        tf4 = new TextField();
        tf4.setBounds(50, 50, 50, 20);
        
        tL1 = new JLabel("Habit");
        tL2 = new JLabel("Unit");
        tL3 = new JLabel("Start");
        tL4 = new JLabel("End");
        
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(3, 0));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        
        panel1.add(ta1);
        
        panel2.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel2.setLayout(new GridLayout(1,0));
        panel2.add(backButton);
        
        panel3.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel3.setLayout(new GridLayout(3, 0));
        panel3.add(tL1); panel3.add(tL2); panel3.add(tL3); panel3.add(tL4);
        panel3.add(tf1); panel3.add(tf2); panel3.add(tf3); panel3.add(tf4);
        panel3.add(submit);
        panel3.add(backButton);
        
        frame.setTitle("GUI Test");
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == button1)
        {
            frame.remove(panel);
            panel1.add(backButton);
            frame.add(panel1);
            frame.pack();
        }
        if (e.getSource() == button2)
        {
            frame.remove(panel);
            panel3.add(backButton);
            frame.add(panel3);
            
            frame.pack();
        }
        if (e.getSource() == button3)
        {
            System.out.println("Button 3 pressed!");
        }
        if (e.getSource() == backButton)
        {
            frame.getContentPane().removeAll();
            frame.add(panel);
            frame.pack();
        }
        if (e.getSource() == submit)
        {
            String s1 = tf1.getText();
            String s2 = tf2.getText();
            String s3 = tf3.getText();
            String s4 = tf4.getText();
            
            int start = Integer.parseInt(s3);
            int goal = Integer.parseInt(s4);
            
            tf1.setText(""); tf2.setText(""); tf3.setText(""); tf4.setText("");
        }
    }
    
    public static void main(String[] args) {
        new GUI();
    }
}
