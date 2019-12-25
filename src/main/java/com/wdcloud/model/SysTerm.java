package com.wdcloud.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_term")
public class SysTerm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学期名称
     */
    private String name;

    /**
     * 学期编码
     */
    private String code;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 机构ID
     */
    @Column(name = "org_id")
    private Long orgId;

    /**
     * 机构TREE ID
     */
    @Column(name = "org_tree_id")
    private String orgTreeId;

    /**
     * SIS ID
     */
    @Column(name = "sis_id")
    private String sisId;

    /**
     * 是否为默认学期
     */
    @Column(name = "is_default")
    private Integer isDefault;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_user_id")
    private Long createUserId;

    @Column(name = "update_user_id")
    private Long updateUserId;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取学期名称
     *
     * @return name - 学期名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学期名称
     *
     * @param name 学期名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学期编码
     *
     * @return code - 学期编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置学期编码
     *
     * @param code 学期编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取机构ID
     *
     * @return org_id - 机构ID
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 设置机构ID
     *
     * @param orgId 机构ID
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取机构TREE ID
     *
     * @return org_tree_id - 机构TREE ID
     */
    public String getOrgTreeId() {
        return orgTreeId;
    }

    /**
     * 设置机构TREE ID
     *
     * @param orgTreeId 机构TREE ID
     */
    public void setOrgTreeId(String orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    /**
     * 获取SIS ID
     *
     * @return sis_id - SIS ID
     */
    public String getSisId() {
        return sisId;
    }

    /**
     * 设置SIS ID
     *
     * @param sisId SIS ID
     */
    public void setSisId(String sisId) {
        this.sisId = sisId;
    }

    /**
     * 获取是否为默认学期
     *
     * @return is_default - 是否为默认学期
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否为默认学期
     *
     * @param isDefault 是否为默认学期
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return create_user_id
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * @param createUserId
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * @return update_user_id
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * @param updateUserId
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }
}