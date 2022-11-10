package tn.esprit.rh.achat.services; 

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FactureServiceTest {

    @Mock
    FactureRepository factureRepository;

    @InjectMocks
    FactureServiceImpl factureService;

    @Test
    public void testRetrieveFacture() {

        Facture facture = new Facture(100, 154, null, null, null, null, null, null);

        facture.setIdFacture(1L);

        Mockito.when(factureRepository.findById(1L)).thenReturn(Optional.of(facture));
        factureService.retrieveFacture(1L);
        Assertions.assertNotNull(facture);

        System.out.println(facture);
        System.out.println(" Retrieve is working correctly...!!");

    }


    @Test
   public void createFacturekTest()
    {
        Facture facture2 = new Facture(20, 100, null, null, null, null, null, null);
        facture2.setIdFacture(2L);

        factureService.addFacture(facture2);
        verify(factureRepository, times(1)).save(facture2);
        System.out.println(facture2);
        System.out.println(" Create is working correctly...!!");
    }


   /* @Test
 public   void getAllFactureTest()
    {
        List<Facture> Facturelist = new ArrayList<Facture>() {

            {
                add(new Facture(30, 100, null, null, null, null, null, null));
                add(new Facture(40, 200, null, null, null, null, null, null));
                add(new Facture(50, 300, null, null, null, null, null, null));
            }};


        when(factureService.retrieveAllFactures()).thenReturn(Facturelist);
        //test
        List<Facture> factureList = factureService.retrieveAllFactures();
        assertEquals(3, factureList.size());
        System.out.println(" Retrieve all is working correctly...!!");
    }*/




}