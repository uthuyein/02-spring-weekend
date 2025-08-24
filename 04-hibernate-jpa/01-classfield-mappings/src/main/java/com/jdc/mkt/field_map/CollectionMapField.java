package com.jdc.mkt.field_map;

import java.util.Map;

import com.jdc.mkt.utils.Size;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OrderBy;
import jakarta.persistence.OrderColumn;
import lombok.Data;

@Entity
@Data
public class CollectionMapField {

	@Id
	private int id;
	@ElementCollection
	@OrderColumn(name = "mapCol")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<Size, String> mapCol;
	
	@OrderBy("mapEmbs desc")
	@ElementCollection
	private Map<MapEmb, String> mapEmbs;
}
