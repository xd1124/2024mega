package com.application.trainingVer2.member.data;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="MEMBER")
@DynamicUpdate
public class Member {

	@Id
    @Column(name = "MEMBER_ID", length = 20)
    private String memberId;

    @Column(name = "PASSWD", nullable = false, length = 200)
    private String passwd;

    @Column(name = "PROFILE_ORIGINAL_NAME", nullable = false, length = 200)
    private String profileOriginalName;

    @Column(name = "PROFILE_UUID", nullable = false, length = 200)
    private String profileUuid;

    @Column(name = "MEMBER_NM", nullable = false, length = 50)
    private String memberNm;

    @Column(name = "SEX", nullable = false, length = 1)
    private String sex;

    @Column(name = "BIRTH_AT", nullable = false)
    private Date birthAt;

    @Column(name = "HP", nullable = false, length = 13)
    private String hp;

    @Column(name = "SMSSTS_YN", nullable = false, length = 1)
    private String smsstsYn;

    @Column(name = "EMAIL", nullable = false, length = 30)
    private String email;

    @Column(name = "EMAILSTS_YN", nullable = false, length = 1)
    private String emailstsYn;

    @Column(name = "ZIPCODE", length = 10)
    private String zipcode;

    @Column(name = "ROAD_ADDRESS", length = 200)
    private String roadAddress;

    @Column(name = "JIBUN_ADDRESS", length = 200)
    private String jibunAddress;

    @Column(name = "NAMUJI_ADDRESS", length = 200)
    private String namujiAddress;

    @Column(name = "ETC", length = 3000)
    private String etc;

    @Column(name = "ACTIVE_YN", length = 1)
    private String activeYn;

    @Column(name = "INACTIVE_AT")
    private Date inactiveAt;

    @Column(name = "JOIN_AT")
    private Date joinAt;
	
}
