package jogador.persistencia;


public interface IDAO <T> {
	
	public void save(T object);
	
	public T find(int id);
	
	public void delete(T object);
	
}
