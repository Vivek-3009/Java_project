import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.LinkedList;
public class Project extends JFrame implements ActionListener {

private JPanel J_panel;					//defining components
private JTextField jtf_result,jtf_s,jtf_q;
private JRadioButton  jr_s,jr_q;
private JButton jb1_s,jb2_s,jb3_q,jb4_q;

LinkedList<Integer> list = new LinkedList<Integer>();

public Project() {
        
    list.add(1);						//adding elements to arraylist
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);
    list.add(10);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 600, 300);
    J_panel = new JPanel();
    J_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(J_panel);
    J_panel.setLayout(null);
    
    jtf_result = new JTextField();
    jtf_result.setText("");
    jtf_result.setBounds(15, 20, 565, 35);
    J_panel.add(jtf_result);
    jtf_result.setColumns(10);

    String a = list.toString();
    jtf_result.setText(a);
    
    jr_s = new JRadioButton("STACK");
    jr_s.setBounds(65, 105, 110, 25);
    J_panel.add(jr_s);
    
    jr_q = new JRadioButton("QUEUE");
    jr_q.setBounds(445, 105, 110, 25);
    J_panel.add(jr_q);

    ButtonGroup option = new ButtonGroup();
    option.add(jr_q);
    option.add(jr_s);

    jb1_s = new JButton("PUSH");
    jb1_s.addActionListener(this);
    jb1_s.setBounds(60, 175, 89, 25);
    J_panel.add(jb1_s);
    
    jb2_s = new JButton("POP");
    jb2_s.addActionListener(this);
    jb2_s.setBounds(60, 210, 90, 25);
    J_panel.add(jb2_s);
    
    jb3_q = new JButton("ADD");
    jb3_q.addActionListener(this);
    jb3_q.setBounds(440, 175, 90, 25);
    J_panel.add(jb3_q);
    
    jb4_q = new JButton("DELETE");
    jb4_q.addActionListener(this);
    jb4_q.setBounds(440, 210, 90, 25);
    J_panel.add(jb4_q);
    
    jtf_s = new JTextField();
    jtf_s.setBounds(60, 140, 90, 25);
    J_panel.add(jtf_s);
    jtf_s.setColumns(10);
    
    jtf_q = new JTextField();
    jtf_q.setBounds(440, 140, 90, 25);
    J_panel.add(jtf_q);
    jtf_q.setColumns(10);

    setTitle("Java Project");
    setVisible(true);
}
public void actionPerformed(ActionEvent e) {		//defining actions to be performed 
    String s =e.getActionCommand();
    if("PUSH".equals(s)){
        if (jtf_s.getText().toString().isBlank() != true) {
            if (jr_s.isSelected() && list.size() < 10) {
                list.addLast(Integer.valueOf(jtf_s.getText()));
                String a = list.toString();
                jtf_result.setText(a);
                jtf_s.setText("");
            }
        }
    }
    else if("POP".equals(s)){
            if (jr_s.isSelected() && list.size() > 0) {
                list.removeLast();
                String a = list.toString();
                jtf_result.setText(a);
            }
    }
    else if("ADD".equals(s)){
        if (jtf_q.getText().toString().isBlank() != true) {
            if (jr_q.isSelected() && list.size() < 10) {
                list.addLast(Integer.valueOf(jtf_q.getText()));
                String a = list.toString();
                jtf_result.setText(a);
                jtf_q.setText("");
            }
        }
    }
    else{
        if (jr_q.isSelected() && list.size() > 0) {
            list.pop();
            String a = list.toString();
            jtf_result.setText(a);
        }
    }
}
public static void main(String[] args) {				//main method
    new Project();						
}
}