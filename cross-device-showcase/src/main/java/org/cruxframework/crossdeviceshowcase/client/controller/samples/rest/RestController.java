package org.cruxframework.crossdeviceshowcase.client.controller.samples.rest;

import java.util.ArrayList;

import org.cruxframework.crux.core.client.collection.Array;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.DataProviderRecord;
import org.cruxframework.crux.core.client.dataprovider.DataSelectionEvent;
import org.cruxframework.crux.core.client.dataprovider.DataSelectionHandler;
import org.cruxframework.crux.core.client.dataprovider.EagerLoadEvent;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.smartfaces.client.grid.DataGrid;

@Controller("restController")
public class RestController 
{
	@Inject
	private RestMessages messages;
	
	@Inject
	private PersonRestProxy personRestProxy; 
	
	@Inject
	private Widgets view;

	@Expose
	public void onLoadData(final EagerLoadEvent<PersonDTO> event)
	{
		clearFields();
		
		personRestProxy.search(new RestCallback<ArrayList<PersonDTO>>()
		{
			@Override
			public void onComplete(ArrayList<PersonDTO> result)
			{
				if(result != null)
				{
					event.getSource().setData(result.toArray(new PersonDTO[result.size()]));
				}
			}
		});
	}
	
	@Expose
	public void onLoad()
	{
		view.grid().getDataProvider().addDataSelectionHandler(new DataSelectionHandler<PersonDTO>()
		{
			@Override
			public void onDataSelection(DataSelectionEvent<PersonDTO> event)
			{
				Array<DataProviderRecord<PersonDTO>> changedRecords = event.getChangedRecords();
				for(int i = 0; i<changedRecords.size(); i++)
				{
					DataProviderRecord<PersonDTO> dataProviderRecord = changedRecords.get(i);
					
					if(dataProviderRecord.isSelected())
					{
						personRestProxy.get(dataProviderRecord.getRecordObject().getId(), new RestCallback<PersonDTO>()
						{
							@Override
							public void onComplete(PersonDTO result)
							{
								if(result == null)
								{
									MessageBox.show(messages.thisIsASample(), MessageType.INFO);
								}
								else
								{
									View.of(RestController.this).write(result);			
								}
							}
						});	
					}
					
				}
			}
		});
	}

	@Expose
	public void onSelectCreate()
	{
		clearFields();
	}
	
	private void clearFields()
	{
		View.of(this).write(new PersonDTO());
	}
	
	@Expose
	public void onSelectSave()
	{
		final PersonDTO person = View.of(this).read(PersonDTO.class);
		
		if(person.getId() != null)
		{
			personRestProxy.update(person.getId(), person, new RestCallback<Void>()
			{
				@Override
				public void onComplete(Void result)
				{
					view.grid().getDataProvider().remove(view.grid().getDataProvider().indexOf(person));
					view.grid().getDataProvider().add(person);
					MessageBox.show(messages.successUpdate(), MessageType.INFO);
				}
			});
		}
		else
		{
			personRestProxy.save(person, new RestCallback<Integer>()
			{
				@Override
				public void onComplete(Integer id)
				{
					person.setId(id);
					View.of(RestController.this).write(person);
					view.grid().getDataProvider().add(person);
					MessageBox.show(messages.successSave(), MessageType.INFO);
				}
			});
		}
	}
	
	@Expose
	public void onSelectRemove()
	{
		final PersonDTO person = View.of(this).read(PersonDTO.class);
		
		if(person.getId() == null)
		{
			MessageBox.show(messages.selectPerson(), MessageType.INFO);
			return;
		}
		
		personRestProxy.remove(person.getId(), new RestCallback<Void>()
		{
			@Override
			public void onComplete(Void result)
			{
				view.grid().getDataProvider().remove(view.grid().getDataProvider().indexOf(person));
				clearFields();
				MessageBox.show(messages.successRemove(), MessageType.INFO);
			}
		});
	}
	
	public void setMessages(RestMessages messages)
	{
		this.messages = messages;
	}
	
	public void setPersonRestProxy(PersonRestProxy personRestProxy)
	{
		this.personRestProxy = personRestProxy;
	}
	
	public void setView(Widgets view)
	{
		this.view = view;
	}
	
	@BindView("rest")
	public static interface Widgets extends WidgetAccessor
	{
		DataGrid<PersonDTO> grid();
	}
}
