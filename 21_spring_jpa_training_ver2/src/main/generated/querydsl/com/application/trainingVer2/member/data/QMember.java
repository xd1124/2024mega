package com.application.trainingVer2.member.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 350877636L;

    public static final QMember member = new QMember("member1");

    public final StringPath activeYn = createString("activeYn");

    public final DateTimePath<java.util.Date> birthAt = createDateTime("birthAt", java.util.Date.class);

    public final StringPath email = createString("email");

    public final StringPath emailstsYn = createString("emailstsYn");

    public final StringPath etc = createString("etc");

    public final StringPath hp = createString("hp");

    public final DateTimePath<java.util.Date> inactiveAt = createDateTime("inactiveAt", java.util.Date.class);

    public final StringPath jibunAddress = createString("jibunAddress");

    public final DateTimePath<java.util.Date> joinAt = createDateTime("joinAt", java.util.Date.class);

    public final StringPath memberId = createString("memberId");

    public final StringPath memberNm = createString("memberNm");

    public final StringPath namujiAddress = createString("namujiAddress");

    public final StringPath passwd = createString("passwd");

    public final StringPath profileOriginalName = createString("profileOriginalName");

    public final StringPath profileUuid = createString("profileUuid");

    public final StringPath roadAddress = createString("roadAddress");

    public final StringPath sex = createString("sex");

    public final StringPath smsstsYn = createString("smsstsYn");

    public final StringPath zipcode = createString("zipcode");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

