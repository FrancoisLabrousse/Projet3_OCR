package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user add neighbour in favorite
 */
public class AddFavoriteNeighbour {

    /**
     * Neighbour to add
     */
    public static Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public AddFavoriteNeighbour(Neighbour neighbour){
        this.neighbour = neighbour;
    }

    /**
     * Get neighbour
     * @return
     */
    public static Neighbour getFavoriteNeighbour() {
        return neighbour;
    }
}
