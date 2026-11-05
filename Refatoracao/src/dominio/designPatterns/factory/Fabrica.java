package dominio.designPatterns.factory;


//Design Pattern Factory - Responsável por criar objetos complexos encapsulando a regra de negócio
public abstract class Fabrica<T> implements FabricaInterface<T>{

	
	//Função responsável por preparar antes de fabricar, quando necessário e retorna estado Booleano da preparacao
	protected Boolean preparar() {
		return null;
	}
	
	
	//Função que fabrica o objeto
	public T fabricar() {
		return null;
	}
}