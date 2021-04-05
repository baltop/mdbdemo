package com.esez.mdb.model.postgres;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;



import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.Persistent;

@Entity
@Table(name="tag_info", schema = "iot_web")
public class TagInfo implements Serializable {

	private static final long serialVersionUID = 8130882479201206991L;
	
	@Id
	@Column(name="tag_id", length=32 )
	private String tagId;
	
	@Column(name="tag_cd", length=64 )
	private String tagCd;
	
	@Column(name="tag_nm", length=300 )
	private String tagNm;
	
	@Column(name="tag_desc", length=500 )
	private String tagDesc;
	
	@Column(name="tag_unit", length=50 )
	private String tagUnit;

	@Column(name="tag_unit_nm", length=200 )
	private String tagUnitNm;
	
	@Column(name="tag_type", length=50 )
	private String tagType;

//	@Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+ CommonCode.GRUP_CD.TagType+"' AND cci.cd = tag_type)")
//	private String tagTypeNm;
	
	@Column(name="cremn", length=32 )
	private String creMn;
	
	@Column(name="cre_dtm", length=32 )
	private String creDtm;
	
	@Column(name="updmn", length=32 )
	private String updMn;
	
	@Column(name="upd_dtm", length=32 )
	private String updDtm;

	@Column(name="client_cd", length=32 )
	private String clientCd;

	@Column(name="site_cd", length=32 )
	private String siteCd;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns(value = {
//			@JoinColumn(name = "client_cd", referencedColumnName = "client_cd", updatable = false, insertable = false),
//			@JoinColumn(name = "site_cd", referencedColumnName = "site_cd", updatable = false, insertable = false)
//	})
//	@Embedded
//	private ClientSiteView clientSiteView;

//	public ClientSiteView getClientSiteView() {
//		return clientSiteView;
//	}

//	public void setClientSiteView(ClientSiteView clientSiteView) {
//		this.clientSiteView = clientSiteView;
//	}

//	@JsonIgnore
//	@OneToMany(mappedBy="tagInfo" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<TagModelMappInfo> dvcModelMappInfos;
//	
	@Transient
	private String creDtmView;
	
	@Transient
	private String updDtmView;

//	public String getTagTypeNm() {
//		return tagTypeNm;
//	}
//
//	public void setTagTypeNm(String tagTypeNm) {
//		this.tagTypeNm = tagTypeNm;
//	}

	public String getCreDtmView() {
		return creDtmView;
	}

	public void setCreDtmView(String creDtmView) {
		this.creDtmView = creDtmView;
	}

	public String getUpdDtmView() {
		return updDtmView;
	}

	public void setUpdDtmView(String updDtmView) {
		this.updDtmView = updDtmView;
	}

	public String getCreMn() {
		return creMn;
	}

	public void setCreMn(String creMn) {
		this.creMn = creMn;
	}

	public String getCreDtm() {
		return creDtm;
	}

	public void setCreDtm(String creDtm) {
		this.creDtm = creDtm;
	}

	public String getUpdMn() {
		return updMn;
	}

	public void setUpdMn(String updMn) {
		this.updMn = updMn;
	}

	public String getUpdDtm() {
		return updDtm;
	}

	public void setUpdDtm(String updDtm) {
		this.updDtm = updDtm;
	}

//	public List<TagModelMappInfo> getDvcModelMappInfos() {
//		return dvcModelMappInfos;
//	}
//
//	public void setDvcModelMappInfos(List<TagModelMappInfo> dvcModelMappInfos) {
//		this.dvcModelMappInfos = dvcModelMappInfos;
//	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getTagCd() {
		return tagCd;
	}

	public void setTagCd(String tagCd) {
		this.tagCd = tagCd;
	}

	public String getTagNm() {
		return tagNm;
	}

	public void setTagNm(String tagNm) {
		this.tagNm = tagNm;
	}

	public String getTagDesc() {
		return tagDesc;
	}

	public void setTagDesc(String tagDesc) {
		this.tagDesc = tagDesc;
	}

	public String getTagUnit() {
		return tagUnit;
	}

	public void setTagUnit(String tagUnit) {
		this.tagUnit = tagUnit;
	}

	public String getTagType() {
		return tagType;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

	public String getClientCd() { return clientCd; }

	public void setClientCd(String clientCd) { this.clientCd = clientCd; }

	public String getSiteCd() { return siteCd; }

	public void setSiteCd(String siteCd) { this.siteCd = siteCd; }

	public String getTagUnitNm() {
		return tagUnitNm;
	}

	public void setTagUnitNm(String tagUnitNm) {
		this.tagUnitNm = tagUnitNm;
	}
}
