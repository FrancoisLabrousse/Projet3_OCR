package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     *
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     *
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     *
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Ajout des favoris
     *
     * @param neighbour
     */
    void addNeighbourFavorite(Neighbour neighbour);

    /**
     * Get favorite neighbours
     *
     * @return
     */
    List<Neighbour> getFavoriteNeighbours();

    /**
     * Deletes favorite neighbours
     * @param neighbour
     */
    void deleteFavoriteNeighbour(Neighbour neighbour);
}
