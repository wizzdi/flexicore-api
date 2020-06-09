package com.flexicore.data.jsoncontainers;

import com.flexicore.model.Clazz;
import com.flexicore.model.ClazzLink;

public class ClazzLinkContainer extends BasicContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2694868154968547016L;
	private Clazz left;
	private Clazz right;
	private Clazz value;
	private boolean isOtherSideRight;

	public ClazzLinkContainer() {
		// TODO Auto-generated constructor stub
	}

	public ClazzLinkContainer(ClazzLink base, boolean isOtherSideRight) {
		super(base);
		setLeft(base.getLeft());
		setRight(base.getRight());
		setValue(base.getValue());
		this.setOtherSideRight(isOtherSideRight);

	}

	public Clazz getLeft() {
		return left;
	}

	public void setLeft(Clazz left) {
		this.left = left;
	}

	public Clazz getRight() {
		return right;
	}

	public void setRight(Clazz right) {
		this.right = right;
	}

	public boolean isOtherSideRight() {
		return isOtherSideRight;
	}

	public void setOtherSideRight(boolean isOtherSideRight) {
		this.isOtherSideRight = isOtherSideRight;
	}

	public Clazz getValue() {
		return value;
	}

	public void setValue(Clazz value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (left != null) {
			builder.append(" Left side is: ").append(left.getName());

		} else {
			builder.append(" Left side is NULL");
		}
		if (right != null) {
			builder.append(" Right side is: ").append(right.getName());

		} else {
			builder.append(" Right side is NULL");
		}
		builder.append(" Other side right: ").append(isOtherSideRight);
		return builder.toString();

	}



}
