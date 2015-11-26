package org.cruxframework.crossdeviceshowcase.client.controller.samples.datagrid;

import java.util.ArrayList;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.EagerLoadEvent;
import org.cruxframework.crux.core.client.event.SelectEvent;
import org.cruxframework.crux.core.client.event.SelectHandler;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.grid.CellEditor;
import org.cruxframework.crux.smartfaces.client.grid.DataGrid;
import org.cruxframework.crux.smartfaces.client.grid.GridDataFactory;
import org.cruxframework.crux.smartfaces.client.label.Label;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;

@Controller("dataGridController")
public class DataGridController
{
	@Inject
	private DataGridMessages dataGridMessages;

	@Inject
	private Widgets view;
	
	@Expose
	public void onLoad()
	{
		createActionColumn(view.grid());
		view.grid().refresh();
	}

	@Expose
	public void onLoadData(EagerLoadEvent<Person> event)
	{
		event.getSource().setData(mockPersonData(10));
	}

	public void setDataGridMessages(DataGridMessages dataGridMessages)
	{
		this.dataGridMessages = dataGridMessages;
	}

	public void setView(Widgets view)
	{
		this.view = view;
	}

	@Expose
	public void onSelectEditAll()
	{
		view.grid().editAllRows();
	}
	
	@Expose
	public void onSelectCommit()
	{
		view.grid().commit();
	}
	
	@Expose
	public void onSelectRollback()
	{
		view.grid().rollback();
	}

	private void createActionColumn(final DataGrid<Person> grid)
	{
		grid.newColumn(new GridDataFactory<Person>()
		{
			@Override
			public Button createData(Person value, final int rowIndex)
			{
				Button edit = new Button();
				edit.setText(dataGridMessages.edit());
				edit.addSelectHandler(new SelectHandler()
				{
					@Override
					public void onSelect(SelectEvent event)
					{
						grid.editRow(rowIndex);
					}
				});
				
				return edit;
			}
		}, "action").setCellEditor(new CellEditor<Person, String>(true)
		{
			@Override
			public IsWidget createData(Person value, final int rowIndex)
			{
				FlowPanel wrapper = new FlowPanel();
				Button cancel = new Button();
				cancel.setText(dataGridMessages.back());
				cancel.addSelectHandler(new SelectHandler()
				{
					@Override
					public void onSelect(SelectEvent event)
					{
						grid.undoRowChanges(rowIndex);
					}
				});
				wrapper.add(cancel);
				
				Button ok = new Button();
				ok.setText(dataGridMessages.ok());
				ok.addSelectHandler(new SelectHandler()
				{
					@Override
					public void onSelect(SelectEvent event)
					{
						grid.makeRowChanges(rowIndex);
					}
				});
				wrapper.add(ok);
				return wrapper;
			}

			@Override
			public void setProperty(Person value, String newValue)
			{
				value.setName(newValue);
			}
		})
		.setHeaderWidget(new Label(dataGridMessages.action()));
	}

	private Person mockPerson(int seed)
	{
		return new Person("name_" + seed, "lastName_" + seed, seed, "profession_" + seed);
	}
	
	private ArrayList<Person> mockPersonData(int numItems)
	{
		ArrayList<Person> people = new ArrayList<Person>();

		for(int i=0;i<numItems;i++)
		{
			people.add(mockPerson(i));
		}

		return people;
	}
	
	@BindView("datagrid")
	public static interface Widgets extends WidgetAccessor
	{
		DataGrid<Person> grid();
	}
}
