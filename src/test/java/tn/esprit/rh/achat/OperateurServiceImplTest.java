package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)


public class OperateurServiceImplTest {


		
		@Mock
		OperateurRepository OPrepository;
		
		@InjectMocks
		OperateurServiceImpl opService;
		
//test Retrieve op by id
		@Test
		public void testRetrieveOperateur() {
			
			Operateur op = new Operateur(1L,"nader","bs","yyy",null);
			//op.setIdOperateur(1L);
			
			Mockito.when(OPrepository.findById(1L)).thenReturn(Optional.of(op));
			opService.retrieveOperateur(1L);
			Assertions.assertNotNull(op);
			
			System.out.println(op);
			
			System.out.println("operateur retrouvé");
		}
		
//Test Retrieve all op
	    @Test
	    public void retrieveAllOperateur() {
	    	
	        when(OPrepository.findAll()).thenReturn(Stream.of(
	                        new Operateur(2L,"nader", "bmrad", "csfwe",null),
	                        new Operateur(3L,"aaa", "bbb", "kkk",null),
	                        new Operateur(4L,"ccc", "ddd", "test",null))
	                .collect(Collectors.toList()));
	        assertEquals(3,opService.retrieveAllOperateurs().size());
	        
	        System.out.println("Tous les operateurs retrouvés");
	        
	    }
//Test Add op
	    @Test
	    public void addOperateurTest() {
	        Operateur op = new Operateur(5L,"nader", "bsj", "ccc",null);
	        when(OPrepository.save(op)).thenReturn(op);
	        assertEquals(op, opService.addOperateur(op));
	        System.out.println("Op added...!!"); 
	    }
	    

//Test Delete op
	    @Test
	    public void deleteOperateurTest() {
	        Operateur op = new Operateur(1L,"nader","fgd","yyy",null);
	        opService.deleteOperateur((long) 1);
	        verify(OPrepository).deleteById(op.getIdOperateur());
	        System.out.println("Op deleted...!!"); 

	    }
//Test update op
	    @Test
	    public void updatetStockTest() {
	        Operateur op = new Operateur(10L,"hjjdjkdkd", "djdujduj","ddddddg",null) ;
	        Mockito.when(OPrepository.save(Mockito.any(Operateur.class))).thenReturn(op);
	        op.setIdOperateur(6L);;
	        Operateur exisitingOp= opService.updateOperateur(op) ;

	        assertNotNull(exisitingOp);
	        assertEquals(6L, op.getIdOperateur());
	        System.out.println("Op updated...!!"); 
	    }
}