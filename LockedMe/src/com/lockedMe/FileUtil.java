package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil 
{
	static int count=0;
	List<MyFile> files=new ArrayList<>();
	
	public FileUtil()
	{
		File f=new File("D:\\poject test file");
		String[] fs=f.list();
		
		if(fs!=null)
		{
			for(String file:fs)
			{
				count++;
				files.add(new MyFile(count,file));
			}
		}
		else
		{
			System.out.println("Incorrect path");
		}
	}
	
	public List<MyFile> getFiles()
	{
		File f=new File("D:\\poject test file");
		
		String[] fs=f.list();
		
		files.clear();
		count=0;
				
		for(String file:fs)
		{
			count++;
			files.add(new MyFile(count,file));
		}
		return files;
	}
	
	public void addFile(String fileName) throws IOException
	{
		if(this.search(fileName))
			System.out.println("File already exists");
		else
		{
			File f = new File ("D:\\poject test file\\"+fileName+".txt");
			f.createNewFile();
			System.out.println(fileName+" File added successfully \t");
		}
	}
	
	public boolean deleteFile(String fileName)
	{
		boolean isDeleted=false;
		files=getFiles();
		
		for(MyFile file:files)
		{
			if(file.getFileName().startsWith(fileName))
			{
				File f=new File("D:\\poject test file\\"+file.getFileName());
				f.delete();
				isDeleted=true;
				break;
			}
		}
		if(isDeleted)
		{
			System.out.println(fileName+" File successfuly deleted");
		}
		else
		{
			System.out.println(fileName+" File not found");
		}
		return isDeleted;
	}
	
	public boolean search(String fileName)
	{
		boolean isIdentified=false;
		files=getFiles();
		
		for(MyFile file:files)
		{
			if(file.getFileName().startsWith(fileName))
			{
				isIdentified=true;
				break;
			}
		}
		return isIdentified;
	}
}
