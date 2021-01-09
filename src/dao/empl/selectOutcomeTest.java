package dao.empl;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class selectOutcomeTest {

    @Test
    public void outcome() {
        assertNotNull(selectOutcome.Outcome());
    }
    @Test
    public void check(){
        assertNotNull(new addPerson().check());
    }
    @Test
    public void  sc(){
        deleteDAO.sc("00");
    }
    @Test
    public void getIncomeExcel(){
        IncomeExcel test=new IncomeExcel();

    }


}