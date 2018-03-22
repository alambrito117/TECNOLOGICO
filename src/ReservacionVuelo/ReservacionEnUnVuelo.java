// ELABOR�: RUBI MARICELA CIAU HU IV SEMESTRE GRUPO A
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
        setTitle( "El Avi�n" );
        setSize( 635, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Crea al avi�n
        avion = new AVION( );

        // Configura la interfaz
        setLayout( new BorderLayout( ) );

       
        // Panel del avi�n
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
        // Pregunta el n�mero de c�dula

        String cedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula", "Eliminar pasajero", JOptionPane.QUESTION_MESSAGE );
        if( cedula != null && !cedula.isEmpty( ) )
        {
            PASAJEROS pasajero = new PASAJEROS( cedula, "no importa" );
            if( !avion.desasignarSilla( pasajero ) )
            {
                JOptionPane.showMessageDialog( this, "El pasajero no ten�a silla asignada", "Eliminar pasajero", JOptionPane.ERROR_MESSAGE );
            }
            JOptionPane.showMessageDialog( this, "Error en el n�mero de c�dula.", "Eliminar pasajero", JOptionPane.ERROR_MESSAGE );
        }

        actualizar( );
    }

    
    public void mostrarPorcentajeOcupacion( )
    {
        double porcentaje;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );
        JOptionPane.showMessageDialog( this, "El porcentaje de ocupaci�n es " + df.format( porcentaje ) + "%", "Ocupaci�n del avi�n", JOptionPane.INFORMATION_MESSAGE );
    }

   
    public void buscarPasajero( )
    {
        // Pregunta el n�mero de c�dula
        String cedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula", "Buscar pasajero", JOptionPane.QUESTION_MESSAGE );
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

        // Panel del avi�n
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














