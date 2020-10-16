package sample.simple.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import sample.simple.store.IFastLane;
import sample.simple.store.IJustHaveALook;
import sample.simple.store.ILane;

@Component
public class Client implements IRun{
	
	@Autowired
	IFastLane fastlane;
	@Autowired
	ILane lane;
	@Autowired
	IJustHaveALook haveALook;
	
	
	int account;
	
	public Client()
	{
		account = 1;
	}
	
	public void run() {
		
		
		lane.addItemToCart("item1", 1);
		lane.addItemToCart("item2",7);
		fastlane.oneShotOrder("item1", 1, account);
		lane.pay(account);
	}

}