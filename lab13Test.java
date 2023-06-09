import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class lab13Test {
	lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data.txt";
	String expectedResultsFilename = "lab13_expected_results.txt";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		lab = new lab13();
		lab.readData(inputFilename);
		
		// testData.get(0) has the expected results for getResult1()
		// testData.get(1) has the expected results for getResult2()
		// testData.get(2) has the expected results for getResult3()
		ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
		for( int i = 0; i < 3; i++ )
		{
			testData.add(new ArrayList<Integer>());
		}
		
		try
		{
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<Integer> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(Integer.valueOf(inn));
					}
					else
					{
						break;
					}
				}
				testData.set(i, currentTestData);
				System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
			}
			input.close();
			
			// put code here to populate expectedResult1 with the values in testData.get(0)
			// so that you can use "assertArrayEquals" to verify expectedResult1 and lab.getResult1() are the same
			expectedResult1 = new Integer[testData.get(0).size()];
			for (int i = 0; i < expectedResult1.length; i++) {
				expectedResult1[i] = testData.get(0).get(i);
			}
			
			
			// put code here to populate expectedResult2 with the values in testData.get(1)
			// so that you can use "assertArrayEquals" to verify expectedResult2 and lab.getResult2() are the same
			expectedResult2 = new Integer[testData.get(1).size()];
			for (int i = 0; i < expectedResult2.length; i++) {
				expectedResult2[i] = testData.get(1).get(i);
			}
			
			// put code here to populate expectedResult3 with the values in testData.get(2)
			// so that you can use "assertArrayEquals" to verify expectedResult3 and lab.getResult3() are the same
			expectedResult3 = new Integer[testData.get(2).size()];
			for (int i = 0; i < expectedResult3.length; i++) {
				expectedResult3[i] = testData.get(2).get(i);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	@Test
	void testGetTotalCount() throws Exception {
		assertEquals(lab.getTotalCount(), 1000);
	}

	@Test
	void testGetOddCount() throws Exception {
		assertEquals(lab.getOddCount(), 507);
	}
	
	@Test
	void testGetEvenCount() throws Exception {
		assertEquals(lab.getEvenCount(), 493);
	}
	
	@Test
	void testGetDistinctGreaterThanFiveCount() throws Exception {
		assertEquals(lab.getDistinctGreaterThanFiveCount(), 94);
	}
	
	@Test
	void testGetResult1() throws Exception {
		assertArrayEquals(expectedResult1, lab.getResult1());
	}
	
	@Test
	void testGetResult2() throws Exception {
		assertArrayEquals(expectedResult2, lab.getResult2());
	}
	
	@Test
	void testGetResult3() throws Exception {
		assertArrayEquals(expectedResult3, lab.getResult3());
	}
	

}
