package areebaproject.xloop.dbwork;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService {
    private final Map<Integer, Item> itemDatabase = new HashMap<>();
    private int currentId = 1;

    // Create
    public Item createItem(Item item) {
        item.setId(currentId++);
        itemDatabase.put(item.getId(), item);
        return item;
    }

    // Read all
    public Collection<Item> getAllItems() {
        return itemDatabase.values();
    }

    // Read by ID
    public Item getItemById(int id) {
        return itemDatabase.get(id);
    }

    // Update
    public Item updateItem(int id, Item updatedItem) {
        if (itemDatabase.containsKey(id)) {
            updatedItem.setId(id);
            itemDatabase.put(id, updatedItem);
            return updatedItem;
        }
        return null;
    }

    // Delete
    public boolean deleteItem(int id) {
        return itemDatabase.remove(id) != null;
    }
}

