package com.dotmarketing.beans;

import java.util.List;

import com.dotmarketing.business.PermissionSummary;
import com.dotmarketing.business.Permissionable;
import com.dotmarketing.business.RelatedPermissionableGroup;
import com.dotmarketing.exception.DotDataException;

public  class PermissionableProxy implements Permissionable {
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		if(type ==null) return;
		if(type.equals("contentlet") || type.equals("host")) {
			setPermissionByIdentifier(true);
		} else if (type.equals("htmlpage")) {
			setPermissionByIdentifier(true);
		} else if (type.equals("folder")) {
			setPermissionByIdentifier(false);
		} else if (type.equals("template")) {
			setPermissionByIdentifier(true);
		} else if (type.equals("containers")) {
			setPermissionByIdentifier(true);
		} else if (type.equals("structure")) {
			setPermissionByIdentifier(false);
		} 
	}

	private static final long serialVersionUID = 1L;
	
	public String Inode =null;
	
	public String Identifier =null;
	
	public Boolean permissionByIdentifier =true;
	
	public String type =null;
	
	public String owner =null;
	
	public Boolean getPermissionByIdentifier() {
		return permissionByIdentifier;
	}

	public void setPermissionByIdentifier(Boolean permissionByIdentifier) {
		this.permissionByIdentifier = permissionByIdentifier;
	}

	public String getInode() {
		return Inode;
	}

	public String getIdentifier() {
		return Identifier;
	}

	public void setInode(String inode) {
		Inode = inode;
	}

	public void setIdentifier(String identifier) {
		Identifier = identifier;
	}
	
	public String getPermissionId() {
		String idReturn=null;
		if(permissionByIdentifier){
			idReturn=getIdentifier();
		}
		else{
			idReturn=getInode();
		}
		return idReturn;
	}

	public List<PermissionSummary> acceptedPermissions() {
		return null;
	}

	public String getOwner() {
		return owner;
	}

	public Permissionable getParentPermissionable() throws DotDataException {
		return null;
	}

	public String getPermissionType() {
		return type;
	}

	public List<RelatedPermissionableGroup> permissionDependencies(
			int requiredPermission) {
		return null;
	}

	public void setOwner(String owner) {
		this.owner=owner;
	}

	public List<? extends Permissionable> getChildrenPermissionable() throws DotDataException {
		return null;
	}

	public boolean isParentPermissionable() {
		return false;
	}

}
