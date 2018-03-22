// ELABORÓ: RUBI MARICELA CIAU HU IV SEMESTRE GRUPO A

package TAREA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class agruparBotones extends JFrame
        implements ActionListener {

    public agruparBotones(String titulo) {
        //Creacion de los RadioButtons
    	
    	

        JRadioButton birdButton = new JRadioButton("Pajarito");
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand("bird");
        birdButton.setSelected(true);

        JRadioButton catButton = new JRadioButton("Gatito");
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand("cat");

        JRadioButton dogButton = new JRadioButton("Perrito");
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand("dog");

        JRadioButton rabbitButton = new JRadioButton("Conejito");
        rabbitButton.setMnemonic(KeyEvent.VK_R);
        rabbitButton.setActionCommand("rabbit");

        JRadioButton pigButton = new JRadioButton("Cerdito");
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setActionCommand("pig");

        ButtonGroup btgAnimalitos = new ButtonGroup();

        btgAnimalitos.add(birdButton);
        btgAnimalitos.add(catButton);
        btgAnimalitos.add(dogButton);
       btgAnimalitos.add(rabbitButton);
        btgAnimalitos.add(pigButton);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(0,1));
        //radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
       radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);
        radioPanel.setBackground(Color.GREEN);

       JLabel picture = new JLabel(new ImageIcon("src/loro.jpg"));

        /*BoxLayout distBoxLayout = new BoxLayout(this.getContentPane(),
                                               BoxLayout.X_AXIS);
        getContentPane().setLayout(distBoxLayout);
        */
       JButton aceptar= new JButton("ACEPTAR");
       aceptar.setBounds(40, 100, 100, 30);
       JButton cancelar= new JButton("CANCELAR");
cancelar.setBounds(160, 100, 100, 30);

       JPanel contBotones = new JPanel();
       contBotones.setLayout(new GridLayout(2,1));
       contBotones.setLayout(new BoxLayout(contBotones, BoxLayout.X_AXIS));
       //contBotones.add(aceptar);
      // contBotones.add(cancelar);
       contBotones.setBackground(Color.BLUE);

      
        GridLayout distGrid = new GridLayout(2,2);
        getContentPane().setLayout(distGrid);
        
        getContentPane().add(radioPanel, BorderLayout.NORTH);
        getContentPane().add(picture,BorderLayout.CENTER);
      // getContentPane().add(contBotones,BorderLayout.CENTER);
        getContentPane().add(aceptar,BorderLayout.CENTER);
        getContentPane().add(cancelar,BorderLayout.CENTER);

        getContentPane().setBackground(Color.BLUE);

        pack();

        setTitle(titulo);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Evento producido por " + e.getActionCommand());
    }

    public static void main (String[] args) {
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        JFrame frame = new agruparBotones("Curso de Java: Agrupar Botones");
        frame.addWindowListener(l);
        frame.pack();
        frame.setVisible(true);
   }
}