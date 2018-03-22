package ReservacionVuelo;


public class SILLAS {

	    public enum Clase {
	      
	        EJECUTIVA,

	        
	        ECONOMICA
	    }

	   
	    public enum Ubicacion {
	       
	        VENTANA,

	        CENTRAL,

	        PASILLO
	    }

	   
	    private int numero;
	    private Clase clase;
	    private Ubicacion ubicacion;
	    private PASAJEROS pasajero;

	   	    public SILLAS( int pNumero, Clase pClase, Ubicacion pUbicacion )
	    {
	        numero = pNumero;
	        clase = pClase;
	        ubicacion = pUbicacion;
	        // Inicialmente no hay ningún pasajero en la silla
	        pasajero = null;
	    }

	    
	    public void asignarAPasajero( PASAJEROS pPasajero )
	    {
	        pasajero = pPasajero;
	    }

	    public void desasignarSilla( )
	    {
	        pasajero = null;
	    }

	    public boolean sillaAsignada( )
	    {
	        boolean asignada = true;
	        if( null == pasajero )
	        {
	            asignada = false;
	        }
	        return asignada;
	    }

	    public boolean sillaAsignadaPasajero( PASAJEROS pPasajero )
	    {
	        boolean asignadaPasajero = true;
	        if( null == pasajero )
	        {
	            asignadaPasajero = false;
	        }
	        else if( pasajero.igualA( pPasajero ) )
	        {
	            asignadaPasajero = true;
	        }

	        return asignadaPasajero;
	    }

	    public int darNumero( )
	    {
	        return numero;
	    }

	    public Clase darClase( )
	    {
	        return clase;
	    }

	    public Ubicacion darUbicacion( )
	    {
	        return ubicacion;
	    }

	  
	    public PASAJEROS darPasajero( )
	    {
	        return pasajero;
	    }
	}