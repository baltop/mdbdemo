package com.esez.mdb.model.postgres;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contentinstance", schema = "zium")
public class ContentInstance {
	@Id
	@Column(name="resource_id")
	String resourceId;
	@Column(name="resource_name")
	String resourceName;
	@Column(name="parent_id")
	String parentId;
	@Column(name="create_at")
	Timestamp createAt;
	@Column(name="state_tag")
	Integer stateTag;
	String labels;
	String creator;
	@Column(name="content_info")
	String contentInfo;
	@Column(name="content_size")
	Integer contentSize;
	@Column(name="ontology_ref")
	String ontologyRef;
	String content;
	Long timeof;
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	public Integer getStateTag() {
		return stateTag;
	}
	public void setStateTag(Integer stateTag) {
		this.stateTag = stateTag;
	}
	public String getLabels() {
		return labels;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getContentInfo() {
		return contentInfo;
	}
	public void setContentInfo(String contentInfo) {
		this.contentInfo = contentInfo;
	}
	public Integer getContentSize() {
		return contentSize;
	}
	public void setContentSize(Integer contentSize) {
		this.contentSize = contentSize;
	}
	public String getOntologyRef() {
		return ontologyRef;
	}
	public void setOntologyRef(String ontologyRef) {
		this.ontologyRef = ontologyRef;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getTimeof() {
		return timeof;
	}
	public void setTimeof(Long timeof) {
		this.timeof = timeof;
	}
	
}
