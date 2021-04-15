package com.bbs;
import javax.security.auth.Subject;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.collection.RepositoryRowSet;
import com.filenet.api.collection.StringList;
import com.filenet.api.constants.AutoClassify;
import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.CheckinType;
import com.filenet.api.constants.ClassNames;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.constants.ReservationType;
import com.filenet.api.core.ContentElement;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Document;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Factory.Choice;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.core.ReferentialContainmentRelationship;
import com.filenet.api.core.VersionSeries;
import com.filenet.api.core.Versionable;
import com.filenet.api.property.Properties;
import com.filenet.api.query.RepositoryRow;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.Id;
import com.filenet.api.util.UserContext;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class FileNet {
	
	@WebMethod
	public String FNConnection()
	{
		
		ObjectStore os = null;
		try {
				com.filenet.api.core.Connection conn = Factory.Connection.getConnection("http://192.168.201.162:9080/wsi/FNCEWS40MTOM/");
				UserContext uc = UserContext.get();
				Subject sub = UserContext.createSubject(conn, "usrcpeadmin", "Bbs@2021", "FileNetP8WSI");
				//System.setProperty("Djava.security.auth.login.config", "D:\\IBM\\FileNet\\ContentEngine\\config\\samples\\jaas.conf.WSI");  
				uc.pushSubject(sub);
				Domain dom = Factory.Domain.getInstance(conn, null);
				os = Factory.ObjectStore.fetchInstance(dom, "OBST", null);   
				return "yasemin2";

		} catch (Exception e) {
		               // TODO Auto-generated catch block
	               e.printStackTrace();
	    
	               return e.getMessage();
		}


		
	}

}
