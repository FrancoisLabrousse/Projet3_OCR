package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * Creation of a favorites list
     */
   private List<Neighbour> favoriteNeighbours = new ArrayList<Neighbour>();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * Adding favorite neighbors to the list
     *
     * @param neighbour
     */
    @Override
    public void addNeighbourFavorite(Neighbour neighbour){ favoriteNeighbours.add(neighbour); }

    /**
     * Get for favorites list
     *
     * @return
     */
    @Override
    public List<Neighbour> getFavoriteNeighbours(){ return favoriteNeighbours;}

    /**
     * Delete method for remove a neighbour in the favorites list
     * @param neighbour
     */
    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        favoriteNeighbours.remove(neighbour);
    }
}
