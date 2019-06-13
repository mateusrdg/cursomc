package com.mateus.cursomc;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mateus.cursomc.domain.Categoria;
import com.mateus.cursomc.domain.Cidade;
import com.mateus.cursomc.domain.Estado;
import com.mateus.cursomc.domain.Produto;
import com.mateus.cursomc.repositories.CategoriaRepository;
import com.mateus.cursomc.repositories.CidadeRepository;
import com.mateus.cursomc.repositories.EstadoRepository;
import com.mateus.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
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
		
		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		
		Cidade cid1 = new Cidade (null, "Uberlândia",est1);
		Cidade cid2 = new Cidade (null, "São Paulo",est2);
		Cidade cid3 = new Cidade (null, "Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
	}

}
