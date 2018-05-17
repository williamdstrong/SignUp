package data;

public class Data<T> {

	private String name;
	private String label;
	private String options;
	private T data;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
	
	public void setData(T t) {
		data = t;
	}
	
	public T getData() {
		return data;
	}
	
	public Data(String name, String label) {
		this.data = null;
		this.name = name;
		this.label = label;
		this.options = "";
	}
	
	public Data(String name, String label, String options) {
		this.data = null;
		this.name = name;
		this.label = label;
		this.options = options;
	}
}
