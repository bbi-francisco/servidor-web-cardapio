//*******************************************************
//
//               Delphi DataSnap Framework
//
// Copyright(c) 1995-2011 Embarcadero Technologies, Inc.
//
//*******************************************************

package web_cardapio.com.embarcadero.javaandroid;

public class DSAdminRestClient {
	private DSRESTConnection Connection = null;

	protected DSRESTConnection getConnection() {
		return Connection;
	}

	public DSAdminRestClient(DSRESTConnection Connection) {
		super();
		this.Connection = Connection;
	}
}
