package com.faculdadedelta.repository;

import org.springframework.data.repository.CrudRepository;

import com.faculdadedelta.model.Fornecedor;

public interface FornecedorRepository extends CrudRepository<Fornecedor, String>{
	Fornecedor findById (int id);
}
