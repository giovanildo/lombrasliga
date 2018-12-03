package giovanildo.lombrasliga.main;

import giovanildo.lombrasliga.controller.TorneioController;
import giovanildo.lombrasliga.dao.DAO;

public class Main {
	public static void main(String[] args) {
//		TorneioController torneio = new TorneioController();
//		torneio.iniciar();
		DAO dao = new DAO();
		dao.execSQL("SELECT * FROM eatleta", "sqlite");
		// dao.apagarBaseDeDados("lombras");
		// dao.criarBanco();

	}
}
