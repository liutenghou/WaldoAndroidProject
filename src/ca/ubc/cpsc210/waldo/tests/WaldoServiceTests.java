package ca.ubc.cpsc210.waldo.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.waldo.model.Waldo;
import ca.ubc.cpsc210.waldo.waldowebservice.WaldoService;


public class WaldoServiceTests{
	
	WaldoService ws = new WaldoService();
	
	@Before
	public void setupTest(){
		ws = new WaldoService();
		
	}
	
	@Test
	public void testInitNullWaldos(){
		String s = ws.initSession(null);
		System.out.println("##TEST null: " + s);
		
		//5 waldos
		List<Waldo> listOfWaldos = ws.getRandomWaldos(5);
		assertEquals(5, listOfWaldos.size());
		for(Waldo x: listOfWaldos){
			System.out.println(x);
		}
		
		List<Waldo> listOfAllWaldos = ws.getWaldos();
		assertEquals(5, listOfAllWaldos.size());
		
		//1 waldo
		listOfWaldos = ws.getRandomWaldos(1);
		assertEquals(1, listOfWaldos.size());
		for(Waldo x: listOfWaldos){
			System.out.println(x);
		};
		
		listOfAllWaldos = ws.getWaldos();
		assertEquals(1, listOfAllWaldos.size());
		
	}
	
	//TODO: why do waldos already exist?
	
	/*
	@Test
	public void testInitWaldoWaldos(){
		
		String s = ws.initSession("waldo");
		System.out.println("##TEST waldo: " + s);
		assertEquals("waldo", s);
	}
	*/
	
	@Test
	public void testGetMessages(){
		ws.initSession(null);
		ws.getRandomWaldos(5);
		System.out.println("## 5 messages: "   + ws.getMessages());	
	}
	
	@Test
	public void testGetMessagesByName(){
		ws.initSession(null);
		ws.getRandomWaldos(5);
		System.out.println("## named messages: "   + ws.getMessages());
	}

}
