import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingDemoMain extends JFrame {
    private JTextField inputCardId;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;

    private SwingDemoMain(String title) throws HeadlessException {
        super(title);
        setContentPane(demo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        this.setSize(1000, 600);
        setLocationRelativeTo(null);
        Process();
        Save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(inputCardId.getText());
            }
        });
    }

    private void Process(){
//        inputCardId.setText("cardid");
    }

    public static void main(String[] args) {
        new SwingDemoMain("demo");
    }

    private JButton Save;
    private JButton 查询Button;
    private JPanel demo;
}
