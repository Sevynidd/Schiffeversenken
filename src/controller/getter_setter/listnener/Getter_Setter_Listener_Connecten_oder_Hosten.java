package controller.getter_setter.listnener;

import java.net.DatagramSocket;

public class Getter_Setter_Listener_Connecten_oder_Hosten {

	private static DatagramSocket socket;

	public static DatagramSocket getSocket() {
		return socket;
	}

	public static void setSocket(DatagramSocket socket) {
		Getter_Setter_Listener_Connecten_oder_Hosten.socket = socket;
	}

}
