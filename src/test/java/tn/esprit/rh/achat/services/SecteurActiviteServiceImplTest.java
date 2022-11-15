package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;



import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class SecteurActiviteServiceImplTest {
	@Mock
	SecteurActiviteRepository sr;
	@InjectMocks
	SecteurActiviteServiceImpl ss;

	@Test
	public void testAddSecteur() {
		
		SecteurActivite s = new SecteurActivite("xq45isdby","secteur");

		Mockito.when(sr.save(ArgumentMatchers.any(SecteurActivite.class))).thenReturn(s);

		SecteurActivite secteuradd = ss.addSecteurActivite(s);

		assertThat(secteuradd.getIdSecteurActivite()).isSameAs(secteuradd.getIdSecteurActivite());
	}

	@Test
	public void RetrieveAllSecteurActiviteTest() {
		List<SecteurActivite> secteur = new ArrayList<>();
		secteur.add(new SecteurActivite());

		when(sr.findAll()).thenReturn(secteur);

		List<SecteurActivite> expected = ss.retrieveAllSecteurActivite();
		
		assertEquals(expected, secteur);
		verify(sr).findAll();
	};
	

}
