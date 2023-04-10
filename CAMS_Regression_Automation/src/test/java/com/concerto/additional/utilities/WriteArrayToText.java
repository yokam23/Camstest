package com.concerto.additional.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class WriteArrayToText {
	
	public static void ArrayToText(String[][] board,String Path) throws Throwable{
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < board.length; i++)//for each row
		{
		   for(int j = 0; j < board[i].length; j++)//for each column
		   {
		      builder.append(board[i][j]+"");//append to the output string
		      if(j < board.length - 1)//if this is not the last row element
		         builder.append(",");//then add comma (if you don't like commas you can use spaces)
		   }
		   builder.append("\n");//append new line at the end of the row
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path));
		writer.write(builder.toString());//save the string representation of the board
		writer.close();
	}

}
