// ELABORÓ: RUBI MARICELA CIAU HU IV SEMESTRE GRUPO A

package InterfazImpuestoCarro;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class InterfazImpuestoCarro extends JFrame{

	//private calculadorImpuestos calculador;
	
	private PanelVehiculo panelVehiculo;
	private PanelDescuentos panelDescuentos;
	private PanelResultados panelResultados;
	
	public InterfazImpuestoCarro (){
		
		
		setTitle("Calculador Impuestos");
		setSize(290, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		panelVehiculo = new PanelVehiculo();
		add(panelVehiculo,BorderLayout.NORTH);
		
		panelDescuentos = new PanelDescuentos();
		add(panelDescuentos,BorderLayout.CENTER);
		
		panelResultados = new PanelResultados();
		add(panelResultados,BorderLayout.SOUTH);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterfazImpuestoCarro ventana= new InterfazImpuestoCarro();

		ventana.setVisible(true);
		
		
	}

}
