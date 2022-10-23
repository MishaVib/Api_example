package models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class RequestModel{
	private String name;
	private int id;
	private List<String> photoUrls;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}