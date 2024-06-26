package main;

/**
 * Clase ByteCodeProgram
 * 
 * @author elena
 */

public class ByteCodeProgram {
	/**
	 * Atributos
	 */
	private ByteCode[] program;
	private int num_elements;
	private int size;
	// pluggling para cambiar el color del texto
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\033[0m";

	/**
	 * Constructora
	 */
	public ByteCodeProgram() {
		this.program = new ByteCode[this.size];
		this.num_elements = 0;
		this.size = 10;
	}

	/**
	 * Metodo que inicializa el programa, es decir, va ejecutando los ByteCode
	 * 
	 * Complejidad = 0(n) donde n es el numero de elementos que hay en el programa
	 * 
	 * @param cpu es el objeto de la clase CPU, necesario para poder ejecutar el
	 *            programa y para saber el estado de la maquina
	 * @return devuelve una cadena de String detallando todo el proceso de ejecucion
	 *         del programa
	 */
	public String runProgram(CPU cpu) {
		String mensaje = "";
		for (int i = 0; i < this.num_elements; i++) {
			if (!cpu.isHalt() && cpu.execute(this.program[i])) {
				mensaje += "El estado de la máquina tras la ejecición de: " + this.program[i].getInstruction() + " "
						+ this.program[i].getparam() + " es: " + "\n " + cpu.toString() + "\n";

			} else if (!cpu.isHalt()) {
				mensaje += ANSI_RED + "\n Eror: Ejecución incorrecta del comando" + ANSI_RESET;

			}
		}
		cpu.erase();
		cpu.runCPU();
		return mensaje;

	}

	/**
	 * Metodo que aniade al programa nuevas instruciones de tipo ByteCode
	 * 
	 * Complejidad = 0(1) ya que no variara en funcion del tamanio del dato
	 * 
	 * @param enum_BYTECODE es el ByteCode que se va a aniadir al programa
	 */
	public void setInstruction(ByteCode enum_BYTECODE) {
		if (this.num_elements >= this.program.length) {
			this.resize();
			this.program[this.num_elements] = enum_BYTECODE;
			this.num_elements++;
		} else {
			this.program[this.num_elements] = enum_BYTECODE;
			this.num_elements++;
		}
	}

	/**
	 * Metodo que aniade al programa un nuevo ByteCode en una posicion especifica
	 * 
	 * Complejidad = 0(1) ya que no variara en funcion del tamanio del dato
	 * 
	 * @param bc  es el ByteCode que se va a aniadir al programa
	 * @param pos es la posicion en la que se va a escribir el ByteCode
	 * @return devuelve true si se ha podido aniadir correctamente en el programa,
	 *         de lo contrario, devuelve false
	 */
	public boolean setInstructionPosition(ByteCode bc, int pos) {
		if (pos >= 0) {
			if (pos >= this.program.length) {
				this.resize();
				this.program[pos] = bc;
				return true;
			} else {
				this.program[pos] = bc;
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Metodo que convierte el programa de tipo ByteCode a un String
	 * 
	 * Complejidad = 0(n) donde n es el tamanio del array programa
	 * 
	 * @return devuelve el programa convertido a tipo String
	 */
	public String toString() {
		String chain = "Programa almacenado: \n";
		for (int i = 0; i < this.num_elements; i++) {
			chain += i + " : " + this.program[i].getInstruction() + " " + this.program[i].getparam() + "\n";
		}
		return chain;
	}

	/**
	 * Metodo que va aumentando el tamaño de nuestro programa
	 * 
	 * Complejidad: 0(n) donde n es el tamanio del array program
	 * 
	 * @param pos Es la posicion a la que se quiere llegar en el programa
	 */
	private void resize() {
		ByteCode[] program2 = new ByteCode[this.size * 2];
		for (int i = 0; i < this.program.length; i++) {
			program2[i] = this.program[i];
		}
		this.program = program2;
	}

	/**
	 * Metodo que devuelve el ultimo ByteCode del programa
	 * 
	 * Complejidad = 0(1) ya que no variara en funcion del tamanio del dato
	 * 
	 * @return retorna la ultima instruccion del programa
	 */
	public ByteCode getInstruction() {
		return this.program[this.num_elements];
	}

	/**
	 * Metodo que devuelve el ByteCode en la posicion pos del programa
	 * 
	 * Complejidad = 0(1) ya que no variara en funcion del tamanio del dato
	 * 
	 * @param pos es la posicion en la que se desea saber que ByteCode hay
	 * @return devuelve el ByteCode en la posicion indicada
	 */
	public ByteCode getInstructionPosition(int pos) {
		return this.program[pos];
	}

	/**
	 * Metodo que resetea nuestro programa, es decir, vacia el programa y pone a 0
	 * el numero de elementos
	 * 
	 * Complejidad = 0(1) ya que no variara en funcion del tamanio del dato
	 */
	public void reset() {
		this.program = new ByteCode[this.size];
		this.num_elements = 0;
	}

	/**
	 * Metodo que nos indica el tamanio del array de program
	 * 
	 * @return devuelve el tamanio del array program
	 */
	public int programSize() {
		return this.program.length;
	}
}