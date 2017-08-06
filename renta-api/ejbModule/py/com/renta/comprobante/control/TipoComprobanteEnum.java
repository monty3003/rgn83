package py.com.renta.comprobante.control;

public enum TipoComprobanteEnum {
	FCC("FCC", "Factura Contado"), FCR("FCR", "Factura Credito"), REC("REC", "Recibo"), RET("RET", "Retencion");

	private String key;
	private String desc;

	private TipoComprobanteEnum(String key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
