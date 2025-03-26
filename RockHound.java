import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
/**
 * A RockHound eats random rocks adjacent to it when it moves around
 * @author Daniel Ji
 */
public class RockHound extends Critter
{
	 /**
	 * Processes the actors. Implemented to "eat" (i.e. remove) all rocks
	 * <br />
	 * Precondition: All objects in <code>actors</code> are contained in the
	 * same grid as this critter.
	 * @param actors the actors to be processed
	 */
	 public void processActors(ArrayList<Actor> actors)
	 {
		 // the exact same thing as Critter, but only removes rocks.
		 for (Actor a : actors)
		 {
			 if (a instanceof Rock)
				a.removeSelfFromGrid();
		 }
	 }
}
