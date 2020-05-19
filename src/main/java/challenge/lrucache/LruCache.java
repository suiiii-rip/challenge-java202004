package challenge.lrucache;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LruCache {
  private final int capacity;

  private Map<Integer, Entry> storage;

  private LruList lru;

  public LruCache(int capacity) {
    this.capacity = capacity;

    storage = new HashMap<>();
    lru = new LruList();
  }

  public int get(int key) {

    return Optional.ofNullable(storage.get(key))
      .map(entry -> lru.bump(entry))
      .orElse(-1);
  }

  public int put(int key, int value) {

    Entry oldEntry = storage.get(key);
    if (oldEntry != null) {
      oldEntry.value = value;
      lru.bump(oldEntry);
    } else {
    Entry entry = new Entry(key, value);
    lru.add(entry)
      .ifPresent(old -> storage.remove(old.key));
    storage.put(key, entry);
    }


    return value;
  }

  private class LruList {

    private Entry start, end = null;

    private int items = 0;

    public Optional<Entry> add(Entry entry) {
      if (end == null) {
        end = entry;
      }

      if (start != null) {
        start.previous = entry;
      }
      entry.next = start;
      start = entry;

      if (items >= capacity) {
        // remove the last element
        if (end.previous != null) {
          end.previous.next = null;
        }
        Optional<Entry> result = Optional.of(this.end);
        end = end.previous;
        return result;
      }

      items++;
      return Optional.empty();
    }

    public int bump(Entry entry) {

      if (entry.next == null) {
        if (entry.previous != null) {
          end = entry.previous;
          entry.previous.next = null;
        }
      } else {
        if (entry.previous != null) {
          entry.previous.next = entry.next;
          entry.next.previous = entry.previous;
        }
      }
      entry.previous = null;
      if (entry != start) {
        entry.next = start;
        if (start != null) {
          start.previous = entry;
        }
      }
      start = entry;

      return entry.value;
    }

  }
    private static class Entry {
      private final int key;

      private int value;

      private Entry previous, next;

      public Entry(int key, int value) {
        this.key = key;
        this.value = value;
      }

    }
}
