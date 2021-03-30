package com.esez.mdb.model.postgres;




import javax.persistence.*;


@Entity
@Table(name = "OMS_USER_INFO", schema="oms")
public class UserInfo {
	
	@Id
	@Column(name = "USER_ID", length = 22, nullable = false, unique = true)
	private String userId = "";
	
	@Column(name = "USER_LOGIN_ID", length = 50)
	private String userLoginId = "";
	
	@Column(name = "USER_LOGIN_PSWD", length = 64)
	private String userLoginPswd = "";
	
	@Column(name = "USER_NM", length = 50)
	private String userNm = "";
	
	@Column(name = "PHONE", length = 50)
	private String phone = "";
	
	@Column(name = "CP_NO", length = 50)
	private String cpNo = "";
	
	@Column(name = "EMAIL", length = 100)
	private String email = "";
	
	@Column(name = "FIST_REG_DTM", length = 17)
	private String fistRegDtm = "";
	
	@Column(name = "LST_LOGIN_DTM", length = 17)
	private String lstLoginDtm = "";
	
	@Column(name = "USE_YN", length = 1)
	private String useYn = "";
	
	@Column(name = "DPT_ID", length = 22)
	private String dptId;
	
	@Column(name = "ROlE_ID", length = 22, nullable = true)
	private String roleId;
	
	@Column(name = "ENCRYPT_KEY", length = 50, nullable = true)
	private String encryptKey;
	
	@Column(name = "login_try_count")
	private int loginTryCount;
	
	@Column(name = "login_block_flag", length = 5)
	private String loginBlockFlag;
	
	@Column(name = "EVENT_ROLE_ID", length = 50)
	private String eventRoleId;
	
	@Column(name = "USER_GD", length = 50)
	private String userGd;
	
	@Column(name = "CLIENT_CD", length = 3)
	private String clientCd;
	
	@Column(name = "SITE_CD", length = 3)
	private String siteCd;
	
	@Column(name = "salt", length = 100)
	private String salt;
	
	@Column(name = "approved", length = 1)
	private String approved;
	
	@Column(name = "INIT", length = 1)
	private String init;
	
	@Column(name = "PSWD_CHANGE_DTM", length = 17)
	private String pswdChangeDtm;
	
	


	
	public UserInfo() {
		super();
	}
	
	public UserInfo(String userId, String userLoginId, String userLoginPswd, String userNm, String phone, String cpNo,
	                String email, String fistRegDtm, String lstLoginDtm, String useYn, String dptId, String roleId,
	                String encryptKey, int loginTryCount, String loginBlockFlag, String eventRoleId, String userGd,
	                String clientCd, String siteCd) {
		super();
		this.userId = userId;
		this.userLoginId = userLoginId;
		this.userLoginPswd = userLoginPswd;
		this.userNm = userNm;
		this.phone = phone;
		this.cpNo = cpNo;
		this.email = email;
		this.fistRegDtm = fistRegDtm;
		this.lstLoginDtm = lstLoginDtm;
		this.useYn = useYn;
		this.dptId = dptId;
		this.roleId = roleId;
		this.encryptKey = encryptKey;
		this.loginTryCount = loginTryCount;
		this.loginBlockFlag = loginBlockFlag;
		this.eventRoleId = eventRoleId;
		this.userGd = userGd;
		this.clientCd = clientCd;
		this.siteCd = siteCd;
	}
	

	

	
	public String getPswdChangeDtm() {
		return pswdChangeDtm;
	}
	
	public void setPswdChangeDtm(String pswdChangeDtm) {
		this.pswdChangeDtm = pswdChangeDtm;
	}
	
	public String getEncryptKey() {
		return encryptKey;
	}
	
	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}
	
	public String getUserLoginPswd() {
		return userLoginPswd;
	}
	
	public void setUserLoginPswd(String userLoginPswd) {
		this.userLoginPswd = userLoginPswd;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserLoginId() {
		return userLoginId;
	}
	
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	
	public String getUserNm() {
		return userNm;
	}
	
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCpNo() {
		return cpNo;
	}
	
	public void setCpNo(String cpNo) {
		this.cpNo = cpNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFistRegDtm() {
		return fistRegDtm;
	}
	
	public void setFistRegDtm(String fistRegDtm) {
		this.fistRegDtm = fistRegDtm;
	}
	
	public String getLstLoginDtm() {
		return lstLoginDtm;
	}
	
	public void setLstLoginDtm(String lstLoginDtm) {
		this.lstLoginDtm = lstLoginDtm;
	}
	
	public String getUseYn() {
		return useYn;
	}
	
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	
	
	public String getDptId() {
		return dptId;
	}
	
	public void setDptId(String dptId) {
		this.dptId = dptId;
	}
	
	public String getRoleId() {
		return roleId;
	}
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public int getLoginTryCount() {
		return loginTryCount;
	}
	
	public void setLoginTryCount(int loginTryCount) {
		this.loginTryCount = loginTryCount;
	}
	
	public String getLoginBlockFlag() {
		return loginBlockFlag;
	}
	
	public void setLoginBlockFlag(String loginBlockFlag) {
		this.loginBlockFlag = loginBlockFlag;
	}
	
	public String getEventRoleId() {
		return eventRoleId;
	}
	
	public void setEventRoleId(String eventRoleId) {
		this.eventRoleId = eventRoleId;
	}
	
	public String getUserGd() {
		return userGd;
	}
	
	public void setUserGd(String userGd) {
		this.userGd = userGd;
	}
	
	
	public String getClientCd() {
		return clientCd;
	}
	
	public void setClientCd(String clientCd) {
		this.clientCd = clientCd;
	}
	
	public String getSiteCd() {
		return siteCd;
	}
	
	public void setSiteCd(String siteCd) {
		this.siteCd = siteCd;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getApproved() {
		return approved;
	}
	
	public void setApproved(String approved) {
		this.approved = approved;
	}
	
	
	
	public String getInit() {
		return init;
	}
	
	public void setInit(String init) {
		this.init = init;
	}
	
	
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("UserInfo{");
		sb.append("userId='").append(userId).append('\'');
		sb.append(", userLoginId='").append(userLoginId).append('\'');
		sb.append(", userLoginPswd='").append(userLoginPswd).append('\'');
		sb.append(", userNm='").append(userNm).append('\'');
		sb.append(", phone='").append(phone).append('\'');
		sb.append(", cpNo='").append(cpNo).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", fistRegDtm='").append(fistRegDtm).append('\'');
		sb.append(", lstLoginDtm='").append(lstLoginDtm).append('\'');
		sb.append(", useYn='").append(useYn).append('\'');
		sb.append(", dptId='").append(dptId).append('\'');
		sb.append(", roleId='").append(roleId).append('\'');
		sb.append(", encryptKey='").append(encryptKey).append('\'');
		sb.append(", loginTryCount=").append(loginTryCount);
		sb.append(", loginBlockFlag='").append(loginBlockFlag).append('\'');
		sb.append(", eventRoleId='").append(eventRoleId).append('\'');
		sb.append(", userGd='").append(userGd).append('\'');
		sb.append(", clientCd='").append(clientCd).append('\'');
		sb.append(", siteCd='").append(siteCd).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
