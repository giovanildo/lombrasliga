package giovanildo.lombrasliga.main;


import giovanildo.lombrasliga.dao.DAO;


public class Main 
{
    public static void main( String[] args )
    {
//		TorneioController torneio = new TorneioController();
//		torneio.iniciar();
    	DAO dao = new DAO();
//    	dao.apagarBaseDeDados("lombras");
//    	dao.criarBanco();
    	dao.inserir("giovanildo");
    	
    	
    }
}
