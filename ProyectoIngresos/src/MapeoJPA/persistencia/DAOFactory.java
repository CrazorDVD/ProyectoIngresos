package MapeoJPA.persistencia;

public class DAOFactory {
    
    private static IEntradassalidasDAO entradassalidasDAO = new EntradassalidasDAO();
    private static INovedadesDAO novedadesDAO = new NovedadesDAO();
    private static IPersonalDAO personalDAO = new PersonalDAO();
    private static IProgramasDAO programasDAO = new ProgramasDAO();
    private static IUsuariosDAO usuariosDAO = new UsuariosDAO();

    public static IEntradassalidasDAO getEntradassalidasDAO() {
        return entradassalidasDAO;
    }

    public static INovedadesDAO getNovedadesDAO() {
        return novedadesDAO;
    }

    public static IPersonalDAO getPersonalDAO() {
        return personalDAO;
    }

    public static IProgramasDAO getProgramasDAO() {
        return programasDAO;
    }

    public static IUsuariosDAO getUsuariosDAO() {
        return usuariosDAO;
    }

    
}
