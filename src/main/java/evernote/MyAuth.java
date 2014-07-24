package evernote;

import com.evernote.auth.EvernoteService;

public class MyAuth {
	public void t(){
		EvernoteService eservice = EvernoteService.SANDBOX;
		System.out.println(eservice.getAuthorizationUrl("0c2d5fb6f23e124a"));
	}
}
