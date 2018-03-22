package ReservacionVuelo;


public class PASAJEROS {

    private String cedula;
    private String nombre;

   
    public PASAJEROS( String pCedula, String pNombre )
    {
        cedula = pCedula;
        nombre = pNombre;
    }

   
    public String darCedula( )
    {
        return cedula;
    }

    public String darNombre( )
    {
        return nombre;
    }

    public boolean igualA( PASAJEROS pOtroPasajero )
    {
        boolean esIgual = false;
        if( cedula.equals( pOtroPasajero.darCedula( ) ) )
        {
            esIgual = true;
        }

        return esIgual;
    }
}
