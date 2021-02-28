package controller.getter_setter;

public class Getter_Setter_Thread_empfangen {

	// 0 = Hosten; 1 = Connecten
	public static Boolean[] btnClicked = new Boolean[2];

	
	
	public static Boolean getBtnClicked(int zahl) {
		return btnClicked[zahl];
	}

	public static void setBtnClicked(Boolean btnClicked, int zahl) {
		Getter_Setter_Thread_empfangen.btnClicked[zahl] = btnClicked;
	}
	
	
}
