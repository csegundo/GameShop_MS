package Presentacion.View;

import Presentacion.Controller.Event;
import Presentacion.Product.GUIProduct;
import Presentacion.Provider.GUIProvider;
import Presentacion.Ticket.GUITicket;
import javafx.util.Pair;

public class ViewDispatcherImp extends ViewDispatcher {

	@Override
	public void createView(Pair<Object, Integer> data) {
		switch(data.getValue()) {
		/******************************** PROVIDER ********************************/
		case Event.RES_REGISTER_PROVIDER_OK:
			GUIProvider.getInstance().actualiza(data);
			break;
		case Event.RES_REGISTER_PROVIDER_FAILED:
			GUIProvider.getInstance().actualiza(data);
			break;
		case Event.RES_UNSUBSCRIBE_PROVIDER_OK:
			GUIProvider.getInstance().actualiza(data);
			break;
		case Event.RES_UNSUBSCRIBE_PROVIDER_FAILED:
			GUIProvider.getInstance().actualiza(data);
			break;
		case Event.RES_MODIFY_PROVIDER_OK:
			GUIProvider.getInstance().actualiza(data);
			break;
		case Event.RES_MODIFY_PROVIDER_FAILED:
			GUIProvider.getInstance().actualiza(data);
			break;
		case Event.RES_READ_PROVIDER_OK:
			GUIProvider.getInstance().actualiza(data);
			break;
		case Event.RES_READ_PROVIDER_FAILED:
			GUIProvider.getInstance().actualiza(data);
			break;
		case Event.RES_READALL_PROVIDERS_OK:
			GUIProvider.getInstance().actualiza(data);
			break;
		case Event.RES_READALL_PROVIDERS_FAILED:
			GUIProvider.getInstance().actualiza(data);
			break;
			
		/******************************** PRODUCT ********************************/
		case Event.RES_REGISTER_PRODUCT_OK:
			GUIProduct.getInstance().actualiza(data);
			break;
		case Event.RES_REGISTER_PRODUCT_FAILED:
			GUIProduct.getInstance().actualiza(data);
			break;
		case Event.RES_UNSUBSCRIBE_PRODUCT_OK:
			GUIProduct.getInstance().actualiza(data);
			break;
		case Event.RES_UNSUBSCRIBE_PRODUCT_FAILED:
			GUIProduct.getInstance().actualiza(data);
			break;
		case Event.RES_MODIFY_PRODUCT_OK:
			GUIProduct.getInstance().actualiza(data);
			break;
		case Event.RES_MODIFY_PRODUCT_FAILED:
			GUIProduct.getInstance().actualiza(data);
			break;
		case Event.RES_READ_PRODUCT_OK:
			GUIProduct.getInstance().actualiza(data);
			break;
		case Event.RES_READ_PRODUCT_FAILED:
			GUIProduct.getInstance().actualiza(data);
			break;
		case Event.RES_READALL_PRODUCT_OK:
			GUIProduct.getInstance().actualiza(data);
			break;
		case Event.RES_READALL_PRODUCT_FAILED:
			GUIProduct.getInstance().actualiza(data);
			break;
			
		/******************************** TICKET ********************************/
		case Event.RES_REGISTER_TICKET_OK:
			GUITicket.getInstance().actualiza(data);
			break;
		case Event.RES_REGISTER_TICKET_FAILED:
			GUITicket.getInstance().actualiza(data);
			break;
		case Event.RES_UNSUBSCRIBE_TICKET_OK:
			GUITicket.getInstance().actualiza(data);
			break;
		case Event.RES_UNSUBSCRIBE_TICKET_FAILED:
			GUITicket.getInstance().actualiza(data);
			break;
		case Event.RES_READ_TICKET_OK:
			GUITicket.getInstance().actualiza(data);
			break;
		case Event.RES_READ_TICKET_FAILED:
			GUITicket.getInstance().actualiza(data);
			break;
		case Event.RES_READALL_TICKET_OK:
			GUITicket.getInstance().actualiza(data);
			break;
		case Event.RES_READALL_TICKET_FAILED:
			GUITicket.getInstance().actualiza(data);
			break;
		}
	}

}