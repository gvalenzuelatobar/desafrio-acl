package com.acl.proceso;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.acl.proceso.controller.ProcesoController;
import com.acl.proceso.request.TablaRequest;
import com.acl.proceso.response.TablaResponse;
import com.acl.proceso.service.TablaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProcesoController.class)
public class TablaControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	 @MockBean
     private TablaService tablaService;

	
    @Test
    public void testIngreso() throws Exception {
        // Crea un objeto TablaRequest con datos de prueba
        TablaRequest request = new TablaRequest(1L, "ingreso descripcion ", new Date(), true);
        TablaResponse response = new TablaResponse(1L, "ingreso descripcion ", "2020-12-12", true);
        
       
        // Convierte el objeto a JSON
        String jsonRequest = new ObjectMapper().writeValueAsString(response);

        Mockito.when(tablaService.ingreso(request)).thenReturn(response);
        mockMvc.perform(post("/tabla/ingreso").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk());
    }

}
