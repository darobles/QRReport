package cl.drobles.distancias.repository;

import java.util.List;

import cl.drobles.distancias.model.Junction;

public interface JunctionQueryRepository {
	public List<Junction> getNearby(double latitude, double longitude, double distance);
}
