package juego;


/*                 TRABAJO PRACTICO: ALGORITMO Y PROGRAMACION I
 * 
 * 				    COMISION: Martes y Jueves (6:00 a 10:00 pm)
 * 								
 * 									PROFESORES:
 * 								 Fontdevila Diego
 * 								   Videla Lucas
 * 								  Gonzalez Matias
 * 
 *								    INTEGRANTES:
 * 								  Dos Santo Julian
 * 								  Braconaro Melina
 * 
 * OBJETIVO: Cuatro en Linea es un juego para dos jugadores, en el que se introducen fichas en un tablero 
 * vertical con el objetivo de alinear cuatro fichas consecutivas de un mismo color. 
 * Los jugadores deben introducir una ficha en la columna que prefieran (siempre que no esté completa) y 
 * ésta caerá a la posición más baja. Gana la partida el primero 
 * que consiga alinear cuatro fichas consecutivas de un mismo color en forma horizontal o vertical.
 * 
 * */

public class CuatroEnLinea {

	private String jugadorRojo;
	private String jugadorAmarillo;
	private String turno;
	private String ganador = null;
	
	private Casillero[][] tableroDeJuego;

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero está vacío.
	 * 
	 * @param filas : cantidad de filas que tiene el tablero.
	 * @param columnas : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo : nombre del jugador con fichas amarillas.
	 */
	
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) {
		
		verificarColumnasYFilas(filas, columnas);

		this.jugadorRojo = jugadorRojo;
		this.jugadorAmarillo = jugadorAmarillo;
		this.turno = this.jugadorRojo;
		
		verificarNombre();
		completarCasillerosConEspaciosVacios(filas, columnas);
		
	}
	
	private void verificarColumnasYFilas(int filas, int columnas){
		
		if (filas < 4 || columnas < 4) {
			throw new Error("Las filas o columnas deben ser mayores o iguales a 4");
		}
		
	}
	
	private void verificarNombre(){
		
		/* validamos que los nombres ingresados no sean solo espacios */
		if (jugadorAmarillo.trim().isEmpty() || jugadorRojo.trim().isEmpty()) {
			throw new Error("Los nombres de jugadores ingresados son incorrectos");
		}
	}

	private void completarCasillerosConEspaciosVacios(int filas, int columnas){
		
		this.tableroDeJuego = new Casillero[filas][columnas];
		for (int fila = 0; fila < this.tableroDeJuego.length; fila++) {
			for (int columna = 0; columna < this.tableroDeJuego[fila].length; columna++) {
				this.tableroDeJuego[fila][columna] = Casillero.VACIO;
			}
		}
		
	}

	
	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden apilar en el tablero.
	 */
	
	public int contarFilas() {
		
		return this.tableroDeJuego.length;
	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden alinear en el tablero.
	 */
	
	public int contarColumnas() {
		
		return this.tableroDeJuego[0].length;
	}

	/**
	 * pre : fila está en el intervalo [1, contarFilas()],
	 * 		 columnas está en el intervalo [1, contarColumnas()].
	 * post: indica qué ocupa el casillero en la posición dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	
	public Casillero obtenerCasillero(int fila, int columna) {
		
		return this.tableroDeJuego[fila-1][columna-1];
	}
	
	/**
	 * pre : el juego no terminó, columna está en el intervalo [1, contarColumnas()]
	 * 		 y aún queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 */
	
	public void soltarFicha(int columna) {

		verificarSiElJuegoTermino();
		verificarColumnaFueraDeRango(columna);
		verificarSiEncontroVacio(columna);
		encuentraVacioYSueltaFicha(columna);
		
	}
	
	private void verificarSiElJuegoTermino(){
		
		if( this.ganador != null){
			throw new Error("El juego ya ha terminado.");
		}
	}

	private void verificarColumnaFueraDeRango(int columna){
		
		if( columna < 1 || columna > this.contarColumnas() ){
			throw new Error("Columna fuera de rango.");
		}
		
	}
	
	private void verificarSiEncontroVacio(int columna){

		boolean encontroVacio = false;

		for(int i=0; i<this.tableroDeJuego.length; i++){
			if( this.tableroDeJuego[i][columna-1] == Casillero.VACIO ){
				encontroVacio = true;
			}
		}
		if( !encontroVacio ){
			throw new Error("No hay ningún casillero vacío.");
		}

	}

	private void encuentraVacioYSueltaFicha(int columna){
		
		int cantidadVacios = 0;
		for(int i=0; i<this.tableroDeJuego.length; i++){
			if( this.tableroDeJuego[i][columna-1] == Casillero.VACIO ){
				cantidadVacios++;
			}
		}
	
		this.tableroDeJuego[cantidadVacios-1][columna-1] = colorJugadorActual();
		this.turno = NombrejugadorActual();	
	}

	private Casillero colorJugadorActual(){
		
		if (this.turno == this.jugadorRojo){
			return Casillero.ROJO;
		}else{
			return Casillero.AMARILLO;
		}
		
	}
	
	private String NombrejugadorActual(){
		
		if (this.turno == this.jugadorRojo){
			 return this.jugadorAmarillo;
		}else{
			return this.jugadorRojo;
		}
		
	}
		
	/**
	 * post: indica si el juego terminó porque uno de los jugadores
	 * 		 ganó o no existen casilleros vacíos.
	 */
	
	public boolean termino() {
		
		boolean terminoJuego = false;
		
		return verificaTerminoEmpate(terminoJuego) || verificaGanadorFila(terminoJuego) 
				|| verificaGanadorColumna(terminoJuego) || verificaGanadorDiagonal(terminoJuego);
	
	}

	private boolean verificaTerminoEmpate(boolean terminoJuego) {
		
		int contador = 0;
		for(int i=0; i<this.tableroDeJuego.length; i++){
			for(int j=0; j<this.tableroDeJuego[i].length; j++){
				if( this.tableroDeJuego[i][j] != Casillero.VACIO ){
					contador++;
				}
			}
		}
		
		boolean terminoEnEmpate = false;
		if(cantidadDeCasillerosOcupados() == contador){
			
			terminoJuego = terminoEnEmpate;
			terminoEnEmpate = true;
		}
		
		return terminoEnEmpate;
	}

	private int cantidadDeCasillerosOcupados(){
		
		return this.tableroDeJuego.length*this.tableroDeJuego[0].length;
	}
	
	private boolean verificaGanadorFila(boolean terminoJuego) {

		for(int i =0; i<contarFilas() && !terminoJuego; i++ ){
			for(int j =0; j<contarColumnas()-3  && !terminoJuego; j++){
				
				terminoJuego = (this.tableroDeJuego[i][j] != Casillero.VACIO)
						&&(this.tableroDeJuego[i][j] == this.tableroDeJuego[i][j+1]) 
						&& (this.tableroDeJuego [i][j] == this.tableroDeJuego[i][j+2]) 
						&& (this.tableroDeJuego[i][j] == this.tableroDeJuego[i][j+3])
						 ;
				
				participanteGanador(i,j);				
			}
		}
		
		return terminoJuego;
	}

	private boolean verificaGanadorColumna(boolean terminoJuego) {
		
		for(int i =0; i<contarFilas() && !terminoJuego; i++ ){
			for(int j =0; j<contarColumnas()-2  && !terminoJuego; j++){
				
				terminoJuego =  (this.tableroDeJuego[j][i] != Casillero.VACIO)
						&&(this.tableroDeJuego[j][i] == this.tableroDeJuego[j+1][i]) 
						&& (this.tableroDeJuego [j][i] == this.tableroDeJuego[j+2][i]) 
						&& (this.tableroDeJuego[j][i] == this.tableroDeJuego[j+3][i]);
				
				participanteGanador(i,j);	
			}
		}
		return terminoJuego;
	}
		
	
	private boolean verificaGanadorDiagonal(boolean terminoJuego) {

		for(int i =3; i<contarFilas() && !terminoJuego; i++ ){
			for(int j =0; j<contarColumnas()-3  && !terminoJuego; j++ ){

				terminoJuego = (this.tableroDeJuego[i][j] == this.tableroDeJuego[i-1][j+1]) 
						&& (this.tableroDeJuego [i][j] == this.tableroDeJuego[i-2][j+2]) 
						&& (this.tableroDeJuego[i][j] == this.tableroDeJuego[i-3][j+3])
						&& (this.tableroDeJuego[i][j] != Casillero.VACIO) ;

				participanteGanador(i,j);
			}
		}

		for(int i =0; i<contarFilas()-3 && !terminoJuego; i++ ){
			for(int j =0; j<contarColumnas()-3  && !terminoJuego; j++ ){

				terminoJuego = (this.tableroDeJuego[i][j] == this.tableroDeJuego[i+1][j+1]) 
						&& (this.tableroDeJuego [i][j] == this.tableroDeJuego[i+2][j+2]) 
						&& (this.tableroDeJuego[i][j] == this.tableroDeJuego[i+3][j+3])
						&& (this.tableroDeJuego[i][j] != Casillero.VACIO) ;

				participanteGanador(i,j);
			}
		}	
		return terminoJuego;
	}

	private void participanteGanador(int fila, int columna){

		if(tableroDeJuego[fila][columna] == Casillero.ROJO){
			this.ganador = this.jugadorRojo;
		}else{
			this.ganador = this.jugadorAmarillo;
		}

	}

	/**
	 * post: indica si el juego terminó y tiene un ganador.
	 */

	public boolean hayGanador() {
		
		boolean hayGanador = false;
		if( this.ganador != null ){
			hayGanador = true;  
		}
		return hayGanador;
	}
	
	/**
	 * pre : el juego terminó.
	 * post: devuelve el nombre del jugador que ganó el juego.
	 */
	
	public String obtenerGanador() {
		
		if(turno==this.jugadorAmarillo){
			ganador = jugadorRojo;
		}else{
			ganador = jugadorAmarillo;	
		}
		return this.ganador;
	}
}
