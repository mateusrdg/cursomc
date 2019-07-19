package com.mateus.cursomc.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mateus.cursomc.domain.Categoria;
import com.mateus.cursomc.domain.Cidade;
import com.mateus.cursomc.domain.Cliente;
import com.mateus.cursomc.domain.Endereco;
import com.mateus.cursomc.domain.Estado;
import com.mateus.cursomc.domain.ItemPedido;
import com.mateus.cursomc.domain.PagamentoComBoleto;
import com.mateus.cursomc.domain.PagamentoComCartao;
import com.mateus.cursomc.domain.Pedido;
import com.mateus.cursomc.domain.Produto;
import com.mateus.cursomc.domain.enums.EstadoPagamento;
import com.mateus.cursomc.domain.enums.Perfil;
import com.mateus.cursomc.domain.enums.TipoCliente;
import com.mateus.cursomc.repositories.CategoriaRepository;
import com.mateus.cursomc.repositories.CidadeRepository;
import com.mateus.cursomc.repositories.ClienteRepository;
import com.mateus.cursomc.repositories.EnderecoRepository;
import com.mateus.cursomc.repositories.EstadoRepository;
import com.mateus.cursomc.repositories.ItemPedidoRepository;
import com.mateus.cursomc.repositories.PagamentoRepository;
import com.mateus.cursomc.repositories.PedidoRepository;
import com.mateus.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() {

		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		Categoria c3 = new Categoria(null, "Cama mesa e banho");
		Categoria c4 = new Categoria(null, "Materiais de construcão");
		Categoria c5 = new Categoria(null, "Perfumes");
		Categoria c6 = new Categoria(null, "Higiene pessoal");
		Categoria c7 = new Categoria(null, "Carnes");
		Categoria c8 = new Categoria(null, "Gamer");
		Categoria c9 = new Categoria(null, "Frutas");
		Categoria c10 = new Categoria(null, "Frios");

		Produto p1 = new Produto(null, "Computador", new BigDecimal(4000.00));
		Produto p2 = new Produto(null, "Monitor", new BigDecimal(1000.00));
		Produto p3 = new Produto(null, "Placa de vídeo", new BigDecimal(1500.00));
		Produto p4 = new Produto(null, "Mesa de escritório", new BigDecimal(300.00));
		Produto p5 = new Produto(null, "Toalha", new BigDecimal(50.00));
		Produto p6 = new Produto(null, "Colcha", new BigDecimal(200.00));
		Produto p7 = new Produto(null, "TV true color", new BigDecimal(1200.00));
		Produto p8 = new Produto(null, "Roçadeira", new BigDecimal(800.00));
		Produto p9 = new Produto(null, "Abajour", new BigDecimal(100.00));
		Produto p10 = new Produto(null, "Pendente", new BigDecimal(180.00));
		Produto p11 = new Produto(null, "Shampoo", new BigDecimal(90.00));

		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		c2.getProdutos().addAll(Arrays.asList(p2, p4));
		c3.getProdutos().addAll(Arrays.asList(p5, p6));
		c4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		c5.getProdutos().addAll(Arrays.asList(p8));
		c6.getProdutos().addAll(Arrays.asList(p9, p10));
		c7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(c1, c4));
		p2.getCategorias().addAll(Arrays.asList(c1, c2, c4));
		p3.getCategorias().addAll(Arrays.asList(c1, c4));
		p4.getCategorias().addAll(Arrays.asList(c2));
		p5.getCategorias().addAll(Arrays.asList(c3));
		p6.getCategorias().addAll(Arrays.asList(c3));
		p7.getCategorias().addAll(Arrays.asList(c4));
		p8.getCategorias().addAll(Arrays.asList(c5));
		p9.getCategorias().addAll(Arrays.asList(c6));
		p10.getCategorias().addAll(Arrays.asList(c6));
		p11.getCategorias().addAll(Arrays.asList(c7));

		categoriarepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "605413293-83", TipoCliente.PESSOAFISICA, pe.encode("123456"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93839393"));
		
		Cliente cli2 = new Cliente(null, "Mateus Rodrigues", "mateusrodrigues-cp@hotmail.com", "605413293-83", TipoCliente.PESSOAFISICA, pe.encode("123456"));
		cli2.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("21545878", "654787894"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "60440530", cli1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "60440530.", cli1, cid2);
		Endereco e3 = new Endereco(null, "Rua Gaspar Lemos", "275", "Sala 800", "Pici", "60440530.", cli2, cid2);

		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli1.getEnderecos().addAll(Arrays.asList(e3));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		Calendar dataHora1 = Calendar.getInstance();
		dataHora1.set(2019, 8, 30, 10, 32);
		Pedido ped1 = new Pedido(null, dataHora1, cli1, e1);

		Calendar dataHora2 = Calendar.getInstance();
		dataHora2.set(2019, 9, 10, 19, 35);
		Pedido ped2 = new Pedido(null, dataHora2, cli1, e2);

		PagamentoComCartao pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);

		Calendar data = Calendar.getInstance();
		data.set(2019, 9, 20);
		PagamentoComBoleto pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, data, null);

		ped1.setPagamento(pgto1);
		ped2.setPagamento(pgto2);
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
		;

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, new BigDecimal(2000.0), new BigDecimal(0), 1);
		ItemPedido ip2 = new ItemPedido(ped1, p3, new BigDecimal(80.0), new BigDecimal(0), 2);
		ItemPedido ip3 = new ItemPedido(ped2, p2, new BigDecimal(800.0), new BigDecimal(100.0), 1);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped1.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}
