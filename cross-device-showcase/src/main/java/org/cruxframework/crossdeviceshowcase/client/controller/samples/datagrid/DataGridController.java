package org.cruxframework.crossdeviceshowcase.client.controller.samples.datagrid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import org.cruxframework.crossdeviceshowcase.client.controller.samples.grid.GridMessages;
import org.cruxframework.crux.core.client.bean.BeanCopier;
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
import org.cruxframework.crux.smartfaces.client.grid.PageableDataGrid.CellEditor;
import org.cruxframework.crux.smartfaces.client.label.Label;
import org.cruxframework.crux.smartfaces.client.pager.PredictivePager;
import org.cruxframework.crux.widgets.client.datepicker.DatePicker;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
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
			new org.cruxframework.crux.core.client.dataprovider.DataProvider.EditionDataHandler<Person>() 
			{
				public Person clone(Person object)
				{
					Person clone = new Person();
					personCloner.copyFrom(object, clone);
					return clone;
				}
			});
		dataProvider.setPageSize(5);

		final DataGrid<Person> grid = new DataGrid<Person>(dataProvider, false);
		dataProvider.setData(mockPersonData(16));

		grid.newColumn(new DataFactory<Label, Person>() 
		{
			@Override
			public Label createData(Person value)
			{
				return new Label(value.getName());
			}
		})
		.setHeaderWidget(new Label("column 1"))
		.setComparator(new Comparator<Person>()
		{
			public int compare(Person o1, Person o2) 
			{
				return o1.getName().compareTo(o2.getName());
			}
		})
		.setSortable(true);

		grid.newColumn(new DataFactory<Label, Person>()
		{
			@Override
			public Label createData(Person value)
			{
				return new Label( String.valueOf(value.getAge() > 2) );
			}
		})
		.setHeaderWidget(new Label("column 2"))
		.setComparator(new Comparator<Person>()
		{
			public int compare(Person o1, Person o2) 
			{
				if(o1.getAge() == o2.getAge())
				{
					return 0;
				} else if(o1.getAge() > o2.getAge())
				{
					return 1;
				} else
				{
					return -1;
				}
			}
		})
		.setSortable(true);

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
			public IsWidget createWidget(Person value)
			{
				TextBox textBox = new TextBox();
				textBox.setText(value.getProfession());
				return textBox;
			}

			@Override
			public void setProperty(Person value, String newValue)
			{
				value.setName(newValue);
			}
		})
		.setHeaderWidget(new Label("column 3"))
		.setComparator(new Comparator<Person>()
		{
			public int compare(Person o1, Person o2) 
			{
				return o1.getName().compareTo(o2.getName());
			}
		})
		.setSortable(true);

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
			public IsWidget createWidget(Person value)
			{
				return new DatePicker();
			}

			@Override
			public void setProperty(Person value, Date newValue)
			{
				value.setName(newValue.toString());
			}
		}).setHeaderWidget(new Label("column 4"));

		createGridInsideGrid(grid);

		FlowPanel wrapper = new FlowPanel();
		wrapper.add(grid);

		PredictivePager<Person> pager = new PredictivePager<Person>();
		wrapper.add(pager);

		//		ScrollablePager<Person> pager = new ScrollablePager<Person>();
		//		grid.setPager(pager);

		pager.setDataProvider(dataProvider, false);

		screen.panel().add(wrapper);

		testGRID(grid, wrapper);
	}

	private void createGridInsideGrid(final DataGrid<Person> grid)
	{
		grid.newColumn(new DataFactory<Label, Person>()
		{
			@Override
			public Label createData(Person value)
			{
				return new Label(value.getName());
			}
		}).setCellEditor(new CellEditor<Person, DataGrid<Person>>(true)
		{
			@Override
			public IsWidget createWidget(Person value)
			{

				final EagerPagedDataProvider<Person> dataProvider = new EagerPagedDataProvider<Person>(
					new org.cruxframework.crux.core.client.dataprovider.DataProvider.EditionDataHandler<Person>() 
					{
						public Person clone(Person object)
						{
							Person clone = new Person();
							personCloner.copyFrom(object, clone);
							return clone;
						}
					});
				dataProvider.setPageSize(5);

				final DataGrid<Person> grid = new DataGrid<Person>(dataProvider, false);
				dataProvider.setData(mockPersonData(2));
				grid.newColumn(new DataFactory<Label, Person>() 
				{
					@Override
					public Label createData(Person value)
					{
						return new Label(value.getName());
					}
				}).setHeaderWidget(new Label("column 1"));

				grid.newColumn(new DataFactory<Label, Person>()
				{
					@Override
					public Label createData(Person value)
					{
						return new Label( String.valueOf(value.getAge() > 2) );
					}
				}).setHeaderWidget(new Label("column 2"));				

				return grid;
			}

			@Override
			public void setProperty(Person value, DataGrid<Person> newValue)
			{
				value.setName(newValue.toString());
			}
		}).setHeaderWidget(new Label("column 5"));
	}

	private void testGRID(final DataGrid<Person> grid, FlowPanel wrapper) 
	{
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

		wrapper.add(commit);
		wrapper.add(rollback);

//		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() 
//		{
//			@Override
//			public boolean execute() 
//			{
//				Array<PageableDataGrid<Person>.Row> rows = grid.getRows();
//				for(int i = 0 ; i < rows.size() ; i++)
//				{
//					rows.get(i).edit();
//				}

//				Scheduler.get().scheduleFixedDelay(new RepeatingCommand() 
//				{
//					@Override
//					public boolean execute() 
//					{
//						grid.setEnabled(false);
//						return false;
//					}
//				}, 2000);

//				return false;
//			}
//		}, 2000);
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
