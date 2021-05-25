package it.epicode.be;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerLinguaTest {

	@Value("${s9-prenotazioni2.istruzioniItaliano}")
	private String italiano;
	
	@Value("${s9-prenotazioni2.istruzioniInglese}")
	private String inglese;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void testMessageItaliano() throws Exception{
		mockMvc.perform(get("/try/istruzioni/italiano"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(italiano));
				
	}
	
	@Test
	void testMessageInglese() throws Exception{
		mockMvc.perform(get("/try/istruzioni/inglese"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(inglese));
				
	}

	@Test
	void testMessageAnyOther() throws Exception{
		mockMvc.perform(get("/try/istruzioni/*"))
				.andDo(print()).andExpect(status().isNotFound());
	}


}
