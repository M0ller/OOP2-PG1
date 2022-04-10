package com.OOP2PG1.application.services;

import com.OOP2PG1.application.entities.Site;
import com.OOP2PG1.application.repositories.SiteRepository;
import com.OOP2PG1.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SiteDetailsImpl  { // public class SiteDetailsImpl  { //

//    @Override
//    public <S extends Site> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Site> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<Site> findById(String s) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(String s) {
//        return false;
//    }
//
//    @Override
//    public List<Site> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Site> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Site> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public Iterable<Site> findAllById(Iterable<String> strings) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(String s) {
//
//    }
//
//    @Override
//    public void delete(Site entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends String> strings) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Site> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Site> S insert(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Site> List<S> insert(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public <S extends Site> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Site> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Site> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Site> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Site> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Site> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends Site, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }

//////////////////////////////////////////////////////////
//	private static final long serialVersionUID = 1L;
//
//	private String id;
//
//	private String site_name;
//
//	private String creator;
//
//	private String creator_name;
//
//	public SiteDetailsImpl(String id, String site_name, String creator, String creator_name) {
//		this.id = id;
//		this.site_name = site_name;
//		this.creator = creator;
//		this.creator_name = creator_name;
//	}
//
//	public static SiteDetailsImpl build(Site site) {
////		List<GrantedAuthority> authorities = site.getRoles().stream()
////				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
////				.collect(Collectors.toList());
//
//		return new SiteDetailsImpl(
//				site.getId(),
//				site.getSite_name(),
//				site.getCreator(),
//				site.getCreator_name());
//	}
//
////	@Override
////	public Collection<? extends GrantedAuthority> getAuthorities() {
////		return authorities;
////	}
//
//	public String getId() {
//		return id;
//	}
//
//	public String getCreator() {
//		return creator;
//	}
//
//	@Override
//	public String getPassword() {
//		return creator_name;
//	}
//
//	@Override
//	public String getUsername() {
//		return site_name;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//		SiteDetailsImpl user = (SiteDetailsImpl) o;
//		return Objects.equals(id, user.id);
//	}
}
