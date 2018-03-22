// ELABORÓ: RUBI MARICELA CIAU HU IV SEMESTRE GRUPO A
package ReservacionVuelo;

import java.awt.*;
import java.text.*;

import javax.swing.*;


public class ReservacionEnUnVuelo extends JFrame
{

    private AVION avion;
    private PanelAvion panelAvion;
    private panelBotonesAvion PanelBotones;
    private Asisgnacion dAsignacion;

   
    public ReservacionEnUnVuelo( )
    {
        setTitle( "El Avión" );
        setSize( 635, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Crea al avión
        avion = new AVION( );

        // Configura la interfaz
        setLayout( new BorderLayout( ) );

       
        // Panel del avión
        panelAvion = new PanelAvion(avion );
        add( panelAvion, BorderLayout.CENTER );

        // Panel de botones
        PanelBotones = new panelBotonesAvion( this );
        add( PanelBotones, BorderLayout.NORTH );

        setResizable( false );
        setLocationRelativeTo( null );
    }

    
    public void registrarPasajero( )
    {
        dAsignacion = new Asisgnacion( this, avion );
        dAsignacion.setVisible( true );
        actualizar( );
    }

   
    public void eliminarPasajero( )
    {
        // Pregunta el número de cédula

        String cedula = JOptionPane.showInputDialog( this, "Ingrese el número de cédula", "Eliminar pasajero", JOptionPane.QUESTION_MESSAGE );
        if( cedula != null && !cedula.isEmpty( ) )
        {
            PASAJEROS pasajero = new PASAJEROS( cedula, "no importa" );
            if( !avion.desasignarSilla( pasajero ) )
            {
                JOptionPane.showMessageDialog( this, "El pasajero no tenía silla asignada", "Eliminar pasajero", JOptionPane.ERROR_MESSAGE );
            }
            JOptionPane.showMessageDialog( this, "Error en el número de cédula.", "Eliminar pasajero", JOptionPane.ERROR_MESSAGE );
        }

        actualizar( );
    }

    
    public void mostrarPorcentajeOcupacion( )
    {
        double porcentaje;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );
        JOptionPane.showMessageDialog( this, "El porcentaje de ocupación es " + df.format( porcentaje ) + "%", "Ocupación del avión", JOptionPane.INFORMATION_MESSAGE );
    }

   
    public void buscarPasajero( )
    {
        // Pregunta el número de cédula
        String cedula = JOptionPane.showInputDialog( this, "Ingrese el número de cédula", "Buscar pasajero", JOptionPane.QUESTION_MESSAGE );
        if( cedula != null && !cedula.isEmpty( ) )
        {
            PASAJEROS pasajero = new PASAJEROS( cedula, "no importa" );

            SILLAS silla = avion.buscarPasajero( pasajero );

            if( silla != null )
            {
                DatosPasajero vDatos = new DatosPasajero( this, silla );
                vDatos.setVisible( true );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El pasajero no se encuentra registrado", "Buscar pasajero", JOptionPane.INFORMATION_MESSAGE );
            }

        }
    }

    
    public void actualizar( )
    {
        remove( panelAvion );

        // Panel del avión
        panelAvion = new PanelAvion( avion );
        add( panelAvion, BorderLayout.CENTER );
        validate( );
    }

   
    public void reqFuncOpcion1( )
    {
        String respuesta = avion.metodo1( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    public void reqFuncOpcion2( )
    {
        String respuesta = avion.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }
  
    
    public static void main( String[] pArgs )
    {
        
            ReservacionEnUnVuelo interfaz = new ReservacionEnUnVuelo( );
            interfaz.setVisible( true );
        
    }
}














