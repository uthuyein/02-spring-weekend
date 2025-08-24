package com.jdc.mkt.field_map;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import lombok.Data;

@Data
//@Entity
public class CollectionField {

	@Id
	private int id;
	@ElementCollection
	@CollectionTable(name = "list_tbl",
	joinColumns = {
			@JoinColumn(name = "list_id",nullable = false,unique = true)
	})
	@Column(name = "list_col")
	private List<String> listCol;
	
	@ElementCollection
	@CollectionTable(name = "set_tbl",
	joinColumns = {
			@JoinColumn(name = "set_id")
	})
	private Set<String> setCol;
	
	@ElementCollection
	@CollectionTable(name = "map_tbl",
	joinColumns = {
			@JoinColumn(name = "map_id"),
	})
	@Column(name ="map_col")
	@MapKeyColumn(name = "map_key_id")
	private Map<Integer, String> mapCol;
	
}
