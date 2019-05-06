package plir2166MV.control;

import org.junit.Before;
import org.junit.Test;
import plir2166MV.model.Carte;
import plir2166MV.repository.repo.CartiRepo;
import plir2166MV.repository.repoInterfaces.CartiRepoInterface;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AdaugaCarteControllerTest {
    BibliotecaController controller;
    CartiRepoInterface cr = new CartiRepo();

    @Before
    public void setUp() throws Exception{
        controller = new BibliotecaController(cr);
    }

    @Test
    public void adaugaCarte_ECP_valid() {
        List<String> r = new ArrayList<>();
        r.add("Eminescu");
        List<String> c = new ArrayList<>();
        c.add("poezii");
        c.add("luceafarul");
        try{
            Integer size = controller.getCarti().size();
            controller.adaugaCarte(new Carte("Poezii",r,"2010",c,"corint"));
            if(controller.getCarti().size() == size + 1)
                assertTrue(true);
            else
                assertTrue(false);
        }catch (Exception s){
            assertTrue(false);
        }
    }

    @Test
    public void adaugaCarte_ECP_nonvalid1() {
        List<String> r = new ArrayList<>();
        r.add("Eminescu");
        List<String> c = new ArrayList<>();
        c.add("poezii2");
        c.add("luceafarul");
        try{
            controller.adaugaCarte(new Carte("Poezii",r,"2010",c,"corint"));
            assertTrue(false);
        }catch (Exception s){
            assertTrue(true);
        }
    }

    @Test
    public void adaugaCarte_ECP_nonvalid2() {
        List<String> r = new ArrayList<>();
        r.add("Eminescu");
        List<String> c = new ArrayList<>();
        c.add("poezii");
        c.add("luceafarul");
        try{
            controller.adaugaCarte(new Carte("Poezii",r,"zzr",c,"corint"));
            assertTrue(false);
        }catch (Exception s){
            assertTrue(true);
        }
    }

    @Test
    public void adaugaCarte_BVA_valid1() {
        List<String> r = new ArrayList<>();
        r.add("a");
        List<String> c = new ArrayList<>();
        c.add("aa");
        try{
            controller.adaugaCarte(new Carte("aa",r,"1234",c,"aaa"));
            assertTrue(true);
        }catch (Exception s){
            assertTrue(false);
        }
    }

    @Test
    public void adaugaCarte_BVA_valid2() {
        List<String> r = new ArrayList<>();
        r.add("a");
        List<String> c = new ArrayList<>();
        c.add("aa");
        try{
            controller.adaugaCarte(new Carte("aaaaaaaaaa",r,"1234",c,"aaa"));
            assertTrue(true);
        }catch (Exception s){
            assertTrue(false);
        }
    }

    @Test
    public void adaugaCarte_BVA_nonvalid1() {
        List<String> r = new ArrayList<>();
        r.add("a");
        List<String> c = new ArrayList<>();
        c.add("aa");
        try{
            controller.adaugaCarte(new Carte("",r,"1234",c,"aaa"));
            assertTrue(false);
        }catch (Exception s){
            assertTrue(true);
        }
    }

    @Test
    public void adaugaCarte_BVA_nonvalid2() {
        List<String> r = new ArrayList<>();
        r.add("a");
        List<String> c = new ArrayList<>();
        c.add("aa");
        try{
            controller.adaugaCarte(new Carte("aaa",r,"aa12",c,"aaa"));
            assertTrue(false);
        }catch (Exception s){
            assertTrue(true);
        }
    }

    @Test
    public void adaugaCarte_BVA_nonvalid3() {
        List<String> r = new ArrayList<>();
        r.add("a");
        List<String> c = new ArrayList<>();
        c.add("aa");
        try{
            controller.adaugaCarte(new Carte("a",r,"",c,"aaa"));
            assertTrue(false);
        }catch (Exception s){
            assertTrue(true);
        }
    }

}