package sample.simple.bank;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank{

	Map<Integer, Integer> accounts =  new HashMap<Integer, Integer>();
	
	public Bank(){
	}
	
	public void transfert(int sendAccount, int receiveAcount, int amount) {
		accounts.put(sendAccount, accounts.getOrDefault(sendAccount, 0) - amount);
		accounts.put(receiveAcount, accounts.getOrDefault(receiveAcount, 0) + amount);
	}
	
	public Map<Integer, Integer> getAccounts()
	{
		return accounts;
	}
	

}