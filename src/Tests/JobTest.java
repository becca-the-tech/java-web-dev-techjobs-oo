package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JobTest {
    Job developer;
    Job scientist;
    Job productTester;
    Job productTester2;


    @Before
    public void createJobs() {
        developer = new Job();
        scientist = new Job();
        productTester = new Job("Product Tester", new Employer("Acme"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        productTester2 = new Job("Product Tester", new Employer("Acme"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));

    }

        @Test
        public void testSettingJobId () {
            System.out.println(developer.getId());
            System.out.println(scientist.getId());
            assertTrue(developer.getId() == scientist.getId() - 1);
        }

        @Test
        public void testJobConstructorSetsAllFields(){
            Job productTester = new Job("Product Tester", new Employer("Acme"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
            //ID of this job should be 3, due to the two initialized Jobs above first
            assertTrue(productTester.getId() == 3);
            assertTrue(productTester.getName() == "Product Tester" && productTester.getName() instanceof String );
            assertTrue(productTester.getEmployer().getValue() == "Acme" && productTester.getEmployer() instanceof Employer);
            assertTrue(productTester.getLocation().getValue() == "Desert" && productTester.getLocation() instanceof Location);
            assertTrue(productTester.getPositionType().getValue() == "Quality Control" && productTester.getPositionType() instanceof PositionType);
            assertTrue(productTester.getCoreCompetency().getValue() == "Persistence" && productTester.getCoreCompetency() instanceof CoreCompetency);
        }

        @Test
        public void testJobsForEquality(){
            assertFalse(scientist.equals(developer));
        }

        @Test
        public void toStringStartWithNewlineTest() {
            assertTrue(developer.toString().startsWith("\n"));
        }

        @Test
        public void toStringEndWithNewlineTest(){
            assertTrue(developer.toString().endsWith("\n"));
        }

        @Test
        public void toStringLabelAndFieldData(){
            assertEquals(productTester.toString(), "\n" + "ID: " + productTester.getId() + "\n" +
                            "Name: " + productTester.getName() + "\n"+
                            "Employer: " + productTester.getEmployer() + "\n" +
                            "Location: " + productTester.getLocation() + "\n" +
                            "Position Type: " + productTester.getPositionType() + "\n" +
                            "Core Competency: " + productTester.getCoreCompetency() + "\n"
                    );
        }

        @Test
        public void toStringWithEmptyFields(){
            developer.setName("Developer");
            assertEquals(developer.toString(), "\n" + "ID: " + developer.getId() + "\n" +
                    "Name: " + "Developer" + "\n"+
                    "Employer: " + "Data not available" + "\n" +
                    "Location: " + "Data not available" + "\n" +
                    "Position Type: " + "Data not available" + "\n" +
                    "Core Competency: " + "Data not available" + "\n"
            );
        }

        @Test
        public void toStringWithJustId(){
            assertEquals(scientist.toString(), "OOPS! This job does not seem to exist.");
        }

}
