package org.cruxframework.crossdeviceshowcase.client.controller.samples.datagrid;

import java.util.ArrayList;

import org.cruxframework.crossdeviceshowcase.client.util.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.collection.Array;
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
import org.cruxframework.crux.smartfaces.client.grid.Row;
import org.cruxframework.crux.smartfaces.client.label.Label;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;

@Controller("dataGridController")
public class DataGridController
{
	@Inject
	private DataGridMessages dataGridMessages;
	
	@Inject
	private DescriptionMessages messages;

	@Inject
	private Widgets view;
	
	@Expose
	public void onLoad()
	{
		view.componentDescription().setHTML(messages.dataGridDescription());
		makeColumnNameEditable();
		createActionColumn(view.grid());
		addDataInterationButtons(view.grid());
		view.grid().redraw();
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

	public void setMessages(DescriptionMessages messages)
	{
		this.messages = messages;
	}

	public void setView(Widgets view)
	{
		this.view = view;
	}

	private void addDataInterationButtons(final DataGrid<Person> grid) 
	{
		FlowPanel wrapper = new FlowPanel();
		Button editAll = new Button();
		editAll.setText(dataGridMessages.editAll());
		editAll.addSelectHandler(new SelectHandler() 
		{
			@Override
			public void onSelect(SelectEvent event) 
			{
				Array<Row<Person>> rows = grid.getCurrentPageRows();
				for(int i = 0 ; i < rows.size() ; i++)
				{
					rows.get(i).edit();
				}
			}
		});
		
		
		Button commit = new Button();
		commit.setText(dataGridMessages.commit());
		commit.addSelectHandler(new SelectHandler() 
		{
			@Override
			public void onSelect(SelectEvent event) 
			{
				grid.commit();
			}
		});

		Button rollback = new Button();
		rollback.setText(dataGridMessages.rollback());
		rollback.addSelectHandler(new SelectHandler() 
		{
			@Override
			public void onSelect(SelectEvent event) 
			{
				grid.rollback();
			}
		});

		wrapper.add(editAll);
		wrapper.add(commit);
		wrapper.add(rollback);
		view.panel().add(wrapper);
	}

	private void createActionColumn(DataGrid<Person> grid)
	{
		grid.newColumn(new GridDataFactory<Person, Button>()
		{
			@Override
			public Button createData(Person value, final Row<Person> row)
			{
				Button edit = new Button();
				edit.setText(dataGridMessages.edit());
				edit.addSelectHandler(new SelectHandler()
				{
					@Override
					public void onSelect(SelectEvent event)
					{
						row.edit();
					}
				});
				
				return edit;
			}
		}, "action").setCellEditor(new CellEditor<Person, String>(true)
		{
			@Override
			public IsWidget createData(Person value, final Row<Person> row)
			{
				FlowPanel wrapper = new FlowPanel();
				Button cancel = new Button();
				cancel.setText(dataGridMessages.back());
				cancel.addSelectHandler(new SelectHandler()
				{
					@Override
					public void onSelect(SelectEvent event)
					{
						row.undoChanges();
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
						row.makeChanges();
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

	private void makeColumnNameEditable()
	{
		view.grid().getColumn("name").setCellEditor(new CellEditor<Person, String>()
		{
			@Override
			public IsWidget createData(Person value, Row<Person> row)
			{
				TextBox textBox = new TextBox();
				textBox.setValue(value.getName());
				textBox.setVisibleLength(8);
				return textBox;
			}

			@Override
			public void setProperty(Person dataObject, String object)
			{
				dataObject.setName(object);
			}
		});
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
		HTML componentDescription();
		DataGrid<Person> grid();
		FlowPanel panel();
	}
}
