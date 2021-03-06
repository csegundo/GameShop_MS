package Presentacion.Command.RealizaCommand;

import Negocio.Realiza.RealizaEmbeddable;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Event;
import utils.Pair;

public class RealizaDesasignarCommand extends Command {

	@Override
	public Pair<Object, Integer> execute(Object data) throws Exception {
		RealizaEmbeddable datos = (RealizaEmbeddable)data;
		Boolean re = SAAbstractFactory.getInstance().createSARealiza().deleteRealiza(datos);
		Integer event = re == true  ? Event.REALIZA_DESASIGNAR_OK : Event.REALIZA_DESASIGNAR_FAILED;
		Pair<Object, Integer> ret = new Pair<Object, Integer>(re, event);
		return ret;
	}

}
