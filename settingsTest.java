package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import frontEnd.InfoTab;

class settingsTest {

	/**
	 * This is a instance of a InfoTab to test its functionality, This makes this a 
	 * white-box testing.
	 */
    private InfoTab myTab;
    
    /**
     * A method to initialize the test feature before each test.
     * Purpose, to setup for the two rounds of testing required.
     * Pre: Infotab is a valid, instantable class.
     * Post: a Infotab is created.
     */
    @Before
    public void setUp() { 
        myTab = new InfoTab();
    }
    
    /**
     * Test of the default constructor.
     * Purpose: that the default Infotab class returns the correct version.
     */
    @Test
    public void testPassableVersionNum() {
    	System.out.println(
    			myTab.getVersion()
    			);
    	assertEquals(myTab.getVersion(), "0.1.04");
    }
    
    /**
     * Purpose: that the Infotab class allows for setting of the version number.
     */
    @Test
    public void testChangeVersionNum() {
	myTab.setVersion("0.0.02");
    	assertEquals(myTab.getVersion(), "0.0.02");
        
    }
}




