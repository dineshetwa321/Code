package a.array.cond;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Room {
	int id;
	List<Room> neighbors;
	boolean isTreasureRoom;
}

/*
instructions_1 = [ 
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "tulip"], 
    ["rose", "rose"],
    ["violet", "rose"], 
    ["sunflower", "violet"],
    ["daisy", "violet"],
    ["iris", "violet"]
]

treasure_rooms_1 = ["lily", "tulip", "violet", "rose"]


 */
public class RoomPath {

	public static void main(String[] args) {

	}

	List<Room> findPath(Room source, Room destination) {
		Queue<Room> queue = new LinkedList<>();
		Map<Room, Room> parentMap = new HashMap<>(); // To reconstruct the path

		queue.add(source);
		parentMap.put(source, null);

		while (!queue.isEmpty()) {
			Room current = queue.poll();

			if (current.equals(destination)) {
				return reconstructPath(parentMap, destination);
			}

			for (Room neighbor : current.neighbors) {
				if (!parentMap.containsKey(neighbor)) {
					queue.add(neighbor);
					parentMap.put(neighbor, current);
				}
			}
		}
		return null; // No path found
	}

	List<Room> reconstructPath(Map<Room, Room> parentMap, Room destination) {
		List<Room> path = new ArrayList<>();
		for (Room at = destination; at != null; at = parentMap.get(at)) {
			path.add(at);
		}
		Collections.reverse(path);
		return path;
	}
}