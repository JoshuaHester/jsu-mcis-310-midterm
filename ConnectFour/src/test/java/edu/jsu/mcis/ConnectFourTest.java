package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class ConnectFourTest {
    
    // Exam Question 1
    // Implement the ConnectFour methods below to make this
    // unit test pass correctly.
    @Test
    public void testNewGameShouldHaveAllEmptyColumns() {
        ConnectFour game = new ConnectFour();
        for(int column = 0; column < ConnectFour.COLUMNS; column++) {
            assertEquals(ConnectFour.Token.EMPTY, game.getTopOfColumn(column));
            assertEquals(0, game.getHeightOfColumn(column));
        }
    }

    // Exam Question 2
    // Implement the ConnectFour methods below to make this
    // unit test pass correctly.
    @Test
    public void testDropFirstTokenInCenterShouldBeRedAndThenSecondTokenInCenterShouldBeBlack() {
        ConnectFour game = new ConnectFour();
        boolean ableToDropToken = game.dropTokenInColumn(3);
        assertTrue(ableToDropToken);
        assertEquals(ConnectFour.Token.RED, game.getTopOfColumn(3));
        assertEquals(1, game.getHeightOfColumn(3));
        ableToDropToken = game.dropTokenInColumn(3);
        assertTrue(ableToDropToken);
        assertEquals(ConnectFour.Token.BLACK, game.getTopOfColumn(3));
        assertEquals(2, game.getHeightOfColumn(3));
    }
    
    // Exam Question 3
    // Implement the ConnectFour methods below to make this
    // unit test pass correctly.
    @Test
    public void testFillSecondColumnFromLeftShouldLeaveNoAbilityToDropToken() {
        ConnectFour game = new ConnectFour();
        game.dropTokenInColumn(1);
        game.dropTokenInColumn(1);
        game.dropTokenInColumn(1);
        game.dropTokenInColumn(1);
        game.dropTokenInColumn(1);
        boolean ableToDropToken = game.dropTokenInColumn(1);
        assertTrue(ableToDropToken);
        ableToDropToken = game.dropTokenInColumn(1);
        assertFalse(ableToDropToken);
    }
    
    // Exam Question 4
    // Implement this unit test to ensure that dropping red tokens
    // exclusively in the center column and black tokens exclusively
    // in the column just to its left will result in a win by red
    // after 7 moves.
    // 
    //  | | | | | | | |
    //  |-|-|-|-|-|-|-|
    //  | | | | | | | |
    //  |-|-|-|-|-|-|-|
    //  | | | |7| | | |
    //  |-|-|-|-|-|-|-|
    //  | | |6|5| | | |
    //  |-|-|-|-|-|-|-|
    //  | | |4|3| | | |
    //  |-|-|-|-|-|-|-|
    //  | | |2|1| | | |
    //  '-'-'-'-'-'-'-'
    //
    // Then, implement the ConnectFour class methods required to make the 
    // test pass correctly.
    @Test
    public void testRedWinVerticallyInCenterColumn() {
        ConnectFour game = new ConnectFour();
        game.dropTokenInColumn(3);
        game.dropTokenInColumn(2);
		assertEquals(ConnectFour.Result.NONE, game.getResult());
        game.dropTokenInColumn(3);
        game.dropTokenInColumn(2);
        game.dropTokenInColumn(3);
		game.dropTokenInColumn(2);
        game.dropTokenInColumn(3);
		assertEquals(ConnectFour.Result.RED_WIN, game.getResult());
    }
    
    // Exam Question 5
    // Implement this unit test to ensure that dropping tokens in
    // the order specified will result in a win by black in 10 moves.
    // (X represents 10 in the figure.)
    //
    //  | | | | | | | |
    //  |-|-|-|-|-|-|-|
    //  | | | | | | | |
    //  |-|-|-|-|-|-|-|
    //  | | | | | | | |
    //  |-|-|-|-|-|-|-|
    //  | | | | | | | |
    //  |-|-|-|-|-|-|-|
    //  |9| |2|4|6|X| |
    //  |-|-|-|-|-|-|-|
    //  |7| |1|3|5|8| |
    //  '-'-'-'-'-'-'-'
    //
    // Then, implement the ConnectFour class methods required to make the 
    // test pass correctly.
    @Test
    public void testBlackWinHorizontallyInSecondRowFromBottom() {
        ConnectFour game = new ConnectFour();
        game.dropTokenInColumn(2);
        game.dropTokenInColumn(2);
		assertEquals(ConnectFour.Result.NONE, game.getResult());
        game.dropTokenInColumn(3);
        game.dropTokenInColumn(3);
        game.dropTokenInColumn(4);
		game.dropTokenInColumn(4);
        game.dropTokenInColumn(0);
        game.dropTokenInColumn(5);		
        game.dropTokenInColumn(0);
        game.dropTokenInColumn(5);			
		assertEquals(ConnectFour.Result.BLACK_WIN, game.getResult());
    }
}
