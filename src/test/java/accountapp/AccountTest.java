package accountapp;

import org.junit.Test;

import com.qa.app.AccountService;

public class AccountTest {

	@Test
	public void test() {

		AccountService ac = new AccountService();

		ac.createAccount("1", "Andrew", "Knott");
		ac.createAccount("1", "Gareth", "Clifford");
		ac.createAccount("1", "Ben", "Taylor");
		ac.createAccount("1", "Andrew", "Knott");

		
		
		assertEquals(2, ac.getAccountSum("Andrew"));
		assertEquals(1, ac.getAccountSum("Ben"));
		assertEquals(0, ac.getAccountSum("Mozi"));

	}

}
