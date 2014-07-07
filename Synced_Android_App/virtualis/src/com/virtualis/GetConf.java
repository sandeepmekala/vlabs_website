package com.virtualis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
public class GetConf implements Global{

	private String ConfStr;
	private String AppName,Tag,Version,Authors,Website,Support,downlods;
	private String ClsNo, ExpList_Link, OneExp_Link,GetStart,Terms;
	
	JSONObject JObj,global,info,conf;
	FileOutputStream fos;
	
	public GetConf() throws Exception{
		
		ConfStr = new Functions().readFile(BASEDIR +CONFFILE);
			
		try{
			
			JObj = (new JSONObject(ConfStr)).getJSONObject("Info"); 
				this.setAppName(JObj.getString("Name"));
				this.setTag(JObj.getString("Tag"));
				this.setVersion(JObj.getString("Version"));
				this.setAuthors(JObj.getString("Authors"));
				this.setSupport(JObj.getString("Support"));
				this.setDownlods(JObj.getString("Downloads"));
				
			JObj = (new JSONObject(ConfStr)).getJSONObject("Conf"); 
				this.setClsNo(JObj.getString("Class"));
				this.setExpList_Link(JObj.getString("ExpList"));
				this.setOneExp_Link(JObj.getString("ExpOne"));
				this.setTerms(JObj.getString("Terms"));
				this.setGetStart(JObj.getString("GetStart"));
				
		}catch(JSONException e){
			e.printStackTrace();
		}
		
	}
	
	public void SetConf(){
			global = new JSONObject();
			info = new JSONObject();
			try{
				info.put("Name", this.getAppName());
				info.put("Tag", this.getTag());
				info.put("Version", this.getVersion());
				info.put("Support", this.getSupport());
				info.put("Authors",this.getAuthors());
				info.put("Downloads", this.getDownlods());
			}catch(JSONException e){
				e.printStackTrace();
			}
			
			conf = new JSONObject();
			try{
				conf.put("Class", this.getClsNo());
				conf.put("ExpList", this.getExpList_Link());
				conf.put("ExpOne", this.getOneExp_Link());
				conf.put("Terms", this.getTerms());
				conf.put("GetStart", this.getGetStart());
				
			}catch(JSONException e){
				e.printStackTrace();
			}
			
			try {
				global.put("Info", info);
				global.put("Conf", conf);
				
				fos = new FileOutputStream(BASEDIR+CONFFILE);
				byte byt[] = global.toString().getBytes();
				Log.d("save",global.toString());
				fos.write(byt);
				fos.close();
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	 
	public String getAppName() {
		return AppName;
	}

	public void setAppName(String appName) {
		AppName = appName;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getAuthors() {
		return Authors;
	}

	public void setAuthors(String authors) {
		Authors = authors;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public String getSupport() {
		return Support;
	}

	public void setSupport(String support) {
		Support = support;
	}

	public String getDownlods() {
		return downlods;
	}

	public void setDownlods(String downlods) {
		this.downlods = downlods;
	}

	public String getClsNo() {
		return ClsNo;
	}

	public void setClsNo(String clsNo) {
		ClsNo = clsNo;
	}

	public String getExpList_Link() {
		return ExpList_Link;
	}

	public void setExpList_Link(String expList_Link) {
		ExpList_Link = expList_Link;
	}

	public String getOneExp_Link() {
		return OneExp_Link;
	}

	public void setOneExp_Link(String oneExp_Link) {
		OneExp_Link = oneExp_Link;
	}
	
	public String getTerms() {
		return Terms;
	}

	public void setTerms(String terms) {
		Terms = terms;
	}

	public String getGetStart() {
		return GetStart;
	}

	public void setGetStart(String getStart) {
		GetStart = getStart;
	}

}
