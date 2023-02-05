import javax.swing.*;

public class Panta {

    private static JFrame frame;

    //Creates a JFrame and add GamePanel to it.
    public static void main(String[] args0) {

        frame = new JFrame("Panta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GamePanel());
        frame.pack();
        frame.setSize(1920, 1040);
        frame.setVisible(true);

    }
}

 
