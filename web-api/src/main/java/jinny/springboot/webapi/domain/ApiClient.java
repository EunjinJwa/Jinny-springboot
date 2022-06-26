package jinny.springboot.webapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_client")
public class ApiClient {
    @Id
    private String clientId;
    private String accessKey;
}
