package io.github.samirsales.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import io.github.samirsales.dao.FabricanteDAO;
import io.github.samirsales.domain.Fabricante;

@SuppressWarnings("deprecation")
@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private ListDataModel<Fabricante> items;
	private Fabricante fabricante;

	public ListDataModel<Fabricante> getItems() {
		return items;
	}

	public void setItems(ListDataModel<Fabricante> items) {
		this.items = items;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * The action happens when the page is loaded.
	 */
	@PostConstruct
	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			ArrayList<Fabricante> arrayList = dao.listar();
			items = new ListDataModel<Fabricante>(arrayList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void prepararNovo(){
		fabricante = new Fabricante();
	}

	public void novo() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			ArrayList<Fabricante> arrayList = dao.listar();
			items = new ListDataModel<Fabricante>(arrayList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
