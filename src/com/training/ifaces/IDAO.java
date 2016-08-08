package com.training.ifaces;

import java.util.Collection;

public interface IDAO<T> {

  public int add(T object);

  public T find(int ID);
  
  public int delete(int ID);

  public Collection<T> findAll();

}
