package ReservacionVuelo;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import ReservacionVuelo.ReservacionEnUnVuelo;
import ReservacionVuelo.PASAJEROS;
import ReservacionVuelo.SILLAS;
import ReservacionVuelo.SILLAS.Clase;
import ReservacionVuelo.SILLAS.Ubicacion;

public class DatosPasajero extends JDialog
{

  
   public final static String ACEPTAR = "ACEPTAR";

   
   private ReservacionEnUnVuelo principal;
   private JTextField txtCedula;
   private JTextField txtNombre;
   private JTextField txtClase;
   private JTextField txtUbicacion;
   private JTextField txtSilla;

  
   public DatosPasajero( ReservacionEnUnVuelo pPrincipal, SILLAS pSilla )
   {
       principal = pPrincipal;

       setTitle( "Datos del pasajero" );
       setSize( 270, 200 );
       setDefaultCloseOperation( DISPOSE_ON_CLOSE );

       PASAJEROS pasajero = pSilla.darPasajero( );
       setLayout( new BorderLayout( ) );

       // Crea el panel de datos del pasajero
       JPanel panelDatosPasajero = new JPanel( );

       panelDatosPasajero.setBorder( new CompoundBorder( new TitledBorder( "Datos del pasajero" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
       panelDatosPasajero.setLayout( new GridLayout( 5, 2, 1, 1 ) );

       // Cédula
       JLabel etiquetaCedula = new JLabel( "Cédula: " );
       panelDatosPasajero.add( etiquetaCedula );

       txtCedula = new JTextField( pasajero.darCedula( ) + "" );
       txtCedula.setEditable( false );
       panelDatosPasajero.add( txtCedula );

       // Nombre
       JLabel etiquetaNombre = new JLabel( "Nombre: " );
       panelDatosPasajero.add( etiquetaNombre );

       txtNombre = new JTextField( pasajero.darNombre( ) );
       txtNombre.setColumns( 15 );
       txtNombre.setEditable( false );
       panelDatosPasajero.add( txtNombre );

       // Silla
       JLabel etiquetaSilla = new JLabel( "Silla: " );
       panelDatosPasajero.add( etiquetaSilla );

       txtSilla = new JTextField( pSilla.darNumero( ) + "" );
       txtSilla.setEditable( false );
       panelDatosPasajero.add( txtSilla );

       // Clase
       JLabel etiquetaClase = new JLabel( "Clase: " );

       panelDatosPasajero.add( etiquetaClase );
       String sClase;
       if( pSilla.darClase( ) == Clase.ECONOMICA )
       {
           sClase = "Económica";
       }
       else
       {
           sClase = "Ejecutiva";
       }
       txtClase = new JTextField( sClase );
       txtClase.setEditable( false );
       panelDatosPasajero.add( txtClase );

       // Ubicación
       JLabel etiquetaUbicacion = new JLabel( "Ubicación: " );
       panelDatosPasajero.add( etiquetaUbicacion );

       String sUbicacion;
       if( pSilla.darUbicacion( ) == Ubicacion.CENTRAL )
       {
           sUbicacion = "Centro";
       }
       else if( pSilla.darUbicacion( ) == Ubicacion.PASILLO )
       {
           sUbicacion = "Pasillo";
       }
       else
       {
           sUbicacion = "Ventana";
       }
       txtUbicacion = new JTextField( sUbicacion );
       txtUbicacion.setEditable( false );
       panelDatosPasajero.add( txtUbicacion );
       add( panelDatosPasajero, BorderLayout.CENTER );

       setModal( true );
       setLocationRelativeTo( principal );
       setResizable( false );
   }

}