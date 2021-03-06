package Presentacion.Command;

import java.util.HashMap;


import Presentacion.Command.ConferenceCommands.*;
import Presentacion.Command.DepartmentCommands.*;
import Presentacion.Command.EmployeeCommands.*;
import Presentacion.Command.ProductCommands.*;
import Presentacion.Command.ProviderCommands.*;
import Presentacion.Command.RealizaCommand.RealizaAsignarCommand;
import Presentacion.Command.RealizaCommand.RealizaDesasignarCommand;
import Presentacion.Command.RealizaCommand.RealizaModificarCommand;
import Presentacion.Command.TicketCommands.*;
import Presentacion.Controller.Event;

public class CommandFactoryImp extends CommandFactory {
	private static HashMap<Integer, Command> _availableCommands = new HashMap<Integer, Command>();

	@Override
	public Command parse(int event) {
		return _availableCommands.get(event);
	}

	@Override
	protected void createAvailableCommands() {
		/********************************** PROVIDER **********************************/
		_availableCommands.put(Event.REGISTER_PROVIDER, new CreateProviderCommand());
		_availableCommands.put(Event.UNSUBSCRIBE_PROVIDER, new DeleteProviderCommand());
		_availableCommands.put(Event.MODIFY_PROVIDER, new UpdateProviderCommand());
		_availableCommands.put(Event.READ_PROVIDER, new ShowOneProviderCommand());
		_availableCommands.put(Event.READ_ALL_PROVIDERS, new ShowAllProvidersCommand());
		_availableCommands.put(Event.UPDATE_LIST_PROVIDER, new UpdateComboBoxProvider());

		/********************************** PRODUCT **********************************/
		_availableCommands.put(Event.REGISTER_PRODUCT, new CreateProductCommand());
		_availableCommands.put(Event.UNSUBSCRIBE_PRODUCT, new DeleteProductCommand());
		_availableCommands.put(Event.MODIFY_PRODUCT, new UpdateProductCommand());
		_availableCommands.put(Event.READ_PRODUCT, new ShowOneProductCommand());
		_availableCommands.put(Event.READ_ALL_PRODUCT, new ShowAllProductCommand());
		_availableCommands.put(Event.UPDATE_LIST_PRODUCT, new UpdateComboBoxProduct());

		/********************************** TICKET **********************************/
		_availableCommands.put(Event.REGISTER_TICKET, new CreateTicketCommand());
		_availableCommands.put(Event.UNSUBSCRIBE_TICKET, new DeleteTicketCommand());
		_availableCommands.put(Event.READ_TICKET, new ShowOneTicketCommand());
		_availableCommands.put(Event.READ_ALL_TICKET, new ShowALLTicketCommand());
		_availableCommands.put(Event.UPDATE_LIST_TICKET, new UpdateComboBoxTicket());

		/******************************** CONFERENCE ********************************/
		_availableCommands.put(Event.REGISTER_CONFERENCE, new CreateConferenceCommand());
		_availableCommands.put(Event.UNSUBSCRIBE_CONFERENCE, new DeleteConferenceCommand());
		_availableCommands.put(Event.MODIFY_CONFERENCE, new UpdateConferenceCommand());
		_availableCommands.put(Event.READ_CONFERENCE, new ShowOneConferenceCommand());
		_availableCommands.put(Event.READ_ALL_CONFERENCE, new ShowAllConferenceCommand());
		_availableCommands.put(Event.UPDATE_LIST_CONFERENCE, new UpdateComboBoxConference());
		_availableCommands.put(Event.READ_CONFERENCE_FORM, new ReadConferenceToForm());
		
		/******************************** DEPARTMENT ********************************/
		_availableCommands.put(Event.REGISTER_DEPARTMENT, new CreateDepartmentCommand());
		_availableCommands.put(Event.UNSUBSCRIBE_DEPARTMENT, new DeleteDepartmentCommand());
		_availableCommands.put(Event.MODIFY_DEPARTMENT, new UpdateDepartmentCommand());
		_availableCommands.put(Event.READ_DEPARTMENT, new ShowOneDepartmentCommand());
		_availableCommands.put(Event.READ_ALL_DEPARTMENT, new ShowAllDepartmentCommand());
		_availableCommands.put(Event.UPDATE_LIST_DEPARTMENT, new UpdateComboBoxDpto());
		_availableCommands.put(Event.CALCULAR_NOMINA_DEPARTAMENTO, new CalcularNominaCommand());
		_availableCommands.put(Event.READ_DEPARTMENT_FORM, new ReadDepartmentToForm());

		/********************************* EMPLOYEE *********************************/
		_availableCommands.put(Event.REGISTER_EMPLOYEE, new CreateEmployeeCommand());
		_availableCommands.put(Event.UNSUBSCRIBE_EMPLOYEE, new DeleteEmployeeCommand());
		_availableCommands.put(Event.MODIFY_EMPLOYEE, new UpdateEmployeeCommand());
		_availableCommands.put(Event.READ_EMPLOYEE, new ShowOneEmployeeCommand());
		_availableCommands.put(Event.READ_ALL_EMPLOYEE, new ShowAllEmployeeCommand());
		_availableCommands.put(Event.UPDATE_LIST_EMPLOYEE, new UpdateComboBoxEmployee());
		_availableCommands.put(Event.READ_EMPLOYEE_FORM, new ReadEmployeeToForm());
		
		/********************************** REALIZA **********************************/
		_availableCommands.put(Event.REALIZA_ASIGNAR, new RealizaAsignarCommand());
		_availableCommands.put(Event.REALIZA_DESASIGNAR, new RealizaDesasignarCommand());
		_availableCommands.put(Event.REALIZA_MODIFICAR, new RealizaModificarCommand());

		/********************************** QUERIES **********************************/
		_availableCommands.put(Event.SHOW_PROVIDER_QUERY, new BestProviderQueryCommand());
		_availableCommands.put(Event.SHOW_PRODUCT_QUERY, new ProductCountQueryCommand());
		_availableCommands.put(Event.SHOW_TICKET_QUERY, new ProductsDateQueryCommand());
	}
}