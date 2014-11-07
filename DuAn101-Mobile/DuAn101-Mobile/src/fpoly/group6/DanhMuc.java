package fpoly.group6;

public class DanhMuc {
	public String itemName;
	public int Itemicon;

	public DanhMuc(String itemName, int itemicon) {
		this.itemName = itemName;
		this.Itemicon = itemicon;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemicon() {
		return Itemicon;
	}

	public void setItemicon(int itemicon) {
		Itemicon = itemicon;
	}

}
