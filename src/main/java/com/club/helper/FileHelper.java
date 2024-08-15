package com.club.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

@Service
public class FileHelper {

	public void copyPicture(){
		InputStream in = null;
		OutputStream out = null;
		try {
			 in = new FileInputStream(new File("D:\\temp-rainyTemp\\picture_own.jpg"));
			 out = new FileOutputStream(new File("D:\\temp-rainy\\picture_own.jpg"));
			 byte[] by = new byte[2014];
			 int length = 0;
			 while((length=in.read(by))!=-1){
				 out.write(by);
			 }
			 
 		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
