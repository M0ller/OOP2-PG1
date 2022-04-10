package com.OOP2PG1.application.services;

import com.OOP2PG1.application.entities.Site;
import com.OOP2PG1.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
//
//public class SiteDetailsImpl implements UserDetails {
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
//}
