package juego;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuatroEnLineaTest {

	

	@Test
	public void IniciarPartidaValida() {

		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Red", "Yellow");

		assertEquals(4, juego.contarFilas());
		assertEquals(4, juego.contarColumnas());
	}
	
	@Test
	public void probarTablero10x10() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Red", "Yellow");
		assertNotNull(juego);
	}
	
	@Test
	public void probarTablero100x100() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Red", "Yellow");
		assertNotNull(juego);
	}
	
	@Test
	public void probarTablero1000x1000() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Red", "Yellow");
		assertNotNull(juego);
	}

	@Test
	public void probarTableroNoCuadrado() {
	
		//se comprueba si la cantidad de filas puede ser distintos al numero de columnas
		CuatroEnLinea juego = new CuatroEnLinea(20, 8, "blue", "red");
		assertNotNull(juego);
	}

	//_____________________________________________________________________________________________________________
	
	@Test(expected = Error.class)
	public void IniciarPartidaInvalidaFilaIncorrecta() {

		//se espera que el test falle, ya que, la cantidad de filas es menor a cuatro
		new CuatroEnLinea(2, 4, "Red", "Yellow");
	}

	@Test(expected = Error.class)
	public void IniciarPartidaInvalidaFilaNegativa() {

		//se espera que el test falle, ya que, la cantidad de filas es negativa
		new CuatroEnLinea(-9, 4, "Red", "Yellow");
	}
	
	@Test(expected = Error.class)
	public void IniciarPartidaInvalidaColumnaIncorrecta() {

		//se espera que el test falle, ya que, la cantidad de columnas es menor a cuatro
		new CuatroEnLinea(5,1, "Red", "Yellow");
	}	
	
	@Test(expected = Error.class)
	public void IniciarPartidaInvalidaColumnaNegativa() {

		//se espera que el test falle, ya que, la cantidad de columnas es negativa
		new CuatroEnLinea(10, -10, "Red", "Yellow");
	}
	
	@Test(expected = Error.class)
	public void IniciarPartidaInvalidaColumnaYFilaIncorrecta() {

		//se espera que el test falle, ya que, la cantidad de columnas y columnas es menor a cuatro
		new CuatroEnLinea(2,1, "Red", "Yellow");
	}	

	//____________________________________________________________________________________________________________
	
	@Test(expected = Error.class)
	public void pruebaPrimerJugadorVacio() {
		
		//se espera que el test falle, ya que, el nombre del primer jugador contiene solo espacios vacios
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, " ", "Yellow");
		assertNotNull(juego);
	}
	
	@Test(expected = Error.class)
	public void pruebaSegundoJugadorVacio() {
		
		//se espera que el test falle, ya que, el nombre del segundo jugador contiene solo espacios vacios
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red ", "  ");
		assertNotNull(juego);
	}
	
	@Test(expected = Error.class)
	public void ambosJugadoresVacios() {
		
		//se espera que el test falle, ya que, el nombre del ambos jugadores contiene solo espacios vacios
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, " ", " ");
		assertNotNull(juego);
	}

	//___________________________________________________________________________________________________________
	
	@Test
	public void contarFilas() {
	
		CuatroEnLinea juego = new CuatroEnLinea(10, 8, "blue", "red");
		juego.contarFilas();
		assertEquals(10, juego.contarFilas());
	}

	@Test
	public void contarFilasCantidadAlta() {
	
		CuatroEnLinea juego = new CuatroEnLinea(1000, 8, "blue", "red");
		juego.contarFilas();
		assertEquals(1000, juego.contarFilas());
	}

	@Test(expected = Error.class)
	public void contarFilaNegativa() {

		//se espera que el test falle, ya que, la cantidad de filas es negativa
		new CuatroEnLinea(-23, 4, "pink", "Yellow");
	}

	@Test
	public void contarColumna() {
	
		CuatroEnLinea juego = new CuatroEnLinea(10, 8, "blue", "red");
		juego.contarFilas();
		assertEquals(8, juego.contarColumnas());
	}

	@Test
	public void contarColumnaCantidadAlta() {
	
		CuatroEnLinea juego = new CuatroEnLinea(15, 2000, "black", "blue");
		juego.contarFilas();
		assertEquals(2000, juego.contarColumnas());
	}

	@Test(expected = Error.class)
	public void contarColumnaNegativa() {

		//se espera que el test falle, ya que, la cantidad de columnas es negativa
		new CuatroEnLinea(15, -4, "black", "Yellow");
	}

	//____________________________________________________________________________________________________________
	
	@Test
	public void SoltarFichasJuegoTerminoPorEmpate() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "blue", "red");
	
		juego.soltarFicha(1);// Jugador uno suleta ficha en primer columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercer columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primer columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna

		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primer columna
		juego.soltarFicha(4);// Jugador uno suleta ficha en cuarta columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercer columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primer columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercer columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		
		assertTrue(juego.termino());
	}

	@Test (expected = Error.class)
	public void soltarFichaEnCasilleroOcupado(){
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "blue", "red");
		
		juego.soltarFicha(1);// Jugador uno suleta ficha en primer columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercer columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primer columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en la segunda columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna

		juego.soltarFicha(2);// Jugador uno suleta ficha en la segunda columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primer columna
		juego.soltarFicha(4);// Jugador uno suleta ficha en cuarta columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercer columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primer columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercer columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en la segunda columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primer columna YA OCUPADA.

	}

	@Test
	public void SoltarFichasJuegoNoTermino() {
		
		//juego no termino, ya que, no hay ganador y el tablero no se encuentra completo
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "blue", "red");
	
		juego.soltarFicha(1);// Jugador 1
		juego.soltarFicha(3);// Jugador 2
		juego.soltarFicha(2);// Jugador 1
		juego.soltarFicha(4);// Jugador 2

		juego.soltarFicha(1);// Jugador 1
		juego.soltarFicha(2);// Jugador 2
		juego.soltarFicha(3);// Jugador 1
	
		assertFalse(juego.termino());
	}

	@Test(expected = Error.class)
	public void SoltarFichasCuandoElJuegoYaTermino() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "blue", "red");
		
		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercera columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercera columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna

		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna
		juego.soltarFicha(4);// Jugador uno suleta ficha en cuarta columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercera columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercera columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna, pero el tablero ya se encuentra completo
		
	}

	@Test (expected = Error.class)
	public void soltarFichaConColumnaNegativa() {

		CuatroEnLinea partida = new CuatroEnLinea(4, 4, "Red", "Yellow");
		
		partida.soltarFicha(1);
		partida.soltarFicha(1);
		partida.soltarFicha(3);
		partida.soltarFicha(2);
		partida.soltarFicha(4);
		partida.soltarFicha(-2);

	}

	@Test (expected = Error.class)
	public void solatarFichaConColumnaMayorAlRango() {

		CuatroEnLinea partida = new CuatroEnLinea(4, 4, "Red", "Yellow");
		
		partida.soltarFicha(1);
		partida.soltarFicha(1);
		partida.soltarFicha(3);
		partida.soltarFicha(2);
		partida.soltarFicha(4);
		partida.soltarFicha(5);
	}
	
	//_____________________________________________________________________________________________________________
	
	@Test
	public void juegoTerminoGanadorJugador1CompletoFila() {
		
		//juego  finalizado. Ganador jugador 1 (pink), completo cuatros fichas consecutivas en la ultima fila
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "pink", "orange");
	
		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna

		juego.soltarFicha(3);// Jugador uno suleta ficha en tercera columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna
		juego.soltarFicha(4);// Jugador uno suleta ficha en cuarta columna
	
		assertTrue(juego.termino());
	}

	@Test
	public void juegoTerminoGanadorJugador2CompletoFila() {
		
		//juego  finalizado. Ganador jugador 2 ("blue"), completo cuatros fichas consecutivas en la ante ultima fila
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "pink", "blue");
	
		juego.soltarFicha(4);// Jugador uno suleta ficha en cuarta columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercera columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en segunda columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna
		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercera columna
		
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		
		assertTrue(juego.termino());
	}
	
	@Test
	public void juegoTerminoGanadorJugador1CompletoColumna() {
		
		//juego finalizado. Ganador jugador 1 ("red"), completo cuatros fichas consecutivas en la columna 3
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "orange");
	
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primer columna

		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
	
		assertTrue(juego.termino());
	}

	@Test
	public void juegoTerminoGanadorJugador2CompletoColumna() {
		
		//juego finalizado. Ganador jugador 2 ("black"), completo cuatros fichas consecutivas en la columna 4
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
	
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(1);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en primer columna

		juego.soltarFicha(2);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		
		assertTrue(juego.termino());
	}
	
	@Test
	public void juegoTerminoGanadorDiagonalDescendente(){
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "orange");
		
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(1); // Jugador dos
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(1); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(2); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(2); // Jugador uno
		juego.soltarFicha(3); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(4); // Jugador dos

		assertTrue(juego.termino());
	}
	
	@Test
	public void juegoTerminoGanadorDiagonalAscendente(){
			
			CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "orange");
			
			juego.soltarFicha(1); // Jugador uno
			juego.soltarFicha(1); // Jugador dos
			juego.soltarFicha(1); // Jugador uno
			juego.soltarFicha(2); // Jugador dos
			juego.soltarFicha(2); // Jugador uno
			juego.soltarFicha(3); // Jugador dos
			juego.soltarFicha(1); // Jugador uno
			juego.soltarFicha(3); // Jugador dos
			juego.soltarFicha(3); // Jugador uno
			juego.soltarFicha(4); // Jugador dos
			juego.soltarFicha(4); // Jugador uno
			juego.soltarFicha(4); // Jugador dos
			juego.soltarFicha(4); // Jugador dos
			
			assertTrue(juego.termino());
		
	}
	
	//_____________________________________________________________________________________________________________
	
	//_____________________________________________________________________________________________________________
	
	@Test
	public void corroborarGanadorHorizontalJugador1(){
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
		
		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna

		juego.soltarFicha(3);// Jugador uno suleta ficha en tercera columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna
		juego.soltarFicha(4);// Jugador uno suleta ficha en cuarta columna
		
		juego.termino();
		assertTrue(juego.hayGanador());
	}
	
	@Test
	public void corroborarGanadorHorizontalJugador2(){
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
		
		juego.soltarFicha(4);// Jugador uno suleta ficha en cuarta columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercera columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en segunda columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna
		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercera columna
		
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		
		juego.termino();
		assertTrue(juego.hayGanador());
	}
	
	@Test
	public void corroborarGanadorVerticalJugador1() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "orange");
	
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primer columna

		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
	
		juego.termino();
		assertTrue(juego.hayGanador());
	}
	
	@Test
	public void corroborarGanadorVerticalJugador2() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
	
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(1);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en primer columna

		juego.soltarFicha(2);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		
		juego.termino();
		assertTrue(juego.hayGanador());
	}

	
	
	@Test
	public void corroborarGanadorDiagonal(){
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "orange");
		
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(1); // Jugador dos
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(1); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(2); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(2); // Jugador uno
		juego.soltarFicha(3); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(4); // Jugador dos

		juego.termino();
		assertTrue(juego.hayGanador());
	}

	@Test
	public void corroborarGanadorDiagonalDescendente() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
	
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(1); // Jugador dos
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(1); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(2); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(2); // Jugador uno
		juego.soltarFicha(3); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(4); // Jugador dos
		
		juego.termino();
		assertTrue(juego.hayGanador());
	}

	@Test
	public void corroborarGanadorDiagonalAscendente() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
	
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(1); // Jugador dos
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(2); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(3); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(4); // Jugador dos
		juego.soltarFicha(4); // Jugador uno
		juego.soltarFicha(4); // Jugador dos
		juego.soltarFicha(4); // Jugador dos
		
		juego.termino();
		assertTrue(juego.hayGanador());
	}

	@Test
	public void noHayGanador(){
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
		
		juego.soltarFicha(1);// Jugador uno suleta ficha en primer columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercer columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primer columna
		juego.soltarFicha(2);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna

		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primer columna
		juego.soltarFicha(4);// Jugador uno suleta ficha en cuarta columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercer columna

		juego.soltarFicha(1);// Jugador uno suleta ficha en primer columna
		juego.soltarFicha(3);// Jugador dos suleta ficha en tercer columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		
		assertFalse(juego.hayGanador() );
		
	}

	
	//_____________________________________________________________________________________________________________
	
	@Test
	public void obtenerNombreDelJugadorGanador1(){
	
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
		
		juego.soltarFicha(1);// Jugador uno suleta ficha en primera columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna
		juego.soltarFicha(2);// Jugador uno suleta ficha en segunda columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna

		juego.soltarFicha(3);// Jugador uno suleta ficha en tercera columna
		juego.soltarFicha(1);// Jugador dos suleta ficha en primera columna
		juego.soltarFicha(4);// Jugador uno suleta ficha en cuarta columna
		
		juego.termino();
		assertEquals("red" ,juego.obtenerGanador());
	}
	
	@Test
	public void obtenerNombreDelJugadorGanador2(){
	
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
		
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en segunda columna
		juego.soltarFicha(1);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en primer columna

		juego.soltarFicha(2);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
		juego.soltarFicha(3);// Jugador uno suleta ficha en tercer columna
		juego.soltarFicha(4);// Jugador dos suleta ficha en cuarta columna
	
		juego.termino();
		assertEquals("black" ,juego.obtenerGanador());
	}
	
	@Test
	public void obtenerNombreGanadorDiagonalJugador1() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
	
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(1); // Jugador dos
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(2); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(3); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(4); // Jugador dos
		juego.soltarFicha(4); // Jugador uno
		juego.soltarFicha(4); // Jugador dos
		juego.soltarFicha(4); // Jugador dos
		
		juego.termino();
		assertEquals("red",juego.obtenerGanador());
	}

	@Test
	public void obtenerNombreGanadorDiagonalJugador2() {
		
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "red", "black");
	
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(1); // Jugador dos
		juego.soltarFicha(1); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(2); // Jugador uno
		juego.soltarFicha(2); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(3); // Jugador dos
		juego.soltarFicha(3); // Jugador uno
		juego.soltarFicha(4); // Jugador dos
		juego.soltarFicha(4); // Jugador uno
		juego.soltarFicha(4); // Jugador dos
		juego.soltarFicha(4); // Jugador dos
		
		juego.termino();
		assertEquals("red",juego.obtenerGanador());
	}
	
	
}
