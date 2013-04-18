package fr.labri.harmony.core;

import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.node.ObjectNode;

import fr.labri.harmony.core.model.Action;
import fr.labri.harmony.core.model.Author;
import fr.labri.harmony.core.model.Data;
import fr.labri.harmony.core.model.Event;
import fr.labri.harmony.core.model.Item;
import fr.labri.harmony.core.model.Source;

public interface Dao {
	
	final static String HARMONY_PERSISTENCE_UNIT = "harmony";
	
	static final Logger LOGGER = Logger.getLogger("fr.labri.harmony.core");
	
	Dao create(ObjectNode config);
	
	void saveSource(Source s);
	
	Source getSource(int id);
	
	void refreshElement(Object o);
	
	Event getEvent(Source s, String nativeId);
	
	List<Event> getEvents(Source s);
	
	void saveEvent(Event e);
	
	void saveItem(Item i);
	
	Item getItem(Source s, String nativeId);
	
	void saveAuthor(Author a);
	
	Author getAuthor(Source s, String nativeId);
	
	void saveAction(Action a);
	
	List<Action> getActions(Source s);
	
	void saveData(String analysis, Data d, int elementKind, int elementId);
	
	<D extends Data> List<D> getDataList(String analysis, Class<D> d, int elementKind, int elementId);
	
	<D extends Data> D getData(String analysis, Class<D> d, int elementKind, int elementId);
	
	void disconnect();

}
