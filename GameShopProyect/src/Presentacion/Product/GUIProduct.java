package Presentacion.Product;

import javax.swing.JPanel;

import Presentacion.View.IGUI;

@SuppressWarnings("serial")
public abstract class GUIProduct extends JPanel implements IGUI {
	private static GUIProduct _instance;
	
	public static GUIProduct getInstance() {
		if(_instance == null) {
			_instance = new GUIProductImp();
			_instance.alingmentPanels();
		}
		return _instance;
	}
	
	protected abstract void alingmentPanels();
	public abstract void actualiza(Integer event, Object id);
}
