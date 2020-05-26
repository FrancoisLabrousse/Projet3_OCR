package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    /**
     *  test to verify the addition of a neighbor to the favorites list
     */
    @Test
    public void getFavoriteNeighboursWithSuccess(){
        Neighbour neighbourToAddFavoriteNeighbour = service.getNeighbours().get(0);
        service.addNeighbourFavorite(neighbourToAddFavoriteNeighbour);
        assertTrue(service.getFavoriteNeighbours().contains(neighbourToAddFavoriteNeighbour));
    }

    /**
     *  test to check the deletion of a neighbor in the favorites list
     */
    @Test
    public void deleteFavoriteNeighbourWithSuccess(){
        Neighbour neighbourToAddFavoriteNeighbour = service.getNeighbours().get(0);
        service.addNeighbourFavorite(neighbourToAddFavoriteNeighbour);
        service.deleteFavoriteNeighbour(neighbourToAddFavoriteNeighbour);
        assertFalse(service.getFavoriteNeighbours().contains(neighbourToAddFavoriteNeighbour));
    }

}
