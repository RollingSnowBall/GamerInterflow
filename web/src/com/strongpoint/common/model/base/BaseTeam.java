package com.strongpoint.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseTeam<M extends BaseTeam<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setTeamName(java.lang.String teamName) {
		set("teamName", teamName);
		return (M)this;
	}

	public java.lang.String getTeamName() {
		return getStr("teamName");
	}

	public M setLeader(java.lang.String leader) {
		set("leader", leader);
		return (M)this;
	}

	public java.lang.String getLeader() {
		return getStr("leader");
	}

}
