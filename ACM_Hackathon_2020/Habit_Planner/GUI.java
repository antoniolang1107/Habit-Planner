/* Author: Tony Lang
 * Date: 11/15/20
 * 2020 Hackathon
 * Habit Planner
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener
{
    private HabitPlanner runHabit = new HabitPlanner();
    private JFrame frame = new JFrame();
    private JButton display = new JButton("List");
    private JButton add = new JButton("Add");
    private JButton remove = new JButton("Remove");
    private JButton backButton = new JButton("Back");
    private JButton submit = new JButton("Enter");
    private JButton rmEnter = new JButton("Enter");
    private JButton save = new JButton("Save");
    
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    
    private TextField tf1, tf2, tf3, tf4, tf5;
    private TextField removeName;
    
    private JLabel listGuide;

    public GUI() {
        JButton spacer = new JButton();
        display.addActionListener(this);
        add.addActionListener(this);
        remove.addActionListener(this);
        backButton.addActionListener(this);
        submit.addActionListener(this);
        save.addActionListener(this);
        rmEnter.addActionListener(this);
                
        JLabel tL1, tL2, tL3, tL4, tL5;
        JLabel removeTF;
        
        tf1 = new TextField();
        tf1.setBounds(50, 50, 150, 20);
        tf2 = new TextField();
        tf2.setBounds(50, 50, 150, 20);
        tf3 = new TextField();
        tf3.setBounds(50, 50, 50, 20);
        tf4 = new TextField();
        tf4.setBounds(50, 50, 50, 20);
        tf5 = new TextField();
        tf5.setBounds(50, 50, 50 ,20);
        removeName = new TextField();
        removeName.setBounds(50, 50, 150, 20);
        
        tL1 = new JLabel("Habit");
        tL2 = new JLabel("Unit");
        tL3 = new JLabel("Start");
        tL4 = new JLabel("Increase");
        tL5 = new JLabel("End");
        listGuide = new JLabel("Habit, Unit, Start, Increment, Goal");
        removeTF = new JLabel("Enter the name of the habit to remove");
        
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(4, 0));
        panel.add(display);
        panel.add(add);
        panel.add(remove);
        panel.add(save);
        
        panel1.setLayout(new GridLayout(3,0));
        panel1.add(listGuide);
        
        panel2.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel2.setLayout(new GridLayout(3,5));
        panel2.add(tL1); panel2.add(tL2); panel2.add(tL3); panel2.add(tL4); panel2.add(tL5);
        panel2.add(tf1); panel2.add(tf2); panel2.add(tf3); panel2.add(tf4); panel2.add(tf5);
        panel2.add(submit);
        panel2.add(backButton);
        panel2.add(spacer);
        spacer.setVisible(false);
        
        panel3.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel3.setLayout(new GridLayout(4,0));
        panel3.add(removeTF);
        panel3.add(removeName);
        panel3.add(rmEnter);
        panel3.add(backButton);
        
        frame.setTitle("Habit Planner");
        frame.setLocation(800, -650);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == display)
        {
            frame.remove(panel);
            panel1.removeAll();
            
            panel1.add(listGuide);
            TextArea ta1 = new TextArea(runHabit.textOutput());
            panel1.add(ta1);
            
            panel1.add(backButton);
            frame.add(panel1);
            frame.pack();
        }
        if (e.getSource() == add)
        {
            frame.remove(panel);
            panel2.add(backButton);
            frame.add(panel2);
            
            frame.pack();
        }
        if (e.getSource() == remove)
        {
            frame.remove(panel);
            panel3.add(backButton);
            frame.add(panel3);
            
            frame.pack();
        }
        if (e.getSource() == rmEnter)
        {
            String rmHabit = removeName.getText();
            runHabit.removeHabit(rmHabit);
            removeName.setText("");
        }
        if (e.getSource() == backButton)
        {
            frame.getContentPane().removeAll();
            frame.add(panel);
            frame.pack();
        }
        if (e.getSource() == save)
        {
            runHabit.writeFile();
        }
        if (e.getSource() == submit)
        {
            String s1 = tf1.getText();
            String s2 = tf2.getText();
            String s3 = tf3.getText();
            String s4 = tf4.getText();
            String s5 = tf5.getText();
            
            int start = Integer.parseInt(s3);
            int increase = Integer.parseInt(s4);
            int goal = Integer.parseInt(s5);
            
            runHabit.addHabit(s1, s2, start, increase, goal);
            
            tf1.setText(""); tf2.setText(""); tf3.setText(""); tf4.setText(""); tf5.setText("");
        }
    }
    
    public static void main(String[] args) {
        new GUI();
    }
}
