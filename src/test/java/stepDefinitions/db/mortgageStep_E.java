package stepDefinitions.db;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import utils.DBUtils;

import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.DBUtils.getColumnNames;

public class mortgageStep_E {

    List<String> actualColumnNames;
    List<String> expectedColumnNames;
    List<String> list;
    List<String> actual;

    private void tableExists() {
    }

    @Given("the tbl_mortgage table exists")
    public void the_tbl_mortgage_table_exists() {

        DBUtils.createConnection();
        tableExists();
        actual = DBUtils.getSingleColumnValues( "employer_name, position, city, state, start_date, end_date, current_job, co_employer_name, co_position, co_city, co_state, co_start_date, co_end_date, co_current_job, gross_monthly_income, monthly_bonuses, monthly_dividends, c_gross_monthly_income, c_monthly_bonuses, c_monthly_commissions, c_monthly_dividends, add_belong, income_source, amount", "tbl_mortgage" );



    }


    @When("It should be the following columns in the {string} table:")
    public void it_should_be_the_following_columns_in_the_table(String table, io.cucumber.datatable.@NotNull DataTable dataTable) {



        List<String> expectedColumns = new ArrayList<String>();
        for (Map<String, String> map : dataTable.asMaps( String.class, String.class )) {
            expectedColumns.add( map.get( "Column" ) );
            //  actualColumnNames = DBUtils.getColumnNames("SELECT * from tbl_mortagage");
            //  Assert.assertEquals(expectedColumnNames, actualColumnNames);

        }

        // Get actual columns from database
        List<String> actualColumns = getColumnNames( table );

        // Compare expected and actual columns
        assertEquals( expectedColumns, actualColumns );
    }

    @And("the {string} and {string} columns should be required and not empty")
    public void the_and_columns_should_be_required_and_not_empty(String column1, String column2) {
        int emptyCount1 = countEmpty( "tbl_mortgage", column1 );
        int emptyCount2 = countEmpty( "tbl_mortgage", column2 );

        assertTrue( emptyCount1 == 0 );
        assertTrue( emptyCount2 == 0 );
    }

    private char countEmpty(String employer_name, String gross_monthly_income) {
        // code to count empty fields
        return 0;
    }



    @Then("the {string} column should only contain two-letter abbreviations of US states")
    public void the_column_should_only_contain_two_letter_abbreviations_of_us_states(List<Map<String, String>> dataTable) throws SQLException {
        String stateName = null;

        List<Map<String, Object>> actual = DBUtils.getListOfMaps( "SELECT state from tbl_mortagage where state='" + stateName + "'" );
        assertTrue( stateName.length() == 2 );


    }

    @When("the {string} column should only contain the following values:")
    public void the_column_should_only_contain_the_following_values(String column, io.cucumber.datatable.DataTable dataTable) {
// Get valid values from data table
        List<String> validValues = new ArrayList<String>();
        for (Map<String, String> map : dataTable.asMaps( String.class, String.class )) {
            validValues.add( map.get( "Value" ) );
        }

    }
}
