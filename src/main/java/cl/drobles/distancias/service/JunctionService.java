package cl.drobles.distancias.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cl.drobles.distancias.model.Junction;
import cl.drobles.distancias.repository.JunctionQueryRepository;
import cl.drobles.distancias.repository.JunctionRepository;

@Service
public class JunctionService implements JunctionRepository, JunctionQueryRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Autowired
	private JunctionRepository junctionRepository;
	
	@Override
	public List<Junction> findAll() {

		// TODO Auto-generated method stub
		return junctionRepository.findAll();
	}

	@Override
	public List<Junction> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<Junction> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Junction> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Junction> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Junction> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void deleteAllInBatch(Iterable<Junction> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Junction getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Junction getById(Integer id) {
		// TODO Auto-generated method stub
		return junctionRepository.getById(id);
	}

	@Override
	public <S extends Junction> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Junction> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public Page<Junction> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Junction> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Junction> findById(Integer id) {
		// TODO Auto-generated method stub

		return junctionRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return junctionRepository.existsById(id);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return junctionRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Junction entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Junction> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Junction> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Junction> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Junction> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Junction> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	//-------------------------------------------------------------------------
	
	@Override
	public List<Junction> findNearby(double latitude, double longitude, double distance) {
		// TODO Auto-generated method stub
		return junctionRepository.findNearby(latitude, longitude, distance);
	}


	@Override
	public List<Junction> getJunctionsByCommuneId(Integer commune_id) {
		// TODO Auto-generated method stub
		return junctionRepository.getJunctionsByCommuneId(commune_id);
	}

	static double truncateTo( double unroundedNumber, int decimalPlaces ){
	    int truncatedNumberInt = (int)( unroundedNumber * Math.pow( 10, decimalPlaces ) );
	    double truncatedNumber = (double)( truncatedNumberInt / Math.pow( 10, decimalPlaces ) );
	    return truncatedNumber;
	}
	
	@Override
	public List<Junction> getNearby(double latitude, double longitude, double distance) {
		String query = "SELECT * FROM fn_cercanos(?,?,?)";
		@SuppressWarnings("unchecked")
		List<Object[]> list = em.createNativeQuery(query).setParameter(1, latitude).setParameter(2, longitude).setParameter(3, distance)
		.getResultList();  // Referencia directa a la conexion de la bd, se debe implementar la anotacion de persistencia
		List<Junction> mobileList = new ArrayList<>();
		for (Object[] fila : list) {
			Junction JuncAux = new Junction();
			JuncAux.setId_cruce( (int) fila[0]);
			JuncAux.setCalle_1((String)fila[1]);
			JuncAux.setCalle_2((String)fila[2]);
			JuncAux.setId_comuna( (int) fila[3]);
			JuncAux.setLatitud((Double) fila[4]);
			JuncAux.setLongitud((Double) fila[5]);
			JuncAux.setDistancia(truncateTo((double)fila[6], 2) );
			
			mobileList.add(JuncAux);
		}
		return mobileList;
	}

}
