package Presentacion.Command.EmployeeCommands;

import java.util.List;

import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Event;
import javafx.util.Pair;

public class ShowAllEmployeeCommand extends Command {

	@Override
	public Pair<Object, Integer> execute(Object data) throws Exception {
		List<Object> conferences = (SAAbstractFactory.getInstance().createSAEmpleado()).mostrarTodosLosEmpleados();
		Integer evento = (conferences == null) ? Event.RES_READALL_EMPLOYEE_FAILED : Event.RES_READALL_EMPLOYEE_OK;
		Pair<Object, Integer> p = new Pair<Object, Integer>(conferences, evento);
		return p;
	}

}
