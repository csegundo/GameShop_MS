package Command.ProductCommands;

import java.util.ArrayList;

import Command.Command;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Controller.Event;
import javafx.util.Pair;

public class ProductCountQueryCommand extends Command {

	@Override
	public Pair<Object, Integer> execute(Object data) throws Exception {
		ArrayList<Pair<String, Integer>> queryData = (ArrayList<Pair<String, Integer>>) SAAbstractFactory.getInstance()
				.createSAProduct().getProductsCount();
		Integer event = (queryData != null) ? Event.SHOW_PRODUCT_QUERY_OK : Event.SHOW_PRODUCT_QUERY_FAILED;
		return new Pair<Object, Integer>(queryData, event);
	}

}
