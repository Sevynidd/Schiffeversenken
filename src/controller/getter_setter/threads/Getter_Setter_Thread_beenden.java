package controller.getter_setter.threads;

public class Getter_Setter_Thread_beenden {

	private static volatile boolean beenden;

	public static boolean isBeenden() {
		return beenden;
	}

	public static void setBeenden(boolean beenden) {
		Getter_Setter_Thread_beenden.beenden = beenden;
	}
	
	
}
