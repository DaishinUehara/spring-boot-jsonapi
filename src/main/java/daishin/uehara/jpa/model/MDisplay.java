package daishin.uehara.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="M_DISPLAY")
public class MDisplay {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="DISPLAY_ID")
	private Long displayId;
	
	@Column(name="DISPLAY_NAME")
	private String displayName;
}
