package ReservacionVuelo;

import ReservacionVuelo.PASAJEROS;
import ReservacionVuelo.SILLAS;
import ReservacionVuelo.SILLAS.Clase;
import ReservacionVuelo.SILLAS.Ubicacion;

public class AVION {

	   public final static int SILLAS_EJECUTIVAS = 8;
	   public final static int SILLAS_ECONOMICAS = 42;

	   private SILLAS[] sillasEjecutivas;
	   private SILLAS[] sillasEconomicas;

	  
	   public AVION( )
	   {
	       Ubicacion ubicacion;

	       // Crea las sillas ejecutivas
	       sillasEjecutivas = new SILLAS[SILLAS_EJECUTIVAS];

	       // Crea las sillas económicas
	       sillasEconomicas = new SILLAS[SILLAS_ECONOMICAS];

	       sillasEjecutivas[ 0 ] = new SILLAS( 1, Clase.EJECUTIVA, Ubicacion.VENTANA );
	       sillasEjecutivas[ 1 ] = new SILLAS( 2, Clase.EJECUTIVA, Ubicacion.PASILLO );
	       sillasEjecutivas[ 2 ] = new SILLAS( 3, Clase.EJECUTIVA, Ubicacion.PASILLO );
	       sillasEjecutivas[ 3 ] = new SILLAS( 4, Clase.EJECUTIVA, Ubicacion.VENTANA );
	       sillasEjecutivas[ 4 ] = new SILLAS( 5, Clase.EJECUTIVA, Ubicacion.VENTANA );
	       sillasEjecutivas[ 5 ] = new SILLAS( 6, Clase.EJECUTIVA, Ubicacion.PASILLO );
	       sillasEjecutivas[ 6 ] = new SILLAS( 7, Clase.EJECUTIVA, Ubicacion.PASILLO );
	       sillasEjecutivas[ 7 ] = new SILLAS( 8, Clase.EJECUTIVA, Ubicacion.VENTANA );

	       for( int numSilla = 1 + SILLAS_EJECUTIVAS, j = 1; j <= SILLAS_ECONOMICAS; numSilla++, j++ )
	       {
	           // Sillas ventana
	           if( j % 6 == 1 || j % 6 == 0 )
	               ubicacion = Ubicacion.VENTANA;
	           // Sillas centrales
	           else if( j % 6 == 2 || j % 6 == 5 )
	               ubicacion = Ubicacion.CENTRAL;
	           // Sillas pasillo
	           else
	               ubicacion = Ubicacion.PASILLO;

	           sillasEconomicas[ j - 1 ] = new SILLAS( numSilla, Clase.ECONOMICA, ubicacion );
	       }
	   }

	  
	   public SILLAS asignarSilla( Clase pClase, Ubicacion pUbicacion, PASAJEROS pPasajero )
	   {
	       // busca una silla libre
		   SILLAS silla = null;
	       if( pClase == Clase.EJECUTIVA )
	       {
	           silla = buscarSillaEjecutivaLibre( pUbicacion );
	       }
	       else if( pClase == Clase.ECONOMICA )
	       {
	           silla = buscarSillaEconomicaLibre( pUbicacion );
	       }
	       if( silla != null )
	       {
	           silla.asignarAPasajero( pPasajero );
	       }
	       return silla;
	   }

	  
	   public SILLAS buscarSillaEjecutivaLibre( Ubicacion pUbicacion )
	   {
	       boolean encontrado = false;
	       SILLAS silla = null;
	       for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
	       {
	           silla = sillasEjecutivas[ i ];
	           if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == pUbicacion )
	           {
	               encontrado = true;
	           }
	       }
	       if( !encontrado )
	       {
	           silla = null;
	       }
	       return silla;
	   }

	   
	   public SILLAS buscarSillaEconomicaLibre( Ubicacion pUbicacion )
	   {
	       boolean encontrado = false;
	       SILLAS silla = null;
	       for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
	       {
	           silla = sillasEconomicas[ i ];
	           if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == pUbicacion )
	           {
	               encontrado = true;
	           }
	       }
	       if( !encontrado )
	       {
	           silla = null;
	       }
	       return silla;
	   }

	  
	   public SILLAS buscarPasajero( PASAJEROS pPasajero )
	   {
	       // Busca el pasajero en ejecutiva
		   SILLAS silla = buscarPasajeroEjecutivo( pPasajero );
	       // Si no estaba en ejecutiva
	       if( null == silla )
	       {
	           // Busca en económica
	           silla = buscarPasajeroEconomico( pPasajero );
	       }

	       return silla;

	   }

	  
	   public SILLAS buscarPasajeroEjecutivo( PASAJEROS pPasajero )
	   {
	       boolean encontrado = false;
	       SILLAS silla = null;
	       for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
	       {
	           silla = sillasEjecutivas[ i ];
	           if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pPasajero ) )
	           {
	               encontrado = true;
	           }
	       }
	       if( !encontrado )
	       {
	           silla = null;
	       }
	       return silla;
	   }

	  
	   public SILLAS buscarPasajeroEconomico( PASAJEROS pPasajero )
	   {
	       boolean encontrado = false;
	       SILLAS silla = null;
	       for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
	       {
	           silla = sillasEconomicas[ i ];
	           if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pPasajero ) )
	           {
	               encontrado = true;
	           }
	       }
	       if( !encontrado )
	       {
	           silla = null;
	       }
	       return silla;
	   }

	   public boolean desasignarSilla( PASAJEROS pPasajero )
	   {
	       // Busca el pasajero en el avión
		   SILLAS silla = buscarPasajero( pPasajero );
	       boolean resultado = false;
	       // Si lo encuentra desasigna
	       if( silla != null )
	       {
	           silla.desasignarSilla( );
	           resultado = true;
	       }
	       return resultado;
	   }

	  
	   public int contarSillasEjecutivasOcupadas( )
	   {
	       int contador = 0;
	       for( SILLAS sillaEjecutiva : sillasEjecutivas )
	       {
	           if( sillaEjecutiva.sillaAsignada( ) )
	           {
	               contador++;
	           }
	       }
	       return contador;
	   }

	 
	   public int contarSillasEconomicasOcupadas( )
	   {
	       int contador = 0;
	       for( SILLAS sillaEconomica : sillasEconomicas )
	       {
	           if( sillaEconomica.sillaAsignada( ) )
	           {
	               contador++;
	           }
	       }
	       return contador;
	   }

	   public double calcularPorcentajeOcupacion( )
	   {
	       double porcentaje;
	       int totalSillas = SILLAS_ECONOMICAS + SILLAS_EJECUTIVAS;
	       int sillasOcupadas = contarSillasEconomicasOcupadas( ) + contarSillasEjecutivasOcupadas( );
	       porcentaje = ( double )sillasOcupadas / totalSillas * 100;
	       return porcentaje;
	   }

	   public SILLAS[] obtenerSillasEjecutivas( )
	   {
	       return sillasEjecutivas;
	   }

	  
	   public SILLAS[] obtenerSillasEconomicas( )
	   {
	       return sillasEconomicas;
	   }

	 
	   public String metodo1( )
	   {
	       return "Respuesta 1";
	   }

	  
	   public String metodo2( )
	   {
	       return "Respuesta 2";
	   }

	}