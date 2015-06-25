package com.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import scala.annotation.meta.getter;


@Controller
public class FileUploadController {
	
	@Value("${uploadPath}")
    public String path;
	
	
	 @RequestMapping(value="/upload", method=RequestMethod.GET)
	    public  String provideUploadInfo() {
	        return "Upload";
	    }

	    @RequestMapping(value="/upload", method=RequestMethod.POST)
	    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
	            @RequestParam("file") MultipartFile file){
	    	 
	   System.out.println(name +" "+file.getOriginalFilename());
	        if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();
	                BufferedOutputStream stream =
	                        new BufferedOutputStream(new FileOutputStream(new File(path+name+"."+ FilenameUtils.getExtension(file.getOriginalFilename()))));
	               
	                stream.write(bytes);
	                stream.close();
	                return "You successfully uploaded " + name + "!";
	            } catch (Exception e) {
	                return "You failed to upload " + name + " => " + e.getMessage();
	            }
	        } else {
	            return "You failed to upload " + name + " because the file was empty.";
	        }
	    }

	}