/**
 * 
 */
package org.cruxframework.crossdeviceshowcase.client.controller.samples.offlinedatabase;


import java.util.ArrayList;

import org.cruxframework.crossdeviceshowcase.client.util.messages.ShowcaseMessages;
import org.cruxframework.crux.core.client.Crux;
import org.cruxframework.crux.core.client.collection.Array;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.dataprovider.DataProviderRecord;
import org.cruxframework.crux.core.client.dataprovider.DataSelectionEvent;
import org.cruxframework.crux.core.client.dataprovider.DataSelectionHandler;
import org.cruxframework.crux.core.client.db.Cursor;
import org.cruxframework.crux.core.client.db.DatabaseCallback;
import org.cruxframework.crux.core.client.db.DatabaseCursorCallback;
import org.cruxframework.crux.core.client.db.DatabaseRetrieveCallback;
import org.cruxframework.crux.core.client.db.DatabaseWriteCallback;
import org.cruxframework.crux.core.client.db.ObjectStore;
import org.cruxframework.crux.core.client.db.Transaction;
import org.cruxframework.crux.core.client.db.Transaction.Mode;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.core.client.screen.views.ViewActivateEvent;
import org.cruxframework.crux.core.client.screen.views.ViewLoadEvent;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.dialog.DialogViewContainer;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox;
import org.cruxframework.crux.smartfaces.client.dialog.MessageBox.MessageType;
import org.cruxframework.crux.smartfaces.client.grid.DataGrid;

import com.google.gwt.core.client.GWT;

/**
 * @author Thiago da Rosa de Bustamante
 *
 */
@Controller("offlineDatabaseController")
public class OfflineDatabaseController 
{
	private static final String PERSON = "person";

	private static CompanyDatabase database = null;

	@Inject
	private DatabaseWidgets databaseWidgets;
	
	@Inject
	private ShowcaseMessages messages;
	
	@Inject
	private DatabaseMessages databaseMessages;

	private static DialogViewContainer dialog = null;
	
	@Expose
	public void add()
	{
		dialog = DialogViewContainer.createDialog(PERSON);
		dialog.center();
	}

	@Expose
	public void onLoadDialog(ViewLoadEvent event)
	{
		if(event.getParameterObject() != null)
		{
			View.of(this).write(event.getParameterObject());
		}
	}
	
	@Expose
	public void onLoad()
	{
		databaseWidgets.peopleGrid().getDataProvider().addDataSelectionHandler(new DataSelectionHandler<Person>()
		{
			@Override
			public void onDataSelection(DataSelectionEvent<Person> event)
			{
				Array<DataProviderRecord<Person>> changedRecords = event.getChangedRecords();
				if(changedRecords != null)
				{
					for(int i=0;i<changedRecords.size();i++)
					{
						Person person = changedRecords.get(i).getRecordObject();
						if(changedRecords.get(i).isSelected())
						{
							Transaction transaction = database.getTransaction(new String[]{Person.STORE_NAME}, Mode.readOnly);
							ObjectStore<Integer, Person> personStore = transaction.getObjectStore(Person.STORE_NAME);
							personStore.get(person.getId(), new DatabaseRetrieveCallback<Person>() 
							{
								@Override
								public void onSuccess(Person person) 
								{
									dialog = DialogViewContainer.createDialog(PERSON, PERSON, true, person);
									dialog.center();
								}
							});
						}
					}
				}
			}
		});
	}
	
	@Expose
	public void onLoadData() 
	{
		database = GWT.create(CompanyDatabase.class);
		
		if (!database.isSupported())
		{
			Crux.getErrorHandler().handleError(messages.databaseNotSupportedError());
		}
		else 
		{
			if (!database.isOpen())
			{
				database.open(new DatabaseCallback() 
				{
					@Override
					public void onSuccess() 
					{
						try
						{
							final ArrayList<Person> peopleDB = new ArrayList<Person>();
							
							Transaction transaction = database.getTransaction(new String[]{Person.STORE_NAME}, Mode.readOnly);
							ObjectStore<Integer, Person> personStore = transaction.getObjectStore(Person.STORE_NAME);
							
							personStore.openCursor(new DatabaseCursorCallback<Integer, Person>()
							{
								@Override
								public void onSuccess(Cursor<Integer, Person> result)
								{
									if(result == null)
									{
										databaseWidgets.peopleGrid().getDataProvider().setData(peopleDB);
										databaseWidgets.peopleGrid().refresh();
									}
									else
									{
										peopleDB.add(result.getValue());
										result.continueCursor();
									}
								}
							});	
						} catch (Exception e)
						{
							//do nothing - no records found
						}
					}
				});
			}
			else
			{
				databaseWidgets.peopleGrid().loadData();
			}
		}
	}

	@Expose
	public void openPersonView(ViewActivateEvent event)
	{
		Person person = event.getParameterObject();
		if (person == null)
		{
			person = new Person();
		}
		View.of(this).write(person);
	}
	
	@Expose
	public void savePerson()
	{
		Person person = View.of(this).read(Person.class);
		
		Transaction transaction = database.getTransaction(new String[]{Person.STORE_NAME}, Mode.readWrite);
		ObjectStore<Integer, Person> personStore = transaction.getObjectStore(Person.STORE_NAME);
		personStore.put(person, new DatabaseWriteCallback<Integer>() 
		{
			@Override
			public void onSuccess(Integer result) 
			{
				onLoadData();
				MessageBox.show(databaseMessages.saveSuccessfully(), MessageType.SUCCESS);
				if(dialog != null)
				{
					dialog.hide();
					dialog.removeFromParent();
				}
			}
		});			
	}
	
	@Expose
	public void removePerson()
	{
		Person person = View.of(this).read(Person.class);
		
		Transaction transaction = database.getTransaction(new String[]{Person.STORE_NAME}, Mode.readWrite);
		ObjectStore<Integer, Person> personStore = transaction.getObjectStore(Person.STORE_NAME);
		personStore.delete(person.getId());
		onLoadData();
		MessageBox.show(databaseMessages.removeSuccessfully(), MessageType.SUCCESS);
		if(dialog != null)
		{
			dialog.hide();
			dialog.removeFromParent();
		}
	}
	
	public void setDatabaseWidgets(DatabaseWidgets view) 
	{
		this.databaseWidgets = view;
	}
	
	public void setMessages(ShowcaseMessages messages) 
	{
		this.messages = messages;
	}
	
	@BindView("offlineDatabase")
	public static interface DatabaseWidgets extends WidgetAccessor
	{
		DataGrid<Person> peopleGrid();
	}
	
	public void setDatabaseMessages(DatabaseMessages databaseMessages)
	{
		this.databaseMessages = databaseMessages;
	}
}
