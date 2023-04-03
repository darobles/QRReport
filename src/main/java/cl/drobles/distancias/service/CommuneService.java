package cl.drobles.distancias.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import cl.drobles.distancias.model.Commune;
import cl.drobles.distancias.repository.CommuneRepository;

@Service
public class CommuneService implements CommuneRepository {

	@Autowired

	private CommuneRepository cRepository;
	
	@Override
	public List<Commune> findAll() {
		// TODO Auto-generated method stub
		return cRepository.findAll();
	}

	@Override
	public List<Commune> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<Commune> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Commune> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Commune> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Commune> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void deleteAllInBatch(Iterable<Commune> entities) {
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
	public Commune getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commune getById(Integer id) {
		// TODO Auto-generated method stub
		return cRepository.getById(id);
	}

	@Override
	public <S extends Commune> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Commune> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public Page<Commune> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Commune> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Commune> findById(Integer id) {

		// TODO Auto-generated method stub
		return cRepository.findById(id);
		}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub

		return cRepository.existsById(id);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub

		return cRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Commune entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Commune> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Commune> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub

		return Optional.empty();
	}

	@Override
	public <S extends Commune> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Commune> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Commune> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Commune> findByIdRegion(Integer id) {
		// TODO Auto-generated method stub
		return cRepository.findByIdRegion(id);
	}

	@Override
	public List<Commune> findAllMaintained() {
		// TODO Auto-generated method stub
		return cRepository.findAllMaintained();
	}

}
