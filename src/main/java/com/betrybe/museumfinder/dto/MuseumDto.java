package com.betrybe.museumfinder.dto;

/**
 * MuseumDto.
 */
public record MuseumDto(
    Long id,
    String name,
    String description,
    String address,
    String collectionType,
    String subject,
    String url,
    com.betrybe.museumfinder.model.Coordinate coordinate
) {
}
