package com.peatera.demo.pojo;

public class SysMessage {
	// cpu
	private int cupCount;
	private double cupUse;
	private double cpuSurplus;
	// 内存
	private double memTotal;
	private double memUse;
	private double menmSurplus;
	// 目录
	private Long CatalogTotal;
	private Long CatalogUse;
	private Long CatalogSurplus;

	// 操作系统
	private String os;
	// JDK
	private String jdk;
	
	//
	private Long ygTotal;
	private Long ygUse;
    
	
	public SysMessage(){
		
	}
	public SysMessage(int cupCount, double cupUse, double cpuSurplus,
			double memTotal, double memUse, double menmSurplus,
			Long catalogTotal, Long catalogUse, Long catalogSurplus, String os,
			String jdk,Long ygTotal,Long ygUse) {
		super();
		this.cupCount = cupCount;
		this.cupUse = cupUse;
		this.cpuSurplus = cpuSurplus;
		this.memTotal = memTotal;
		this.memUse = memUse;
		this.menmSurplus = menmSurplus;
		CatalogTotal = catalogTotal;
		CatalogUse = catalogUse;
		CatalogSurplus = catalogSurplus;
		this.os = os;
		this.jdk = jdk;
		this.ygTotal=ygTotal;
		this.ygUse=ygUse;
	}

	public Long getYgTotal() {
		return ygTotal;
	}

	public void setYgTotal(Long ygTotal) {
		this.ygTotal = ygTotal;
	}

	public Long getYgUse() {
		return ygUse;
	}

	public void setYgUse(Long ygUse) {
		this.ygUse = ygUse;
	}

	public int getCupCount() {
		return cupCount;
	}

	public void setCupCount(int cupCount) {
		this.cupCount = cupCount;
	}

	public double getCupUse() {
		return cupUse;
	}

	public void setCupUse(double cupUse) {
		this.cupUse = cupUse;
	}

	public double getCpuSurplus() {
		return cpuSurplus;
	}

	public void setCpuSurplus(double cpuSurplus) {
		this.cpuSurplus = cpuSurplus;
	}

	public double getMemTotal() {
		return memTotal;
	}

	public void setMemTotal(double memTotal) {
		this.memTotal = memTotal;
	}

	public double getMemUse() {
		return memUse;
	}

	public void setMemUse(double memUse) {
		this.memUse = memUse;
	}

	public double getMenmSurplus() {
		return menmSurplus;
	}

	public void setMenmSurplus(double menmSurplus) {
		this.menmSurplus = menmSurplus;
	}

	public Long getCatalogTotal() {
		return CatalogTotal;
	}

	public void setCatalogTotal(Long catalogTotal) {
		CatalogTotal = catalogTotal;
	}

	public Long getCatalogUse() {
		return CatalogUse;
	}

	public void setCatalogUse(Long catalogUse) {
		CatalogUse = catalogUse;
	}

	public Long getCatalogSurplus() {
		return CatalogSurplus;
	}

	public void setCatalogSurplus(Long catalogSurplus) {
		CatalogSurplus = catalogSurplus;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getJdk() {
		return jdk;
	}

	public void setJdk(String jdk) {
		this.jdk = jdk;
	}

	@Override
	public String toString() {
		return "SysMessage [cupCount=" + cupCount + ", cupUse=" + cupUse
				+ ", cpuSurplus=" + cpuSurplus + ", memTotal=" + memTotal
				+ ", memUse=" + memUse + ", menmSurplus=" + menmSurplus
				+ ", CatalogTotal=" + CatalogTotal + ", CatalogUse="
				+ CatalogUse + ", CatalogSurplus=" + CatalogSurplus + ", os="
				+ os + ", jdk=" + jdk + ", ygTotal=" + ygTotal + ", ygUse="
				+ ygUse + "]";
	}

	
	

}
