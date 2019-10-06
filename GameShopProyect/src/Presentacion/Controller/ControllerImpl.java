package Presentacion.Controller;

import java.util.ArrayList;
import java.util.List;

import Main.Main;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Product.GUIProduct;
import Presentacion.Provider.GUIProvider;
import Presentacion.Ticket.GUITicket;
import Presentacion.View.GUIGameshop;
import Presentacion.View.IGUI;
import Transfers.TProduct;
import Transfers.TProvider;
import Transfers.TTicket;

/** 
 * @author GameShop
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControllerImpl extends Controller {
	
	private IGUI gui;
	private GUIGameshop gs;
	
	public ControllerImpl() {
		gs = new GUIGameshop(Main.applicationName);
		List<Object> guis = new ArrayList<Object>();
		guis.add((new GUIProvider()));
		guis.add((new GUIProduct()));
		guis.add((new GUITicket()));
		gs.initTabs(guis);
	}

	@Override
	public void action(Object data, Integer event) {
		Integer id;
		TProvider tpr;
		TProduct tprod;
		TTicket tti;
		
		gui = gs.getGuiAt(event/100 - 1);

		switch(event) {
		
		////////////////////////////////////////////////////////////// PROVIDER ///////////////////////////////////////////////
		case Event.REGISTER_PROVIDER:
			tpr = (TProvider)data;
			int resRegisterProv = (SAAbstractFactory.getInstance().createSAProvider()).createProvider(tpr);
			if(resRegisterProv > 0)
				gui.actualiza(Event.RES_REGISTER_PROVIDER_OK, new Integer(resRegisterProv));
			else if (resRegisterProv <= 0)
				gui.actualiza(Event.RES_REGISTER_PROVIDER_FAILED, null);
			break;
			
		case Event.UNSUBSCRIBE_PROVIDER:
			id = (Integer)data;
			boolean resDeleteProv = (SAAbstractFactory.getInstance().createSAProvider()).deleteProvider(id);
			if(resDeleteProv)
				gui.actualiza(Event.RES_UNSUBSCRIBE_PROVIDER_OK, id);
			else
				gui.actualiza(Event.RES_UNSUBSCRIBE_PROVIDER_FAILED, null);
			break;
			
		case Event.MODIFY_PROVIDER:
			tpr = (TProvider)data;
			if(SAAbstractFactory.getInstance().createSAProvider().updateProvider(tpr))
				gui.actualiza(Event.RES_MODIFY_PROVIDER_OK, null);
			else
				gui.actualiza(Event.RES_MODIFY_PROVIDER_FAILED, null);
			break;
			
		case Event.READ_PROVIDER:
			id = (Integer)data;
			TProvider t = (TProvider)(SAAbstractFactory.getInstance().createSAProvider()).readProvider(id);
			if (t != null) 
				gui.actualiza(Event.RES_READ_PROVIDER_OK, t);
			else
				gui.actualiza(Event.RES_READ_PROVIDER_FAILED, null);
			break;
			
		case Event.READ_ALL_PROVIDERS:
			List<Object> providers = (SAAbstractFactory.getInstance().createSAProvider()).readAllProviders();
			if(providers == null)
				gui.actualiza(Event.RES_READALL_PROVIDERS_FAILED, null);
			else
				gui.actualiza(Event.RES_READALL_PROVIDERS_OK, providers);
			break;
			
		////////////////////////////////////////////////////////////// PRODUCT ////////////////////////////////////////////////
			
		case Event.REGISTER_PRODUCT:
			tprod = (TProduct) data;
			int resRegister= (SAAbstractFactory.getInstance().createSAProduct()).createProduct(tprod);
			if(resRegister > 0)
				gui.actualiza(Event.RES_REGISTER_PRODUCT_OK, new Integer(resRegister));
			else
				gui.actualiza(Event.RES_REGISTER_PRODUCT_FAILED, null);
			break;
			
		case Event.UNSUBSCRIBE_PRODUCT:
			id = (Integer)data;
			boolean resDelete = (SAAbstractFactory.getInstance().createSAProduct()).deleteProduct(id);
			if(resDelete)
				gui.actualiza(Event.RES_UNSUBSCRIBE_PRODUCT_OK, id);
			else
				gui.actualiza(Event.RES_UNSUBSCRIBE_PRODUCT_FAILED, null);
			break;
			
		case Event.MODIFY_PRODUCT:
			tprod = (TProduct) data;
			if(SAAbstractFactory.getInstance().createSAProduct().updateProduct(tprod))
				gui.actualiza(Event.RES_MODIFY_PRODUCT_OK, tprod.get_id());
			else
				gui.actualiza(Event.RES_MODIFY_PRODUCT_FAILED, null);
			break;
			
		case Event.READ_PRODUCT:
			id = (Integer)data;
			tprod = (TProduct) (SAAbstractFactory.getInstance().createSAProduct()).readProduct(id);
			if (tprod != null) 
				gui.actualiza(Event.RES_READ_PRODUCT_OK, tprod);
			else
				gui.actualiza(Event.RES_READ_PRODUCT_FAILED, null);
			break;
			
		case Event.READ_ALL_PRODUCT:
			List<Object> products = (SAAbstractFactory.getInstance().createSAProduct()).readAllProducts();
			if(products == null)
				gui.actualiza(Event.RES_READALL_PRODUCT_FAILED, null);
			else
				gui.actualiza(Event.RES_READALL_PRODUCT_OK, products);
			break;
			
		////////////////////////////////////////////////////////////// TICKET ///////////////////////////////////////////////	
		case Event.REGISTER_TICKET:
			tti = (TTicket)data;
			int resRegisterTicket = (SAAbstractFactory.getInstance().createSATicket().createTicket(tti));
			if(resRegisterTicket > 0)
				gui.actualiza(Event.RES_REGISTER_TICKET_OK, new Integer(resRegisterTicket));
			else
				gui.actualiza(Event.RES_REGISTER_TICKET_FAILED, null);
			break;
		case Event.UNSUBSCRIBE_TICKET:
			id = (Integer) data;
			boolean resDeleteTi = (SAAbstractFactory.getInstance().createSATicket()).deleteTicket(id);
			if(resDeleteTi)
				gui.actualiza(Event.RES_UNSUBSCRIBE_TICKET_OK, id);
			else
				gui.actualiza(Event.RES_UNSUBSCRIBE_TICKET_FAILED, null);
			break;
		case Event.READ_TICKET:
			id = (Integer) data;
			TTicket ticket = (TTicket)(SAAbstractFactory.getInstance().createSATicket().readTicket(id));
			if (ticket != null) 
				gui.actualiza(Event.RES_READ_TICKET_OK, ticket);
			else
				gui.actualiza(Event.RES_READ_TICKET_FAILED, null);
			break;
		case Event.READ_ALL_TICKET:
			List<Object> tickets = (SAAbstractFactory.getInstance().createSATicket().readAllTickets());
			if(tickets == null)
				gui.actualiza(Event.RES_READALL_TICKET_FAILED, null);
			else
				gui.actualiza(Event.RES_READALL_TICKET_OK, tickets);
			break;
		}
	}
	
}