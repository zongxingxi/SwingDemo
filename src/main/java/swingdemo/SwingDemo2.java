package swingdemo;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingDemo2 extends JFrame {

    private JLabel CardId;
    private JButton search;
    private JButton Save;
    private JPanel SwingDemo2;
    private JPanel j1;
    private JTextField textField1;
    private JPanel j2;
    private JTabbedPane tabbedPane1;
    private JPanel j3;
    private JScrollPane js1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JScrollPane js2;
    private JPanel j4;
    private JTextArea InputUrl;

    SwingControl control = new SwingControl();
    public SwingDemo2(String title){
        super(title);
        setContentPane(SwingDemo2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String[] result = control.GetUrlAndIds(CardId.getText());
                textArea2.setText(result[0]);
                textArea3.setText(result[1]);
            }
        });
        Save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    control.Save(CardId.getText(), InputUrl.getText());
                } catch (Exception ex) {
                    //TODO
                }
                InputUrl.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new SwingDemo2("SwingDemo2");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
