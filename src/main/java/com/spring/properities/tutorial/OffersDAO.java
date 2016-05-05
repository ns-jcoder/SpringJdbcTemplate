package com.spring.properities.tutorial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("offersDao")
public class OffersDAO {
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Offers> getOfferss() {
		return jdbcTemplate.query("select * from offers", new RowMapper<Offers>() {

			@Override
			public Offers mapRow(ResultSet rsltSet, int rowNum) throws SQLException {
				Offers offer = new Offers();
				offer.setId(rsltSet.getInt("id"));
				offer.setName(rsltSet.getString("name"));
				offer.setEmail(rsltSet.getString("email"));
				offer.setText(rsltSet.getString("text"));

				return offer;
			}

		});
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	}

	public boolean create(Offers offer) {
		BeanPropertySqlParameterSource params= new BeanPropertySqlParameterSource(offer);
		return jdbcTemplate.update("insert into offers(name, text, email) "
				+ "values(:name, :text, :email)",params) == 1;
		
	}
}
