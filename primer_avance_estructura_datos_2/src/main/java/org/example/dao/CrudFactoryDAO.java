package org.example.dao;

import org.example.model.BaseModel;
import java.util.List;

public abstract class CrudFactoryDAO<T extends BaseModel> {

    public abstract void crear(T model);

    public abstract void modificar(T model);

    public abstract void eliminar(T model);

    public abstract List<T> seleccionarTodos();

    public abstract T seleccionarPorId(int id);
}