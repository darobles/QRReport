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

import cl.drobles.distancias.model.Imagen;
import cl.drobles.distancias.repository.ImagenRepository;

@Service
public class ImagenService implements ImagenRepository {
	
	@Autowired
	private ImagenRepository iRepository;


	@Override
	public List<Imagen> findAll() {
		// TODO Auto-generated method stub
		return iRepository.findAll();
	}

	@Override
	public List<Imagen> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<Imagen> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Imagen> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Imagen> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Imagen> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void deleteAllInBatch(Iterable<Imagen> entities) {
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
	public Imagen getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Imagen getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Imagen> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Imagen> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public Page<Imagen> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Imagen> S save(S entity) {
		// TODO Auto-generated method stub
		return iRepository.save(entity);
	}

	@Override
	public Optional<Imagen> findById(Integer id) {
		// TODO Auto-generated method stub
		return iRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return iRepository.existsById(id);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return iRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Imagen entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Imagen> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Imagen> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Imagen> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Imagen> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Imagen> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	


}
