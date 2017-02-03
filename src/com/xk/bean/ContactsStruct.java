package com.xk.bean;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.graphics.Image;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xk.utils.JSONUtil;

/**
 * 用途：联系人数据
 *
 * @author xiaokui
 * @date 2016年12月30日
 */
public class ContactsStruct {
	public Long Uin;
	public String UserName;
	public String NickName;
	public String HeadImgUrl;
	public Integer ContactFlag;
	public Integer MemberCount;
	public List<MemberStruct> MemberList;
	public String RemarkName;
	public Integer HideInputBarFlag;
	public Integer Sex;
	public String Signature;
	public Integer VerifyFlag;
	public Long OwnerUin;
	public String PYInitial;
	public String PYQuanPin;
	public String RemarkPYInitial;
	public String RemarkPYQuanPin;
	public Integer StarFriend;
	public Integer AppAccountFlag;
	public Integer Statues;
	public Long AttrStatus;
	public String Province;
	public String City;
	public String Alias;
	public Integer SnsFlag;
	public Integer UniFriend;
	public String DisplayName;
	public Integer ChatRoomId;
	public String KeyWord;
	public String EncryChatRoomId;
	public String IsOwner;
	
	@JsonIgnore
	public Image head;
	
	public ContactsStruct(){
		
	}
	
	
	public ContactsStruct(Long uin, String userName, String nickName, String headImgUrl, Integer contactFlag,
			Integer memberCount, List<MemberStruct> memberList, String remarkName, Integer hideInputBarFlag,
			Integer sex, String signature, Integer verifyFlag, Long ownerUin, String pYInitial, String pYQuanPin,
			String remarkPYInitial, String remarkPYQuanPin, Integer starFriend, Integer appAccountFlag, Integer statues,
			Long attrStatus, String province, String city, String alias, Integer snsFlag, Integer uniFriend,
			String displayName, Integer chatRoomId, String keyWord, String encryChatRoomId) {
		super();
		Uin = uin;
		UserName = userName;
		NickName = nickName;
		HeadImgUrl = headImgUrl;
		ContactFlag = contactFlag;
		MemberCount = memberCount;
		MemberList = memberList;
		RemarkName = remarkName;
		HideInputBarFlag = hideInputBarFlag;
		Sex = sex;
		Signature = signature;
		VerifyFlag = verifyFlag;
		OwnerUin = ownerUin;
		PYInitial = pYInitial;
		PYQuanPin = pYQuanPin;
		RemarkPYInitial = remarkPYInitial;
		RemarkPYQuanPin = remarkPYQuanPin;
		StarFriend = starFriend;
		AppAccountFlag = appAccountFlag;
		Statues = statues;
		AttrStatus = attrStatus;
		Province = province;
		City = city;
		Alias = alias;
		SnsFlag = snsFlag;
		UniFriend = uniFriend;
		DisplayName = displayName;
		ChatRoomId = chatRoomId;
		KeyWord = keyWord;
		EncryChatRoomId = encryChatRoomId;
	}
	
	/**
	 * 用途：微信服务器获取的数据
	 * @date 2016年12月30日
	 * @param map
	 * @return
	 */
	public static ContactsStruct fromMap(Map<String, Object> map) {
		String json = JSONUtil.toJson(map);
		ContactsStruct conv = JSONUtil.toBean(json, ContactsStruct.class);
		return conv;
	}
	
	
	/**
	 * 用途：获取指定群成员显示名称
	 * @date 2017年1月3日
	 * @param user
	 * @param con
	 * @return
	 */
	public static String getGroupMember(String user, ContactsStruct con) {
		String name = "匿名";
		if(null != con && con.UserName.startsWith("@@")) {
			for(MemberStruct member : con.MemberList) {
				if(user.equals(member.UserName)) {
					if(null != member.DisplayName && !member.DisplayName.isEmpty()) {
						name = member.DisplayName.trim();
					}else {
						name = member.NickName;
					}
					break;
				}
			}
		}
		return name;
	}
	
	
	/**
	 * 用途：获取显示名
	 * @date 2017年1月3日
	 * @param con
	 * @return
	 */
	public static String getContactName(ContactsStruct con) {
		String name = "匿名";
		if (null != con.RemarkName && !con.RemarkName.trim().isEmpty()) {
			name = con.RemarkName;
		} else {
			name = con.NickName;
		}
		return name;
	}
}
