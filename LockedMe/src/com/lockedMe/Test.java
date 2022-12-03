package com.lockedMe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Test 
{
	public static void main(String[] args) throws IOException
	{
		FileUtil util = new FileUtil();
		int ch;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("************* Project Name ************* \n********* LOCKEDME.COM PROJECT *********");
		System.out.println("************* Developed By *************  \n******* AKSHATHA PRAVEEN KAMATH ********");
		while(true)
		{
			System.out.println("\n");
			System.out.println("1. Create A File");
			System.out.println("2. Delete A File");
			System.out.println("3. Display All Files");
			System.out.println("4. Search A File");
			System.out.println("5. Exit");
			System.out.println("Enter the choice : \t");
			try
			{
				ch = Integer.parseInt(br.readLine());
				switch(ch)
				{
				case 1: 
						String fileName;
						System.out.println("Enter the filename to be create : \t");
						fileName=br.readLine();
						util.addFile(fileName);
						break;
				case 2:
						String fileName1;
						System.out.println("Enter the filename to be delete : \t");
						fileName1=br.readLine();
						util.deleteFile(fileName1);
						break;
				case 3: 
						System.out.println("The following files and folders are in the directory\n");
						List<MyFile> files = util.getFiles();
						for(MyFile f : files)
						System.out.println(f.getId()+"\t" +f.getFileName());
						break;
				case 4: 
						String fileName2;
						System.out.println("Enter the filename : \t");
						fileName2 = br.readLine();
						if(util.search(fileName2))
							System.out.println(fileName2+" File is exist");
						else
							System.out.println(fileName2+" File does not exist");
						break;
				case 5:
						System.out.println("Exit");
						br.close();
						System.exit(0);
						break;
				default:
						System.out.println("Please enter your choice : \t");
			}
						
		}
		catch(NumberFormatException e)	
		{
			System.out.println("Please enter numbers only");
		}
	}
  }
}