package practica1;

public class ContenedorDeEnteros {
	
	//Nodos donde se guardan los numeros y la posicion siguiente
	private class Nodo {
		
		int num;
		Nodo next = null;
		
		public Nodo(int num) {
			this.num = num;
		}
	}
	
	//Atributos de la clase ContenedorDeEnteros
	private Nodo first;
	private int size = 0;
	
	//Constructor que inicializa el contenedor vacio
	public ContenedorDeEnteros() {
		first = null;
	}
	
	//Devuelve el tama�o de la coleccion
	public int cardinal() {
		return size;
	}
	
	//Inserta un nuevo elemento e indica si fue posible(true) o no(false)
	public boolean insertar(int num) {
		
		if(first == null) {
			first = new Nodo(num);
			size++;
			return true;
		}
		
		//Variable iteradora que recorre la coleccion por el inicio
		Nodo aux = first;
		Nodo prev = null;
		
		while(aux != null) {
			//Si hay alguno igual, no se inserta(false)
			if(aux.num == num) {
				return false;
			}
			
			//guardo la posicion actual antes de avanzar para poder enlazarlo con la insercion al final
			prev = aux;
			aux = aux.next;
		}
		
		aux = new Nodo(num);
		prev.next = aux;
		size++;
		
		return true;
	}
	
	public boolean extraer(int num) {
		
		if(first == null) {
			return false;
		}
		
		if(first.num == num) {
			first = first.next;
			size--;
			return true;
		}
		
		//Nodo que recorre la coleccion
		Nodo aux = first.next;
		
		//Nodo que guardara la posicion actual antes de avanzar
		Nodo prev = first;
		
		while(aux != null) {
			if(aux.num == num) {
				//El anterior apuntara al siguiente, haciendo que nada apunte al actual(que queremos borrar)
				prev.next = aux.next;
				size--;
				return true;
			}
			//guardo la posicion actual antes de avanzar para poder enlazarlo con la insercion al final
			prev = aux;
			aux = aux.next;
		}
		return false;
	}
	
	public boolean buscar(int num) {
		
		//Nodo que recorre la coleccion
		Nodo aux = first;
		
		while(aux != null) {
			//Si hay alguno igual, se devuelve true
			if(aux.num == num) {
				return true;
			}
			aux = aux.next;
		}
		return false;
	}
	
	public void vaciar() {
		first = null;
		size = 0;
	}
	
	public int[] elementos() {
		
		int [] elements = new int[size];
		
		//Nodo que recorre la coleccion
		Nodo aux = first;
		
		//variable contadora para las posiciones del vector
		int i = 0;
		
		while(aux != null) {
			elements[i] = aux.num;
			aux = aux.next;
			i++;
		}
		
		return elements;
	}
}



