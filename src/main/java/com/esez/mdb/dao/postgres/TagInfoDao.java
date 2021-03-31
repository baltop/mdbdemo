package com.esez.mdb.dao.postgres;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.esez.mdb.model.postgres.TagInfo;
import com.google.common.base.Strings;



@Repository(value = "TagInfoDao")
public class TagInfoDao {

    @PersistenceContext(unitName = "postgresPU")
    EntityManager em;
    
    /**
     * total count get 
     * @param paramMap
     * @return
     */
    public int getTotalCount(Map<String, Object> paramMap) {

        String siteCd = paramMap.get("siteCd") == null ? "" : paramMap.get("siteCd").toString();
    	String tagNm = paramMap.get("tagNm") == null ? "" : paramMap.get("tagNm").toString();
		String tagType = paramMap.get("tagType") == null ? "" : paramMap.get("tagType").toString();
//		User user = (User) paramMap.get("user");
//		ArrayList<JsonObject> allowedClientList = user.getAllowedCilentList();
//		ArrayList<JsonObject> allowedSiteList = user.getAllowedSiteList();
//
//		if(allowedClientList.size() <= 0 || allowedSiteList.size() <= 0) return 0;

		StringBuilder sb = new StringBuilder();
    	sb.append(" SELECT count(ti) FROM TagInfo AS ti ");
    	sb.append(" WHERE 1=1 ");

//        if (!Strings.isNullOrEmpty(clientCd)) {
//        	if(clientCd.equals("all")){
//				sb.append(" AND (");
//				for (int i = 0; i < allowedClientList.size(); i++) {
//					if(i == 0){
//						sb.append(" clientCd = :clientCd"+i+" ");
//					}
//					else {
//						sb.append(" OR clientCd = :clientCd"+i+" ");
//					}
//				}
//				sb.append(" ) ");
//			}
//            else {
//				sb.append(" AND clientCd = :clientCd ");
//			}
//        }
//        if (!Strings.isNullOrEmpty(siteCd)) {
//        	if(siteCd.equals("all")){
//				sb.append(" AND (");
//				for (int i = 0; i < allowedSiteList.size(); i++) {
//					if(i == 0){
//						sb.append(" siteCd = :siteCd"+i+" ");
//					}
//					else {
//						sb.append(" OR siteCd = :siteCd"+i+" ");
//					}
//				}
//				sb.append(" ) ");
//			}
//        	else{
//				sb.append(" AND siteCd = :siteCd ");
//			}
//        }
    	if (siteCd != null && !siteCd.equals("")) {
    		sb.append(" AND siteCd = :siteCd ");
    	}
    	if (tagNm != null) {
    		sb.append(" AND tagNm like :tagNm ");
    	}
    	if (tagType != null) {
    		sb.append(" AND tagType = :tagType ");
    	}
    	
    	Query query = em.createQuery(sb.toString());

//        if (!Strings.isNullOrEmpty(clientCd)) {
//        	if(clientCd.equals("all")){
//				for (int i = 0; i < allowedClientList.size(); i++) {
//					query.setParameter("clientCd"+i, allowedClientList.get(i).get("clientCd").getAsString());
//				}
//			}
//        	else {
//				query.setParameter("clientCd", clientCd);
//			}
//        }
//        if (!Strings.isNullOrEmpty(siteCd)) {
//			if(siteCd.equals("all")){
//				for (int i = 0; i < allowedSiteList.size(); i++) {
//					query.setParameter("siteCd"+i, allowedSiteList.get(i).get("siteCd").getAsString());
//				}
//			}
//			else {
//				query.setParameter("siteCd", siteCd);
//			}
//        }
    	if (siteCd != null) {
    		query.setParameter("siteCd", siteCd);
    	}
    	if (tagNm != null) {
    		query.setParameter("tagNm", tagNm);
    	}
    	if (tagType != null) {
    		query.setParameter("tagType", tagType);
    	}
    	
    	int result = ((Long) query.getSingleResult()).intValue();
    	
    	return result;
    }
    
