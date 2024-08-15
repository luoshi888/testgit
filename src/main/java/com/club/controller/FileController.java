package com.club.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.club.helper.FileHelper;

@Controller
@RequestMapping("/club")
public class FileController {
	@Autowired
	FileHelper fileHelper;

	@RequestMapping("/pictureUpload")
	@ResponseBody
	public String  pictureUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
		Map<String, Object> resObj = new HashMap<String,Object>();
		String isNotTemp = request.getParameter("isNotTemp");
		if (file.isEmpty()) {
            resObj.put("code", 1);
            return JSONObject.toJSONString(resObj);
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainyTemp//"; // 上传后的路径
        if("true".equals(isNotTemp)){
        	filePath = "D://temp-rainy//";
        }
        fileName = "picture_own.jpg"; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        model.addAttribute("filename", filename);
        resObj.put("msg", "ok");
        resObj.put("code", "0");
        resObj.put("filename", filename);
        return JSONObject.toJSONString(resObj);
	}
	
	
	@RequestMapping("/copyPicture")
	@ResponseBody
	public String  copyPicture(){
		Map<String, Object> resObj = new HashMap<String,Object>();
		fileHelper.copyPicture();
		resObj.put("status", 1);
		return JSONObject.toJSONString(resObj);
	}
}
