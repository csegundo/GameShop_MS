package Presentacion.Command;

import utils.Pair;


public abstract class Command {
	
	//devuelve una pair con lo que recibe del SA y el evento asociado
	public abstract Pair<Object, Integer> execute(Object data) throws Exception;
}
