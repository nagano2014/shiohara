package test;

public interface IDao<T> {
	public int insert(T entity);
	public T select(int key);
}