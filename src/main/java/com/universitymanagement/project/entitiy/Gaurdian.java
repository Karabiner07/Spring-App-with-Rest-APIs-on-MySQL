package com.universitymanagement.project.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "gaurdian_name")
        ),
        @AttributeOverride(
                name = "emailId",
                column = @Column(name = "gaurdian_email_address")
        ),
        @AttributeOverride(
                name = "Mobile",
                column = @Column(name = "gaurdian_mobile")
        )
})
public class Gaurdian {

    private String gName;
    private String gEmailId;
    private Long gMobile;

}
