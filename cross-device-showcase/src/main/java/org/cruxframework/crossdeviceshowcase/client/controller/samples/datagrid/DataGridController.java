package org.cruxframework.crossdeviceshowcase.client.controller.samples.datagrid;

import java.util.ArrayList;
import java.util.Date;

import org.cruxframework.crossdeviceshowcase.client.controller.samples.grid.GridMessages;
import org.cruxframework.crux.core.client.bean.BeanCopier;
import org.cruxframework.crux.core.client.collection.Array;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.EagerPagedDataProvider;
import org.cruxframework.crux.core.client.dto.DataObject;
import org.cruxframework.crux.core.client.event.SelectEvent;
import org.cruxframework.crux.core.client.event.SelectHandler;
import org.cruxframework.crux.core.client.factory.DataFactory;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.grid.DataGrid;
import org.cruxframework.crux.smartfaces.client.grid.PageableDataGrid;
import org.cruxframework.crux.smartfaces.client.grid.PageableDataGrid.CellEditor;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.smartfaces.client.pager.ScrollablePager;
import org.cruxframework.crux.widgets.client.datepicker.DatePicker;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;

@Controller("dataGridController")
public class DataGridController
{
	@DataObject("personGrid")
	public static class Person 
	{
		private String name; 
		private int age;
		private String profession;

		public Person()
		{
		}

		public Person(String name, int age, String profession)
		{
			this.name = name;
			this.age = age;
			this.profession = profession;
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		public int getAge() 
		{
			return age;
		}

		public void setAge(int age) 
		{
			this.age = age;
		}

		public String getProfession() 
		{
			return profession;
		}

		public void setProfession(String profession) 
		{
			this.profession = profession;
		}
	}

	@Inject
	private MyWidgetAccessor screen;

	@Inject
	private GridMessages messages;

	@Expose
	public void onLoad()
	{
		screen.htmlDescText().setHTML(messages.htmlDescText());

		loadData();
	}

	/**
	 * Interface que possibilita a copia de um bean para o outro.
	 */
	public static interface DataCopier extends BeanCopier<Person, Person> 
	{
	}

	@Inject
	private DataCopier personCloner;

	public void setPersonCloner(DataCopier personCloner) 
	{
		this.personCloner = personCloner;
	}

	private <T> void loadData()
	{
		final EagerPagedDataProvider<Person> dataProvider = new EagerPagedDataProvider<Person>(
		new org.cruxframework.crux.core.client.dataprovider.DataProvider.DataHandler<Person>() {
			public Person clone(Person object)
			{
				Person clone = new Person();
				personCloner.copyFrom(object, clone);
				return clone;
			}
		}
		);
		dataProvider.setPageSize(5);

		final DataGrid<Person> grid = new DataGrid<Person>(dataProvider, false);
		dataProvider.setData(mockPersonData());
		
		grid.newColumn(new DataFactory<Label, Person>() 
				{
			@Override
			public Label createData(Person value)
			{
				return new Label(value.getName());
			}
				});

		grid.newColumn(new DataFactory<Label, Person>()
		{
			@Override
			public Label createData(Person value)
			{
				return new Label( String.valueOf(value.getAge() > 2) );
			}
		});

		grid.newColumn(new DataFactory<Label, Person>()
				{
			@Override
			public Label createData(Person value)
			{
				return new Label(value.getName());
			}
				}).setCellEditor(new CellEditor<Person, String>(true)
						{
					@Override
					public HasValue<String> getWidget(Person value)
					{
						TextBox textBox = new TextBox();
						textBox.setText(value.getName());
						return textBox;
					}

					@Override
					public void setProperty(Person value, String newValue)
					{
						value.setName(newValue);
					}
						});

		grid.newColumn(new DataFactory<Label, Person>()
				{
			@Override
			public Label createData(Person value)
			{
				return new Label(value.getName());
			}
				}).setCellEditor(new CellEditor<Person, Date>(true)
						{
					@Override
					public HasValue<Date> getWidget(Person value)
					{
						return new DatePicker();
					}

					@Override
					public void setProperty(Person value, Date newValue)
					{
						value.setName(newValue.toString());
					}
						});

		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() 
		{
			@Override
			public boolean execute() 
			{
				Array<PageableDataGrid<Person>.Row> rows = grid.getRows();
				for(int i = 0 ; i < rows.size() ; i++)
				{
					rows.get(i).edit();
				}
				return false;
			}
		}, 2000);

//		PredictivePager pager = new PredictivePager();
		ScrollablePager<Person> pager = new ScrollablePager<Person>();
		pager.setDataProvider(dataProvider, false);
		
		Button commit = new Button();
		commit.setText("Commit");
		commit.addSelectHandler(new SelectHandler() 
		{
			@Override
			public void onSelect(SelectEvent event) 
			{
				grid.commit();
			}
		});
		
		Button rollback = new Button();
		rollback.setText("Rollback");
		rollback.addSelectHandler(new SelectHandler() 
		{
			@Override
			public void onSelect(SelectEvent event) 
			{
				grid.rollback();
			}
		});
		
		FlowPanel fp = new FlowPanel();
		
		fp.add(grid);
		
		fp.add(pager);
		fp.add(commit);
		fp.add(rollback);
		
//		RootPanel.get().add(fp);
		screen.panel().add(fp);
	}

	private ArrayList<Person> mockPersonData()
	{
		ArrayList<Person> people = new ArrayList<Person>();

		people.add(mockPerson(1));
		people.add(mockPerson(2));
		people.add(mockPerson(3));
		people.add(mockPerson(4));
		people.add(mockPerson(5));
		people.add(mockPerson(6));
		people.add(mockPerson(7));
		people.add(mockPerson(8));
		people.add(mockPerson(9));
		people.add(mockPerson(10));
		people.add(mockPerson(11));
		people.add(mockPerson(12));
		people.add(mockPerson(13));
		people.add(mockPerson(14));
		people.add(mockPerson(15));
		people.add(mockPerson(16));
		people.add(mockPerson(17));
		people.add(mockPerson(18));
		

		return people;
	}

	private Person mockPerson(int seed)
	{
		return new Person("name_" + seed, seed, "professiona_" + seed);
	}

	@BindView("datagrid")
	public static interface MyWidgetAccessor extends WidgetAccessor
	{
		HTML htmlDescText();
		FlowPanel panel();
	}

	public void setMessages(GridMessages messages) {
		this.messages = messages;
	}

	public MyWidgetAccessor getScreen()
	{
		return screen;
	}

	public void setScreen(MyWidgetAccessor screen)
	{
		this.screen = screen;
	}
}
