package dominio.designPatterns.factory;


//Contrato de Factory - Fabrica
public interface FabricaInterface<T> {
	T fabricar();
}