    public List<TagInfo> getList(Map<String, Object> paramMap) {
    	
    	String page = paramMap.get("page") == null ? "" : paramMap.get("page").toString(); 
    	String rows = paramMap.get("rows") == null ? "" : paramMap.get("rows").toString(); 
    	String sortIndex = paramMap.get("sortIndex") == null ? "" : paramMap.get("sortIndex").toString(); 
    	String sortColumn = paramMap.get("sortColumn") == null ? "" : paramMap.get("sortColumn").toString();

		String siteCd = paramMap.get("siteCd") == null ? "" : paramMap.get("siteCd").toString();
    	String tagNm = paramMap.get("tagNm") == null ? "" : paramMap.get("tagNm").toString(); 
    	String tagType = paramMap.get("tagType") == null ? "" : paramMap.get("tagType").toString();
//		User user = (User) paramMap.get("user");
//		ArrayList<JsonObject> allowedClientList = user.getAllowedCilentList();
//		ArrayList<JsonObject> allowedSiteList = user.getAllowedSiteList();
//
//		if(allowedClientList.size() <= 0 || allowedSiteList.size() <= 0) return null;
//    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(" SELECT t FROM TagInfo AS t");
    	sb.append(" WHERE 1=1 ");

//		if (!Strings.isNullOrEmpty(clientCd)) {
//			if(clientCd.equals("all")){
//				sb.append(" AND (");
//				for (int i = 0; i < allowedClientList.size(); i++) {
//					if(i == 0){
//						sb.append(" clientCd = :clientCd"+i+" ");
//					}
//					else {
//						sb.append(" OR clientCd = :clientCd"+i+" ");
//					}
//				}
//				sb.append(" ) ");
//			}
//			else {
//				sb.append(" AND clientCd = :clientCd ");
//			}
//		}
//		if (!Strings.isNullOrEmpty(siteCd)) {
//			if(siteCd.equals("all")){
//				sb.append(" AND (");
//				for (int i = 0; i < allowedSiteList.size(); i++) {
//					if(i == 0){
//						sb.append(" siteCd = :siteCd"+i+" ");
//					}
//					else {
//						sb.append(" OR siteCd = :siteCd"+i+" ");
//					}
//				}
//				sb.append(" ) ");
//			}
//			else{
//				sb.append(" AND siteCd = :siteCd ");
//			}
//		}
    	if (!Strings.isNullOrEmpty(siteCd)) {
    		sb.append(" AND siteCd = :siteCd ");
    	}
    	if (!Strings.isNullOrEmpty(tagNm)) {
    		sb.append(" AND tagNm like :tagNm ");
    	}
    	if (!Strings.isNullOrEmpty(tagType)) {
    		sb.append(" AND tagType = :tagType ");
    	}
    	
    	if(sortIndex.equalsIgnoreCase("desc")){
			if(Strings.isNullOrEmpty(sortColumn)){
				sb.append(" ORDER BY clientCd ASC, siteCd ASC, creDtm DESC");
			}else{
				sb.append(" ORDER BY clientCd ASC, siteCd ASC, ").append( sortColumn ).append(" DESC");
			}
		}else{
			if(Strings.isNullOrEmpty(sortColumn)){
				sb.append(" ORDER BY clientCd ASC, siteCd ASC, creDtm ASC");
			}else{
				sb.append(" ORDER BY clientCd ASC, siteCd ASC, ").append( sortColumn ).append(" ASC");
			}
		}
		
    	int startIndex = 0;
    	int rowsInt = 999;
    	if (!(Strings.isNullOrEmpty(page) || Strings.isNullOrEmpty(rows))) {
    		startIndex = (Integer.valueOf(page)-1) * Integer.valueOf(rows);
    		rowsInt = Integer.valueOf(rows);
    	}

    	TypedQuery<TagInfo> query = em.createQuery(sb.toString(), TagInfo.class).setFirstResult(startIndex).setMaxResults(rowsInt);

//		if (!Strings.isNullOrEmpty(clientCd)) {
//			if(clientCd.equals("all")){
//				for (int i = 0; i < allowedClientList.size(); i++) {
//					query.setParameter("clientCd"+i, allowedClientList.get(i).get("clientCd").getAsString());
//				}
//			}
//			else {
//				query.setParameter("clientCd", clientCd);
//			}
//		}
//		if (!Strings.isNullOrEmpty(siteCd)) {
//			if(siteCd.equals("all")){
//				for (int i = 0; i < allowedSiteList.size(); i++) {
//					query.setParameter("siteCd"+i, allowedSiteList.get(i).get("siteCd").getAsString());
//				}
//			}
//			else {
//				query.setParameter("siteCd", siteCd);
//			}
//		}
    	if (!Strings.isNullOrEmpty(siteCd)) {
    		query.setParameter("siteCd", siteCd);
    	}
//    	if (!Strings.isNullOrEmpty(tagNm)) {
//    		query.setParameter("tagNm", CommonCode.SEPERATOR.PERSENTAGE.getValue()+tagNm+CommonCode.SEPERATOR.PERSENTAGE.getValue());
//    	}
    	if (!Strings.isNullOrEmpty(tagType)) {
    		query.setParameter("tagType", tagType);
    	}

    	List<TagInfo> lists = query.getResultList();
    	return lists;
    }
//    
//    @Transactional
//    public int create(TagInfo tagInfo) throws IoTException {
//    	int i = 0;
//    	try {
//    		em.persist(tagInfo);
//    		i ++;
//    	} catch (EntityExistsException e) {
//    		logger.error(e.getMessage());
//    		throw new IoTException(CommonCode.RSC.ALREADY_EXISTS.getValue(), e.getMessage());
//    	} catch (IllegalArgumentException e) {
//    		logger.error(e.getMessage());
//    		throw new IoTException(CommonCode.RSC.BAD_REQUEST.getValue(), e.getMessage());
//    	}
//    	return i;
//    }
//    
//    public TagInfo retrieve(TagInfo tagInfo) throws IoTException {
//    	TagInfo findObj = null;
//    	try {
//    		findObj = em.find(TagInfo.class, tagInfo.getTagId());
//    		if (findObj == null) {
//    			logger.error("tag info not found");
//    			throw new IoTException(CommonCode.RSC.NOT_FOUND.getValue(), "tag info not found");
//    		}
//    	} catch (IllegalArgumentException e) {
//    		logger.error(e.getMessage());
//    		throw new IoTException(CommonCode.RSC.BAD_REQUEST.getValue(), e.getMessage());
//    	}
//    	return findObj;
//    }
//    
//    
//    @Transactional
//    public int update(TagInfo tagInfo) throws IoTException {
//    	
//    	int i = 0;
//    	try {
//    		
//	    	TagInfo findObj = em.find(TagInfo.class, tagInfo.getTagId());
//	    	if (findObj == null) {
//    			logger.error("tag info not found");
//        		throw new IoTException(CommonCode.RSC.NOT_FOUND.getValue(), "tag info not found");
//    		}
//
//			if (!Strings.isNullOrEmpty(tagInfo.getClientCd())) {
//				findObj.setClientCd(tagInfo.getClientCd());
//			}
//			if (!Strings.isNullOrEmpty(tagInfo.getSiteCd())) {
//				findObj.setSiteCd(tagInfo.getSiteCd());
//			}
//	    	// 태그 코드
//	    	if (!Strings.isNullOrEmpty(tagInfo.getTagCd())) {
//	    		findObj.setTagCd(tagInfo.getTagCd());
//	    	}
//	    	// 태그 명
//	    	if (!Strings.isNullOrEmpty(tagInfo.getTagNm())) {
//	    		findObj.setTagNm(tagInfo.getTagNm());
//	    	}
//	    	// 태그 설명
//	    	if (!Strings.isNullOrEmpty(tagInfo.getTagDesc())) {
//	    		findObj.setTagDesc(tagInfo.getTagDesc());
//	    	}
//	    	// 태그 유형
//	    	if (!Strings.isNullOrEmpty(tagInfo.getTagType())) {
//	    		findObj.setTagType(tagInfo.getTagType());
//	    	}
//	    	// 태그 단위
//	    	if (!Strings.isNullOrEmpty(tagInfo.getTagUnit())) {
//	    		findObj.setTagUnit(tagInfo.getTagUnit());
//	    	}
//			if (!Strings.isNullOrEmpty(tagInfo.getTagUnitNm())) {
//				findObj.setTagUnitNm(tagInfo.getTagUnitNm());
//			}
//	    	em.flush();
//	    	i ++;
//    	} catch (IllegalArgumentException e) {
//    		logger.error(e.getMessage());
//    		throw new IoTException(CommonCode.RSC.BAD_REQUEST.getValue(), e.getMessage());
//    	}
//    	return i;
//    }
//    
//    @Transactional
//    public int delete(TagInfo tagInfo) throws IoTException { 
//    	int i = 0;
//    	try {
//    		TagInfo findObj = em.find(TagInfo.class, tagInfo.getTagId());
//    		
//    		if (findObj == null) {
//    			logger.error("tag info not found");
//        		throw new IoTException(CommonCode.RSC.NOT_FOUND.getValue(), "tag info not found");
//    		}
//    		
//    		em.remove(findObj);
//    		i ++;
//    	} catch (IllegalArgumentException e) {
//    		logger.error(e.getMessage());
//    		throw new IoTException(CommonCode.RSC.BAD_REQUEST.getValue(), e.getMessage());
//    	}
//    	return i;
//    }
//    
//    public List<TagModelMappInfo> getMappInfoList(String dvcModelId) {
//    	
//    	StringBuilder sb = new StringBuilder();
//    	sb.append(" SELECT tmmi FROM TagModelMappInfo AS tmmi");
//    	sb.append(" WHERE 1=1 ");
//    	
//    	if (!Strings.isNullOrEmpty(dvcModelId)) {
//    		sb.append(" AND dvcModelId = :dvcModelId ");
//    	}
//    	
//    	TypedQuery<TagModelMappInfo> query = em.createQuery(sb.toString(), TagModelMappInfo.class);
//    	
//    	if (!Strings.isNullOrEmpty(dvcModelId)) {
//    		query.setParameter("dvcModelId", dvcModelId);
//    	}
//    	
//    	List<TagModelMappInfo> lists = query.getResultList();
//    	return lists;
//    }
//
//    public List<TagModelMappInfo> getMappInfoListByModelId(String modelId) {
//
//    	StringBuilder sb = new StringBuilder();
//    	sb.append(" SELECT tmmi FROM TagModelMappInfo AS tmmi");
//    	sb.append(" LEFT JOIN DvcModelInfo AS dmi on dmi.dvcModelId = tmmi.dvcModelId");
//    	sb.append(" LEFT JOIN TagInfo AS ti on ti.tagId = tmmi.tagId");
//    	sb.append(" WHERE 1=1 ");
//
//		sb.append(" AND dmi.modelId = :modelId ");
//		
//		sb.append(" ORDER BY ti.tagCd ASC ");
//		
//    	TypedQuery<TagModelMappInfo> query = em.createQuery(sb.toString(), TagModelMappInfo.class);
//		query.setParameter("modelId", modelId);
//    	
//    	List<TagModelMappInfo> lists = query.getResultList();
//    	return lists;
//    }
//
//    public List<TagInfo> check(Map<String, Object> paramMap) {
//		String clientCd = paramMap.get("clientCd") == null ? "" : paramMap.get("clientCd").toString();
//		String siteCd = paramMap.get("siteCd") == null ? "" : paramMap.get("siteCd").toString();
//    	String tagCd = paramMap.get("tagCd") == null ? "" : paramMap.get("tagCd").toString();
//		String tagNm = paramMap.get("tagNm") == null ? "" : paramMap.get("tagNm").toString();
//
//		StringBuilder sb = new StringBuilder();
//		sb.append(" SELECT t FROM TagInfo AS t");
//		sb.append(" WHERE 1=1 ");
//
//		if (!Strings.isNullOrEmpty(tagCd)) {
//			sb.append(" AND clientCd = :clientCd ");
//		}
//		if (!Strings.isNullOrEmpty(tagCd)) {
//			sb.append(" AND siteCd = :siteCd ");
//		}
//		if (!Strings.isNullOrEmpty(tagCd)) {
//			sb.append(" AND tagCd = :tagCd ");
//		}
//		if (!Strings.isNullOrEmpty(tagNm)) {
//			sb.append(" AND tagNm = :tagNm ");
//		}
//
//		int startIndex = 0;
//		int rowsInt = 999;
//
//		TypedQuery<TagInfo> query = em.createQuery(sb.toString(), TagInfo.class).setFirstResult(startIndex).setMaxResults(rowsInt);
//
//		if (!Strings.isNullOrEmpty(tagCd)) {
//			query.setParameter("clientCd", clientCd);
//		}
//		if (!Strings.isNullOrEmpty(tagCd)) {
//			query.setParameter("siteCd", siteCd);
//		}
//		if (!Strings.isNullOrEmpty(tagCd)) {
//			query.setParameter("tagCd", tagCd);
//		}
//		if (!Strings.isNullOrEmpty(tagNm)) {
//			query.setParameter("tagNm", tagNm);
//		}
//
//		List<TagInfo> lists = query.getResultList();
//		return lists;
//    }
}
