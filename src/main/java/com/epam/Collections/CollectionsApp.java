package com.epam.Collections;

import java.util.Scanner;

import org.apache.logging.log4j.*;

public class CollectionsApp {
	
	private static final Logger LOGGER = LogManager.getLogger(CollectionsApp.class);
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		DataList<Integer> dataList = new DataList<Integer>();
		int choice;
		do
		{
			LOGGER.info("1.Insert an Integer\n2.Display\n3.Remove\n4.See\nEnter Your Choice");
			Scanner sc =new Scanner(System.in);
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				LOGGER.info("Enter Element You want to insert");
				int element=sc.nextInt();
				dataList.add(element);
				break;
			case 2:
				dataList.display();
				break;
			case 3:
				LOGGER.info("Enter index at which you want to remove element:");
				int index=sc.nextInt();
				LOGGER.info("Successfully deleted "+ dataList.remove(index));
				break;
			case 4:
				LOGGER.info("Enter index at which you want to peek element:");
				int peekIndex=sc.nextInt();
				LOGGER.info("Elemnt present is "+ dataList.get(peekIndex));
				break;
			default:LOGGER.info("Terminating");
			break;
			
			}
		}while(choice<4);
	}

}
