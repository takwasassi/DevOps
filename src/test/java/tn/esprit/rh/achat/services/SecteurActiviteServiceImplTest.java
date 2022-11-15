package tn.esprit.rh.achat;

import java.util.Optional;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecteurActiviteServiceImplTest {

    @Autowired
    SecteurActiviteServiceImpl secteurImpl;
    @Mock
    SecteurActiviteRepository secteurRepository;

    @InjectMocks
    SecteurActiviteServiceImpl secteurServiceImpl;

    SecteurActivite s = new SecteurActivite("xq45isdby","secteur");

    @Test
    public void testAddSecteur() {
        //	List<Stock> stocks = stockService.retrieveAllStocks();
        //	int expected=stocks.size();
        SecteurActivite s = new SecteurActivite("xq45isdby","secteur");
        SecteurActivite savedSecteur= secteurImpl.addSecteurActivite(s);

        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedSecteur.getLibelleSecteurActivite());
        //stockImpl.deleteStock(savedStock.getIdStock());
    }

    @Test
    void getSecteur(){
        Iterable<SecteurActivite> Lsecteur = secteurRepository.findAll();
        Assertions.assertNotNull(Lsecteur);
    }

    @Test
    void retrieveSecteur() {
        Mockito.when(secteurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        SecteurActivite secteur = secteurServiceImpl.retrieveSecteurActivite(1L);
        Mockito.verify(secteurRepository,Mockito.times(1)).findById(1L);
    }

    @Test
    public void testDeleteSecteur() {
        SecteurActivite s = new SecteurActivite("xq45isdby","secteur");
        SecteurActivite savedSecteur= secteurImpl.addSecteurActivite(s);
        secteurImpl.deleteSecteurActivite(savedSecteur.getIdSecteurActivite());
        assertNull(secteurImpl.retrieveSecteurActivite(savedSecteur.getIdSecteurActivite()));
    }





}
