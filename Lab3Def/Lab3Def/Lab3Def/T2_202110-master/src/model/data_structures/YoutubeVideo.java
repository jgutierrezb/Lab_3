package model.data_structures;

import java.util.*;

public class YoutubeVideo implements Comparable <YoutubeVideo> {

	private Date IDVideo;

	private String categoryID;

	private int likes;

	private String title;

	private String  channeltitle;

	private int uploadDate;



	public YoutubeVideo(int pLikes, String pCategoryID, Date date, String pTitle, String  f, int i ) {
		this.IDVideo = date;
		this.categoryID = pCategoryID;
		this.likes = pLikes;
		this.title = pTitle;
		this.channeltitle = f;
		this.uploadDate = i;
		

	}


	
	
	
	@Override
	public int compareTo(YoutubeVideo o) {
		int respuesta =0;
		if(this.likes == o.likes) {
			respuesta = 0;
			
		}
		else if (this.likes >o.likes) {
			respuesta = 1;
		}
		else if (this.likes <o.likes) {
			respuesta = -1;
		}
		return respuesta;
		
		
	}

	public Date getID()
	{
		return IDVideo;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public float getLikes()
	{
		return likes;
	}
	
	public String gettitle()
	{
		return title;
	}
	
	public String getchanneltitle()
	{
		return channeltitle;
	}
	
	public int getuploadDate()
	{
		return uploadDate;
	}

	

}
