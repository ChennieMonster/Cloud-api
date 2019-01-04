/**
 * 
 */
package com.cloud.api.entity.request;

import com.cloud.api.model.ModelEntity;

/**
 * @author zhao_pengchen
 *
 */
public class DeleteProjectToOSReq implements ModelEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 596628804751708883L;
	private boolean orphanDependents;

	public boolean isOrphanDependents() {
		return orphanDependents;
	}

	public void setOrphanDependents(boolean orphanDependents) {
		this.orphanDependents = orphanDependents;
	}
	
}
