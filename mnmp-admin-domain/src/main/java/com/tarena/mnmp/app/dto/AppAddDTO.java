package com.tarena.mnmp.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tarena.mnmp.commons.regex.admin.AppRegexExpression;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel(
    value = "应用新增"
)
public class AppAddDTO implements Serializable, AppRegexExpression {
    private static final long serialVersionUID = 1L;
    private static final String VALIDATE_MESSAGE_PREFIX = "应用新增失败";
    @JsonProperty("id")
    private Long id;
    @JsonProperty("code")
    @NotNull(message = VALIDATE_MESSAGE_PREFIX + "请填写应用CODE！")
    //@Pattern(regexp = TEST_REGEX, message = VALIDATE_MESSAGE_PREFIX + TEST_MESSAGE)
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("leader")
    private String leader;
    @JsonProperty("teamMembers")
    private String teamMembers;
    @JsonProperty("remark")
    private String remark;
    @JsonProperty("enabled")
    private Integer enabled;
    @JsonProperty("createTime")
    private Long createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
