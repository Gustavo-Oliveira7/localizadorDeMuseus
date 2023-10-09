package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import com.betrybe.museumfinder.util.MuseumLoader;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * MuseumService.
 */
@Service
public class MusemService implements MuseumServiceInterface {
  private final MuseumFakeDatabase museumFakeDatabase;

  public MusemService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    if (!CoordinateUtil.isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException();
    }
    Optional<Museum> museum = museumFakeDatabase.getClosestMuseum(coordinate, maxDistance);
    if (museum.isEmpty()) {
      throw new MuseumNotFoundException();
    }
    return museum.get();
  }

  @Override
  public Museum createMuseum(Museum museum) {
    if (CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      return museumFakeDatabase.saveMuseum(museum);
    }
    throw new InvalidCoordinateException();
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
