/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package test.java.start;

import org.junit.Test;

import main.java.start.Silvalsim;

import static org.junit.Assert.*;

public class SilvalsimTest {
    @Test public void testAppHasAGreeting() {
        Silvalsim classUnderTest = new Silvalsim();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
