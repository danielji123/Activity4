import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;
/**
 * A BlusterCritter gets darker with >= c critters around and lighter
 * with < c critters around.
 * @author Daniel Ji
 */
public class BlusterCritter extends Critter
{
	 private int socialBattery;
	 private static final double COLOR_FACTOR = 0.05;
	 public BlusterCritter(int c)
	 {
		 super();
		 socialBattery = c;
	 } 
	 /**
	 * gets darker with >= c critters around and lighter
	 * with < c critters around.
	 * @param actors, a list of the actors around it
	 */
	 public void processActors(ArrayList<Actor> actors)
   {
		 int count ++;
		 for(Actor a : actors)
			if(a instanceof Critter)
				count++;
      if(actors.size() < socialBattery)
      {
				Color c = getColor();
				int red = (int) (c.getRed() * (1 + COLOR_FACTOR));
				int green = (int) (c.getGreen() * (1 + COLOR_FACTOR));
				int blue = (int) (c.getBlue() * (1 + COLOR_FACTOR));
				setColor(new Color(red, green, blue)); 
			}
      else
      {
				Color c = getColor();
				int red = (int) (c.getRed() * (1 - COLOR_FACTOR));
				int green = (int) (c.getGreen() * (1 - COLOR_FACTOR));
				int blue = (int) (c.getBlue() * (1 - COLOR_FACTOR));
				setColor(new Color(red, green, blue)); 
			}
   }
   /**
	 * gets all actors 2 away from it
	 * @return actors, a list of the actors around it
	 */
   public ArrayList<Actor> getActors()
	 {
		 ArrayList<Actor> actors = new ArrayList<Actor>();
		 for (Location loc : getLocationsInDirections(dirs))
		 {
			 Actor a = getGrid().get(loc);
			 if (a != null)
				actors.add(a);
		 }
		 return actors;
	 } 
	 /**
	 * Finds the valid adjacent locations of this critter in different
	 * directions.
	 * @param directions - an array of directions (which are relative to the
	 * current direction)
	 * @return a set of valid locations that are neighbors of the current
	 * location in the given directions
	 */
	 public ArrayList<Location> getLocationsInDirections(int[] directions)
	 {
		 ArrayList<Location> locs = new ArrayList<Location>();
		 Grid gr = getGrid();
		 Location loc = getLocation();
		 for (int d : directions)
		 {
			 Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
			 // any valid neighbors 1 away will be put into the list
			 if(gr.isValid(neighborLoc)) locs.add(neighborLoc);
		 }
		 for (int d : directions)
		 {
			 Location neighborLoc = loc.getAdjacentLocation(getDirection() + d).getAdjacentLocation(getDirection());
			 // any valid neighbors 2 away will be put into the list
			 if(gr.isValid(neighborLoc)) locs.add(neighborLoc);
		 }
		 return locs;
	}
		
