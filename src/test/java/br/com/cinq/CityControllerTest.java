package br.com.cinq;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import br.com.cinq.Application;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@RestController
public class CityControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
    public void listAll() throws Exception {
        mockMvc.perform(get("/cities"))
        .andExpect(status().isOk())
	    	.andExpect(jsonPath("$", hasSize(12)))
	        .andExpect(jsonPath("$[0].id", is(1)))
	        .andExpect(jsonPath("$[0].name", is("Curitiba")))
	        .andExpect(jsonPath("$[1].id", is(2)))
	        .andExpect(jsonPath("$[1].name", is("Rio de Janeiro")));
    }
	
	@Test
	public void listCountriesWithUni() throws Exception {
		mockMvc.perform(get("/cities?country=Uni"))
		.andExpect(status().isOk())
    	.andExpect(jsonPath("$", hasSize(3)))
        .andExpect(jsonPath("$[0].id", is(notNullValue())))
        .andExpect(jsonPath("$[0].name", is(notNullValue())))
        .andExpect(jsonPath("$[1].id", is(notNullValue())))
        .andExpect(jsonPath("$[1].name", is(notNullValue())))
        .andExpect(jsonPath("$[2].id", is(notNullValue())))
        .andExpect(jsonPath("$[2].name", is(notNullValue())));		
	}
	
	@Test
	public void listCountriesWithInvalidaName() throws Exception {
		mockMvc.perform(get("/cities?country=ABC"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(0)));;		
	}
}
