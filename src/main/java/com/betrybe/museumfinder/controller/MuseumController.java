package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * MuseumController.
 */

@RestController
@RequestMapping("/museums")
public class MuseumController {
  private final MuseumServiceInterface museumService;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }


  /**
   * MuseumController post.
   */

  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody Museum museum) {
    return ResponseEntity.status(HttpStatus.CREATED).body(museumService.createMuseum(museum));
  }


  /**
   * MuseumController getclosest.
   */

  @GetMapping("/closest")
  public ResponseEntity<Museum> getClosestMuseum(
      @RequestParam Double lat,
      @RequestParam Double lng,
      @RequestParam("max_dist_km") Double maxDist) {
    Coordinate coordinate = new Coordinate(lat, lng);
    Museum museu = museumService.getClosestMuseum(coordinate, maxDist);
    if (museu == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(museu);
    }

  }


}
