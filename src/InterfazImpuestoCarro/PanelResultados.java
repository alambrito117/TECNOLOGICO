package InterfazImpuestoCarro;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelResultados extends JPanel implements ActionListener {
	
	public final static String LIMPIAR = "limpiar";
	public final static String CALCULAR = "calcular";

	
	public PanelResultados (){
		
		
		setLayout (new GridLayout (2,3));
		setPreferredSize(new Dimension(0,65));
		TitledBorder border = BorderFactory.createTitledBorder ("Resultados");
		border.setTitleColor(Color.BLUE);
		setBorder (border);
		
		JLabel labTotal = new JLabel ("Total a Pagar");
		JTextField txtTotal = new JTextField (" $ 0 ");
		JButton butLimpiar = new JButton ("Limpiar");
		JButton butCalcular = new JButton ("Calcular");
		
		txtTotal.setEditable(false);
		txtTotal.setForeground(Color.BLUE);
		txtTotal.setBackground (Color.WHITE);
		
		butLimpiar.setActionCommand(LIMPIAR);
		butCalcular.setActionCommand(CALCULAR);
        butLimpiar.addActionListener(this);
        butCalcular.addActionListener(this);

		
		add(new JLabel(""));
		add(new JLabel(""));
		add(butLimpiar);
		add(labTotal);
		add(txtTotal);
		add(butCalcular);

		

		
	}
	
	public void actionPerformed (ActionEvent evento){
		
		String comando = evento.getActionCommand();
		
		if (comando.equals(LIMPIAR)){
			
			// Reacción al evento de limpiar
		}
		else if (comando.equalsIgnoreCase(CALCULAR)){
			
			// Reacción al evento de calcular

		}
		

	}
	



	

}
