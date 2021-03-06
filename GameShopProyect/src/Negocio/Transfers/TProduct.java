package Negocio.Transfers;

/**
 * @author GameShop
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TProduct {

	public static final String game = "VideoGame";
	public static final String accessory = "Accessory";

	private String _name;
	private Integer _stock; // La cantidad total de ese producto en la tienda
	private Double _pvp;
	private Integer _id;
	private String _type;
	private Integer _providerId;
	private Boolean _activated;
	private Integer _unitsProvided;
	private String _description;

	public TProduct(String name, Integer stock, Double pvp, String type, Integer provider, String desc) {
		this._name = name;
		this._unitsProvided = stock;
		this._stock = stock;
		this._pvp = pvp;
		this._type = type;
		this._providerId = provider;
		this._activated = true;
		this._description = desc;
	}

	public TProduct() {
		// Constructor vacío
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Integer get_stock() {
		return _stock;
	}

	public void set_stock(Integer _stock) {
		this._stock = _stock;
	}

	public Double get_pvp() {
		return _pvp;
	}

	public void set_pvp(Double _pvp) {
		this._pvp = _pvp;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public String get_type() {
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}

	public Integer get_providerId() {
		return _providerId;
	}

	public void set_providerId(Integer _employeeId) {
		this._providerId = _employeeId;
	}

	public Boolean get_activated() {
		return _activated;
	}

	public void set_activated(Boolean _activated) {
		this._activated = _activated;
	}

	public Integer get_unitsProvided() {
		return _unitsProvided;
	}

	public void set_unitsProvided(Integer _unitsProvided) {
		this._unitsProvided = _unitsProvided;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

}