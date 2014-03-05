package gridworld.pm.ctec;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class SpawnBug extends Bug
{
	public SpawnBug()
	{
		this.setColor(Color.MAGENTA);
	}
	
	public void move()
	{
		Grid<Actor> myGrid = getGrid();
		if (myGrid == null)
		{
			return;
		}
	
		Location currentLocation = getLocation();
		Location nextLocation = currentLocation.getAdjacentLocation(getDirection());
		Location backRightLocation = currentLocation.getAdjacentLocation(90);
		Location backLeftLocation = currentLocation.getAdjacentLocation(270);
		
		if(myGrid.isValid(nextLocation))
		{
			moveTo(nextLocation);
		}
		else
		{
			removeSelfFromGrid();
		}
		
		SpawnBug backBug = new SpawnBug();
		backBug.putSelfInGrid(myGrid,currentLocation);
		SpawnBug backLeftBug = new SpawnBug();
		SpawnBug backRightBug = new SpawnBug();
		backLeftBug.putSelfInGrid(myGrid, backLeftLocation);
		backRightBug.putSelfInGrid(myGrid, backRightLocation);
		
		if (myGrid.isValid(backLeftLocation) && myGrid.get(backLeftLocation) == null)
		{
			backLeftBug.putSelfInGrid(myGrid, backLeftLocation);
		}
		
		if (myGrid.isValid(backRightLocation))
		{
			backRightBug.putSelfInGrid(myGrid, backRightLocation);
		}
	}
}
