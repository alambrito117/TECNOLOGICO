package ReservacionVuelo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.*;

import ReservacionVuelo.ReservacionEnUnVuelo;


public class panelBotonesAvion extends JPanel implements ActionListener
{
    public final static String REGISTRAR = "REGISTRAR_PASAJERO";
    public final static String ANULAR = "ANULAR_PASAJERO";
    public final static String BUSCAR = "BUSCAR_PASAJERO";
    public final static String PORCENTAJE = "PORCENTAJE_OCUPACION";
    private final static String OPCION_1 = "OPCION_1";
    private final static String OPCION_2 = "OPCION_2";

    private JButton bRegistro;
    private JButton bAnular;
    private JButton bBuscarPasajero;
    private JButton bPorcOcupacion;
    private JButton botonOpcion1;
    private JButton botonOpcion2;
    private ReservacionEnUnVuelo ventana;

    public panelBotonesAvion( ReservacionEnUnVuelo pVentana )
    {
        // Guarda la referencia al frame
        ventana = pVentana;

        // Configura propiedades visuales
        setLayout( new GridLayout( 2, 3, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        // Botón registrar
        bRegistro = new JButton( "Registrar Pasajero" );
        bRegistro.setActionCommand( REGISTRAR );
        bRegistro.addActionListener( this );
        bRegistro.setPreferredSize( new Dimension( 40, 10 ) );
        add( bRegistro );

        // Botón anular registro
        bAnular = new JButton( "Eliminar Pasajero" );
        bAnular.setActionCommand( ANULAR );
        bAnular.addActionListener( this );
        add( bAnular );

        // Botón buscar pasajero
        bBuscarPasajero = new JButton( "Buscar Pasajero" );
        bBuscarPasajero.setActionCommand( BUSCAR );
        bBuscarPasajero.addActionListener( this );
        add( bBuscarPasajero );

        // Botón porcentaje de ocupación
        bPorcOcupacion = new JButton( "Porcentaje Ocupación" );
        bPorcOcupacion.setActionCommand( PORCENTAJE );
        bPorcOcupacion.addActionListener( this );
        add( bPorcOcupacion );

        // Botones de opciones adicionales
        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        add( botonOpcion1 );
        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        add( botonOpcion2 );
    }

    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( REGISTRAR ) )
        {
            ventana.registrarPasajero( );
        }
        else if( comando.equals( ANULAR ) )
        {
            ventana.eliminarPasajero( );
        }
        else if( comando.equals( BUSCAR ) )
        {
            ventana.buscarPasajero( );
        }
        else if( comando.equals( PORCENTAJE ) )
        {
            ventana.mostrarPorcentajeOcupacion( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            ventana.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            ventana.reqFuncOpcion2( );
        }
    }
}



















/*public class panelBotonesAvion extends JPanel  {

    private JButton bRegistro;
    private JButton bAnular;
    private JButton bBuscarPasajero;
    private JButton bPorcOcupacion;
    private JButton botonOpcion1;
    private JButton botonOpcion2;


  
    public panelBotonesAvion(  )
    {
       
        setLayout( new GridLayout( 2, 3, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        // Botón registrar
        bRegistro = new JButton( "Registrar Pasajero" );
       
        bRegistro.setPreferredSize( new Dimension( 40, 10 ) );
        add( bRegistro );

        // Botón anular registro
        bAnular = new JButton( "Eliminar Pasajero" );
        
        add( bAnular );

        // Botón buscar pasajero
        bBuscarPasajero = new JButton( "Buscar Pasajero" );
       
        add( bBuscarPasajero );

        // Botón porcentaje de ocupación
        bPorcOcupacion = new JButton( "Porcentaje Ocupación" );
               add( bPorcOcupacion );

        // Botones de opciones adicionales
        botonOpcion1 = new JButton( "Opción 1" );
        
        add( botonOpcion1 );
        botonOpcion2 = new JButton( "Opción 2" );
       
        add( botonOpcion2 );
    }

    
	
	






	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
*/