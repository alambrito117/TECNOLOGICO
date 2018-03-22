package ReservacionVuelo;

import java.awt.*;

import javax.swing.*;

import ReservacionVuelo.SILLAS;
import ReservacionVuelo.SILLAS.Clase;



public class DIBUJARSILLAS extends JPanel
{
   
    private ImageIcon imagen;

    
    public DIBUJARSILLAS( SILLAS pSilla )
    {
        super( new BorderLayout( ) );
        JLabel lSilla = new JLabel( );
        if( pSilla.darClase( ) == Clase.EJECUTIVA && pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "src/silla-ejec-asig.png" );
        }
        else if( pSilla.darClase( ) == Clase.EJECUTIVA && !pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "src/silla-ejec-libre.png" );
        }
        else if( pSilla.darClase( ) == Clase.ECONOMICA && pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "src/silla-econ-asig.png" );
        }
        else if( pSilla.darClase( ) == Clase.ECONOMICA && !pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "src/silla-econ-libre.png" );
            lSilla.setForeground( Color.white );
        }
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );
        lSilla.setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        lSilla.setText( "" + pSilla.darNumero( ) );
        lSilla.setHorizontalAlignment( SwingConstants.CENTER );
        lSilla.setVerticalAlignment( SwingConstants.CENTER );
        add( lSilla );
    }

    
    public void paint( Graphics pGrafica )
    {
        pGrafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( pGrafica );
    }

}