package main;

/**
 * Clase ByteCode
 * 
 * @author elena
 */
public class ByteCode {
	/**
	 * Atributos
	 */
	private ENUM_BYTECODE name;
	private int param;

	/**
	 * Constructora 1
	 * 
	 * @param bc es un ByteCode
	 */
	public ByteCode(ENUM_BYTECODE bc) {
		this.name = bc;
	}

	/**
	 * Constructora 2
	 * 
	 * @param bc  es un ByteCode
	 * @param num es un parametro
	 */
	public ByteCode(ENUM_BYTECODE bc, int num) {
		this.name = bc;
		this.param = num;
	}

	/**
	 * Metodo que transforma el ByteCode en un tipo String
	 * 
	 * Complejidad = 0(1) ya que no variara en funcion del tamanio del dato
	 * 
	 * @return devuelve el ByteCode transformado a String
	 */
	public String toString() {
		String chain = this.name.toString().toUpperCase() + " " + this.param;
		return chain;
	}

	/**
	 * Metodo que devuelve el nombre del ByteCode
	 * 
	 * Complejidad = 0(1) ya que no variara en funcion del tamanio del dato
	 * 
	 * @return devuelve el nombre del ByteCode
	 */
	public ENUM_BYTECODE getInstruction() {
		return this.name;
	}

	/**
	 * Metodo que devuelve el parametro del ByteCode
	 * 
	 * @return devuelve el parametro del ByteCode
	 */
	public int getparam() {
		return this.param;
	}
}