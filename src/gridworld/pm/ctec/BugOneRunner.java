package gridworld.pm.ctec;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class BugOneRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		world.add(new Location(3, 3), new ChameleonCritter());
		world.add(new Location(3, 2), new Rock());
		world.add(new Location(3, 4), new Rock());
		world.add(new Location(2, 3), new Rock());
		world.add(new Location(4, 3), new Rock());
		world.show();
	}
}
