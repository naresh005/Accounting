package demo.service;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.Application;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Application.class)
public class AccountServiceImplTest {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired DataSource dataSource;
	
	@Before
	public void setUp() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Test
	public void testEmbeddedDatabase() {
		assertEquals(new Long(1234),getAccountBalance(new Long(1)));
	}
	
	Long getAccountBalance(Long accountNumber) {
		return jdbcTemplate.queryForObject("Select BAL from ACCOUNT where ID = ?", Long.class, accountNumber);
	}

}
