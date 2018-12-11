package utilities;

/**
 * @author - Alberto Bartolome Sanchez on 10.12.2018.
 * @project phpTravelsFlightReservation
 * This class handles the Test Driven Data getters
 */
public class TestData {

    public static final String TESTDATA_LOCATION  =  "TestDrivenData.csv";

    public static class Environment {
		public static String getURL() { return TestDataManager.getData("Test_URL"); }
	}

	public static class RunnerConfig {
		public static int getTimeOut() { return Integer.parseInt(TestDataManager.getData("TimeOut_In_Seconds")); }
	}

    public static class Flight {
        public static String getFromCity() { return TestDataManager.getData("Flight_From_City"); }
        public static String getToCity() { return TestDataManager.getData("Flight_To_City"); }
		public static String getDate() { return TestDataManager.getData("Flight_Date"); }
    }

	public static class User {
		public static String getName() { return TestDataManager.getData("User_First_Name"); }
		public static String getLastName() { return TestDataManager.getData("User_Last_Name"); }
		public static String getEmail() { return TestDataManager.getData("User_Email"); }
		public static String getMobile() { return TestDataManager.getData("User_Mobile"); }
		public static String getAddress() { return TestDataManager.getData("User_Address"); }
		public static String getCountry() { return TestDataManager.getData("User_Country"); }
	}
}