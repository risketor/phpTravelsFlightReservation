package utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 * Managing the Data file (CSV), to load and read the data for certain key
 */
public class TestDataManager {

    /**
     * Character used as a delimiter for the CSV file
     */
    private static final String CSV_SPLIT_BY = ",";

    /**
     * Copy in Memory of the Test Data
     */
    static List<String[]> testDrivenData;

    /**
     * Constructor
     *
     * @param strTestDataLocation location and name of the Test Data file
     */
    public TestDataManager(String strTestDataLocation) {
        /**
         * Location and name of the Test Data file
         */
        String mTestDataLocation = strTestDataLocation;
        TestDataManager.testDrivenData = TestDataManager.loadTestDrivenData(mTestDataLocation);
    }

    /**
     * Retrieve a Test Data
     *
     * @param key key to search
     * @return the value corresponding to the key or null if the key hasn't been found.
     */
    static String getData(String key) {
        String output = null;
        for (String[] s : testDrivenData) {
            if (s[0].toUpperCase(Locale.UK).equals(key.toUpperCase(Locale.UK))) {
                output = "";
                if (s.length > 1) {
                    output = s[1];
                }
                break;
            }
        }
        if (output != null) {
            return output.trim();
        }else{
            Log.exception("Output null");
        }
        return null;
    }

    /**
     * Load the Test Data file in memory.
     * Each test Data is composed of 3 elements: key, value and comments.
     *
     * @param strTestDataLocation location and name of the Test Data file
     * @return a List<String[]> containing all the Test Data lines
     */
    private static List<String[]> loadTestDrivenData(String strTestDataLocation) {
        BufferedReader br = null;
        String line = "";
        List<String[]> list = new ArrayList<String[]>();

        try {
            br = new BufferedReader(new FileReader(strTestDataLocation));
            while ((line = br.readLine()) != null) {
                if (line.trim().length() > 0) {
                    String[] data = line.split(CSV_SPLIT_BY);
                    String key = data[0];
                    String value = data.length > 1 ? data[1] : "";
                    String comments = data.length > 2 ? data[2] : "";
                    String[] listData = {key, value, comments};
                    list.add(listData);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
