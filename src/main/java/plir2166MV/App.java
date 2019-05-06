package plir2166MV;


import plir2166MV.control.BibliotecaController;
import plir2166MV.repository.repo.CartiRepo;
import plir2166MV.repository.repoInterfaces.CartiRepoInterface;
import plir2166MV.view.Consola;

import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        CartiRepoInterface cr = new CartiRepo();
        BibliotecaController bc = new BibliotecaController(cr);
        Consola c = new Consola(bc);
        try {
            c.executa();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
