package models.response;

import java.util.List;
import lombok.Data;

@Data
public class ResponseModel {
	private List<Object> photoUrls;
	private String name;
	private int id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}