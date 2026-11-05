package dominio.designPatterns.observable;
import java.util.ArrayList;

public class Observavel<T> {

	ArrayList<Observador<T>> observadores = new ArrayList<Observador<T>>();
	
	public void inscrever(Observador<T> observador) {
		this.observadores.add(observador);
	}
	
	public void desinscrever(Observador<T> observador) {
		this.observadores.remove(observador);
	}
	
	protected void notificarObservadores(T evento) {
		for (Observador<T> observador: observadores) {
			observador.reagir(evento);
		}
	}
}