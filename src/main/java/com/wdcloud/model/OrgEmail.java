package com.wdcloud.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_org_email")
public class OrgEmail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 根机构代码
     */
    @Column(name = "root_org_code")
    private String rootOrgCode;

    /**
     * 邮件默认名称
     */
    @Column(name = "email_display_name")
    private String emailDisplayName;

    /**
     * smtp host
     */
    @Column(name = "email_host")
    private String emailHost;

    /**
     * 端口号
     */
    @Column(name = "emai_port")
    private Integer emaiPort;

    /**
     * 加密类型 0:none,1:ssl,2:tls
     */
    @Column(name = "emai_security_type")
    private Integer emaiSecurityType;

    /**
     * 授权类型 0:login
     */
    @Column(name = "emai_auth_type")
    private Integer emaiAuthType;

    /**
     * 邮箱用户名
     */
    @Column(name = "email_user_name")
    private String emailUserName;

    /**
     * 邮箱授权码
     */
    @Column(name = "email_pwd")
    private String emailPwd;

    /**
     * 是否开通
     */
    @Column(name = "is_open")
    private Integer isOpen;

    /**
     * 是否开通注册
     */
    @Column(name = "is_open_regist")
    private Integer isOpenRegist;

    /**
     * 是否开通找回密码
     */
    @Column(name = "is_open_retrieve_pwd")
    private Integer isOpenRetrievePwd;

    /**
     * 是否开通邮件通知
     */
    @Column(name = "is_open_push_notify")
    private Integer isOpenPushNotify;

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
     * 获取根机构代码
     *
     * @return root_org_code - 根机构代码
     */
    public String getRootOrgCode() {
        return rootOrgCode;
    }

    /**
     * 设置根机构代码
     *
     * @param rootOrgCode 根机构代码
     */
    public void setRootOrgCode(String rootOrgCode) {
        this.rootOrgCode = rootOrgCode;
    }

    /**
     * 获取邮件默认名称
     *
     * @return email_display_name - 邮件默认名称
     */
    public String getEmailDisplayName() {
        return emailDisplayName;
    }

    /**
     * 设置邮件默认名称
     *
     * @param emailDisplayName 邮件默认名称
     */
    public void setEmailDisplayName(String emailDisplayName) {
        this.emailDisplayName = emailDisplayName;
    }

    /**
     * 获取smtp host
     *
     * @return email_host - smtp host
     */
    public String getEmailHost() {
        return emailHost;
    }

    /**
     * 设置smtp host
     *
     * @param emailHost smtp host
     */
    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    /**
     * 获取端口号
     *
     * @return emai_port - 端口号
     */
    public Integer getEmaiPort() {
        return emaiPort;
    }

    /**
     * 设置端口号
     *
     * @param emaiPort 端口号
     */
    public void setEmaiPort(Integer emaiPort) {
        this.emaiPort = emaiPort;
    }

    /**
     * 获取加密类型 0:none,1:ssl,2:tls
     *
     * @return emai_security_type - 加密类型 0:none,1:ssl,2:tls
     */
    public Integer getEmaiSecurityType() {
        return emaiSecurityType;
    }

    /**
     * 设置加密类型 0:none,1:ssl,2:tls
     *
     * @param emaiSecurityType 加密类型 0:none,1:ssl,2:tls
     */
    public void setEmaiSecurityType(Integer emaiSecurityType) {
        this.emaiSecurityType = emaiSecurityType;
    }

    /**
     * 获取授权类型 0:login
     *
     * @return emai_auth_type - 授权类型 0:login
     */
    public Integer getEmaiAuthType() {
        return emaiAuthType;
    }

    /**
     * 设置授权类型 0:login
     *
     * @param emaiAuthType 授权类型 0:login
     */
    public void setEmaiAuthType(Integer emaiAuthType) {
        this.emaiAuthType = emaiAuthType;
    }

    /**
     * 获取邮箱用户名
     *
     * @return email_user_name - 邮箱用户名
     */
    public String getEmailUserName() {
        return emailUserName;
    }

    /**
     * 设置邮箱用户名
     *
     * @param emailUserName 邮箱用户名
     */
    public void setEmailUserName(String emailUserName) {
        this.emailUserName = emailUserName;
    }

    /**
     * 获取邮箱授权码
     *
     * @return email_pwd - 邮箱授权码
     */
    public String getEmailPwd() {
        return emailPwd;
    }

    /**
     * 设置邮箱授权码
     *
     * @param emailPwd 邮箱授权码
     */
    public void setEmailPwd(String emailPwd) {
        this.emailPwd = emailPwd;
    }

    /**
     * 获取是否开通
     *
     * @return is_open - 是否开通
     */
    public Integer getIsOpen() {
        return isOpen;
    }

    /**
     * 设置是否开通
     *
     * @param isOpen 是否开通
     */
    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * 获取是否开通注册
     *
     * @return is_open_regist - 是否开通注册
     */
    public Integer getIsOpenRegist() {
        return isOpenRegist;
    }

    /**
     * 设置是否开通注册
     *
     * @param isOpenRegist 是否开通注册
     */
    public void setIsOpenRegist(Integer isOpenRegist) {
        this.isOpenRegist = isOpenRegist;
    }

    /**
     * 获取是否开通找回密码
     *
     * @return is_open_retrieve_pwd - 是否开通找回密码
     */
    public Integer getIsOpenRetrievePwd() {
        return isOpenRetrievePwd;
    }

    /**
     * 设置是否开通找回密码
     *
     * @param isOpenRetrievePwd 是否开通找回密码
     */
    public void setIsOpenRetrievePwd(Integer isOpenRetrievePwd) {
        this.isOpenRetrievePwd = isOpenRetrievePwd;
    }

    /**
     * 获取是否开通邮件通知
     *
     * @return is_open_push_notify - 是否开通邮件通知
     */
    public Integer getIsOpenPushNotify() {
        return isOpenPushNotify;
    }

    /**
     * 设置是否开通邮件通知
     *
     * @param isOpenPushNotify 是否开通邮件通知
     */
    public void setIsOpenPushNotify(Integer isOpenPushNotify) {
        this.isOpenPushNotify = isOpenPushNotify;
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