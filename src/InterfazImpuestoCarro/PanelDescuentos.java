package InterfazImpuestoCarro;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelDescuentos extends JPanel{
	
	public PanelDescuentos (){
		
		setLayout (new GridLayout (2,2));
		
		TitledBorder border = BorderFactory.createTitledBorder ("Descuentos");
		border.setTitleColor(Color.BLUE);
		setBorder (border);

		JCheckBox cbPPago = new JCheckBox ("Pronto Pago");
		JCheckBox cbSPublico = new JCheckBox ("Servicio de Público");
		JCheckBox cbTCuenta = new JCheckBox ("Traslado de Cuenta");
		
		add(cbPPago);
		add(cbTCuenta);
		add(cbSPublico);

		
	}
	
	

	
}
