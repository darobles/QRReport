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

import cl.drobles.distancias.model.Fail;
import cl.drobles.distancias.repository.FailRepository;

@Service
public class FailService implements FailRepository {
	
	@Autowired
	private FailRepository fRepository;
	
	@Override
	public List<Fail> findAll() {
		// TODO Auto-generated method stub
		return fRepository.findAll();
	}

	@Override
	public List<Fail> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return fRepository.findAll(sort);
	}

	@Override
	public List<Fail> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Fail> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Fail> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Fail> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void deleteAllInBatch(Iterable<Fail> entities) {
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
	public Fail getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fail getById(Integer id) {
		// TODO Auto-generated method stub
		return fRepository.getById(id);
	}

	@Override
	public <S extends Fail> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Fail> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public Page<Fail> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Fail> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Fail> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Fail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Fail> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Fail> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Fail> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Fail> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Fail> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
