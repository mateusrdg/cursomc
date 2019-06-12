package com.mateus.cursomc;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mateus.cursomc.domain.Categoria;
import com.mateus.cursomc.domain.Produto;
import com.mateus.cursomc.repositories.CategoriaRepository;
import com.mateus.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria (null, "Informática") ;
		Categoria c2 = new Categoria (null, "Escritório") ;
		
		Produto p1 = new Produto (null, "Computador", new BigDecimal(4000.00));
		Produto p2 = new Produto (null, "Monitor", new BigDecimal(1000.00));
		Produto p3 = new Produto (null, "Placa de vídeo", new BigDecimal(1500.00));
		
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		
		
		categoriarepository.saveAll(Arrays.asList(c1,c2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
