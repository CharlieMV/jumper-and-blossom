package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Jumper extends Bug {
	
	public Jumper() {
		setColor(Color.BLUE);
	}
	
	/**
	 * Tries to move in the following heirarchy
     * jump 2 spaces forwards
     * jump 2 spaces any direction
     * jump 1 space forwards
     * jump 1 space any direction
     */
    public void act()
    {
        if (canJump())
            jump();
        
    }
    
    /**
     * Tests whether this jumper can jump forward into a location that is empty or
     * contains a flower or a blossom.
     * @return true if this jumper can jump.
     */
     public boolean canJump() {
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).
									getAdjacentLocation(getDirection());
	 }
    
    /**
     * Tests whether this jumper can move forward into a location that is empty or
     * contains a flower or a blossom.
     * @return true if this jumper can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower) || 
									(neighbor instanceof Blossom);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
}
