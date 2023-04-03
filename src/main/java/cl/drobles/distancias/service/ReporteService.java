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

import cl.drobles.distancias.model.Report;
import cl.drobles.distancias.repository.ReportRepository;

@Service
public class ReporteService implements ReportRepository {
	@Autowired
	private ReportRepository rReportRepository;

	@Override
	public List<Report> findAll() {
		// TODO Auto-generated method stub
		return rReportRepository.findAll();
	}

	@Override
	public List<Report> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<Report> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Report> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Report> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Report> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void deleteAllInBatch(Iterable<Report> entities) {
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
	public Report getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Report> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public <S extends Report> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public Page<Report> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Report> S save(S entity) {
		// TODO Auto-generated method stub
		return rReportRepository.save(entity);
	}

	@Override
	public Optional<Report> findById(Integer id) {
		// TODO Auto-generated method stub
		return rReportRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return rReportRepository.existsById(id);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return rReportRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Report entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Report> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Report> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Report> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Report> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Report> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
