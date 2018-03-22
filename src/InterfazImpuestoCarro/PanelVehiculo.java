package InterfazImpuestoCarro;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelVehiculo extends JPanel {
	
	public PanelVehiculo (){
		
		setLayout (new GridLayout (5,2));
		setPreferredSize(new Dimension(0,130));
		TitledBorder border = BorderFactory.createTitledBorder ("Datos del Vehículo");
		border.setTitleColor(Color.BLUE);
		setBorder (border);
		
		JLabel labMarca = new JLabel("Marca");
		JLabel labLinea = new JLabel("Linea");
		JLabel labModelo = new JLabel("Modelo");
		JLabel labValor = new JLabel("Valor");
		JTextField txtMarca = new JTextField ();
		JTextField txtLinea = new JTextField ();
		JTextField txtModelo = new JTextField ();
		JTextField txtValor = new JTextField (" $ 0 ");
		
		txtValor.setEditable(false);
		txtValor.setForeground(Color.BLUE);
		txtValor.setBackground(Color.WHITE);
		
		add(labMarca);
		add(txtMarca);
		add(labLinea);
		add(txtLinea);
		add(labModelo);
		add(txtModelo);
		add(labValor);
		add(txtValor);
		



	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
