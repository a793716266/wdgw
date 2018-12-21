package com.flc.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 帖子
 * @author Jason
 *
 */
public class Posting {
	private String post_id;      //帖子Id
	private String postType_id;  //帖子类型id
	private String title;        //帖子标题
	private String content;      //帖子内容(富文本)
	private String use;			//用户
	private User user;           //发布人
	private Integer viewNumber = 0;  //浏览次数
	private Integer heat = 0;         //热度
	private String downloadAttachment;  //下载附件地址
	private String releaseCVersion;  //发布版本
	private Integer restoreNumber = 0; //回复数
	private List<PostReturn> postReturns;  //评论集合
	private Date createTime = new Date();     //创建时间
	private String createUser;   //创建人
	private String remarks;      //备注
	private String userid;		//用户id
	private String picture;		//用户头像
	
	private String name;	//帖子类型名称
	private String nickname;	//用户名
	private Integer replycard;  //回帖次数
	private String NewTimeDifference;//时间差
	private String viewnumber;	//帖子浏览量
	
	private String timeDiff;		//时间差
	
	/**
	 * 时间判断
	 * @return
	 */
	public String getTimeDiff() {
		if(null != timeDiff ){
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String fromDate = simpleFormat.format(new Date());
			SimpleDateFormat simplefirst = new SimpleDateFormat("yyyy-MM-dd");
			String todayFirst = simplefirst.format(new Date());
			
			try {
				long from = simpleFormat.parse(fromDate).getTime();
				long to = simpleFormat.parse(todayFirst+" 00:00:00").getTime();
				long diff = (from-to)/1000;
				Long timeDiff = Long.parseLong(this.timeDiff);
				if((timeDiff-diff)<0){
					if(timeDiff<60){
						this.timeDiff = "刚刚";
					}else if(60 < timeDiff && timeDiff < (60*60)){
						this.timeDiff = (timeDiff/60)+"分钟前";
					}else if(60*60 < timeDiff && timeDiff <  (60*60*24)){
						this.timeDiff = (timeDiff/60/60)+"小时前";
					}
					return this.timeDiff;
				}else{
					timeDiff = timeDiff-diff;
					switch ((int)(timeDiff/(24*60*60))) {
					case 0:
						this.timeDiff="昨天";
						break;
					case 1:
						this.timeDiff="前天";
						break;
					case 2:case 3:case 4:case 5:case 6:
						this.timeDiff= timeDiff/(24*60*60)+"天前";
						break;
					case 7:
						this.timeDiff= "一周前";
						break;
					default:
						SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm");
						this.timeDiff= simple.format(createTime);
						break;
					}
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return this.timeDiff;
	}
	public void setTimeDiff(String timeDiff) {
		this.timeDiff = timeDiff;
	}
	public String getViewnumber() {
		return viewnumber;
	}
	public void setViewnumber(String viewnumber) {
		this.viewnumber = viewnumber;
	}
	public String getNewTimeDifference() {
		return NewTimeDifference;
	}
	public void setNewTimeDifference(String newTimeDifference) {
		NewTimeDifference = newTimeDifference;
	}
	public Integer getReplycard() {
		return replycard;
	}
	public void setReplycard(Integer replycard) {
		this.replycard = replycard;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PostReturn> getPostReturns() {
		return postReturns;
	}
	public void setPostReturns(List<PostReturn> postReturns) {
		this.postReturns = postReturns;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getPostType_id() {
		return postType_id;
	}
	public void setPostType_id(String postType_id) {
		this.postType_id = postType_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getViewNumber() {
		return viewNumber;
	}
	public void setViewNumber(Integer viewNumber) {
		this.viewNumber = viewNumber;
	}
	public Integer getHeat() {
		return heat;
	}
	public void setHeat(Integer heat) {
		this.heat = heat;
	}
	public String getDownloadAttachment() {
		return downloadAttachment;
	}
	public void setDownloadAttachment(String downloadAttachment) {
		this.downloadAttachment = downloadAttachment;
	}
	public String getReleaseCVersion() {
		return releaseCVersion;
	}
	public void setReleaseCVersion(String releaseCVersion) {
		this.releaseCVersion = releaseCVersion;
	}
	public Integer getRestoreNumber() {
		return restoreNumber;
	}
	public void setRestoreNumber(Integer restoreNumber) {
		this.restoreNumber = restoreNumber;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	@Override
	public String toString() {
		return "Posting [post_id=" + post_id + ", postType_id=" + postType_id + ", title=" + title + ", content="
				+ content + ", viewNumber=" + viewNumber + ", heat=" + heat + ", downloadAttachment="
				+ downloadAttachment + ", releaseCVersion=" + releaseCVersion + ", restoreNumber=" + restoreNumber
				+ ", createTime=" + createTime + ", createUser=" + createUser + ", remarks=" + remarks + "]";
	}
	
	
	
}
