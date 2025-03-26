import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
/**
 * A KingCrab scares all actors away, removing them if they can't.
 */
public class KingCrab extends CrabCritter
{
	 public KingCrab()
	 {
			setColor(Color.PINK);
	 } 
		/**
    * Scares away all actors on the list
    * @param actors the actors to be processed
    */
    public void processActors(ArrayList<Actor> actors)
    {
				Grid g = getGrid();
        for (Actor a : actors)
        {
					Location newLoc = a.getAdjacentLocation(getArcTan(a));
					if(g.isValid(newLoc) && newLoc == null)
						a.moveTo(newLoc);
					else
						a.removeSelfFromGrid();
        }
    }
    // gets the approximate angle between a given actor and the kingcrab.
    private int getArcTan(Actor a)
    {
				Location loc1 = a.getLocation();
				Location loc2 = getLocation();
				int x1 = loc1.getRow();
				int y1 = loc1.getCol();
				int x2 = loc2.getRow();
				int y2 = loc2.getCol();
				int ret = (int)(Math.atan((y2 - y1)/(x2 - x1)));
				if(ret < 0) return ret + 360;
				else return ret;
		}
}
