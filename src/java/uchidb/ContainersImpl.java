package uchidb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainersImpl<T,S> implements Containers<T,S> {
	
		private static ContainersImpl containers = new ContainersImpl();
		private ContainersImpl() {}

		public static ContainersImpl getInstance() {
			return containers;
		}

		private Map<S,T> p_map;
		// Create and return a set that stores the array of T objects
		// You do not need to create your own set implementation and 
		// can use an existing set class.
		public Set<T> initSet(T[] tArray){
			Set<T> s = new HashSet<T> ();
			for(int i=0;i<tArray.length;i++) {
				s.add(tArray[i]);
			}
			return s;
		}
		
		// Create and return a list that stores an the array of T objects
		// You do not need to create your own list implementation and 
		// can use an existing list class.
		public List<T> initList(T[] tArray){
			List<T> s = new ArrayList<T> ();
			for(int i=0;i<tArray.length;i++) {
				s.add(tArray[i]);
			}
			return s;
		};
		
		// Create and return an empty map that will use type S as keys, and T as values
		// You do not need to create your own map implementation and 
		// can use an existing map class.
		public Map<S,T> initEmptyMap() {
			Map<S,T> map = new HashMap<S,T>();
			return map;
		};
		
		// Store the map in a local field variable -- often called a setter 
		public void storeMap(Map<S,T> mapToStoreInClass) {
			p_map = mapToStoreInClass;
		}
		
		// Add a key value to the stored/local map with a boolean indicating whether to overwrite existing value
		// The return value indicates if you added the key value pair to the map
		// You do not need to check if the value changed or not (e.g. no need to compare values)
		public boolean addToMap(S key, T value, boolean overwriteExistingKey) {
			boolean b = true;
			if(p_map.containsKey(key)) {
				if (overwriteExistingKey) {
					p_map.put(key, value);
				} else {
					b = false;
				}
			} else {
				p_map.put(key, value);
			}
			return b;
		}
		
		// Return a value from the stored/local map based on the key
		public T getValueFromMap(S key) {
			T value = p_map.get(key);
			return value;
		}
		
		// An overloaded function to get a value from the store/local map, but with a default value
		// if the key is not present in the map.
		public T getValueFromMap(S key, T defaultValue) {
			if(p_map.containsKey(key)) {
				return p_map.get(key);
			} else {
				return defaultValue;
			}
		}
}
