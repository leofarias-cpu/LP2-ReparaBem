package reparebem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrdemServicoTest {

	@Test
	void MudarStatusTest() {
		OrdemServico ordem = new OrdemServico(1, "Eu", "1234", "Carça");
		ordem.setStatus("Oiiii");
		assertEquals(ordem.getStatus(), "Oiiii");
	}

}
