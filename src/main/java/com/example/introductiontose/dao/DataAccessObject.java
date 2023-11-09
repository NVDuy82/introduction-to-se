package com.example.introductiontose.dao;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface DataAccessObject<T, K> {
    List<T> getAll();
    Optional<T> get(K id);
    void save(@NotNull T t);
    void update(@NotNull T t);
    void delete(@NotNull T t);
}
