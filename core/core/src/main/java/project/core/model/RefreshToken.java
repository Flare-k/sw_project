package project.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Table(name = "refresh_token")
@Entity
public class RefreshToken {

    @Id
    private String keyr;
    private String valuer;

    public RefreshToken updateValue(String token) {
        this.valuer = token;
        return this;
    }

    @Builder
    public RefreshToken(String key, String value) {
        this.keyr = key;
        this.valuer = value;
    }
}