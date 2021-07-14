package se.atg.service.harrykart.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import se.atg.service.harrykart.services.HarryKartServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(HarryCartController.class)
@ContextConfiguration(classes = HarryCartController.class)
public class IntegrationTestCase {
	
	@MockBean
	private HarryKartServiceImpl serviceImpl;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testHarryKart() throws Exception {
		String xml = "<harryKart>\n"
				+ "    <numberOfLoops>3</numberOfLoops>\n"
				+ "    <startList>\n"
				+ "        <participant>\n"
				+ "            <lane>1</lane>\n"
				+ "            <name>TIMETOBELUCKY</name>\n"
				+ "            <baseSpeed>10</baseSpeed>\n"
				+ "        </participant>\n"
				+ "        <participant>\n"
				+ "            <lane>2</lane>\n"
				+ "            <name>CARGO DOOR</name>\n"
				+ "            <baseSpeed>10</baseSpeed>\n"
				+ "        </participant>\n"
				+ "        <participant>\n"
				+ "            <lane>3</lane>\n"
				+ "            <name>HERCULES BOKO</name>\n"
				+ "            <baseSpeed>10</baseSpeed>\n"
				+ "        </participant>\n"
				+ "        <participant>\n"
				+ "            <lane>4</lane>\n"
				+ "            <name>WAIKIKI SILVIO</name>\n"
				+ "            <baseSpeed>10</baseSpeed>\n"
				+ "        </participant>\n"
				+ "    </startList>\n"
				+ "    <powerUps>\n"
				+ "        <loop number=\"1\">\n"
				+ "            <lane number=\"1\">1</lane>\n"
				+ "            <lane number=\"2\">1</lane>\n"
				+ "            <lane number=\"3\">0</lane>\n"
				+ "            <lane number=\"4\">-2</lane>\n"
				+ "        </loop>\n"
				+ "        <loop number=\"2\">\n"
				+ "            <lane number=\"1\">1</lane>\n"
				+ "            <lane number=\"2\">-1</lane>\n"
				+ "            <lane number=\"3\">2</lane>\n"
				+ "            <lane number=\"4\">-2</lane>\n"
				+ "        </loop>\n"
				+ "    </powerUps>\n"
				+ "</harryKart>\n"
				+ "";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/play").content(xml)
				.contentType(MediaType.APPLICATION_XML_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
	