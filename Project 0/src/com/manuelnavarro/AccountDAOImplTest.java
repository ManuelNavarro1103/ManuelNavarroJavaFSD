package com.manuelnavarro;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AccountDAOImplTest {

    @Test
    void getNewAccountId() throws SQLException {
        // Arrange
        AccountDAOImpl dao = new AccountDAOImpl();

        // Act
        int actualResult = dao.getNewAccountId();

        // Assert
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void accountExists() throws SQLException {

        AccountDAOImpl dao = new AccountDAOImpl();

        boolean actualResult = dao.accountExists(3, 5);
        boolean actualResult2 = dao.accountExists(3, 6);

        boolean expectedResult = true;
        boolean expectedResult2 = false;
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult2, actualResult2);


    }
}