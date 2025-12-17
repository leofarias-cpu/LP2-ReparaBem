package reparebem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReparoTest {

	@Test
	void ReajustarDescontotest() {
		Reparo reparo = new Reparo("1", "AAAAAAAAA", 10);
		reparo.reajustarPreco(0.5);
		assertEquals(reparo.getPreco(), 5);
	}
	
	@Test
	void ReajustarEncarecertest() {
		Reparo reparo = new Reparo("1", "AAAAAAAAA", 10);
		reparo.reajustarPreco(1.5);
		assertEquals(reparo.getPreco(), 15);
	}
}
