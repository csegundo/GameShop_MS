package Presentacion.View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Negocio.SA.SAAbstractFactory;
import Negocio.Transfers.TConferencia;
import Negocio.Transfers.TDepartamento;
import Negocio.Transfers.TEmpleado;
import Negocio.Transfers.TProduct;
import Negocio.Transfers.TProvider;
import Negocio.Transfers.TTicket;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;

@SuppressWarnings("serial")
public class ShowOne extends JPanel {

	private JComboBox<Object> _election;
	private JButton _show;
	private JTextArea _info;
	private String nameIdentificator;

	public ShowOne(String nameIdentificator) {
		this.nameIdentificator = nameIdentificator.toLowerCase();
		initGUI();
	}

	private void initGUI() {
		this.setPreferredSize(new Dimension(400, 300));
		this.setMinimumSize(new Dimension(400, 300));
		this.setMaximumSize(new Dimension(400, 300));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		initComponents();

		this.setVisible(true);
	}

	private void addShowButtonAction() {
		_show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (_election.getItemCount() > 0) {
					Integer id = Integer.parseInt(_election.getSelectedItem().toString().split(" - ")[0]);
					switch (nameIdentificator) {
					case "provider":
						Controller.getInstance().action(id, Event.READ_PROVIDER);
						break;
					case "product":
						Controller.getInstance().action(id, Event.READ_PRODUCT);
						break;
					case "ticket":
						Controller.getInstance().action(id, Event.READ_TICKET);
						break;
					case "conference":
						Controller.getInstance().action(id, Event.READ_CONFERENCE);
						break;
					case "department":
						Controller.getInstance().action(id, Event.READ_DEPARTMENT);
						break;
					case "employee":
						Controller.getInstance().action(id, Event.READ_EMPLOYEE);
						break;
					}
				}
			}
		});
	}

	private void initComponents() {
		this.add(Box.createVerticalGlue());

		_election = new JComboBox<Object>();
		_election.setPreferredSize(new Dimension(200, 20));
		_election.setMinimumSize(new Dimension(200, 20));
		_election.setMaximumSize(new Dimension(200, 20));
		_election.setEditable(false);
		_election.setVisible(true);
		this.add(_election);

		this.add(Box.createRigidArea(new Dimension(1, 10)));

		_show = new JButton("Show");
		_show.setAlignmentX(CENTER_ALIGNMENT);
		_show.setSize(new Dimension(100, 30));
		_show.setMinimumSize(new Dimension(100, 30));
		_show.setMaximumSize(new Dimension(100, 30));
		this.add(_show);
		_show.setVisible(true);

		this.add(Box.createRigidArea(new Dimension(1, 30)));

		_info = new JTextArea();
		_info.setWrapStyleWord(true);
		_info.setLineWrap(true);
		_info.setPreferredSize(new Dimension(300, 190));
		_info.setMinimumSize(new Dimension(300, 190));
		_info.setMaximumSize(new Dimension(300, 190));
		_info.setEditable(false);
		_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1),
				"Detailed data", TitledBorder.LEFT, TitledBorder.TOP));
		_info.setFont(new Font("Arial", 0, 11));
		_info.setVisible(true);
		this.add(new JScrollPane(_info, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		this.add(Box.createVerticalGlue());

		addShowButtonAction();
	}

	public void fillList(List<Object> l) {
		_election.removeAllItems();
		if (l != null) {
			switch (nameIdentificator) {
			case "provider":
				for (Object tpro : SAAbstractFactory.getInstance().createSAProvider().readAllProviders())
					_election.addItem(((TProvider) tpro).get_id() + " - " + ((TProvider) tpro).get_nif());
				break;
			case "product":
				for (Object temp : SAAbstractFactory.getInstance().createSAProduct().readAllProducts())
					_election.addItem(((TProduct) temp).get_id() + " - " + ((TProduct) temp).get_type() + " - "
							+ ((TProduct) temp).get_name());
				break;
			case "ticket":
				for (Object tt : SAAbstractFactory.getInstance().createSATicket().readAllTickets())
					_election.addItem(((TTicket) tt).get_id() + " - " + ((TTicket) tt).get_date());
				break;

			/*****************************************************************************************************************/

			case "conference":
				for (Object o : l)
					_election.addItem(((TConferencia) o).getID() + " - " + ((TConferencia) o).getNombre());
				break;
			case "department":
				for (Object o : l)
					_election.addItem(((TDepartamento) o).getID() + " - " + ((TDepartamento) o).getNombre());
				break;
			case "employee":
				for (Object o : l)
					_election.addItem(((TEmpleado) o).getID() + " - " + ((TEmpleado) o).getNombre());
				break;
			}
		}
	}

	public void update(List<Object> l) {
		fillList(l);
	}

	public void set_info(String text) {
		_info.setText(text);
	}
}