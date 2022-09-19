package com.usecash.challenge.entities.enums;

public enum StatusTransaction {
	PENDING(1),
	CONCLUDED(2),
	NO_BALANCE(3);
	
	private int code;
	
	private StatusTransaction(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusTransaction valueOf(int code) {
		for (StatusTransaction value : StatusTransaction.values()) {
			if (value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid StatusTransaction code");
	}
}
