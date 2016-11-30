import java.awt.FlowLayout; import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import javax.swing.JButton; import javax.swing.JFrame; import javax.swing.JLabel; import javax.swing.JPasswordField; import javax.swing.JTextField;
 public class SwingBasic extends JFrame
 {
 JLabel l; 
 public void start()
 { 
 l=new JLabel(); l.setText("	Name :"); 
 JTextField txt=new JTextField(); txt.setText("Anurag jain(csanuragjain)"); 
 JPasswordField ps=new JPasswordField(10); 
 JButton but=new JButton(); but.setText("Submit");
 add(l); add(txt); add(ps); add(but); 
 but.addActionListener( new ActionListener(){ public void actionPerformed( ActionEvent e){ l.setText("Button clicked"); } } ); 
 setLayout(new FlowLayout()); 
 setSize(400,400); 
 setVisible(true);
 setDefaultCloseOperation(EXIT_ON_CLOSE); 
 } 
 
 public static void main(String args[]) 
 { new SwingBasic().start(); } 
 }
