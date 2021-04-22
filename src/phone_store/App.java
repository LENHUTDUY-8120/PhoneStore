package phone_store;

import java.awt.EventQueue;

import view.UserView;
import controller.UserController;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				UserView view = new UserView();
				UserController Uctl = new UserController(view,1);
				Uctl.showView();
			}
		});
	}
}
