package ReservacionVuelo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ReservacionVuelo.AVION;
import ReservacionVuelo.SILLAS;
//import ReservacionVuelo.SillaGrafica;


public class PanelAvion extends JPanel {
	
    private AVION avion;
    private ImageIcon imagen;

       public PanelAvion( AVION pAvion )
    {
        super( new BorderLayout( ) );
        avion = pAvion;
        imagen = new ImageIcon( "src/avion1.jpeg" );
setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );

        // Adiciona las imágenes de las sillas ejecutivas
        JPanel panelEjecutivas = new JPanel( );
        dibujarSillasEjecutivas( panelEjecutivas );
        add( panelEjecutivas, BorderLayout.NORTH );

        // Adiciona las imágenes de las sillas económicas
        JPanel panelEconomicas = new JPanel( );
        dibujarSillasEconomicas( panelEconomicas );
        add( panelEconomicas, BorderLayout.CENTER );
    }

   
    public void paint( Graphics pGrafica )
    {
        pGrafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( pGrafica );
    }

    
    private void dibujarSillasEjecutivas( JPanel pPanel )
    {
        pPanel.setLayout( new GridLayout( AVION.SILLAS_EJECUTIVAS / 4, 5, 8, 5 ) );
        pPanel.setBorder( new EmptyBorder( 90, 210, 20, 210 ) );

        SILLAS[] ejecutivas = avion.obtenerSillasEjecutivas( );
        SILLAS silla;

        for( int i = 0; i < ejecutivas.length; i++ )
        {
            silla = ejecutivas[ i ];
            DIBUJARSILLAS sillaG = new DIBUJARSILLAS( silla );
            pPanel.add( sillaG );
            if( i % 4 == 1 )
            {
                pPanel.add( new JLabel( " " ) );
            }
        }
        pPanel.setOpaque( false );
    }

   
    private void dibujarSillasEconomicas( JPanel pPanel )
    {
        pPanel.setLayout( new GridLayout( AVION.SILLAS_ECONOMICAS / 6, 7, 5, 4 ) );
        pPanel.setBorder( new EmptyBorder( 0, 200, 100, 200 ) );

        SILLAS[] economicas = avion.obtenerSillasEconomicas( );
        SILLAS silla;

        for( int i = 0; i < economicas.length; i++ )
        {
            silla = economicas[ i ];

            DIBUJARSILLAS sillaG = new DIBUJARSILLAS( silla );
            pPanel.add( sillaG );
            if( i % 6 == 2 )
            {
                pPanel.add( new JLabel( " " ) );
            }
        }
        pPanel.setOpaque( false );
    }
}

